package com.viveknaskar.restfulwebservices.beans;

public class WelcomeDeveloperBean {

    public String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public WelcomeDeveloperBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "WelcomeDeveloperBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
