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
public class Channel {
    private int id;
    private String title;
    private String icon;
    private int WeekLimitCount;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWeekLimitCount() {
        return WeekLimitCount;
    }

    public void setWeekLimitCount(int weekLimitCount) {
        WeekLimitCount = weekLimitCount;
    }
}
