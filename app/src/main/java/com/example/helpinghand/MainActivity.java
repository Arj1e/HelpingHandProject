package com.example.helpinghand;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements LocationListener {

    RequestQueue requestQueue;  // This is our requests queue to process our HTTP requests.

    String baseUrl = "http://arjie.cba.pl/Users.php";  // This is the API base URL (GitHub API)
    String url;  // This will hold the full URL which will include the username entered in the etGitHubUser.

    private Double Latitude,Longtitude;
    private LocationManager locationManager;
    List<User> ServerUsers;

    String des_Users_String;
    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Project Stuff
        Button CheckPossButton = (Button) findViewById(R.id.ChckPosBtn);
        CheckPossButton.setClickable(false);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, this);
        final  TextView Lng = (TextView) findViewById(R.id.LngTxt);
        final TextView Lat = (TextView) findViewById(R.id.LatTxt);
        final TextView JsonOutput = (TextView)findViewById(R.id.JsonTxt);
        final Gson Rest_gson = new Gson();

        CheckPossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lat.setText(String.valueOf(Latitude));
                Lng.setText(String.valueOf(Longtitude));


            }
        });



    }

    @Override
    public void onLocationChanged(Location location) {

//        String str = "Latitude: "+location.getLatitude()+" Longitude: "+location.getLongitude();
//
//        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Possition changed",Toast.LENGTH_SHORT).show();
        Latitude = location.getLatitude();
        Longtitude = location.getLongitude();



    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }



}
