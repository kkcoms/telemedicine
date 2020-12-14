package com.medical.telemedicine.models;

public class Appointment {
    String date;
    String time;
    String doctor;
    String type;
    String place;


    public Appointment() {
        this.date = "";
        this.time = "";
        this.doctor = "";
        this.type = "";
        this.place = "";
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
