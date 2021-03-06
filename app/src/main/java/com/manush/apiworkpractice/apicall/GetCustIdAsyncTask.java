package com.manush.apiworkpractice.apicall;

import android.os.AsyncTask;

import com.manush.apiworkpractice.utils.SendOkHttpClientToApi;
import com.manush.apiworkpractice.utils.Utils;

import org.json.JSONObject;

public class GetCustIdAsyncTask extends AsyncTask<String, String, String> {

    String urlPath2;
    JSONObject jsonObject2;
    Callback2 callback2;

    public GetCustIdAsyncTask(String urlPath2, JSONObject jsonObject2, Callback2 callback2) {
        this.urlPath2 = urlPath2;
        this.jsonObject2 = jsonObject2;
        this.callback2 = callback2;
    }

    @Override
    protected String doInBackground(String... strings) {
            String responseData = null;
        try {
            SendOkHttpClientToApi sendOkHttpClientToApi = new SendOkHttpClientToApi();
            Utils utils = new Utils();
            responseData = sendOkHttpClientToApi.SendHttpData2(urlPath2, jsonObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseData;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject2 = new JSONObject(s);
            callback2.OnSuccess(s);
            System.out.println(jsonObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface Callback2{
        void OnSuccess(String data);

        void OnFail(String msg);
    }

}

