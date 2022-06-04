package com.example.myapplication.models;

public class Abuso {
    private String date;
    private String informer;
    private String message;


    public Abuso(String date, String informer, String message) {
        this.date = date;
        this.informer = informer;
        this.message = message;
    }

    public Abuso(){

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInformer() {
        return informer;
    }

    public void setInformer(String informer) {
        this.informer = informer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}