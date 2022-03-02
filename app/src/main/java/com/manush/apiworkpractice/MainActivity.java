package com.manush.apiworkpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.manush.apiworkpractice.apicall.CheckPhnRstAsyncTask;
import com.manush.apiworkpractice.apicall.GetCustIdAsyncTask;
import com.manush.apiworkpractice.apicall.RegCustInfoAsyncTask;
import com.manush.apiworkpractice.utils.Utils;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button button, button2, button3;
    TextView textView, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        textView = findViewById(R.id.txt);
        textView2 = findViewById(R.id.txt2);
        textView3 = findViewById(R.id.txt3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils utils = new Utils();
                new CheckPhnRstAsyncTask(utils.CHECK_PHN_RST, reqPramsFromGetCustId(), new CheckPhnRstAsyncTask.Callback() {
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
                Utils utils = new Utils();
                new GetCustIdAsyncTask(utils.GET_CUST_ID, reqPramsFromGetCustId2(), new GetCustIdAsyncTask.Callback2() {
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
                new RegCustInfoAsyncTask(utils.REG_CUST_INFO, reqPramsFromRegCustInfo(), new RegCustInfoAsyncTask.Callback3() {
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

    private JSONObject reqPramsFromGetCustId() {
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("cellphone", "89032456189");
            jsonObject.put("app_id", "2A2281820236772");
            jsonObject.put("deviceId", "71866456134516986852");
            jsonObject.put("lat", "27.7149839");
            jsonObject.put("lng", "85.3100981");
            jsonObject.put("new_cust_id", "20235743");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private JSONObject reqPramsFromGetCustId2() {
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("dev_token", "64607390-FE4B-4396-84A8-435CEBCDDBB0");
            jsonObject.put("device_type", "AND");
            jsonObject.put("lat", "11.11");
            jsonObject.put("lng", "33.3");
            jsonObject.put("gname", "prabhu pay");
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    private JSONObject reqPramsFromRegCustInfo() {
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("app_id", "AB5518110270631");
            jsonObject.put("cust_id", "10270631");
            jsonObject.put("fname", "aswin");
            jsonObject.put("lname", "verma");
            jsonObject.put("cell", "9805363732");
            jsonObject.put("email", "azwinverma@gmail.com");
            jsonObject.put("lat", "2.1111");
            jsonObject.put("lng", "1.1111");
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }
}



