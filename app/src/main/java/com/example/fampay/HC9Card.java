package com.example.fampay;

public class HC9Card {
    private String URL;
    private double Ratio;

    public HC9Card(String URL,double Ratio) {
        this.URL = URL;
        this.Ratio = Ratio;
    }

    public HC9Card() {
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public double getRatio() {
        return Ratio;
    }

    public void setRatio(double ratio) {
        Ratio = ratio;
    }
}
