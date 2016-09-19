package com.example.xiaowu.customview.BaseLearn;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.aaron.library.MLog;
import com.example.xiaowu.androidutils.R;

/**
 * Created by xiaowu on 2016-8-30.
 */
public class CustomImageView extends View {
    private String titleText="";
    private int titleColor;
    private int    titleSize;
    private Bitmap image;
    private int    imageScaleType;
    private int width;
    private int height;
    private Rect textBound;
    private Paint paint;
    private Rect rect;

    private static final String TAG = "CustomImageView";
    //一个参数的构造函数调用两个的,以此类推...  记住是this,不是super
    public CustomImageView(Context context) {
        this(context,null);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray typedArray=context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomImageView,0,0);
        try {
            int count=typedArray.getIndexCount();
            MLog.d(TAG,"count"+count);
            for (int i=0;i<count;i++){
                int attr=typedArray.getIndex(i);
                switch (attr){
                    case R.styleable.CustomImageView_titleText:
                        titleText=typedArray.getString(attr);
                        MLog.d(TAG,"titleText:"+titleText);
                        break;
                    case R.styleable.CustomImageView_titleSize:
                        titleSize=typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
                        MLog.d(TAG,"titleSize:"+titleSize);
                        break;
                    case R.styleable.CustomImageView_titleColor:
                        titleColor=typedArray.getColor(attr,Color.BLACK);
                        MLog.d(TAG,"titleColor:"+titleColor);

                        break;
                    case R.styleable.CustomImageView_image:
                        image= BitmapFactory.decodeResource(getResources(),typedArray.getResourceId(attr,0));
                        MLog.d(TAG,"image:"+image);
                        break;
                    case R.styleable.CustomImageView_imageScaleType:
                        imageScaleType=typedArray.getInt(attr,1);
                        MLog.d(TAG,"imageScaleType:"+imageScaleType);
                        break;
                }
            }
        } finally {
            typedArray.recycle();
        }
        rect=new Rect();
        paint=new Paint();
        textBound=new Rect();
        paint.setTextSize(titleSize);
        paint.getTextBounds(titleText,0,titleText.length(),textBound);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int specMode=MeasureSpec.getMode(widthMeasureSpec);
        int specSize=MeasureSpec.getSize(widthMeasureSpec);
        //FIXME:当宽设置为固定值时,padding不起作用
        if (specMode==MeasureSpec.EXACTLY){//match_parent  accurate
            width=specSize;
        }else {
            if (specMode==MeasureSpec.AT_MOST){
                int widthByImage=getPaddingLeft()+getPaddingRight()+image.getWidth();
                int widthByText=getPaddingLeft()+getPaddingRight()+textBound.width();
                int desireWidth=Math.max(widthByImage,widthByText);
                width=Math.min(desireWidth,specSize);
            }
        }
        specMode=MeasureSpec.getMode(heightMeasureSpec);
        specSize=MeasureSpec.getSize(heightMeasureSpec);
        if (specMode==MeasureSpec.EXACTLY){
            height=specSize;
        }else{
            if (specMode==MeasureSpec.AT_MOST){
                int heightDesired=getPaddingTop()+getPaddingBottom()+image.getHeight()+textBound.height();
                height=Math.min(heightDesired,specSize);
            }
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        //paint是画笔   canvas是画布
        //边框
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.CYAN);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);

        rect.left=getPaddingLeft();
        rect.right=width-getPaddingRight();
        rect.bottom=height-getPaddingBottom();
        rect.top=getPaddingTop();

        paint.setColor(titleColor);
        paint.setStyle(Paint.Style.FILL);
        if (textBound.width()>width){//当设置的宽度小于字体需要的宽度
            TextPaint textPaint=new TextPaint(paint);
            String text=TextUtils.ellipsize(titleText,textPaint,width-getPaddingLeft()-getPaddingRight(),TextUtils.TruncateAt.END).toString();
            canvas.drawText(text,getPaddingLeft(),height-getPaddingBottom(),paint);
        }else{
            //正常情况字体居中
            canvas.drawText(titleText,width/2-textBound.width()/2,height-getPaddingBottom(),paint);
        }
        rect.bottom-=textBound.height();
        if (imageScaleType==0){
            canvas.drawBitmap(image,null,rect,paint);//Rect src: 是对图片进行裁截，若是空null则显示整个图片
                                                    // RectF dst：是图片在Canvas画布中显示的区域，大于src则把src的裁截区放大，小于src则把src的裁截区缩小。
        }else{
            rect.left=width/2-image.getWidth()/2;
            rect.top=(height-textBound.height())/2-image.getHeight()/2;
            rect.bottom=(height-textBound.height())/2+image.getHeight()/2;
            rect.right=width/2+image.getWidth()/2;
            canvas.drawBitmap(image,null,rect,paint);
        }

    }
}
