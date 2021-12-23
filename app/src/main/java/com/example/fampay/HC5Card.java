package com.example.fampay;

public class HC5Card {
    private String text;
    private String URL;
    private String Color;

    public HC5Card(){

    }

    public HC5Card(String text, String URL) {
        this.text = text;
        this.URL = URL;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
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
