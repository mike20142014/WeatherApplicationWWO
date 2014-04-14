package com.mike.models;

/**
 * Created by MichaelHenry on 4/14/14.
 */
public class CurrentConditionModel {

    String feelsLike;
    String humidity;
    String observationTime;
    String temp;
    String value;
    String windSpeed;
    String weatherIcon;
    String windDirection;

    public CurrentConditionModel() {
    }

    public CurrentConditionModel(String feelsLike, String humidity, String observationTime, String temp, String value, String windSpeed, String weatherIcon) {
        this.feelsLike = feelsLike;
        this.humidity = humidity;
        this.observationTime = observationTime;
        this.temp = temp;
        this.value = value;
        this.windSpeed = windSpeed;
        this.weatherIcon = weatherIcon;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }


}
