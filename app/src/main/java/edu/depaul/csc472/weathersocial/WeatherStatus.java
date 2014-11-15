package edu.depaul.csc472.weathersocial;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeatherStatus extends Activity {
    private final int ZOOM = 15;
    private final List<WeatherView> view = new ArrayList<WeatherView>();
    private MapHandler locationHandler;

    private CurrentWeather mainView;
    private String currentCity;
    private GoogleMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_status);
        //Setup all views
        initialize();
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        locationHandler = new MapHandler(this,map);
        map.setOnMapClickListener(locationHandler);
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {

                currentCity = locationHandler.getCurrentCity();
                mainView.setMainCity(currentCity);

            if (currentCity != null) {
                locationHandler.drawMap();
            } else
                ErrorMessage("Can't find your current location. Please check your internet connection.");

            requestJSONData(currentCity);



        } catch (IOException e) {
            ErrorMessage("Can't find your current location. Please check your internet connection.");
        }


    }

    //Connect to weather server for data.
    private void requestJSONData(String currentCity) {
        currentCity = currentCity.toLowerCase();
        new getWeatherData(currentCity).execute();
    }

    //Interact with Social button. Run Social page and destroy activity.
    public void socialHandler(View v) {
        //TODO GO TO SOCIAL PAGE.
        finish();
    }

    //Interact with logout button. Just call login page and destroy this activity.
    public void logoutHandler(View v) {
        Intent loginPage = new Intent(WeatherStatus.this, WeatherSocial.class);
        startActivity(loginPage);
        finish();
    }

    //Set up all View in daily section.
    private void initialize() {
        mainView = new CurrentWeather((TextView) findViewById(R.id.cityScreen),
                (TextView) findViewById(R.id.currentTemp),
                (TextView) findViewById(R.id.minmaxTemp),
                (TextView) findViewById(R.id.detail),
                (ImageView) findViewById(R.id.weatherImage));

        view.add(new WeatherView((TextView) findViewById(R.id.date1),
                (TextView) findViewById(R.id.temp1),
                //(TextView) findViewById(R.id.status1),
                (ImageView) findViewById(R.id.forecastImage1)));
        view.add(new WeatherView((TextView) findViewById(R.id.date2),
                (TextView) findViewById(R.id.temp2),
                //(TextView) findViewById(R.id.status2),
                (ImageView) findViewById(R.id.forecastImage2)));
        view.add(new WeatherView((TextView) findViewById(R.id.date3),
                (TextView) findViewById(R.id.temp3),
                //(TextView) findViewById(R.id.status3),
                (ImageView) findViewById(R.id.forecastImage3)));
        view.add(new WeatherView((TextView) findViewById(R.id.date4),
                (TextView) findViewById(R.id.temp4),
                //(TextView) findViewById(R.id.status4),
                (ImageView) findViewById(R.id.forecastImage4)));
        view.add(new WeatherView((TextView) findViewById(R.id.date5),
                (TextView) findViewById(R.id.temp5),
               // (TextView) findViewById(R.id.status5),
                (ImageView) findViewById(R.id.forecastImage5)));


    }



    //Show Toast with error message.
    private void ErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.weather_status, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class getWeatherData extends AsyncTask<Void, Void,  Void> {

        private final JSONFacility facility;

        getWeatherData(String city){
            facility = new JSONFacility(city);
        }
        @Override
        protected Void doInBackground(Void... params) {

            //using the try to get data and catch any issue if it happens
            try {
                facility.getData();
                return null;
                //setWeatherData(facility);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //return default if it is okay
            return null;
        }

        @Override
        protected void onPostExecute(Void p) {
            super.onPostExecute(p);
            char symbol = (char) 0x00B0;

            TextView currentTemp = (TextView) findViewById(R.id.currentTemp);
            TextView minmaxTemp = (TextView) findViewById(R.id.minmaxTemp);
            TextView detail = (TextView) findViewById(R.id.detail);



            /******************************************************************************************
             * this is the section for the facility to get the data for weather and current condition
             */
            List<Weather> list_W = new ArrayList<Weather>();

            for(int i=0 ;i < 5; i++){
                list_W.add(facility.getWeather().get(i));
            }

            for(int i=0 ;i < 5; i++) {
                String maxMinTemp = list_W.get(i).getMaxtempF() + symbol +"F/"+list_W.get(i).getMaxtempF()+symbol+"F";
                List<Hourly> hourly = list_W.get(i).getHourly();
                String tempurl = hourly.get(4).getWeatherIconUrl().get(0).getValue();
                tempurl = iconName(tempurl);
                int W_image = getResources().getIdentifier(tempurl, "drawable", getPackageName());

                view.get(i).setImage(W_image);
                view.get(i).setDate(getLocalDay(list_W.get(i).getDate()));
                view.get(i).setTemp(maxMinTemp);

            }


            /******************************************************************************************
             * this section for the 1 section
             */

            CurrentCondition current =facility.getCurrentCondition();

            //set the temp F
            currentTemp.setText(current.getTemp_F() + symbol+"F/"+current.getTemp_C()+symbol+"C");
            //set min and max temp
            Weather weatherDay1 = facility.getWeather().get(0);
            minmaxTemp.setText(weatherDay1.getMintempF()+symbol+"F/"+weatherDay1.getMaxtempF()+symbol+"F");
            //weather detail

            List<WeatherDesc> WD = current.getWeatherDesc();
            WeatherDesc D = WD.get(0);
            detail.setText(D.getWD()+"\n"+"wind speed: "+current.getWindspeedMiles()+"\n"+ "humidity: "+current.getHumidity());


            /******************************************************************************************
             * this section for all the images
             */

            List<WeatherIconUrl> url = current.getWeatherIconUrl();
            WeatherIconUrl l = url.get(0);
            String MainUrl = l.getValue();

            //clean out the link strings
            String MainIcon = iconName(MainUrl);
            //get the id from the name of the image
            int j = getResources().getIdentifier(MainIcon, "drawable", getPackageName());
            //assign the icon to the app
            ImageView pp = (ImageView) findViewById(R.id.weatherImage);
            pp.setImageResource(j);


            //loop all the image to the 5 day forcast.



        }

        //this function converst date to day of the week
        private String getLocalDay(String datetime){

            try {
                //get today's date for today's label
               int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
               String Today = getDay(day);

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date localDate = formatter.parse(datetime);

                if(Today.toString().toLowerCase().equals(localDate.toString().substring(0,3).toLowerCase()))
                    return "Today";
               else
                    return localDate.toString().substring(0,3);


            }
            catch(Exception e){

            }

            return "";
        }

        private String getDay(int d){

           String day = "";
            if(d == 1)
                day = "Sun";
            else if(d == 2)
                day =  "Mon";
            else if(d == 3)
                day =  "Tue";
            else if(d == 4)
                day =  "Wed";
            else if(d == 5)
                day =  "Thu";
            else if(d == 6)
                day =  "Fri";
            else if(d == 7)
                day =  "Sat";

                return day;
        }

        private String iconName(String name){

            int first = name.indexOf("wsymbol_");
            int last = name.lastIndexOf(".png");
            return name.substring(first,last);

        }

    }

    }

