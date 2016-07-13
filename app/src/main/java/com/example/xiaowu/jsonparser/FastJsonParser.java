package com.example.xiaowu.jsonparser;



import com.alibaba.fastjson.JSON;

/**
 * Created by xiaowu on 2016-7-13.
 */
public class FastJsonParser {
    public static JsonData parseJsonToObject(String json)
    {

        JsonData data= JSON.parseObject(json,JsonData.class);
        return data;

    }
}
