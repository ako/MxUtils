package mxawss3.impl;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;

import java.io.File;

/**
 * Created by ako on 30-12-2016.
 */
public class AwsS3Connector {
    public static final String LOG_NODE = "AwsS3";
    private ILogNode logger = null;
    private IContext context = null;
    private String awsAccessKeyId = null;
    private String awsSecretAccessKey = null;
    private String awsRegion = null;

    public AwsS3Connector() {

    }

    public void setLogger(ILogNode logger) {
        this.logger = logger;
    }

    public String copyFileDocumentToS3(String bucketName, String key, File sourceFile) {
        info(String.format("copyFileDocymentToS3 - region %s, bucket %s, key %s", this.awsRegion, bucketName, key));
        AWSCredentials credentials = null;
        info("Connecting to aws using: " + awsAccessKeyId);
        credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        AmazonS3 s3 = new AmazonS3Client(credentials);
        s3.setRegion(Region.getRegion(Regions.fromName(this.awsRegion)));
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, sourceFile);
        PutObjectResult result = s3.putObject(putObjectRequest);
        return bucketName + "/"+ key;
    }

    private void info(String message) {
        if (logger != null) {
            logger.info(message);
        } else {
            System.err.println(message);
        }
    }

    public void setAwsCredentials(String awsAccessKeyId, String awsSecretAccessKey) {
        this.awsAccessKeyId = awsAccessKeyId;
        this.awsSecretAccessKey = awsSecretAccessKey;
    }

    public void setRegion(String awsRegion) {
        this.awsRegion = awsRegion;
    }
}
