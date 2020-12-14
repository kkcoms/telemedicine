package com.medical.telemedicine.models;

public class MessageB {

    String name;
    String message;
    String time;

    public MessageB() {
        this.name = "";
        this.message = "";
        this.time = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
