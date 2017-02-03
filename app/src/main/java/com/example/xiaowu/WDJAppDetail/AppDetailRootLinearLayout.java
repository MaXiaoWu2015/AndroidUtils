package com.example.xiaowu.WDJAppDetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.xiaowu.androidutils.CommonUtils;
import com.example.xiaowu.androidutils.R;

/**
 * Created by matingting on 2017/1/16.
 */

public class AppDetailRootLinearLayout extends LinearLayout {
    private int mTouchMoveOffset=0;
    private LinearLayout mLlContent;
    private ImageView  mIvAppIcon;
    private ScrollView mScrollView;
    private boolean isAnimation;
    private boolean isLayoutImageView;
    private boolean isUpScroll;
    private boolean isDrag;
    private float mInitY=0;
    private int mDetailContentTopOffset=0;
    private int mDetailContentBottomOffset=0;
    private int mViewMarginTop=0;
    private int mAppIconTopOffset=0;
    private int mAppIconLeftOffset =0;
    private Context mContext;
    private int mInitBottom;
    private int mImageIconTop;
    private int mImageIconLeft;
    private int mLlContentHeight;
    private int mTitleViewHeight;
    private int mCenterVisibileHeight;
    private ValueAnimator mQuitAnimator;
    private IOnCloseListener mCloseListener;
    private int mBgAlpha=150;
    private ColorDrawable mDetailRootDrawable;

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
        Drawable detailRootDrawable=getBackground();
        mDetailRootDrawable= (ColorDrawable) detailRootDrawable;
        mDetailRootDrawable.setAlpha(mBgAlpha);
    }

    public void init(){
        mImageIconLeft=getResources().getDimensionPixelSize(R.dimen.icon_margin_left);
        mImageIconTop=getResources().getDimensionPixelSize(R.dimen.icon_margin_left);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mLlContentHeight=mLlContent.getHeight();
        mTitleViewHeight=getChildAt(0).getHeight();
        if (mScrollView==null) mScrollView= (ScrollView) getParent();
        mCenterVisibileHeight=mScrollView.getHeight()-mTitleViewHeight;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mLlContent.layout(0,mViewMarginTop+mTouchMoveOffset,mLlContent.getWidth(),!isAnimation ? mViewMarginTop+mTouchMoveOffset+mLlContentHeight: mInitBottom +mDetailContentBottomOffset);

        if (isLayoutImageView){
            int left=mImageIconLeft+mAppIconLeftOffset;
            int top=mImageIconTop+mAppIconTopOffset;
            mIvAppIcon.layout(left,top,left+mIvAppIcon.getWidth(),top+mIvAppIcon.getHeight());
        }
    }

    public void setInitViewMarginTop(int viewMarginTop) {
        mViewMarginTop = viewMarginTop;
        requestLayout();
    }

    public void setTouchMoveOffset(int touchMoveOffset) {
        mTouchMoveOffset = touchMoveOffset;
        requestLayout();
        //改变背景色透明度
        updateBgColor(mTouchMoveOffset);
    }

    public void setAnimation(boolean animation) {
        isAnimation = animation;
    }

    public void setLayoutImageView(boolean layoutImageView) {
        isLayoutImageView = layoutImageView;
    }

    public void setAllViewsOffset(int contentLlTop,int contentLlBottom,int imageIconLeft,int imageIconTop){
        mDetailContentBottomOffset=contentLlBottom;
        mViewMarginTop=contentLlTop;
        mAppIconLeftOffset=imageIconLeft;
        mAppIconTopOffset=imageIconTop;
        requestLayout();
    }

    public void setInitBottom(int initBottom) {
        this.mInitBottom = initBottom;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean isConsume=true;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mInitY=event.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                float moveY=event.getY();
                //TODO:外层scrollview和内层滑动冲突  mScrollView.getScrollY()一直为0
                if ((mScrollView.getScrollY()<=0 && mInitY==moveY)||isDrag){
                    float detal=moveY-mInitY;
                    mTouchMoveOffset= (int) detal;
                    setTouchMoveOffset(mTouchMoveOffset);
                    isDrag=true;
                    isConsume=true;
                }else{
                    getParent().requestDisallowInterceptTouchEvent(false);
                    isConsume=false;
                }
                break;
            case MotionEvent.ACTION_UP:
                isDrag=false;
                isUpScroll=false;
                int animationOffset;
                if (mLlContent.getTop()<(mCenterVisibileHeight/2+mTitleViewHeight)){
                    animationOffset=mTouchMoveOffset;
                    isUpScroll=true;
                }else{
                    animationOffset=mCenterVisibileHeight-mTouchMoveOffset;
                    isUpScroll=false;
                }
                startQuitAnimation(animationOffset,isUpScroll,mTouchMoveOffset);
                break;
        }
        return isConsume;
    }

    public void  updateBgColor(int touchMoveOffset){
        float ratio=CommonUtils.divide(touchMoveOffset,mCenterVisibileHeight);
        int alpha= (int) (mBgAlpha-mBgAlpha*ratio);
        mDetailRootDrawable.setAlpha(alpha);
    }

    /**
     * 详情页退出动画
     * */
    public void startQuitAnimation(final int moveOffset,final boolean isUpScroll, final int currentOffset){
        mQuitAnimator=ValueAnimator.ofFloat(0,1).setDuration(600);

        mQuitAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float ratio= (float) valueAnimator.getAnimatedValue();
                if (isUpScroll){
                    mTouchMoveOffset= (int) (moveOffset-moveOffset*ratio);
                }else{
                    mTouchMoveOffset= (int) (currentOffset+(moveOffset*ratio));
                }
                requestLayout();
                updateBgColor(mTouchMoveOffset);
            }
        });
        mQuitAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (mCloseListener!=null && !isUpScroll){
                    mCloseListener.close();
                }
            }

        });
        mQuitAnimator.start();
    }

    public int getCenterVisibileHeight() {
        return mCenterVisibileHeight;
    }

    public void setCloseListener(
            IOnCloseListener closeListener) {
        mCloseListener = closeListener;
    }

    interface IOnCloseListener{
        void close();
    }

}
