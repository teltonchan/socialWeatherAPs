package edu.depaul.csc472.weathersocial;

import java.util.ArrayList;
import java.util.List;



public class CurrentCondition {


    private String cloudcover;
    private String FeelsLikeC;
    private String FeelsLikeF;
    private String humidity;
    private String observationTime;
    private String precipMM;
    private String pressure;
    private String temp_C;
    private String temp_F;
    private String visibility;
    private String weatherCode;
    private List<WeatherDesc> weatherDesc = new ArrayList<WeatherDesc>();
    private List<WeatherIconUrl> weatherIconUrl = new ArrayList<WeatherIconUrl>();
    private String winddir16Point;
    private String winddirDegree;
    private String windspeedKmph;
    private String windspeedMiles;

    //getCloudcover property
    public String getCloudcover() {
        return cloudcover;
    }

    //setCloudcover property
    public void setCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
    }

    //getFeelsLikeC property
    public String getFeelsLikeC() {
        return FeelsLikeC;
    }

    //setFeelsLikeC property
    public void setFeelsLikeC(String FeelsLikeC) {
        this.FeelsLikeC = FeelsLikeC;
    }

    //getFeelsLikeF property
    public String getFeelsLikeF() {
        return FeelsLikeF;
    }

    //setFeelsLikeF property
    public void setFeelsLikeF(String FeelsLikeF) {
        this.FeelsLikeF = FeelsLikeF;
    }

    //getHumidity property
    public String getHumidity() {
        return humidity;
    }

    //setHumidity property
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    //getObservationTime property
    public String getObservationTime() {
        return observationTime;
    }

    //setObservationTime property
    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    //getPrecipMM property
    public String getPrecipMM() {
        return precipMM;
    }

    //setPrecipMM property
    public void setPrecipMM(String precipMM) {
        this.precipMM = precipMM;
    }

    //getPressure property
    public String getPressure() {
        return pressure;
    }

    //setPressure property
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    //getTemp_C property
    public String getTemp_C() {
        return temp_C;
    }

    //setTemp_C property
    public void setTemp_C(String temp_C) {
        this.temp_C = temp_C;
    }

    //getTemp_F property
    public String getTemp_F() {
        return temp_F;
    }

    //setTemp_F property
    public void setTemp_F(String temp_F) {
        this.temp_F = temp_F;
    }

    //getVisibility property
    public String getVisibility() {
        return visibility;
    }

    //setVisibility property
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    //getWeatherCode property
    public String getWeatherCode() {
        return weatherCode;
    }

    //setWeatherCode property
    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    //List getWeatherDesc
    public List<WeatherDesc> getWeatherDesc() {
        return weatherDesc;
    }

    //setWeatherDesc property
    public void setWeatherDesc(List<WeatherDesc> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    //List getWeatherIconUrl property
    public List<WeatherIconUrl> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    //List setWeatherIconUrl property
    public void setWeatherIconUrl(List<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    //getWinddir16Point property
    public String getWinddir16Point() {
        return winddir16Point;
    }

    //setWinddir16Point property
    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    //getWinddirDegree property
    public String getWinddirDegree() {
        return winddirDegree;
    }

    //setWinddirDegree property
    public void setWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
    }


    //getWindspeedKmph property
    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    //setWindspeedKmph property
    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }


    //getWindspeedMiles property
    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    //setWindspeedMiles proerty
    public void setWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }



}