package com.example.xiaowu.jsonparser;

import java.util.ArrayList;

/**
 * Created by xiaowu on 2016-7-13.
 */
public class Data <T>{
    private ArrayList<T> list;
    public ArrayList<T> getMessages() {
        return list;
    }
    public void setMessages(ArrayList<T> messages) {
        this.list = messages;
    }
}
