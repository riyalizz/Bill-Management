package com.learn.electricitybillmanagent;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigs {

    @Value("${aws.access_key_id}")
    private String awsId;

    @Value("${aws.secret_access_key}")
    private String awsKey;

    @Value("${aws.region}")
    private String region;

    @Bean
    public AmazonSQS sqsClient(){
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(awsId, awsKey);
        return AmazonSQSClientBuilder.standard().withRegion(Regions.fromName(region)).withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).build();
    }
}
