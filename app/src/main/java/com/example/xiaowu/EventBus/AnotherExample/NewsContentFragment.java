package com.example.xiaowu.EventBus.AnotherExample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiaowu.androidutils.R;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by matingting on 2016/11/25.
 */

public class NewsContentFragment extends Fragment {
    private TextView tvNewsContent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.news_content_frag,container,false);
        tvNewsContent= (TextView) view.findViewById(R.id.tv_news_content);
        EventBus.getDefault().register(this);
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void handleNewsContentEvent(LoadNewsContentEvent loadNewsContentEvent){
        tvNewsContent.setText(loadNewsContentEvent.getNewsContent());
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
