package com.example.xiaowu.EventBus.AnotherExample;

import android.os.AsyncTask;

import java.util.concurrent.TimeUnit;

import de.greenrobot.event.EventBus;

/**
 * Created by matingting on 2016/11/25.
 */

public class LoadNewsContentEvent {
    private String mNewsContent;

    public String getNewsContent() {
        return mNewsContent;
    }

    public void loadNewsContent(final String newsUrl){
        new AsyncTask<Void,Void,Integer>(){

            @Override
            protected Integer doInBackground(Void... params) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return 1;
            }

            @Override
            protected void onPostExecute(Integer integer) {
                if (integer==1){
                    mNewsContent=newsUrl+".真是一条新闻";
                    EventBus.getDefault().post(LoadNewsContentEvent.this);
                }
            }
        }.execute();
    }
}
