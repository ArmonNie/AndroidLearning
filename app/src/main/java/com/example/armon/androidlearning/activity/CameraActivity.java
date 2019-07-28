package com.example.armon.androidlearning.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.armon.androidlearning.R;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_startCamera;
    private Button btn_startRecognize;
    private ImageView imageview_temprory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        init();
        this.btn_startCamera.setOnClickListener(this);
        this.btn_startRecognize.setOnClickListener(this);
    }

    public void init()
    {
        this.btn_startCamera = (Button)findViewById(R.id.btn_startcamera);
        this.btn_startRecognize = (Button)findViewById(R.id.btn_startrecognize);
        this.imageview_temprory = (ImageView)findViewById(R.id.camera_tempimage);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_startcamera)
        {
            startCamera();
        }
        if(view.getId() == R.id.btn_startrecognize)
        {
            startRecognize();
        }
    }

    public void startCamera()
    {
        Toast.makeText(this, "开启相机", Toast.LENGTH_SHORT).show();
    }

    public void startRecognize()
    {
        Toast.makeText(this, "人脸识别", Toast.LENGTH_SHORT).show();
    }

}
