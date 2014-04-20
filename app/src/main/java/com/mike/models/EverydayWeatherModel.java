package com.mike.models;

import android.content.Context;

/**
 * Created by MichaelHenry on 4/14/14.
 */
public class EverydayWeatherModel {

    /**
     * For JSON array items NOT hourly!!But daily!!
     */
    private String sunRise;
    private String sunSet;
    private String moonRise;
    private String moonSet;

    /**
     * For JSON array items hourly
     */
    private String EverydayDate;
    private String EverydayMaxTempF;
    private String EverydayMinTempF;
    private String EverydayMaxTempC;
    private String EverydayMinTempC;

    /**
     * For JSON array items hourly
     */
    private String EverydayWeatherICON;
    private String EverydayHumidity;
    private String EverydayWindChillF;
    private String EverydayWeatherDescriptionValue;
    private String EverydayFeelsLike;
    private String EverydayDewPoint;
    private String EverydayWindDirection;
    private String EverydayTempF;
    private String EverydayWindSpeed;
    Context context;

    public EverydayWeatherModel(Context context) {
        super();
        this.context = context;
    }

    public EverydayWeatherModel(String url) {
        super();
        this.EverydayWeatherICON = url;
    }

    public EverydayWeatherModel(String sunRise, String sunSet, String moonRise, String moonSet) {

        super();
        this.sunRise = sunRise;
        this.sunSet = sunSet;
        this.moonRise = moonRise;
        this.moonSet = moonSet;
    }

    public String getEverydayWindSpeed() {
        return EverydayWindSpeed;
    }

    public void setEverydayWindSpeed(String everydayWindSpeed) {
        EverydayWindSpeed = everydayWindSpeed;
    }

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
