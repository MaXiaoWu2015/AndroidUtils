package com.example.xiaowu.dataparser.jsonparser.jsonbean;

/**
 * Created by xiaowu on 2016-7-13.
 */
public class JsonData {
   private String version;
   private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
