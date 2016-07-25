package com.example.xiaowu.dataparser.jsonparser.jsonbean;

/**
 * Created by xiaowu on 2016-7-13.
 *
 * "detail": {
 "btnText": "查看详情",
 "pics": [
 "http://konka.com/1.jpg",
 "http://konka.com/2.jpg"
 ]
 }
 */
public class Detail {
    private String btnText;
//    private ArrayList<String> pics;
    private String pics;

//    public ArrayList<String> getPics() {
//        return pics;
//    }
//
//    public void setPics(ArrayList<String> pics) {
//        this.pics = pics;
//    }


    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }
}
