package com.example.helpinghand.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helpinghand.R;
import com.example.helpinghand.ServerDataClasses.DatabaseHelper;
import com.example.helpinghand.ServerDataClasses.DownloadUsers;
import com.example.helpinghand.ServerDataClasses.User;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {

    User[] UsersList;
    String login,password;
    DatabaseHelper UserBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        UserBase = new DatabaseHelper(this);
        Button loginBtn= (Button) findViewById(R.id.loginBtn);
        final EditText loginPln= (EditText) findViewById(R.id.loginPln);
        final EditText passwordPln = (EditText)findViewById(R.id.passwordPln);
        final DownloadUsers UsersJson = new DownloadUsers();
        UsersJson.LoadUsers();




        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsersList= new Gson().fromJson(UsersJson.getUser(), User[].class);
                login= loginPln.getText().toString();
                password= passwordPln.getText().toString();
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(User x: UsersList){

                    if(x.getLOGIN().equals(login) && x.getPASSWORD().equals(password)) {

                        boolean IsSucces = UserBase.insertData(x.getID(),x.getLOGIN(),x.getPASSWORD(),x.getNAME(),x.getFORENAME(),x.getPOINTS(),null,null);
                    if(IsSucces){
                        Log.d("Insert of"+x.getID()+" :", "Succesfull ");
                    }else{
                        Log.d("Insert of"+x.getID()+" :","Failed");
                    }


                        Context context = getApplicationContext();
                        CharSequence text = "Loged in as: " + x.getNAME() + " " + x.getFORENAME();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        launchMain();
                        break;
                    }else {
                        loginPln.setText("Incorect login or password");
                    }
                }


            }
        });




    }
    private void launchMain(){
        Intent startBase = new Intent(this, BaseActivity.class);
        startActivity( startBase);
    };

}
