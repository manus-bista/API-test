package com.manush.apiworkpractice.apicall;

import android.os.AsyncTask;

import com.manush.apiworkpractice.utils.SendOkHttpClientToApi;
import com.manush.apiworkpractice.utils.Utils;

import org.json.JSONObject;

public class CheckPhnRstAsyncTask extends AsyncTask<String,String,String> {

    String urlPath;
    JSONObject jsonObject;
    Callback callback;

    public CheckPhnRstAsyncTask(String urlPath, JSONObject jsonObject, Callback callback ){
        this.urlPath = urlPath;
        this.jsonObject = jsonObject;
        this.callback = callback;

    }

    @Override
    protected String doInBackground(String... strings) {
        String responseData = null;
        try {
            SendOkHttpClientToApi sendOkHttpClientToApi = new SendOkHttpClientToApi();
            Utils utils = new Utils();
            responseData = sendOkHttpClientToApi.SendHttpData(urlPath, jsonObject);
        }catch (Exception e){
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
            JSONObject jsonObject = new JSONObject(s);
            callback.OnSuccess(s);
            System.out.println(jsonObject);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public interface Callback{
        void OnSuccess(String data);

        void OnFail(String msg);
    }
}
