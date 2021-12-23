package com.example.fampay;

public class HC3Card {
    private String text;
    private String URL;
    private String desc;

    public HC3Card(){

    }

    public HC3Card(String text, String URL) {
        this.text = text;
        this.URL = URL;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
