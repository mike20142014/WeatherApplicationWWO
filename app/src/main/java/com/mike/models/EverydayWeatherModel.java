package com.mike.models;

/**
 * Created by MichaelHenry on 4/14/14.
 */
public class EverydayWeatherModel {

    String sunRise;
    String sunSet;
    String moonRise;
    String moonSet;


    public EverydayWeatherModel() {
    }

    public EverydayWeatherModel(String sunRise, String sunSet, String moonRise, String moonSet) {
        this.sunRise = sunRise;
        this.sunSet = sunSet;
        this.moonRise = moonRise;
        this.moonSet = moonSet;
    }

    public String getSunRise() {
        return sunRise;
    }

    public void setSunRise(String sunRise) {
        this.sunRise = sunRise;
    }

    public String getSunSet() {
        return sunSet;
    }

    public void setSunSet(String sunSet) {
        this.sunSet = sunSet;
    }

    public String getMoonSet() {
        return moonSet;
    }

    public void setMoonSet(String moonSet) {
        this.moonSet = moonSet;
    }

    public String getMoonRise() {
        return moonRise;
    }

    public void setMoonRise(String moonRise) {
        this.moonRise = moonRise;
    }


}
