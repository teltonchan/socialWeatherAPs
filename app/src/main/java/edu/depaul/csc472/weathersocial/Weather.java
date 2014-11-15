package edu.depaul.csc472.weathersocial;

/**
 * Created by De C Chin on 11/8/2014.
 */


import java.util.ArrayList;
import java.util.List;

public class Weather {

    private String date;

    private List<Hourly> hourly = new ArrayList<Hourly>();

    private String maxtempC;

    private String maxtempF;

    private String mintempC;

    private String mintempF;

    //getDate property
    public String getDate() {
        return date;
    }

    //setDate property
    public void setDate(String date) {
        this.date = date;
    }

    //getHourly property
    public List<Hourly> getHourly() {
        return hourly;
    }

    //setHourly property
    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }

    //getMaxtempC property
    public String getMaxtempC() {
        return maxtempC;
    }

    //setMaxtempC property
    public void setMaxtempC(String maxtempC) {
        this.maxtempC = maxtempC;
    }

    //getMaxtempF property
    public String getMaxtempF() {
        return maxtempF;
    }

    //setMaxtempF property
    public void setMaxtempF(String maxtempF) {
        this.maxtempF = maxtempF;
    }

    //getMintempC property
    public String getMintempC() {
        return mintempC;
    }

    //setMintempC property
    public void setMintempC(String mintempC) {
        this.mintempC = mintempC;
    }

    //getMintempF property
    public String getMintempF() {
        return mintempF;
    }

    //setMintempF propety
    public void setMintempF(String mintempF) {
        this.mintempF = mintempF;
    }


}
