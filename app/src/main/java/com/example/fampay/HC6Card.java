package com.example.fampay;

public class HC6Card {
    private String text;
    private String URL;

    public HC6Card(){

    }

    public HC6Card(String text, String URL) {
        this.text = text;
        this.URL = URL;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
