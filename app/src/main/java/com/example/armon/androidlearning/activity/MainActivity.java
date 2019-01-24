package com.example.armon.androidlearning.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.example.armon.androidlearning.R;
import com.example.armon.androidlearning.myAdapter.FunctionAdapter;
import com.example.armon.androidlearning.mybean.ApplicationFunction;

public class MainActivity extends AppCompatActivity {

    private ListView list_main;
    private LinearLayout root_layout;
    private List<ApplicationFunction> applist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitList();
        //InitAnimation();
        InitUI();
        InitAnimation();
    }

    /*
    进入的动画
     */
    public void InitAnimation()
    {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(3000);
        root_layout.setAnimation(alphaAnimation);
    }
    /*
    控件初始化
     */
    public void InitUI()
    {
        root_layout = (LinearLayout)findViewById(R.id.root_layout);
        list_main = (ListView)findViewById(R.id.list_main);
        FunctionAdapter functionAdapter = new FunctionAdapter(MainActivity.this,R.layout.list_main_item,
                applist);
        list_main.setAdapter(functionAdapter);
    }

    /*
    往列表中添加心得功能描述
    */
    public void InitList()
    {
        applist = new ArrayList<>();

        ApplicationFunction applicationFunction1 = new ApplicationFunction
                    ("基础控件",
                            "点击进入一些Android的基础控件的展示",
                            1);
        ApplicationFunction applicationFunction2 = new ApplicationFunction
                ("高级控件",
                        "点击查看一些高级控件",
                        2);
        ApplicationFunction applicationFunction3 = new ApplicationFunction
                ("View测试",
                        "测试一些View的属性等，以便于后续学习",
                        3);
        ApplicationFunction applicationFunction4 = new ApplicationFunction
                ("动画测试",
                        "动画的相关",
                        4);
        ApplicationFunction applicationFunction5 = new ApplicationFunction("简单网络请求测试",
                "app使用了Rxjava，Retrofit，服务器使用的是WebStorm的一个Node.js程序",
                5);

        applist.add(applicationFunction1);
        applist.add(applicationFunction2);
        applist.add(applicationFunction3);
        applist.add(applicationFunction4);
        applist.add(applicationFunction5);
    }

}
