package com.example.xiaowu.network.jsonparser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xiaowu on 2016-7-13.
 */
public class JSONObjectParser {
    public static JsonData parseJsonToObject(String json)
    {
        try {
            Data jsonData=new Data();
            JSONObject object=new JSONObject(json);
            JSONObject data=object.getJSONObject("data");
            JSONArray  messages=data.getJSONArray("messages");

            for (int i=0;i<messages.length();i++)
            {
                Message message=new Message();
                JSONObject messagejson=messages.getJSONObject(i);
                JSONObject detailjson=messagejson.getJSONObject("Detail");
                Detail detail=new Detail();
                detail.setBtnText(detailjson.getString("name"));

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
