package edu.depaul.csc472.weathersocial;

import android.widget.ImageView;
import android.widget.TextView;


public class CurrentWeather {

    private TextView mainCity;
    private TextView currentTemp;
    private TextView currentMinMax;
    private TextView currentDetail;
    private ImageView currentImage;

    CurrentWeather(TextView mainCity, TextView currentTemp, TextView currentMinMax,
                   TextView currentDetail, ImageView currentImage){
        this.mainCity = mainCity;
        this.currentDetail = currentDetail;
        this.currentMinMax = currentMinMax;
        this.currentTemp = currentTemp;
        this.currentImage = currentImage;
    }

    void setMainCity(String city){
        mainCity.setText(city);
    }

    void setCurrentTemp(String temp){
        currentTemp.setText(temp);
    }

    void setCurrentMinMax(String range){
        currentMinMax.setText(range);
    }

    void setCurrentDetail(String detail){
        currentDetail.setText(detail);
    }

    void setCurrentImage(int image){
        currentImage.setImageResource(image);
    }
}
