package com.example.xiaowu.dataparser.jsonparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.xiaowu.androidutils.R;
import com.example.xiaowu.dataparser.jsonparser.jsonbean.Constant;
import com.example.xiaowu.dataparser.jsonparser.jsonbean.FastJsonParser;
import com.example.xiaowu.dataparser.jsonparser.jsonbean.JsonData;
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

        String param=(data.getData().getMessages().get(0)).getExpireTime();
        String picStr=(data.getData().getMessages().get(0)).getDetail().getPics();


            Log.d(TAG, "onCreate: \n "+json+"  "+param.toString());
            Log.d(TAG, "onCreate: \n "+picStr.substring(1,picStr.length()-1));






    }
}
