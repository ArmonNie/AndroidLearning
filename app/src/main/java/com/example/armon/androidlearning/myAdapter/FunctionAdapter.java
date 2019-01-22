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
import com.example.armon.androidlearning.activity.HighControllActivity;
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
                        Intent intent = new Intent(getContext(), ShowViewActivity.class);
                        getContext().startActivity(intent);
                        break;
                    case 2:
                        Intent intent1 = new Intent(getContext(), HighControllActivity.class);
                        getContext().startActivity(intent1);
                        break;
                    case 3:
                        Intent intent2 = new Intent(getContext(),ViewTestActivity.class);
                        getContext().startActivity(intent2);
                        break;
                    case 4:
                        Intent intent3 = new Intent(getContext(),AnimationActivity.class);
                        getContext().startActivity(intent3);
                        break;
                    default:
                        Toast.makeText(getContext(), "未找到命令", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        return view;
    }
}
