package com.example.xiaowu.WDJAppDetail;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.xiaowu.androidutils.R;

/**
 * Created by matingting on 2017/1/16.
 */

public class AppDetailRootLinearLayout extends LinearLayout {
    private int mTouchMoveOffset=0;
    private LinearLayout mLlContent;
    private ImageView  mIvAppIcon;
    private boolean isAnimation;
    private boolean isLayoutImageView;
    private int mDetailContentBottomOffset=0;
    private int mViewMarginTop=0;
    private int mAppIconTopOffset=0;
    private int mAppIconLeftOffset =0;


    public AppDetailRootLinearLayout(Context context) {
        super(context);
        init();
    }

    public AppDetailRootLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AppDetailRootLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        mLlContent= (LinearLayout) findViewById(R.id.ll_detail_content);
        mIvAppIcon= (ImageView) findViewById(R.id.iv_app_icon);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mLlContent.layout(0,mViewMarginTop+mTouchMoveOffset,mLlContent.getWidth(),!isAnimation ? mViewMarginTop+mTouchMoveOffset+mLlContent.getHeight():mLlContent.getBottom()+mDetailContentBottomOffset);

        if (isLayoutImageView){
            int left=mIvAppIcon.getLeft()+mAppIconLeftOffset;
            int top=mIvAppIcon.getTop()+mAppIconTopOffset;

            mIvAppIcon.layout(left,top,left+mIvAppIcon.getWidth(),top+mIvAppIcon.getBottom());
        }
    }

    public void setInitViewMarginTop(int viewMarginTop) {
        mViewMarginTop = viewMarginTop;
        requestLayout();
    }

    public void setTouchMoveOffset(int touchMoveOffset) {
        mTouchMoveOffset = touchMoveOffset;
    }

    public void setAnimation(boolean animation) {
        isAnimation = animation;
    }

    public void setLayoutImageView(boolean layoutImageView) {
        isLayoutImageView = layoutImageView;
    }
}
