package com.medical.telemedicine.models;

public class NotificationModel {

    String title;
    String message;
    String time;

    public NotificationModel() {
        this.title = "";
        this.message = "";
        this.time = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


