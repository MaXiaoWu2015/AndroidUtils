package com.example.xiaowu.EventBus.AnotherExample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

/**
 * Created by matingting on 2016/11/25.
 */

public class TitleListLinearLayout extends LinearLayout {

    public TitleListLinearLayout(Context context) {
        super(context);
    }

    public TitleListLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TitleListLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TitleListLinearLayout(Context context, AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    public void setAdapter(BaseAdapter baseAdapter){
        int count=baseAdapter.getCount();
        this.removeAllViews();
        for (int i=0;i<count;i++){
            View view=baseAdapter.getView(i,null,null);
            addView(view,i);
        }
    }

}
