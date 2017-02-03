package com.example.xiaowu.WDJAppDetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.xiaowu.androidutils.Constant;
import com.example.xiaowu.androidutils.R;

public class DetailActivity extends AppCompatActivity {
    private int mItemViewTop;
    private AppDetailRootLinearLayout mAppDetailRoot;
    private LinearLayout mLlContent;
    private int initAlpha=150;
    private ColorDrawable mDetailRootDrawable;
    private ValueAnimator mValueAnimator;
    private ScrollView mScrollView;
    private ImageView mImageIcon;
    private int mContentTopOffsetNum;
    private int mContentBottomOffsetNum;
    private int mImageIconTopOffset;
    private int mImageIconLeftOffset;
    private View mContentHeader;
    private View mContentBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mItemViewTop=getIntent().getIntExtra(Constant.ITEM_VIEW_TOP,0);

        mAppDetailRoot= (AppDetailRootLinearLayout) findViewById(R.id.ll_app_detail);

        mLlContent= (LinearLayout) findViewById(R.id.ll_detail_content);
        mContentHeader=findViewById(R.id.layout_header);
        mContentBottom=findViewById(R.id.layout_bottom);
        mScrollView= (ScrollView) findViewById(R.id.activity_detail_scroll);

        mImageIcon= (ImageView) findViewById(R.id.iv_app_icon);
        mImageIcon.setImageResource(R.mipmap.ic_launcher);
         mAppDetailRoot.setInitViewMarginTop(mItemViewTop);
        mAppDetailRoot.setCloseListener(new AppDetailRootLinearLayout.IOnCloseListener() {
            @Override
            public void close() {
                finish();
                overridePendingTransition(0,0);
            }
        });
        initAnimationData();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    private void initAnimationData() {
        mScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        mScrollView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        mContentTopOffsetNum=mItemViewTop-getResources().getDimensionPixelSize(R.dimen.detail_content_margin);
                        mAppDetailRoot.setInitBottom(mLlContent.getBottom());
                        mContentBottomOffsetNum=mScrollView.getMeasuredHeight()-mLlContent.getBottom();
                        mImageIconTopOffset=getResources().getDimensionPixelSize(R.dimen.detail_content_header_height);
                        mImageIconLeftOffset=(mAppDetailRoot.getWidth()-mImageIcon.getWidth())/2-getResources().getDimensionPixelSize(R.dimen.icon_margin_left);
                        mAppDetailRoot.setLayoutImageView(true);
                        mAppDetailRoot.setAnimation(true);
                        startAnimation();
                    }
                });
    }

    private void startAnimation() {
        mValueAnimator=ValueAnimator.ofFloat(0,1).setDuration(400);
        mValueAnimator.setStartDelay(100);
        mValueAnimator.start();
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float ratio= (float) valueAnimator.getAnimatedValue();
                int contentLlTop= (int) (ratio*mContentTopOffsetNum);
                int contentLlBottom= (int) (ratio*mContentBottomOffsetNum);
                int imageIconLeft= (int) (ratio*mImageIconLeftOffset);
                int imageIconTop= (int) (ratio*mImageIconTopOffset);
                mAppDetailRoot.setAllViewsOffset(mItemViewTop-contentLlTop,contentLlBottom,imageIconLeft,imageIconTop);
            }
        });

        mValueAnimator.addListener(new AnimatorListenerAdapter(){

            @Override
            public void onAnimationEnd(Animator animator) {
                 mAppDetailRoot.setAnimation(false);
                mContentBottom.setVisibility(View.VISIBLE);
                mContentHeader.setVisibility(View.VISIBLE);
            }
        });
    }
    //Activity退出时的动画
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){
            mAppDetailRoot.startQuitAnimation(mAppDetailRoot.getCenterVisibileHeight(),false,0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
