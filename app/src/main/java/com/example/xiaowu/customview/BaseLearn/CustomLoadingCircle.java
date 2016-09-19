package com.example.xiaowu.customview.BaseLearn;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

import com.example.xiaowu.androidutils.R;

/**
 * Created by maxiaowu on 16/9/4.
 *
 */
public class CustomLoadingCircle extends View {
    private int firstColor;
    private int secondColor;
    private int   circleWidth;
    private int   interval;
    private boolean isNextColor;
    private int progress;
    private Paint paint;
    private RectF rectF;
    public CustomLoadingCircle(Context context) {
        this(context,null);
    }

    public CustomLoadingCircle(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomLoadingCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public CustomLoadingCircle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray typedArray=context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomLoadingCircle,0,0);
        int count=typedArray.getIndexCount();
        for (int i=0;i<count;i++){
            int attr=typedArray.getIndex(i);
            switch (attr){
                case R.styleable.CustomLoadingCircle_circleWidth:
                    circleWidth= (int) typedArray.getDimension(attr,5);
                    break;
                case R.styleable.CustomLoadingCircle_firstColor:
                    firstColor=typedArray.getColor(attr,Color.GRAY);
                    break;
                case R.styleable.CustomLoadingCircle_secondColor:
                    secondColor=typedArray.getColor(attr,Color.GREEN);
                    break;
                case R.styleable.CustomLoadingCircle_interval:
                    interval=typedArray.getInt(attr,500);
                    break;
            }
        }
        typedArray.recycle();
        paint=new Paint();
        paint.setStrokeWidth(circleWidth);
        paint.setStyle(Paint.Style.STROKE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    progress++;
                    if (progress>=360){
                        progress=0;
                        if (isNextColor){
                            isNextColor=false;
                        }else {
                            isNextColor=true;
                        }
                    }
                    postInvalidate();
                    SystemClock.sleep(interval);
                }
            }
        }).start();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        int centerX=getWidth()/2;
        int radius=getWidth()/2-circleWidth;
        rectF=new RectF(centerX-radius,centerX-radius,centerX+radius,centerX+radius);
        if (!isNextColor){
            paint.setColor(firstColor);
            canvas.drawCircle(centerX,centerX,radius,paint);
            paint.setColor(secondColor);
            canvas.drawArc(rectF,-90,progress,false,paint);
        }else {
            paint.setColor(secondColor);
            canvas.drawCircle(centerX,centerX,radius,paint);
            paint.setColor(firstColor);
            canvas.drawArc(rectF,-90,progress,false,paint);
        }
    }
}
