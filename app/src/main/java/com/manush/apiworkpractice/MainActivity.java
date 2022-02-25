package com.manush.apiworkpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.manush.apiworkpractice.apicall.GetCustIdAsyncTask;
import com.manush.apiworkpractice.utils.Utils;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button button,button2,button3 ;
    TextView textView,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        button2 =findViewById(R.id.btn2);
        button3 =findViewById(R.id.btn3);
        textView =findViewById(R.id.txt);
        textView2 =findViewById(R.id.txt2);
        textView3 =findViewById(R.id.txt3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils utils = new Utils();
                new GetCustIdAsyncTask(utils.CHECK_PHN_RST,reqPramsFromGetCustId(), new GetCustIdAsyncTask.Callback() {
                    @Override
                    public void OnSuccess(String data) {
                        textView.setText(data);
                    }

                    @Override
                    public void OnFail(String msg) {

                    }
                }).execute();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils utils  =new Utils();
                new  GetCustIdAsyncTask(utils.GET_CUST_ID, reqPramsFromGetCustId(), new GetCustIdAsyncTask.Callback() {
                    @Override
                    public void OnSuccess(String data) {
                        textView2.setText(data);
                    }

                    @Override
                    public void OnFail(String msg) {

                    }
                }).execute();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils utils = new Utils();
                new GetCustIdAsyncTask(utils.CHECK_PHN_RST, reqPramsFromGetCustId(), new GetCustIdAsyncTask.Callback() {
                    @Override
                    public void OnSuccess(String data) {
                        textView3.setText(data);
                    }

                    @Override
                    public void OnFail(String msg) {

                    }
                }).execute();
            }
        });
    }
    private JSONObject reqPramsFromGetCustId(){
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("cellphone", "89032456189");
            jsonObject.put("app_id", "2A2281820236772");
            jsonObject.put("deviceId", "71866456134516986852");
            jsonObject.put("lat", "27.7149839");
            jsonObject.put("lng", "85.3100981");
            jsonObject.put("new_cust_id", "20235743");
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }
}
