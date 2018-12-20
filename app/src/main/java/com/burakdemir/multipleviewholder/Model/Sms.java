package com.burakdemir.multipleviewholder.Model;

public class Sms {

    private String senderName;
    private String smsContent;
    private String smsTime;

    public Sms(String senderName, String smsContent, String smsTime) {
        this.senderName = senderName;
        this.smsContent = smsContent;
        this.smsTime = smsTime;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public String getSmsTime() {
        return smsTime;
    }

    public void setSmsTime(String smsTime) {
        this.smsTime = smsTime;
    }
}
