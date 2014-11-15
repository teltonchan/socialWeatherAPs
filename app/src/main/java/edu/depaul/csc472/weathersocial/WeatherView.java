package edu.depaul.csc472.weathersocial;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * This class is used for set up all weather daily views in WeatherStatus class.
 * Make a code look shorter and manageable.
 */
public class WeatherView {

    private final TextView date;
    private final TextView temp;
   // private final TextView detail;
    private final ImageView image;
    //Constructor
    WeatherView(TextView date, TextView temp, //TextView detail,
                ImageView image){
        this.date = date;
        //this.detail = detail;
        this.temp = temp;
        this.image = image;
    }
    //Set up date.
    void setDate(String message){
        date.setText(message);
    }
    //Set up temp. Min and max temp.
    void setTemp(String message){
        temp.setText(message);
    }
    //Set detail.

//    void setDetail(String message){
//        detail.setText(message);
//    }
    // Set image.
    void setImage(int image){
        this.image.setImageResource(image);
    }
}
