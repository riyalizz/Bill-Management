package com.learn.electricitybillmanagent.sqs;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SqsService {

    @Autowired
    public AmazonSQS sqsClient;

    @Value("${aws.queue}")
    public String queueUrl;

    public void sendMessage(SQSMessage msg) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMsg = objectMapper.writeValueAsString(msg);
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(jsonMsg)
                .withDelaySeconds(5);
        sqsClient.sendMessage(send_msg_request);
    }

    public static void main(String[] args) throws JsonProcessingException {

        String accessKeyId = "AKIA46RAXZE4GJ6H47OA";
        String secretAccessKey = "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";
        String region = "us-east-2";
        String queueUrl = "https://sqs.us-east-2.amazonaws.com/890200639800/customer-misses";
        SQSMessage sqsMessage = new SQSMessage();
        sqsMessage.setMsg("1234");
        SqsService sqsClient1 = new SqsService();
        //sqsClient1.sendMessage(sqsMessage);

        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
        AmazonSQS sqsClient =  AmazonSQSClientBuilder.standard().withRegion(Regions.fromName(region)).withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).build();

        // Create and send SQS message
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody("ass")
                .withDelaySeconds(5);
        sqsClient.sendMessage(sendMessageRequest);


    }
}