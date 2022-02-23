package com.manush.apiworkpractice.utils;

import com.squareup.picasso.Downloader;

import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SendOkHttpClientToApi {

    public static String SendHttpData(String urlPath, JSONObject jsonObject){

        try {
            MediaType JSon = MediaType.parse("application/json; charset=utf-8");
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();

            RequestBody requestBody = RequestBody.create(JSon, jsonObject.toString());

            Request request = new Request.Builder()
                    .url(urlPath)
                    .post(requestBody)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
