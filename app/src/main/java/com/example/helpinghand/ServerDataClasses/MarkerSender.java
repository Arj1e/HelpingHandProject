package com.example.helpinghand.ServerDataClasses;

import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MarkerSender {


    public void sendStandardMarker() {
        //String url="http://ptsv2.com/t/ewz7h-1534251350/post";
        String url="http://arjie.cba.pl/ReportNA.php";

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        Map<String, String> params = new HashMap<String, String>();

        params.put("Id", "9999test");
        params.put("Lat", "78.55555");
        params.put("Lng", "78.55555");
        params.put("Status", "2");

        JSONObject parameter = new JSONObject(params);

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, parameter.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("content-type", "application/json; charset=utf-8")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("response", call.request().body().toString());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("response", response.body().string());
            }

        });
    }
}
