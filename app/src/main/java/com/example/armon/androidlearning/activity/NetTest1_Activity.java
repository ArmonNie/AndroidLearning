package com.example.armon.androidlearning.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.armon.androidlearning.R;
import com.example.armon.androidlearning.config.HttpConfig;
import com.example.armon.androidlearning.myInterface.GetService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetTest1_Activity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_startrequest;
    private TextView text_response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_test1_);
        initView();
    }

    public void initView()
    {
        btn_startrequest = (Button)findViewById(R.id.btn_startrequest);
        btn_startrequest.setOnClickListener(this);
        text_response = (TextView)findViewById(R.id.text_response);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_startrequest)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(HttpConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            GetService getService = retrofit.create(GetService.class);
            //注意此处的类要写完整路径，单写Response会与其他包冲突
            Call<ResponseBody> call = getService.getNormal();
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        try {
                            //返回的数据：{"code":1,"msg":"success","data":{"name":"leavesC","mobile":123456}}
                            System.out.println("onResponse body: " + response.body().string());
                            final String strResponse = response.body().string();
                            //注意重点，此处关于线程
                            //text_response.append(strResponse);
                            //text_response.setText("onResponse body: %s" + strResponse);
                            //text_response.setText(String.format("onResponse body: %s",response.body().string()));
                            //text_response.setText(String.format("onResponse body: %s",strResponse));
                            //text_response.setText(String.format(getResources().getString(R.string.responsebody),strResponse));
                            //showResponse(response.body().string());
                            System.out.println("ceshi:" + strResponse);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    // 在这里进行UI操作，将结果显示到界面上
                                    text_response.setText(strResponse);
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("onResponse code: " + response.code());
                        text_response.setText("onResponse code: " + response.code());
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    System.out.println("onFailure: " + t.getMessage());
                }
            });
            /*getService.getNormal().enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        try {
                            //返回的数据：{"code":1,"msg":"success","data":{"name":"leavesC","mobile":123456}}
                            System.out.println("onResponse body: " + response.body().string());
                            text_response.setText("onResponse body: " + response.body().string());
                            Toast.makeText(NetTest1_Activity.this, "" + response.body(), Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("onResponse code: " + response.code());
                        text_response.setText("onResponse code: " + response.code());
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    System.out.println("onFailure: " + t.getMessage());
                }
            });*/
        }
    }

    private void showResponse(final String response) {
        System.out.println("Test" + response);
        //在子线程中更新UI
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作，将结果显示到界面上
                text_response.setText(response);
            }
        });
    }

}
