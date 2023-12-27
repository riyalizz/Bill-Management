package com.learn.electricitybillmanagent.sqs;

public class SQSMessage {
    private String customerId;

    public SQSMessage(){}

    public SQSMessage(String customerId) {
        this.customerId = customerId;
    }

    public void setMsg(String msg) {
        this.customerId = msg;
    }

    public String getMsg() {
        return customerId;
    }
}
