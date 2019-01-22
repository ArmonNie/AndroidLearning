package com.example.armon.androidlearning.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.armon.androidlearning.R;

public class ViewTestActivity extends AppCompatActivity {

    private View view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test);
        init();
    }

    public void init()
    {
        view1 = (View)findViewById(R.id.view_1);
    }

    public void get_view_position()
    {
        String msg = "top=" + view1.getTop() + "\nleft=" + view1.getLeft()
                + "\nright=" + view1.getRight() + "\nbottom=" + view1.getBottom()
                + "\nwidth=" + view1.getWidth() + "\nheight=" + view1.getHeight();
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
    }

}
