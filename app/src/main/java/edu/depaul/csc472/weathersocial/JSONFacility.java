package edu.depaul.csc472.weathersocial;

import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dchin on 11/8/2014.
 */



public class JSONFacility {

    //CurrentCondition local variables
    String  cloudcover,FeelsLikeC, FeelsLikeF, humidity,observation_time,precipMM,pressure,temp_C,temp_F,visibility,weatherCode,
            winddir16Point,winddirDegree,windspeedKmph,windspeedMiles, WeatherCode;
    List weatherIconUrl,weatherDesc;


    private HttpClient client;
    private final String tag = "JSONFacility";
    private final String beginURL = "http://api.worldweatheronline.com/free/v2/weather.ashx?key=dd00837af36c5783d51c011d0b899b8cccabd18a&&q=";
    private final String endURL = "&format=json&num_of_days=7";
    private final String Url;


    private CurrentCondition ccObject = new CurrentCondition();
    private List<Weather> weather = new ArrayList<Weather>();
    private CurrentCondition currentcondition = new CurrentCondition();

    //constructor
    public JSONFacility(String city){
        Url = beginURL + city + endURL;
    }

    //public properties to supply for the UI
    public String getHumidity(){
        return humidity;
    }
    public String getPressure(){
        return pressure;
    }

    public String getWeatherIconUrl(){
        return weatherIconUrl.get(0).toString();
    }

    public String getWeatherDesc(){
        return weatherDesc.get(0).toString();
    }

    public String getWindspeedMiles(){
        return windspeedMiles;
    }

    public List<Weather> getWeather(){
        return weather;
    }

    public CurrentCondition getCurrentCondition(){
        return currentcondition;
    }

    public void getData() throws ClientProtocolException, IOException, JSONException {
            String tag = "JSONObject";

            StringBuilder url = new StringBuilder(Url);
            //url.append(username);
            HttpGet get = new HttpGet(url.toString());
            client = new DefaultHttpClient();


            try {

                HttpResponse r = client.execute(get);


                int status = r.getStatusLine().getStatusCode();
                if(status == 200){
                HttpEntity e = r.getEntity();
                String data = EntityUtils.toString(e);

                JSONObject reader = new JSONObject(data);
                JSONObject Jdata = reader.getJSONObject("data");

                //Weather JSON part data
                JSONArray weatherArray = Jdata.getJSONArray("weather");
                //JSONObject weatherJson = weatherArray.getJSONObject(0);


                //Gson object will do the auto bind data into the object that we need.
                Gson gson = new Gson();
                //current_condition Gson assign into CurrentCondition object
                for(int n = 0; n < weatherArray.length(); n++){

                    JSONObject object = weatherArray.getJSONObject(n);
                    weather.add(gson.fromJson(object.toString(), Weather.class));

                }

                //Current Condition Json part data
                JSONArray ccArray = Jdata.getJSONArray("current_condition");
                JSONObject ccJson = ccArray.getJSONObject(0);

                //Gson object will do the auto bind data into the object that we need.
                currentcondition = gson.fromJson(ccJson.toString(), CurrentCondition.class);

            }
            else{
                Log.e(tag, "getData() error");
            }

            }
            catch (Exception e)
            {
                Log.e(tag, e.toString());
            }
        }




}
