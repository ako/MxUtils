package mxnlptest;

import mxnlp.impl.MxNlpConnector;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by ako on 1/16/2017.
 */
public class test1 {
    @Test
    public void testPredict() throws IOException {
        MxNlpConnector connector = new MxNlpConnector();
        connector.initNetwork("test1",
                "mxnlptest/test1_network.zip",
                "/mxnlptest/test1_sentences.txt");
        String label = connector.predict("test1","help me");
    }

    public static void main(String[] args) throws IOException {
        test1 t = new test1();
        t.testPredict();
    }

}
