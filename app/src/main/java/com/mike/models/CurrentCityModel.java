package com.mike.models;

/**
 * Created by MichaelHenry on 4/14/14.
 */
public class CurrentCityModel {


    String currentCity;

    String currentCountry;

    public CurrentCityModel() {
    }

    public CurrentCityModel(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getCurrentCountry() {
        return currentCountry;
    }

    public void setCurrentCountry(String currentCountry) {
        this.currentCountry = currentCountry;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }
}
