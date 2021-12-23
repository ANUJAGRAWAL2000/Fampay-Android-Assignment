package com.example.fampay;

public class HC1Card {
    private String text;
    private String URL;

    public HC1Card(){

    }

    public HC1Card(String text, String URL) {
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
