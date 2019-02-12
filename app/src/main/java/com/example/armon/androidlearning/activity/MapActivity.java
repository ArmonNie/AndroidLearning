package com.example.armon.androidlearning.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.MapView;
import com.example.armon.androidlearning.R;
import com.example.armon.androidlearning.myListener.MyLocationListener;

public class MapActivity extends AppCompatActivity implements View.OnClickListener{

    private MapView mMapView;
    private LocationClient mLocationClient;
    private Button btnStartlocate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        InitView();
    }

    //初始化活动中的控件
    public  void InitView()
    {
        mMapView = (MapView)findViewById(R.id.bmapView);
        btnStartlocate = (Button)findViewById(R.id.btn_startLocate);
        btnStartlocate.setOnClickListener(this);
    }

    //开始定位
    public  void startLocate()
    {
        mMapView.getMap().setMyLocationEnabled(true);

        Toast.makeText(this, "开始定位", Toast.LENGTH_SHORT).show();
        //定位初始化
        mLocationClient = new LocationClient(this);

        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

        //设置locationClientOption
        mLocationClient.setLocOption(option);

        //注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener(this,mMapView);
        mLocationClient.registerLocationListener(myLocationListener);
        //开启地图定位图层
        mLocationClient.start();
    }

    //本活动点击事件放于此处
    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Click触发", Toast.LENGTH_SHORT).show();
        switch (view.getId())
        {
            case R.id.btn_startLocate:
                Toast.makeText(this, "btn_Locate", Toast.LENGTH_SHORT).show();
                startLocate();
                break;
            default:
                System.out.println("未绑定事件");
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mLocationClient.stop();
        mMapView.getMap().setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
    }

}
