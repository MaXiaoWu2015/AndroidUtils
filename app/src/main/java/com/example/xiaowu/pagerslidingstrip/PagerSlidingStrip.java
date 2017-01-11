package com.example.xiaowu.pagerslidingstrip;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by matingting on 2017/1/11.
 */

public class PagerSlidingStrip extends HorizontalScrollView {
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private LinearLayout mTabContainer;
    private Context mContext;
    private ViewPager mViewPager;
    private int mCurrentPosition;
    private float mCurrentPositionOffset;


    public PagerSlidingStrip(Context context) {
        this(context,null);
    }

    public PagerSlidingStrip(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PagerSlidingStrip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        init();
    }

    private void init(){
        mTabContainer=new LinearLayout(mContext);

    }


    public void setIndicatorColor(int indicatorColor) {
        mIndicatorColor = indicatorColor;
    }

    public void setIndicatorHeight(int indicatorHeight) {
        mIndicatorHeight = indicatorHeight;
    }

    public class PageListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            mCurrentPosition=position;
            mCurrentPositionOffset=positionOffset;

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


}
