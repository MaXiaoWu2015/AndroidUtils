package com.example.xiaowu.pagerslidingstrip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xiaowu.androidutils.R;

/**
 * Created by matingting on 2017/1/11.
 */

public class PagerSlidingStrip extends HorizontalScrollView {

    private Context mContext;
    private ViewPager mViewPager;
    private ViewPager.OnPageChangeListener mDelegatePageChangeListener;
    private PageListener mPageListener=new PageListener();
    private int mCurrentPosition;
    private float mCurrentPositionOffset;
    private int mTabWidth;
    private int mTextColor=0xFF666666;
    private int mSelectedTextColor;
    private int mTextSize=12;
    private int mTabBgResId;
    private int mLastScrollX=0;
    private int mScrollOffset=52;//选中tab的滑动距离，决定滑动到哪个tab的时候跟着ViewPapager联动
    private int mTabPadding=24;
    private int mTabCount;
    private int mDividerColor=0x1A000000;
    private int mDividerPadding=12;
    private int mDividerWidth=5;
    private int mUnderLineColor=0x1A000000;
    private int mUnderLineHeight=2;
    private int mIndicatorColor=0xFF666666;
    private int mIndicatorHeight=8;
    private int mIndicatorPadding=4;
    private LinearLayout mTabContainer;
    private LinearLayout.LayoutParams mExpanableLayoutParams;
    private LinearLayout.LayoutParams mDefaultLayoutParams;
    private boolean isDefaultLayoutParams=false;
    private Paint mRectPaint;
    private Paint mDividerPaint;
    private int mTabSelector=R.drawable.tab_selector;






    interface IconTabProvider{
        int getPageIconResId(int position);
    }

    public PagerSlidingStrip(Context context) {
        this(context,null);
    }

    public PagerSlidingStrip(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PagerSlidingStrip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //你想让一个高度值不足scrollview的子控件fillparent的时候，单独的定义android:layout_height="fill_parent"是不起作用的，
        // 必须加上fillviewport属性，当子控件的高度值大于scrollview的高度时，这个标签就没有任何意义了
        setFillViewport(true);
        setWillNotDraw(false);//自定义控件时，如果重写的onDraw方法没有被调用，有可能是被设置了此标志，所以要在构造方法中清除

        this.mContext=context;
        init(attrs);
    }

    private void init(AttributeSet attrs){
        mTabContainer=new LinearLayout(mContext);
        mTabContainer.setOrientation(LinearLayout.HORIZONTAL);
        mTabContainer.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mDefaultLayoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
        , ViewGroup.LayoutParams.MATCH_PARENT);
        mExpanableLayoutParams=new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT
                ,1.0f);

        addView(mTabContainer);

        DisplayMetrics dm=getResources().getDisplayMetrics();

        mScrollOffset= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP
        ,mScrollOffset,dm);
        mIndicatorHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mIndicatorHeight, dm);
        mUnderLineHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mUnderLineHeight, dm);
        mDividerPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mDividerPadding, dm);
        mTabPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mTabPadding, dm);
        mDividerWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mDividerWidth, dm);
        mTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, mTextSize, dm);
        mIndicatorPadding= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,mIndicatorPadding,dm);

        TypedArray typedArray=mContext.obtainStyledAttributes(attrs, R.styleable.PagerSlidingStrip);

        mIndicatorColor=typedArray.getColor(R.styleable.PagerSlidingStrip_indicatorColor,mIndicatorColor);
        mIndicatorHeight=typedArray.getDimensionPixelSize(R.styleable.PagerSlidingStrip_indicatorHeight,mIndicatorHeight);
        mIndicatorPadding=typedArray.getDimensionPixelSize(R.styleable.PagerSlidingStrip_indicatorPadding,mIndicatorPadding);
        mDividerColor=typedArray.getColor(R.styleable.PagerSlidingStrip_dividerColor,mDividerColor);

        typedArray.recycle();

        mRectPaint=new Paint();
        mRectPaint.setAntiAlias(false);
        mRectPaint.setStyle(Paint.Style.FILL);

        mDividerPaint=new Paint();
        mDividerPaint.setAntiAlias(false);
        mDividerPaint.setStrokeWidth(mDividerWidth);
    }

    public void setDelegatePageChangeListener(
            ViewPager.OnPageChangeListener delegatePageChangeListener) {
        mDelegatePageChangeListener = delegatePageChangeListener;
    }

    public void setIndicatorColor(int indicatorColor) {
        mIndicatorColor = indicatorColor;
    }

    public void setIndicatorHeight(int indicatorHeight) {
        mIndicatorHeight = indicatorHeight;
    }

    public void setViewPager(ViewPager viewPager) {
        mViewPager = viewPager;

        if (mViewPager.getAdapter()==null){
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        mViewPager.setOnPageChangeListener(mPageListener);

        notifyDataChanged();
    }

    private void notifyDataChanged() {
        mTabContainer.removeAllViews();
        mTabCount=mViewPager.getAdapter().getCount();

        for (int i=0;i<mTabCount;i++){
            if (mViewPager.getAdapter() instanceof IconTabProvider){
                addIconTab(i,((IconTabProvider)mViewPager.getAdapter()).getPageIconResId(i));
            }else{
                addTextTab(i,mViewPager.getAdapter().getPageTitle(i).toString());
            }
        }
        updateTabSyles();

        getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        mCurrentPosition=mViewPager.getCurrentItem();
                        scrollToChild(mCurrentPosition,0);
                    }
                });

    }

    private void addIconTab(int i, int pageIconResId) {
    }

    private void addTextTab(final int i, String pageTitle) {
        TextView tab=new TextView(mContext);
        tab.setText(pageTitle);
        tab.setGravity(Gravity.CENTER);
        tab.setSingleLine();
        tab.setFocusable(true);
        tab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(i);
            }
        });
        tab.setPadding(mTabPadding,0,mTabPadding,0);
        mTabContainer.addView(tab,i,isDefaultLayoutParams?mDefaultLayoutParams:mExpanableLayoutParams);
    }

    public void updateTabSyles(){
        //tab style
        for (int i=0;i<mTabCount;i++){
            View v=mTabContainer.getChildAt(i);
//         v.setBackgroundColor(Color.parseColor("#ffffff"));不能先设置背景色，PagerSlidingStrip作为父控件要先绘制画分割线、indicator、
//  和underline，如果此处设置了背景色，那么子View后绘制，会覆盖掉分割线、indicator、
//  和underline
            v.setBackgroundResource(mTabSelector);//此处背景色默认是透明的
            if (v instanceof TextView){
                TextView tab= (TextView) v;
                tab.setTextColor(mTextColor);
                tab.setTextSize(TypedValue.COMPLEX_UNIT_PX,mTextSize);
            }
        }
    }


    public void setTextColor(int textColor) {
        mTextColor = textColor;
    }

    public void setSelectedTextColor(int selectedTextColor) {
        mSelectedTextColor = selectedTextColor;
    }

    public void setTextSize(int textSize) {
        mTextSize = textSize;
    }

    public class PageListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            mCurrentPosition=position;
            mCurrentPositionOffset=positionOffset;

            int x= (int) (positionOffset*mTabContainer.getChildAt(position).getWidth());
            scrollToChild(position,x);
            invalidate();//更新indicator的位置

            if (mDelegatePageChangeListener!=null){
                mDelegatePageChangeListener.onPageScrolled(position,positionOffset,positionOffsetPixels);
            }

        }

        @Override
        public void onPageSelected(int position) {
            //设置tab选中的默认图片或文字颜色
//            if (mTabContainer.getChildAt(position)!=null){
//                if (mTabContainer.getChildAt(position) instanceof TextView){
//                    ((TextView) mTabContainer.getChildAt(position)).setTextColor(Color.parseColor("#00ff00"));//设置选中颜色
//                }else{
//                    mTabContainer.getChildAt(position).setBackground(null);//设置tab选中时的图片
//                }
//            }

            if (mDelegatePageChangeListener!=null){
                mDelegatePageChangeListener.onPageSelected(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state==ViewPager.SCROLL_STATE_IDLE){
                scrollToChild(mViewPager.getCurrentItem(),0);
            }
            if (mDelegatePageChangeListener!=null){
                mDelegatePageChangeListener.onPageScrollStateChanged(state);
            }
        }
    }

    private void scrollToChild(int position,int offset){

        int newScrollX=mTabContainer.getChildAt(position).getLeft()+offset;
        if (position>0 || offset>0){
            newScrollX-=mScrollOffset;
        }

        if (newScrollX!=mLastScrollX){
            mLastScrollX=newScrollX;
            scrollTo(newScrollX,0);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || mTabCount==0){
            return;
        }
        final int height=getHeight();
        //indicator
        mRectPaint.setColor(mIndicatorColor);
        View curTab=mTabContainer.getChildAt(mCurrentPosition);
        float lineLeft=curTab.getLeft();
        float lineRight=curTab.getRight();

        if (mCurrentPositionOffset>0 && mCurrentPosition<mTabCount-1){
            View nextTab=mTabContainer.getChildAt(mCurrentPosition+1);
            float nextTabLeft=nextTab.getLeft();
            float nextTabRight=nextTab.getRight();

            lineLeft=mCurrentPositionOffset*(nextTabLeft-lineLeft)+lineLeft;
            lineRight=mCurrentPositionOffset*(nextTabRight-lineRight)+lineRight;

        }
        canvas.drawRect(lineLeft+mIndicatorPadding,
                height-mIndicatorHeight,lineRight-mIndicatorPadding,height,mRectPaint);

        //underline
        mRectPaint.setColor(mUnderLineColor);
        canvas.drawRect(0,height- mUnderLineHeight,mTabContainer.getWidth(),height,mRectPaint);

        //divider line
        mDividerPaint.setColor(mDividerColor);
        for (int i=0;i<mTabCount-1;i++){
            View tab=mTabContainer.getChildAt(i);
            canvas.drawLine(tab.getRight(),mDividerPadding,tab.getRight(),height-mDividerPadding
            ,mDividerPaint);
        }
    }
}
