package com.reddit.demo.Model;

import com.sun.javafx.beans.IDProperty;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.print.DocFlavor;
import java.net.URL;

@Entity
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String url;
    long votes;

    public Post(String title, String url, long votes) {
        this.title = title;
        this.url = url;
        this.votes = votes;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }
}
