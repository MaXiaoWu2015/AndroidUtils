package com.example.xiaowu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.xiaowu.androidutils.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        test();
    }

    public void test(){
        ArrayList<Object> list=new ArrayList<>();
        list.add(0,1);

        ArrayList<String> stringArrayList=new ArrayList<>(Arrays.asList("2","3","4","5"));
        list.add(stringArrayList);
        Log.d(TAG, "test: "+list.toString());
    }
}
