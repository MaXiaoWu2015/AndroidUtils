package com.example.xiaowu.network.jsonparser;

/**
 * Created by xiaowu on 2016-7-13.
 *
 * "param": [
 {
 "key": "className",
 "value": "FastJsonActivity",
 "valueType": la,
 "isExtra": false
 }
 ]
 *
 */
public class Param {
    private String key;
    private String value;
    private int valueType;
    private boolean isExtra;

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getValueType() {
        return valueType;
    }

    public void setValueType(int valueType) {
        this.valueType = valueType;
    }
}
