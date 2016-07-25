package com.example.xiaowu.dataparser.jsonparser.jsonbean;

/**
 * Created by xiaowu on 2016-7-13.
 */

/**
 * {
 "version": "4.0",
 "data": {
 "messages": [
 {
 "id": 1000,
 "title": "消息标题",
 "showTime": 1467682128,
 "expireTime": 1467682128,
 "isPopup": true,
 "isInList": true,
 "popupImage": "http://konka.com/1.jpg",
 "goto": {
 "type": 2,
 "mode": 3,
 "param": [
 {
 "key": "className",
 "value": "FastJsonActivity",
 "valueType": la,
 "isExtra": false
 }
 ]
 },
 "detail": {
 "btnText": "查看详情",
 "pics": [
 "http://konka.com/1.jpg",
 "http://konka.com/2.jpg"
 ]
 },
 "isDelete": false,
 "channel": {
 "id": la,
 "title": "用户中心",
 "icon": "http://konka.com/center.jpg",
 "WeekLimitCount": 10
 }
 }
 ]
 }
 }
 * */
public class Goto {
    private int type;
    private int mode;
    private String param;

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

//    public ArrayList<Param> getParam() {
//        return param;
//    }
//
//    public void setParam(ArrayList<Param> param) {
//        this.param = param;
//    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
