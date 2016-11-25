package com.example.xiaowu.EventBus;

import android.os.AsyncTask;

import de.greenrobot.event.EventBus;

/**
 * Created by matingting on 2016/11/24.
 */

public class RunTask {
    private String result;

    public  void runTask(){
        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                    result="SUCCESS";
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 1;
            }

            @Override
            protected void onPostExecute(Integer integer) {
                if (integer==1){
                    EventBus.getDefault().post(RunTask.this);
                }
            }
        }.execute();
    }

    public String getResult() {
        return result;
    }
}
