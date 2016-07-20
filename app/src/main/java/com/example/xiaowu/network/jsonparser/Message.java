package com.example.xiaowu.network.jsonparser;

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
 "linkto": {
 "type": 2,
 "mode": 3,
 "param": [
 {
 "key": "className",
 "value": "FastJsonActivity",
 "valueType": 1,
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
 "id": 1,
 "title": "用户中心",
 "icon": "http://konka.com/center.jpg",
 "WeekLimitCount": 10
 }
 }
 ]
 }
 }
 * */
public class Message {

    private int id;
    private String title;
    private String showTime;
    private String expireTime;
    private boolean isPopup;
    private boolean isInList;
    private boolean isDelete;
    private String popupImage;
    private Goto  linkto;
    private Channel channel;
    private Detail detail;

    public Goto getLinkto() {
        return linkto;
    }

    public void setLinkto(Goto linkto) {
        this.linkto = linkto;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public boolean isInList() {
        return isInList;
    }

    public void setInList(boolean inList) {
        isInList = inList;
    }

    public boolean isPopup() {
        return isPopup;
    }

    public void setPopup(boolean popup) {
        isPopup = popup;
    }

    public String getPopupImage() {
        return popupImage;
    }

    public void setPopupImage(String popupImage) {
        this.popupImage = popupImage;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
