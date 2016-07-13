package com.example.xiaowu.androidutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.xiaowu.jsonparser.Constant;
import com.example.xiaowu.jsonparser.FastJsonParser;
import com.example.xiaowu.jsonparser.JsonData;
import com.squareup.picasso.Cache;

public class FastJsonActivity extends AppCompatActivity {
    private static final String TAG = "FastJsonActivity";
    Cache cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /**
        * json解析
        * */
        //fastjson解析
        JsonData data= FastJsonParser.parseJsonToObject(Constant.json);
        String   json= JSON.toJSONString(data);
        //JSONObjectParser
        Log.d(TAG, "onCreate: \n "+json);



    }
}
