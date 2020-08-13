package com.greenfoxacademy.springstart.controllers;

public class Greeting {
    long id;
    String contentFields;


    public Greeting(long id, String contentFields) {
        this.id = id;
        this.contentFields = contentFields;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContentFields() {
        return contentFields;
    }

    public void setContentFields(String contentFields) {
        this.contentFields = contentFields;
    }
}
