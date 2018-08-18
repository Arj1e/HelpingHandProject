package com.example.helpinghand.ServerDataClasses;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
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
    public void isExist(final String login, final String password){

        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                OkHttpClient client = new OkHttpClient();
                MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                Map<String, String> params = new HashMap<String, String>();

                params.put("Login", login);
                params.put("Password", password);

                JSONObject parameter = new JSONObject(params);
                RequestBody body = RequestBody.create(JSON, parameter.toString());
                Request request = new Request.Builder()
                        .url("http://arjie.cba.pl/IsExist.php")
                        .put(body)
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
                isExist= o.toString();
            }

        }.execute();
    }

}
