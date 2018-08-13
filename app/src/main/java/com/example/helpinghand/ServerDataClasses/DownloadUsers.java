package com.example.helpinghand.ServerDataClasses;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadUsers {
    public String getUser() {
        return User;
    }

    String User;
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

}
