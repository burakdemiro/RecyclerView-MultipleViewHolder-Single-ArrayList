package com.burakdemir.multipleviewholder.Model;

public class Call {

    private String callerName;
    private String callTime;

    public Call(String callerName, String callTime) {
        this.callerName = callerName;
        this.callTime = callTime;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }
}
