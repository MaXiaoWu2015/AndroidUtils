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
    private int mDetailContentTopOffset=0;
    private int mDetailContentBottomOffset=0;
    private int mViewMarginTop=0;
    private int mAppIconTopOffset=0;
    private int mAppIconLeftOffset =0;
    private Context mContext;


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

    /**
     * 我们一般使用View的流程是在onCreate中使用setContentView来设置要显示Layout文件或直接创建一个View，
     * 在当设置了ContentView之后系统会对这个View进行解析，然后回调当前视图View中的onFinishInflate方法。
     * 只有解析了这个View我们才能在这个View容器中获取到拥有Id的组件，同样因为系统解析完View之后才会调
     * 用onFinishInflate方法，所以我们自定义组件时可以onFinishInflate方法中获取指定子View的引用
     * */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //放在init里会出现mLlContent=null   mIvAppIcon=null
        mLlContent= (LinearLayout) findViewById(R.id.ll_detail_content);
        mIvAppIcon= (ImageView) findViewById(R.id.iv_app_icon);
    }

    public void init(){
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

    public void setAllViewsOffset(int contentLlTop,int contentLlBottom,int imageIconLeft,int imageIconTop){
        mDetailContentBottomOffset=contentLlBottom;
        mDetailContentTopOffset=contentLlTop;
        mAppIconLeftOffset=imageIconLeft;
        mAppIconTopOffset=imageIconTop;
        requestLayout();
    }

}
