package mxnlp.impl;

import org.deeplearning4j.bagofwords.vectorizer.BagOfWordsVectorizer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;

/**
 * Created by ako on 1/16/2017.
 */
public class NlpNetwork {

    private String name = null;
    private String networkResourcePath = null;
    private BagOfWordsVectorizer vectorizer;
    private MultiLayerNetwork network;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetworkResourcePath() {
        return networkResourcePath;
    }

    public void setNetworkResourcePath(String networkResourcePath) {
        this.networkResourcePath = networkResourcePath;
    }

    public String getTrainingSetResourcePath() {
        return trainingSetResourcePath;
    }

    public void setTrainingSetResourcePath(String trainingSetResourcePath) {
        this.trainingSetResourcePath = trainingSetResourcePath;
    }

    private String trainingSetResourcePath = null;


    public void setVectorizer(BagOfWordsVectorizer vectorizer) {
        this.vectorizer = vectorizer;
    }

    public void setNetwork(MultiLayerNetwork network) {
        this.network = network;
    }

    public MultiLayerNetwork getNetwork() {
        return this.network;
    }

    public BagOfWordsVectorizer getVectorizer() {
        return this.vectorizer;
    }
}
