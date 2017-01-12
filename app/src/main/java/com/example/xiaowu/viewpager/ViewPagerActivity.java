package com.example.xiaowu.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.xiaowu.androidutils.R;

import java.util.ArrayList;

public class ViewPagerActivity extends FragmentActivity {
    private TestViewPagerAdapter mTestViewPagerAdapter;
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initViewPager();

    }

    private void initViewPager() {
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

        mFragList.add(frag1);
        mFragList.add(frag2);
        mFragList.add(frag3);
        mFragList.add(frag4);

        mTestViewPagerAdapter=new TestViewPagerAdapter(getSupportFragmentManager(),mFragList,this);
        mViewPager= (ViewPager) findViewById(R.id.vp_test);
        mViewPager.setAdapter(mTestViewPagerAdapter);
        mViewPager.setCurrentItem(2,true);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                    int positionOffsetPixels) {
                Log.d("onPageScrolled", "position: "+position+"--positionOffset: "+positionOffset
                    +"--positionOffsetPixels:"+positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("onStateChanged", "state: "+state+"--position:"+mViewPager.getCurrentItem());
            }
        });


    }
}
