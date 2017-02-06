package com.example.xiaowu.WDJAppDetail;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by matingting on 2017/2/4.
 */

public class DetailScrollView extends ScrollView {
    private float initY;
    public DetailScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DetailScrollView(Context context) {
        super(context);
    }

    public DetailScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("DetailScrollView:","MotionEvent.ACTION_DOWN");
                initY=ev.getY();
                break;
            case MotionEvent.ACTION_UP:

            case MotionEvent.ACTION_MOVE:
                Log.d("DetailScrollView:","MotionEvent.ACTION_UP");
                float moveY=ev.getY()-initY;
                if (getScrollY()<=0 && moveY>0){
                    return false;
                }
                break;
//                if (getScrollY()>0){
//                    requestDisallowInterceptTouchEvent(false);
//                }
//                Log.d("DetailScrollView:","MotionEvent.ACTION_MOVE");
//                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        return super.onTouchEvent(ev);
    }
}
