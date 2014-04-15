package com.mike.models;

/**
 * Created by MichaelHenry on 4/14/14.
 */
public class EverydayWeatherModel {

    /**
     * For JSON array items NOT hourly!!But daily!!
     */
    String sunRise;
    String sunSet;
    String moonRise;
    String moonSet;

    /**
     * For JSON array items hourly
     */
    String EverydayDate;
    String EverydayMaxTempF;
    String EverydayMinTempF;
    String EverydayMaxTempC;
    String EverydayMinTempC;

    /**
     * For JSON array items hourly
     */
    String EverydayWeatherICON;
    String EverydayHumidity;
    String EverydayWindChillF;
    String EverydayWeatherDescriptionValue;
    String EverydayFeelsLike;
    String EverydayDewPoint;
    String EverydayWindDirection;
    String EverydayTempF;

    public String getEverydayDate() {
        return EverydayDate;
    }

    public void setEverydayDate(String everydayDate) {
        EverydayDate = everydayDate;
    }

    public String getEverydayMaxTempF() {
        return EverydayMaxTempF;
    }

    public void setEverydayMaxTempF(String everydayMaxTempF) {
        EverydayMaxTempF = everydayMaxTempF;
    }

    public String getEverydayMinTempF() {
        return EverydayMinTempF;
    }

    public void setEverydayMinTempF(String everydayMinTempF) {
        EverydayMinTempF = everydayMinTempF;
    }

    public String getEverydayMaxTempC() {
        return EverydayMaxTempC;
    }

    public void setEverydayMaxTempC(String everydayMaxTempC) {
        EverydayMaxTempC = everydayMaxTempC;
    }

    public String getEverydayMinTempC() {
        return EverydayMinTempC;
    }

    public void setEverydayMinTempC(String everydayMinTempC) {
        EverydayMinTempC = everydayMinTempC;
    }

    public String getEverydayWeatherICON() {
        return EverydayWeatherICON;
    }

    public void setEverydayWeatherICON(String everydayWeatherICON) {
        EverydayWeatherICON = everydayWeatherICON;
    }

    public String getEverydayHumidity() {
        return EverydayHumidity;
    }

    public void setEverydayHumidity(String everydayHumidity) {
        EverydayHumidity = everydayHumidity;
    }

    public String getEverydayWindChillF() {
        return EverydayWindChillF;
    }

    public void setEverydayWindChillF(String everydayWindChillF) {
        EverydayWindChillF = everydayWindChillF;
    }

    public String getEverydayWeatherDescriptionValue() {
        return EverydayWeatherDescriptionValue;
    }

    public void setEverydayWeatherDescriptionValue(String everydayWeatherDescriptionValue) {
        EverydayWeatherDescriptionValue = everydayWeatherDescriptionValue;
    }

    public String getEverydayFeelsLike() {
        return EverydayFeelsLike;
    }

    public void setEverydayFeelsLike(String everydayFeelsLike) {
        EverydayFeelsLike = everydayFeelsLike;
    }

    public String getEverydayDewPoint() {
        return EverydayDewPoint;
    }

    public void setEverydayDewPoint(String everydayDewPoint) {
        EverydayDewPoint = everydayDewPoint;
    }

    public String getEverydayWindDirection() {
        return EverydayWindDirection;
    }

    public void setEverydayWindDirection(String everydayWindDirection) {
        EverydayWindDirection = everydayWindDirection;
    }

    public String getEverydayTempF() {
        return EverydayTempF;
    }

    public void setEverydayTempF(String everydayTempF) {
        EverydayTempF = everydayTempF;
    }


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
