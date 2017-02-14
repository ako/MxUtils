package mxnlp.impl;

import com.mendix.core.Core;
import com.mendix.logging.ILogNode;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import org.apache.uima.resource.ResourceInitializationException;
import org.datavec.api.util.ClassPathResource;
import org.deeplearning4j.bagofwords.vectorizer.BagOfWordsVectorizer;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.models.word2vec.VocabWord;
import org.deeplearning4j.models.word2vec.wordstore.inmemory.AbstractCache;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.distribution.UniformDistribution;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.text.sentenceiterator.labelaware.LabelAwareListSentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.deeplearning4j.util.ModelSerializer;
import org.junit.Test;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by ako on 1/16/2017.
 */
public class MxNlpConnector {
    public static final String LOGNODE = "MxNlpConnector";
    private static HashMap<String, NlpNetwork> nets = new HashMap<String, NlpNetwork>();

    public MxNlpConnector() {

    }


    public void initNetwork(String networkName, String networkResourceLocation, String trainingSetResourceLocation) throws IOException {
        info("initNetwork");
        synchronized (nets) {
            if (nets == null) {
                nets = new HashMap<String, NlpNetwork>();
            }
            NlpNetwork net = nets.get(networkName);
            if (net == null) {
                net = new NlpNetwork();
                net.setName(networkName);
                net.setNetworkResourcePath(networkResourceLocation);
                net.setTrainingSetResourcePath(trainingSetResourceLocation);
                nets.put(networkName, net);
                initNet(net);
            }
        }
    }

    private void initNet(NlpNetwork net) throws IOException {
        info("initNet");

        BagOfWordsVectorizer bowv = createBowVectorizer(net.getTrainingSetResourcePath());
        net.setVectorizer(bowv);
        /*
         * Load the model
         */
        File locationToSave = null;
        try {
            locationToSave = new File(Core.getConfiguration().getResourcesPath() + File.separator + net.getNetworkResourcePath());
        } catch(Exception e){
            locationToSave = new File(getClass().getClassLoader().getResource(net.getNetworkResourcePath()).getFile());
        }

        MultiLayerNetwork restored = ModelSerializer.restoreMultiLayerNetwork(locationToSave);
        net.setNetwork(restored);

    }

    private BagOfWordsVectorizer createBowVectorizer(String trainingSetResourcePath) throws IOException {
        TokenizerFactory t = new DefaultTokenizerFactory();
        t.setTokenPreProcessor(new CommonPreprocessor());

        ClassPathResource resource = new ClassPathResource(trainingSetResourcePath);
        LabelAwareListSentenceIterator iter = new LabelAwareListSentenceIterator(resource.getInputStream(), ",");

        AbstractCache<VocabWord> cache = new AbstractCache<>();

        /*
         * Build words vectorizer
         */
        BagOfWordsVectorizer bowv = new BagOfWordsVectorizer.Builder()
                .setTokenizerFactory(t)
                .setIterator(iter)
                .setMinWordFrequency(1)
                .setVocab(cache)
                .build();

        bowv.fit();
        Collection<VocabWord> words = cache.vocabWords();
        for (
                VocabWord word : words)

        {
            info(String.format("%d = %s", word.getIndex(), word.getWord()));
        }
        return bowv;
    }

    private void info(String msg) {
        if (logger == null) {
            System.out.println(msg);
        } else {
            logger.info(msg);
        }
    }

    ILogNode logger = null;

    public void setLogger(ILogNode logger) {
        this.logger = logger;
    }

    public String predict(String networkName, String sentence) {
        info("predict");
        String result = null;
        NlpNetwork net = nets.get(networkName);
        MultiLayerNetwork network = net.getNetwork();
        int labelResult = network.predict(net.getVectorizer().transform(sentence))[0];
        info("labelResult: " + labelResult);
        return result;
    }
}
