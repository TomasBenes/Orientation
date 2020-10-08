package com.api.backend.Model;

public class Append {
    String appended;

    public Append(){}

    public Append(String appended) {
        this.appended = appended.concat("a");
    }

    public String getAppended() {
        return appended;
    }

    public void setAppended(String appended) {
        this.appended = appended;
    }
}
