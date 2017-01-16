package com.example.xiaowu.pagerslidingstrip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.xiaowu.androidutils.R;
import com.example.xiaowu.viewpager.TestFourFrag;
import com.example.xiaowu.viewpager.TestOneFrag;
import com.example.xiaowu.viewpager.TestThreeFrag;
import com.example.xiaowu.viewpager.TestTwoFrag;
import com.example.xiaowu.viewpager.TestViewPagerAdapter;

import java.util.ArrayList;

public class HorizontalViewActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private PagerSlidingStrip mPagerSlidingStrip;
    private ArrayList<Fragment> mFragList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_view);

        TestOneFrag frag1=new TestOneFrag();
        Bundle bundle1=new Bundle();
        bundle1.putCharSequence("object","1");
        frag1.setArguments(bundle1);

        TestTwoFrag frag2=new TestTwoFrag();
        Bundle bundle2=new Bundle();
        bundle2.putCharSequence("object","2");
        frag2.setArguments(bundle2);

        TestThreeFrag frag3=new TestThreeFrag();
        Bundle bundle3=new Bundle();
        bundle3.putCharSequence("object","3");
        frag3.setArguments(bundle3);

        TestFourFrag frag4=new TestFourFrag();
        Bundle bundle4=new Bundle();
        bundle4.putCharSequence("object","4");
        frag4.setArguments(bundle4);

        TestOneFrag frag5=new TestOneFrag();
        Bundle bundle5=new Bundle();
        bundle5.putCharSequence("object","5");
        frag5.setArguments(bundle5);

        TestTwoFrag frag6=new TestTwoFrag();
        Bundle bundle6=new Bundle();
        bundle6.putCharSequence("object","6");
        frag6.setArguments(bundle6);

        TestThreeFrag frag7=new TestThreeFrag();
        Bundle bundle7=new Bundle();
        bundle7.putCharSequence("object","7");
        frag7.setArguments(bundle7);

        TestFourFrag frag8=new TestFourFrag();
        Bundle bundle8=new Bundle();
        bundle8.putCharSequence("object","8");
        frag8.setArguments(bundle8);

        mFragList.add(frag1);
        mFragList.add(frag2);
        mFragList.add(frag3);
        mFragList.add(frag4);
        mFragList.add(frag5);
        mFragList.add(frag6);
        mFragList.add(frag7);
        mFragList.add(frag8);

        mPagerSlidingStrip= (PagerSlidingStrip) findViewById(R.id.pst_tab);
        mViewPager= (ViewPager) findViewById(R.id.vp_tab_pager);
        mViewPager.setAdapter(new TestViewPagerAdapter(getSupportFragmentManager(),mFragList,this));
        mPagerSlidingStrip.setViewPager(mViewPager);
    }
}
