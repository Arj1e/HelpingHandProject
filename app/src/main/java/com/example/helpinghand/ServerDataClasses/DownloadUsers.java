package com.example.helpinghand.ServerDataClasses;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DownloadUsers {
    public String getUser() {
        return User;
    }
    public String getUserExist() {
        return isExist;
    }

    String User;
    String isExist;
    public String LoadUsers(){

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("http://arjie.cba.pl/Users.php")
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    return  response.body().string();

                }catch (IOException e){
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected  void onPostExecute(Object o) {
                // JsonOutput.setText(o.toString())
                  User= o.toString();
            }

        }.execute();

        return null;
    }
    public Boolean isExist(final String login, final String password){
        final Boolean[] Existance = new Boolean[1];
        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                OkHttpClient client = new OkHttpClient();
                RequestBody requestBody = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("Login", login)
                        .addFormDataPart("Password", password)
                        .build();

                Request request = new Request.Builder()
                        .url("http://arjie.cba.pl/IsExistPost.php")
                        .post(requestBody)
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    return  response.body().string();

                }catch (IOException e){
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected  void onPostExecute(Object o) {



                if(o.toString().equals("[true]")){
                Existance[0] = true;

                }else{
                Existance[0] = false;

                }
            }

        }.execute();
        return Existance[0];
    }

}
