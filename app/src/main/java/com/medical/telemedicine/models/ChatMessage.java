package com.medical.telemedicine.models;

public class ChatMessage {

    String message;
    String time;
    String type;


    public ChatMessage() {
        this.message = "";
        this.time = "";
        this.type = "";
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
