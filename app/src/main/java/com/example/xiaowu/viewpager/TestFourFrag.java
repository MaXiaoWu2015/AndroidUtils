package com.example.xiaowu.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xiaowu.androidutils.R;

/**
 * Created by matingting on 2017/1/11.
 */

public class TestFourFrag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.view_pager_frag,container,false);
        Bundle args=getArguments();
        ((Button)rootView.findViewById(R.id.button4)).setText(args.getCharSequence("object"));
        return rootView;

    }

}
