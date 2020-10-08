package com.example.orientationexam.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String url;
    private String alias;
    private Integer hitCount;

    @JsonIgnore
    private Integer secretCode;

    public Properties(String url, String alias) {
        this.url = url;
        this.alias = alias;
        Random random = new Random();
        this.secretCode = random.nextInt((9999 - 100) + 1) + 10;
        this.hitCount = 0;
    }

    public Properties() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getSecretCode() {
        return secretCode;
    }
    public Integer getHitCount() {
        return hitCount;
    }

    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }

    public void setSecretCode(Integer secretCode) {
        this.secretCode = secretCode;
    }

}
