package edu.depaul.csc472.weathersocial;

/**
 * Created by dchin on 11/8/2014.
 */


import java.util.ArrayList;
import java.util.List;

public class Hourly {


    private String chanceoffog;
    private String chanceoffrost;
    private String chanceofhightemp;
    private String chanceofovercast;
    private String chanceofrain;
    private String chanceofremdry;
    private String chanceofsnow;
    private String chanceofsunshine;
    private String chanceofthunder;
    private String chanceofwindy;
    private String cloudcover;
    private String DewPointC;
    private String DewPointF;
    private String FeelsLikeC;
    private String FeelsLikeF;
    private String HeatIndexC;
    private String HeatIndexF;
    private String humidity;
    private String precipMM;
    private String pressure;
    private String tempC;
    private String tempF;
    private String time;
    private String visibility;
    private String weatherCode;
    private List<WeatherDesc> weatherDesc = new ArrayList<WeatherDesc>();
    private List<WeatherIconUrl> weatherIconUrl = new ArrayList<WeatherIconUrl>();
    private String WindChillC;
    private String WindChillF;
    private String winddir16Point;
    private String winddirDegree;
    private String WindGustKmph;
    private String WindGustMiles;
    private String windspeedKmph;
    private String windspeedMiles;

    /**
     *
     * @return
     * The chanceoffog
     */
    public String getChanceoffog() {
        return chanceoffog;
    }

    /**
     *
     * @param chanceoffog
     * The chanceoffog
     */
    public void setChanceoffog(String chanceoffog) {
        this.chanceoffog = chanceoffog;
    }

    public Hourly withChanceoffog(String chanceoffog) {
        this.chanceoffog = chanceoffog;
        return this;
    }

    /**
     *
     * @return
     * The chanceoffrost
     */
    public String getChanceoffrost() {
        return chanceoffrost;
    }

    /**
     *
     * @param chanceoffrost
     * The chanceoffrost
     */
    public void setChanceoffrost(String chanceoffrost) {
        this.chanceoffrost = chanceoffrost;
    }

    public Hourly withChanceoffrost(String chanceoffrost) {
        this.chanceoffrost = chanceoffrost;
        return this;
    }

    /**
     *
     * @return
     * The chanceofhightemp
     */
    public String getChanceofhightemp() {
        return chanceofhightemp;
    }

    /**
     *
     * @param chanceofhightemp
     * The chanceofhightemp
     */
    public void setChanceofhightemp(String chanceofhightemp) {
        this.chanceofhightemp = chanceofhightemp;
    }

    public Hourly withChanceofhightemp(String chanceofhightemp) {
        this.chanceofhightemp = chanceofhightemp;
        return this;
    }

    /**
     *
     * @return
     * The chanceofovercast
     */
    public String getChanceofovercast() {
        return chanceofovercast;
    }

    /**
     *
     * @param chanceofovercast
     * The chanceofovercast
     */
    public void setChanceofovercast(String chanceofovercast) {
        this.chanceofovercast = chanceofovercast;
    }

    public Hourly withChanceofovercast(String chanceofovercast) {
        this.chanceofovercast = chanceofovercast;
        return this;
    }

    /**
     *
     * @return
     * The chanceofrain
     */
    public String getChanceofrain() {
        return chanceofrain;
    }

    /**
     *
     * @param chanceofrain
     * The chanceofrain
     */
    public void setChanceofrain(String chanceofrain) {
        this.chanceofrain = chanceofrain;
    }

    public Hourly withChanceofrain(String chanceofrain) {
        this.chanceofrain = chanceofrain;
        return this;
    }

    /**
     *
     * @return
     * The chanceofremdry
     */
    public String getChanceofremdry() {
        return chanceofremdry;
    }

    /**
     *
     * @param chanceofremdry
     * The chanceofremdry
     */
    public void setChanceofremdry(String chanceofremdry) {
        this.chanceofremdry = chanceofremdry;
    }

    public Hourly withChanceofremdry(String chanceofremdry) {
        this.chanceofremdry = chanceofremdry;
        return this;
    }

    /**
     *
     * @return
     * The chanceofsnow
     */
    public String getChanceofsnow() {
        return chanceofsnow;
    }

    /**
     *
     * @param chanceofsnow
     * The chanceofsnow
     */
    public void setChanceofsnow(String chanceofsnow) {
        this.chanceofsnow = chanceofsnow;
    }

    public Hourly withChanceofsnow(String chanceofsnow) {
        this.chanceofsnow = chanceofsnow;
        return this;
    }

    /**
     *
     * @return
     * The chanceofsunshine
     */
    public String getChanceofsunshine() {
        return chanceofsunshine;
    }

    /**
     *
     * @param chanceofsunshine
     * The chanceofsunshine
     */
    public void setChanceofsunshine(String chanceofsunshine) {
        this.chanceofsunshine = chanceofsunshine;
    }

    public Hourly withChanceofsunshine(String chanceofsunshine) {
        this.chanceofsunshine = chanceofsunshine;
        return this;
    }

    /**
     *
     * @return
     * The chanceofthunder
     */
    public String getChanceofthunder() {
        return chanceofthunder;
    }

    /**
     *
     * @param chanceofthunder
     * The chanceofthunder
     */
    public void setChanceofthunder(String chanceofthunder) {
        this.chanceofthunder = chanceofthunder;
    }

    public Hourly withChanceofthunder(String chanceofthunder) {
        this.chanceofthunder = chanceofthunder;
        return this;
    }

    /**
     *
     * @return
     * The chanceofwindy
     */
    public String getChanceofwindy() {
        return chanceofwindy;
    }

    /**
     *
     * @param chanceofwindy
     * The chanceofwindy
     */
    public void setChanceofwindy(String chanceofwindy) {
        this.chanceofwindy = chanceofwindy;
    }

    public Hourly withChanceofwindy(String chanceofwindy) {
        this.chanceofwindy = chanceofwindy;
        return this;
    }

    /**
     *
     * @return
     * The cloudcover
     */
    public String getCloudcover() {
        return cloudcover;
    }

    /**
     *
     * @param cloudcover
     * The cloudcover
     */
    public void setCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
    }

    public Hourly withCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
        return this;
    }

    /**
     *
     * @return
     * The DewPointC
     */
    public String getDewPointC() {
        return DewPointC;
    }

    /**
     *
     * @param DewPointC
     * The DewPointC
     */
    public void setDewPointC(String DewPointC) {
        this.DewPointC = DewPointC;
    }

    public Hourly withDewPointC(String DewPointC) {
        this.DewPointC = DewPointC;
        return this;
    }

    /**
     *
     * @return
     * The DewPointF
     */
    public String getDewPointF() {
        return DewPointF;
    }

    /**
     *
     * @param DewPointF
     * The DewPointF
     */
    public void setDewPointF(String DewPointF) {
        this.DewPointF = DewPointF;
    }

    public Hourly withDewPointF(String DewPointF) {
        this.DewPointF = DewPointF;
        return this;
    }

    /**
     *
     * @return
     * The FeelsLikeC
     */
    public String getFeelsLikeC() {
        return FeelsLikeC;
    }

    /**
     *
     * @param FeelsLikeC
     * The FeelsLikeC
     */
    public void setFeelsLikeC(String FeelsLikeC) {
        this.FeelsLikeC = FeelsLikeC;
    }

    public Hourly withFeelsLikeC(String FeelsLikeC) {
        this.FeelsLikeC = FeelsLikeC;
        return this;
    }

    /**
     *
     * @return
     * The FeelsLikeF
     */
    public String getFeelsLikeF() {
        return FeelsLikeF;
    }

    /**
     *
     * @param FeelsLikeF
     * The FeelsLikeF
     */
    public void setFeelsLikeF(String FeelsLikeF) {
        this.FeelsLikeF = FeelsLikeF;
    }

    public Hourly withFeelsLikeF(String FeelsLikeF) {
        this.FeelsLikeF = FeelsLikeF;
        return this;
    }

    /**
     *
     * @return
     * The HeatIndexC
     */
    public String getHeatIndexC() {
        return HeatIndexC;
    }

    /**
     *
     * @param HeatIndexC
     * The HeatIndexC
     */
    public void setHeatIndexC(String HeatIndexC) {
        this.HeatIndexC = HeatIndexC;
    }

    public Hourly withHeatIndexC(String HeatIndexC) {
        this.HeatIndexC = HeatIndexC;
        return this;
    }

    /**
     *
     * @return
     * The HeatIndexF
     */
    public String getHeatIndexF() {
        return HeatIndexF;
    }

    /**
     *
     * @param HeatIndexF
     * The HeatIndexF
     */
    public void setHeatIndexF(String HeatIndexF) {
        this.HeatIndexF = HeatIndexF;
    }

    public Hourly withHeatIndexF(String HeatIndexF) {
        this.HeatIndexF = HeatIndexF;
        return this;
    }

    /**
     *
     * @return
     * The humidity
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     *
     * @param humidity
     * The humidity
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Hourly withHumidity(String humidity) {
        this.humidity = humidity;
        return this;
    }

    /**
     *
     * @return
     * The precipMM
     */
    public String getPrecipMM() {
        return precipMM;
    }

    /**
     *
     * @param precipMM
     * The precipMM
     */
    public void setPrecipMM(String precipMM) {
        this.precipMM = precipMM;
    }

    public Hourly withPrecipMM(String precipMM) {
        this.precipMM = precipMM;
        return this;
    }

    /**
     *
     * @return
     * The pressure
     */
    public String getPressure() {
        return pressure;
    }

    /**
     *
     * @param pressure
     * The pressure
     */
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public Hourly withPressure(String pressure) {
        this.pressure = pressure;
        return this;
    }

    /**
     *
     * @return
     * The tempC
     */
    public String getTempC() {
        return tempC;
    }

    /**
     *
     * @param tempC
     * The tempC
     */
    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    public Hourly withTempC(String tempC) {
        this.tempC = tempC;
        return this;
    }

    /**
     *
     * @return
     * The tempF
     */
    public String getTempF() {
        return tempF;
    }

    /**
     *
     * @param tempF
     * The tempF
     */
    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    public Hourly withTempF(String tempF) {
        this.tempF = tempF;
        return this;
    }

    /**
     *
     * @return
     * The time
     */
    public String getTime() {
        return time;
    }

    /**
     *
     * @param time
     * The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    public Hourly withTime(String time) {
        this.time = time;
        return this;
    }

    /**
     *
     * @return
     * The visibility
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     *
     * @param visibility
     * The visibility
     */
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Hourly withVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    /**
     *
     * @return
     * The weatherCode
     */
    public String getWeatherCode() {
        return weatherCode;
    }

    /**
     *
     * @param weatherCode
     * The weatherCode
     */
    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public Hourly withWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
        return this;
    }

    /**
     *
     * @return
     * The weatherDesc
     */
    public List<WeatherDesc> getWeatherDesc() {
        return weatherDesc;
    }

    /**
     *
     * @param weatherDesc
     * The weatherDesc
     */
    public void setWeatherDesc(List<WeatherDesc> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public Hourly withWeatherDesc(List<WeatherDesc> weatherDesc) {
        this.weatherDesc = weatherDesc;
        return this;
    }

    /**
     *
     * @return
     * The weatherIconUrl
     */
    public List<WeatherIconUrl> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    /**
     *
     * @param weatherIconUrl
     * The weatherIconUrl
     */
    public void setWeatherIconUrl(List<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public Hourly withWeatherIconUrl(List<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
        return this;
    }

    /**
     *
     * @return
     * The WindChillC
     */
    public String getWindChillC() {
        return WindChillC;
    }

    /**
     *
     * @param WindChillC
     * The WindChillC
     */
    public void setWindChillC(String WindChillC) {
        this.WindChillC = WindChillC;
    }

    public Hourly withWindChillC(String WindChillC) {
        this.WindChillC = WindChillC;
        return this;
    }

    /**
     *
     * @return
     * The WindChillF
     */
    public String getWindChillF() {
        return WindChillF;
    }

    /**
     *
     * @param WindChillF
     * The WindChillF
     */
    public void setWindChillF(String WindChillF) {
        this.WindChillF = WindChillF;
    }

    public Hourly withWindChillF(String WindChillF) {
        this.WindChillF = WindChillF;
        return this;
    }

    /**
     *
     * @return
     * The winddir16Point
     */
    public String getWinddir16Point() {
        return winddir16Point;
    }

    /**
     *
     * @param winddir16Point
     * The winddir16Point
     */
    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    public Hourly withWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
        return this;
    }

    /**
     *
     * @return
     * The winddirDegree
     */
    public String getWinddirDegree() {
        return winddirDegree;
    }

    /**
     *
     * @param winddirDegree
     * The winddirDegree
     */
    public void setWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
    }

    public Hourly withWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
        return this;
    }

    /**
     *
     * @return
     * The WindGustKmph
     */
    public String getWindGustKmph() {
        return WindGustKmph;
    }

    /**
     *
     * @param WindGustKmph
     * The WindGustKmph
     */
    public void setWindGustKmph(String WindGustKmph) {
        this.WindGustKmph = WindGustKmph;
    }

    public Hourly withWindGustKmph(String WindGustKmph) {
        this.WindGustKmph = WindGustKmph;
        return this;
    }

    /**
     *
     * @return
     * The WindGustMiles
     */
    public String getWindGustMiles() {
        return WindGustMiles;
    }

    /**
     *
     * @param WindGustMiles
     * The WindGustMiles
     */
    public void setWindGustMiles(String WindGustMiles) {
        this.WindGustMiles = WindGustMiles;
    }

    public Hourly withWindGustMiles(String WindGustMiles) {
        this.WindGustMiles = WindGustMiles;
        return this;
    }

    /**
     *
     * @return
     * The windspeedKmph
     */
    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    /**
     *
     * @param windspeedKmph
     * The windspeedKmph
     */
    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    public Hourly withWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
        return this;
    }

    /**
     *
     * @return
     * The windspeedMiles
     */
    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    /**
     *
     * @param windspeedMiles
     * The windspeedMiles
     */
    public void setWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }

    public Hourly withWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
        return this;
    }

}