package com.example.xiaowu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.xiaowu.androidutils.R;
import com.example.xiaowu.androidutils.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2Activity";
    private SpannableStringBuilder mSpannableString;
    private TextView mTvSpannableText;
    private TextView mTextView2;
    private TextView mTextView3;
    private RelativeLayout mRlComment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        test();
//        setSpannableString("明星","回复","粉丝:","你好，很高兴认识你");
    }

    private void initView() {
        mTvSpannableText= (TextView) findViewById(R.id.tv_spannable);
        mTextView2= (TextView) findViewById(R.id.textView2);
        mTextView3= (TextView) findViewById(R.id.textView3);
        mRlComment = (RelativeLayout) findViewById(R.id.rl_comment);
//        mTvSpannableText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ToastUtil.showToast(Main2Activity.this,"click all me");
//            }
//        });

        mRlComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showToast(Main2Activity.this,"click rl");
            }
        });
    }

    private void setSpannableString(String reply,String replyStr,String replied,String comment) {
        mSpannableString=new SpannableStringBuilder();
        mSpannableString.append(reply).append(replyStr).append(replied).append(comment);
//        mSpannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#0000ff")),2,5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#7693AC")),0,reply.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#7693AC")),reply.length()+replyStr.length(),reply.length()+replyStr.length()+replied.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        mSpannableString.setSpan(new NoUnderLineClickable() {
//            @Override
//            public void onClick(View view) {
//                mTextView2.setText("click reply");
//            }
//        },0,reply.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        mSpannableString.setSpan(new NoUnderLineClickable() {
//            @Override
//            public void onClick(View view) {
//                mTextView3.setText("click replied");
//            }
//        },reply.length()+replyStr.length(),reply.length()+replyStr.length()+replied.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //TODO:为什么没有效果
//        mSpannableString.setSpan(new DynamicDrawableSpan() {
//            @Override
//            public Drawable getDrawable() {
//                return getResources().getDrawable(R.mipmap.ic_launcher);
//            }
//        },0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        mSpannableString.setSpan(new ImageSpan(this,R.mipmap.ic_launcher),mSpannableString.length()-1,mSpannableString.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        mSpannableString.setSpan(new ClickableSpan() {
//            @Override
//            public void onClick(View view) {
//                ToastUtil.showToast(Main2Activity.this,"click me!");
//            }
//        },2,5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTvSpannableText.setText(mSpannableString);
        mTvSpannableText.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public void test(){
        ArrayList<Object> list=new ArrayList<>();
        list.add(0,1);

        ArrayList<String> stringArrayList=new ArrayList<>(Arrays.asList("2","3","4","5"));
        list.add(stringArrayList);
        Log.d(TAG, "test: "+list.toString());
    }


    abstract class NoUnderLineClickable extends ClickableSpan{
        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(false);
//            ds.bgColor=Color.parseColor("#ffffff");
        }

        public NoUnderLineClickable() {
            super();

        }
    }
}
