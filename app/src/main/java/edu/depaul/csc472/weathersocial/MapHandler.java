package edu.depaul.csc472.weathersocial;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MapHandler implements LocationListener,GoogleMap.OnMapClickListener{

    private final int ZOOM = 15;
    private final long MIN_REQUEST_UPDATE_TIME = 1000 * 5; // in millisecond --> 5 seconds.
    private final float MIN_DISTANCE = 0; // in Meters --> 1 meter.
    private final Context mainActivity;
    private final GoogleMap map;
    private final LatLng currentLoc;


    MapHandler(Context mainActivity, GoogleMap map){
        this.map = map;
        this.mainActivity = mainActivity;
        this.currentLoc = getCurrentLocation();
        if(currentLoc == null){
            throw new IllegalArgumentException();
        }
    }

    private LatLng  getCurrentLocation(){
        LocationManager finder = (LocationManager) mainActivity.getSystemService(mainActivity.LOCATION_SERVICE);

        boolean hasInternet = finder.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if(hasInternet) {
            finder.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_REQUEST_UPDATE_TIME, MIN_DISTANCE, this);

            Location currentLocation = finder.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            LatLng currentLoc = new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());

            return currentLoc;
        }else
            return null;
    }

    String getCurrentCity() throws IOException {
        Geocoder geographic = new Geocoder(mainActivity, Locale.getDefault());

        List<Address> list_of_city = geographic.getFromLocation(currentLoc.latitude,currentLoc.longitude,1);
        if(list_of_city.size() > 0) {
            String city = list_of_city.get(0).getLocality();
            return city;
        }else
            return null;
    }

    void drawMap(){
        map.addMarker(new MarkerOptions().position(currentLoc).title("You are here"));
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate ZoomIn = CameraUpdateFactory.newLatLngZoom(currentLoc, ZOOM);
        map.moveCamera(ZoomIn);
        map.stopAnimation();
        UiSettings mapSetting = map.getUiSettings();
        mapSetting.setScrollGesturesEnabled(false);
        mapSetting.setZoomGesturesEnabled(false);
        mapSetting.setRotateGesturesEnabled(false);
    }


    @Override
    public void onMapClick(LatLng latLng) {

        Uri currentLocation = Uri.parse("geo:" + currentLoc.latitude + "," + currentLoc.longitude + "?z=" + ZOOM);

        Intent realMap = new Intent(android.content.Intent.ACTION_VIEW,currentLocation);
        mainActivity.startActivity(realMap);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

}
