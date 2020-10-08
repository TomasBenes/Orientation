package com.api.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Greeter {
    String name;
    String title;
    private String welcome;

    public Greeter(String name, String title) {
        this.name = name;
        this.title = title;
        this.welcome = "Oh, hi there " + name + ", my dear " + title + "!";
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
