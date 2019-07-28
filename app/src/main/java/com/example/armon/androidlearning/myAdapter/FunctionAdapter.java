package com.example.armon.androidlearning.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.armon.androidlearning.R;
import com.example.armon.androidlearning.activity.AnimationActivity;
import com.example.armon.androidlearning.activity.CameraActivity;
import com.example.armon.androidlearning.activity.HighControllActivity;
import com.example.armon.androidlearning.activity.MapActivity;
import com.example.armon.androidlearning.activity.MyOwnViewActivity;
import com.example.armon.androidlearning.activity.NetTest1_Activity;
import com.example.armon.androidlearning.activity.ShowViewActivity;

import java.util.List;

import com.example.armon.androidlearning.activity.ViewTestActivity;
import com.example.armon.androidlearning.mybean.ApplicationFunction;

/**
 * Created by Armon on 2018/11/6.
 */

public class FunctionAdapter extends ArrayAdapter<ApplicationFunction> {

    private int resId;

    public FunctionAdapter(Context context,int listitemId,
    List<ApplicationFunction> applist)
    {
        super(context,listitemId,applist);
        resId = listitemId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ApplicationFunction applicationFunction = getItem(position);
        //关于此方法
        View view = LayoutInflater.from(getContext())
                .inflate(resId,parent,false);
        TextView textView_name = (TextView)view.findViewById(R.id.listitem_name);
        TextView textView_des = (TextView)view.findViewById(R.id.listitem_description);
        Button btn = (Button)view.findViewById(R.id.listitem_btn);

        textView_name.setText(applicationFunction.getFunctionName());
        textView_des.setText(applicationFunction.getFunctionDescription());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Index = applicationFunction.getFunctionIndex();
                Toast.makeText(getContext(), "" + Index, Toast.LENGTH_SHORT).show();
                switch(Index)
                {
                    case 1:
                        Intent intent1 = new Intent(getContext(), ShowViewActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getContext(), HighControllActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getContext(),ViewTestActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getContext(),AnimationActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getContext(), NetTest1_Activity.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getContext(), MapActivity.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(getContext(), CameraActivity.class);
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(getContext(), MyOwnViewActivity .class);
                        startActivity(intent8);
                        break;
                    default:
                        Toast.makeText(getContext(), "未找到命令", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        return view;
    }

    private void startActivity(Intent intent)
    {
        getContext().startActivity(intent);
    }

}
