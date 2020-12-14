package com.medical.telemedicine.models;

public class Doctor {


    String name;
    String specialist;
    int rating;
    String experience;
    String paitent;
    String place;
    String time;


    public Doctor() {
        this.name = "";
        this.specialist = "";
        this.rating = 0;
        this.experience = "";
        this.paitent = "";
        this.place = "";
        this.time = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPaitent() {
        return paitent;
    }

    public void setPaitent(String paitent) {
        this.paitent = paitent;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
