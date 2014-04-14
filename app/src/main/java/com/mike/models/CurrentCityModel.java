package com.mike.models;

/**
 * Created by MichaelHenry on 4/14/14.
 */
public class CurrentCityModel {


    String currentCity;
    String testCommit;
    String anotherCommit;
    String anoter;


    public CurrentCityModel() {
    }

    public CurrentCityModel(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }
}
