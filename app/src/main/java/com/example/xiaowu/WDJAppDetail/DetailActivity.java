package com.example.xiaowu.WDJAppDetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.example.xiaowu.androidutils.Constant;
import com.example.xiaowu.androidutils.R;

public class DetailActivity extends AppCompatActivity {
    private int mItemViewTop;
    private AppDetailRootLinearLayout mAppDetailRoot;
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
        mContentHeader=findViewById(R.id.layout_header);
        mContentBottom=findViewById(R.id.layout_bottom);
        mScrollView= (ScrollView) findViewById(R.id.activity_detail_scroll);
        Drawable detailRootDrawable=mAppDetailRoot.getBackground();
        mDetailRootDrawable= (ColorDrawable) detailRootDrawable;
        mDetailRootDrawable.setAlpha(initAlpha);
        mImageIcon= (ImageView) findViewById(R.id.iv_app_icon);
        mImageIcon.setImageResource(R.mipmap.ic_launcher);
         mAppDetailRoot.setInitViewMarginTop(mItemViewTop);

        initAnimationData();

    }

    private void initAnimationData() {
        mScrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        mContentTopOffsetNum=mItemViewTop-getResources().getDimensionPixelSize(R.dimen.detail_content_margin);
                        mContentBottomOffsetNum=mScrollView.getMeasuredHeight()-mAppDetailRoot.getBottom();
                        mImageIconTopOffset=80;
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
                mAppDetailRoot.setAllViewsOffset(contentLlTop,contentLlBottom,imageIconLeft,imageIconTop);
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

    private void initView() {
    }

    private void initData(){

    }
}
