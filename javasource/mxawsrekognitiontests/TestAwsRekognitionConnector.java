package mxawsrekognitiontests;

import mxawsrekognition.AwsRekognitionConnector;
import org.junit.BeforeClass;
import org.junit.Test;
import ca.szc.configparser.Ini;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ako on 2/12/2017.
 */
public class TestAwsRekognitionConnector {

    @Test
    public void testImageLabels(){
        AwsRekognitionConnector conn = new AwsRekognitionConnector();
        String labels = conn.getImageLabels(accessKeyId,secretAccessKey,"awss3-tests/5","mx-iot-demo",region);
        System.out.println(labels);
    }

    @Test
    public void testDetectFaces(){
        AwsRekognitionConnector conn = new AwsRekognitionConnector();
        String labels = conn.detectFaces(accessKeyId,secretAccessKey,"awss3-tests/24","mx-iot-demo",region);
        System.out.println(labels);
    }

    private static String accessKeyId = null;
    private static String secretAccessKey = null;
    private static String region = null;

    @BeforeClass
    public static void initConfiguration() {
        Path configurationFile = Paths.get(System.getProperty("user.home"), ".mxutils.cfg");
        System.err.println("Reading aws credentials from : " + configurationFile.toString());
        try {
            Ini ini = new Ini().read(configurationFile);
            accessKeyId = ini.getValue("AwsRekognition", "aws_access_key_id");
            secretAccessKey = ini.getValue("AwsRekognition", "aws_secret_access_key");
            region = ini.getValue("AwsRekognition", "region");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
