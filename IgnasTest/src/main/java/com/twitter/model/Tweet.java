package com.twitter.model;

public class Tweet {

    private String text, author, tag;

    public Tweet(String text, String author, String tag) {
        this.text = text;
        this.author = author;
        this.tag = tag;
    }

    public Tweet(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
