package com.example.helpinghand;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helpinghand.ServerDataClasses.DatabaseHelper;
import com.example.helpinghand.ServerDataClasses.DownloadUsers;
import com.example.helpinghand.ServerDataClasses.User;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements LocationListener {

    DatabaseHelper UserBase;
    private Double Latitude,Longtitude;
    private LocationManager locationManager;
    User[] UsersList;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Project Stuff
        UserBase = new DatabaseHelper(this);
        Button CheckPossButton = (Button) findViewById(R.id.ChckPosBtn);
        final Button ChceckBase = (Button) findViewById(R.id.BaseBtn);
        CheckPossButton.setClickable(false);

       locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
       locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, this);

        final TextView Lng = (TextView) findViewById(R.id.LngTxt);
        final TextView Lat = (TextView) findViewById(R.id.LatTxt);
        final TextView JsonOutput = (TextView)findViewById(R.id.JsonTxt);
        final DownloadUsers UsersJson = new DownloadUsers();
        UsersJson.LoadUsers();


        CheckPossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Lat.setText(String.valueOf(Latitude));
                Lng.setText(String.valueOf(Longtitude));
        UsersList= new Gson().fromJson(UsersJson.getUser(), User[].class);
        for(User x : UsersList){
           boolean IsSucces = UserBase.insertData(x.getID(),x.getLOGIN(),x.getPASSWORD(),x.getNAME(),x.getFORENAME(),x.getPOINTS(),null,null);
           if(IsSucces){
               Log.d("Insert of"+x.getID()+" :", "Succesfull ");
           }else{
               Log.d("Insert of"+x.getID()+" :","Failed");
           }
           ChceckBase.setVisibility(View.VISIBLE);
        }
//        if(UsersJson != null) {
//            String showUsers = "";
//            for(User x:UsersList){
//                showUsers +=x.getNAME()+" ";
//            }
//            JsonOutput.setText(showUsers);
//        }
            }
        });
        ChceckBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = UserBase.getData("95020407072");
                StringBuffer buffer= new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("NAME :"+ res.getString(0)+"\n");
                }
                JsonOutput.setText(buffer.toString());
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
