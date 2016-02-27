package com.example.riki.doctor;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class ShowMap extends ActionBarActivity {
    GoogleMap googleMap;
    Marker marker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_map);
        Intent intent=getIntent();
        String store=intent.getStringExtra("store");
        double lat=intent.getDoubleExtra("lat",1.0);
        double longi=intent.getDoubleExtra("longi",1.0);
        LatLng latLng=new LatLng(lat,longi);

        try{
            if(googleMap == null){
                googleMap=((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();

            }
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            googleMap.setMyLocationEnabled(true);


            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
            //googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            //googleMap.getCameraPosition().target;

            marker=googleMap.addMarker(new MarkerOptions().position(latLng).title(store));


        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
