package com.example.helpinghand.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helpinghand.R;
import com.example.helpinghand.ServerDataClasses.DownloadUsers;
import com.example.helpinghand.ServerDataClasses.User;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {

    User[] UsersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextView testV = (TextView) findViewById(R.id.testView);
        Button loginBtn= (Button) findViewById(R.id.loginBtn);
        final DownloadUsers userCheck = new DownloadUsers();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                            userCheck.isExist("test","test");
                UsersList= new Gson().fromJson(userCheck.getUserExist(), User[].class);
        for(User x : UsersList){
                                testV.setText(x.getNAME()+" "+x.getFORENAME());


                        Log.d("Insert of"+x.getID()+" :","Dziaa");
                    }

                }


        });



    }

}
