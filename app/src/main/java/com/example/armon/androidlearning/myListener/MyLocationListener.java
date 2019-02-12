package com.example.armon.androidlearning.myListener;

import android.content.Context;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;

/**
 * Created by Armon on 2019/2/12.
 */

public class MyLocationListener extends BDAbstractLocationListener {

    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private Context context;


    public MyLocationListener(Context context,MapView mMapView) {
        this.context = context;
        this.mMapView = mMapView;
        mBaiduMap = mMapView.getMap();
    }

    @Override
    public void onReceiveLocation(BDLocation location) {
        //mapView 销毁后不在处理新接收的位置
        if (location == null || mMapView == null){
            return;
        }
        MyLocationData locData = new MyLocationData.Builder()
                .accuracy(location.getRadius())
                // 此处设置开发者获取到的方向信息，顺时针0-360
                .direction(location.getDirection()).latitude(location.getLatitude())
                .longitude(location.getLongitude()).build();
        mBaiduMap.setMyLocationData(locData);
    }
}
