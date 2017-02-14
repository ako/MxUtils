package mxawsrekognition;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClient;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import com.mendix.logging.ILogNode;

import java.util.logging.Logger;

/**
 * Created by ako on 2/12/2017.
 */
public class AwsRekognitionConnector {
    public AwsRekognitionConnector() {

    }

    private static ILogNode logger = null;
    private static final Logger javaLogger = Logger.getLogger(AwsRekognitionConnector.class.getName());

    public void setLogger(ILogNode logger) {
        this.logger = logger;
    }

    public void info(String message) {
        if (this.logger != null) {
            logger.info(message);
        } else {
            javaLogger.info(message);
        }
    }

    public String getImageLabels(String AwsAccessKeyId, String AwsSecretAccessKey, String s3PictureKey, String s3PictureBucket, String awsRegion) {
        info("> getImageLabels");
        String labels = "";
        AWSCredentials credentials = new BasicAWSCredentials(AwsAccessKeyId, AwsSecretAccessKey);
        DetectLabelsRequest request = new DetectLabelsRequest()
                .withImage(new Image().withS3Object(new S3Object().withName(s3PictureKey).withBucket(s3PictureBucket)))
                .withMaxLabels(10)
                .withMinConfidence(80F);

//        AmazonRekognitionClient rekognitionClient = new AmazonRekognitionClient(credentials)
//                .withRegion(Region.getRegion(Regions.fromName(awsRegion)));
        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard().
                withCredentials(new AWSStaticCredentialsProvider(credentials)).
                withRegion(awsRegion).
                build();

        DetectLabelsResult result = rekognitionClient.detectLabels(request);
        info(String.format("detect labels result: %s, %s", result.getLabels().toString(), result.toString()));
        for (Label label : result.getLabels()) {
            info(label.getName() + " : " + label.getConfidence());
            labels += "{\"label\":\"" + label.getName() + "\"," +
                    "\"confidence\":\"" + label.getConfidence() + "\"},";
        }
        labels = "[" + (labels.equals("") ? "" : labels.substring(0, labels.length() - 1)) + "]";
        return labels;
    }


    public String detectFaces(String awsAccessKeyId, String awsSecretAccessKey, String awsPictureS3Key, String awsPictureS3Bucket, String awsS3Region) {
//        String labels = "";
        info("detectFaces");
        AWSCredentials credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        DetectFacesRequest request = new DetectFacesRequest()
                .withImage(new Image().withS3Object(new S3Object().withName(awsPictureS3Key).withBucket(awsPictureS3Bucket)))
                .withAttributes(Attribute.ALL);

//        AmazonRekognitionClient rekognitionClient = new AmazonRekognitionClient(credentials)
//                .withRegion(Region.getRegion(Regions.fromName(awsS3Region)));
        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard().
                withCredentials(new AWSStaticCredentialsProvider(credentials)).
                withRegion(awsS3Region).
                build();

        DetectFacesResult result = rekognitionClient.detectFaces(request);
        info(String.format("detect faces result: %s, %s", result.getFaceDetails(), result.toString()));
        String jsonResult = "";
        for (FaceDetail faceDetail : result.getFaceDetails()) {
            jsonResult += "{\"faceDetails\":{\"details\":[";
            if (faceDetail.getBeard() != null) {
                jsonResult += faceDetailJson("Beard", faceDetail.getBeard().getValue(), faceDetail.getBeard().getConfidence());
            }
            if (faceDetail.getGender() != null) {
                jsonResult += "," + faceDetailJson("Gender", faceDetail.getGender().getValue(), faceDetail.getGender().getConfidence());
            }
            if (faceDetail.getMustache() != null) {
                jsonResult += "," + faceDetailJson("Mustache", faceDetail.getMustache().getValue(), faceDetail.getMustache().getConfidence());
            }
            if (faceDetail.getEyeglasses() != null) {
                jsonResult += "," + faceDetailJson("Eyeglasses", faceDetail.getEyeglasses().getValue(), faceDetail.getEyeglasses().getConfidence());
            }
            if (faceDetail.getMouthOpen() != null) {
                jsonResult += "," + faceDetailJson("MounthOpen", faceDetail.getMouthOpen().getValue(), faceDetail.getMouthOpen().getConfidence());
            }
            if (faceDetail.getEyesOpen() != null) {
                jsonResult += "," + faceDetailJson("EyesOpen", faceDetail.getEyesOpen().getValue(), faceDetail.getEyesOpen().getConfidence());
            }
            if (faceDetail.getSmile() != null) {
                jsonResult += "," + faceDetailJson("Smile", faceDetail.getSmile().getValue(), faceDetail.getSmile().getConfidence());
            }
            if (faceDetail.getSunglasses() != null) {
                jsonResult += "," + faceDetailJson("Sunglasses", faceDetail.getSunglasses().getValue(), faceDetail.getSunglasses().getConfidence());
            }
            jsonResult += "],\"Emotions\":[";
            if (faceDetail.getEmotions() != null) {
                for (Emotion emotion : faceDetail.getEmotions()) {
                    jsonResult += String.format("{\"Emotion\":\"%s\",\"Confidence\":\"%f\"},", emotion.getType(), emotion.getConfidence());
                }
            }
            jsonResult = jsonResult.substring(0, jsonResult.length() - 1);
            jsonResult += "]";
            if(faceDetail.getBoundingBox() != null) {
                jsonResult += String.format(",\"BoundingBox\":{\"Top\":%f,\"Left\":%f,\"Width\":%f,\"Height\":%f}",
                        faceDetail.getBoundingBox().getTop(),
                        faceDetail.getBoundingBox().getLeft(),
                        faceDetail.getBoundingBox().getWidth(),
                        faceDetail.getBoundingBox().getHeight());
            }
            if(faceDetail.getQuality() != null ){
                jsonResult += String.format(",\"Quality\":{\"Brightness\":%f,\"Sharpness\":%s}",
                        faceDetail.getQuality().getBrightness(),faceDetail.getQuality().getSharpness());
            }
            if(faceDetail.getAgeRange() != null){
                jsonResult += String.format(",\"AgeRange\": {\"High\":%d , \"Low\":%d}",
                        faceDetail.getAgeRange().getHigh(),
                        faceDetail.getAgeRange().getLow());
            }

            jsonResult += "}},";
        }
        jsonResult = "[" + (jsonResult.equals("") ? "" : jsonResult.substring(0, jsonResult.length() - 1)) + "]";
        return jsonResult;
    }

    private String faceDetailJson(String detailName, Object detailValue, Float confidence) {
        return String.format("{\"Detail\":\"%s\", \"Value\":\"%s\", \"Confidence\":\"%f\" }", detailName, detailValue, confidence);
    }
}
