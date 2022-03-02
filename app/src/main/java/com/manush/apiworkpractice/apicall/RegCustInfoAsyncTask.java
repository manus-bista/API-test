package com.manush.apiworkpractice.apicall;

import android.os.AsyncTask;

import com.manush.apiworkpractice.utils.SendOkHttpClientToApi;
import com.manush.apiworkpractice.utils.Utils;

import org.json.JSONObject;

public class RegCustInfoAsyncTask extends AsyncTask<String,String,String> {

        String urlPath3;
        JSONObject jsonObject3;
        Callback3 callback3;

        public RegCustInfoAsyncTask(String urlPath3, JSONObject jsonObject3, Callback3 callback3 ){
            this.urlPath3 = urlPath3;
            this.jsonObject3= jsonObject3;
            this.callback3 = callback3;

        }

        @Override
        protected String doInBackground(String... strings) {
            String responseData = null;
            try {
                SendOkHttpClientToApi sendOkHttpClientToApi = new SendOkHttpClientToApi();
                Utils utils = new Utils();
                responseData = sendOkHttpClientToApi.SendHttpData3(urlPath3, jsonObject3);
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
                callback3.OnSuccess(s);
                System.out.println(jsonObject);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        public interface Callback3{
            void OnSuccess(String data);

            void OnFail(String msg);
        }
    }

