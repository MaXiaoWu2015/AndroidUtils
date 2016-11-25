package com.example.xiaowu.EventBus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiaowu.androidutils.R;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class EventBusActivity extends AppCompatActivity {
    private TextView mTextView;
    private Button   btn;
    private RunTask mRunTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        mTextView = (TextView) findViewById(R.id.event_text);
        btn = (Button) findViewById(R.id.btn);
        mRunTask = new RunTask();
        EventBus.getDefault().register(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRunTask.runTask();
            }
        });
    }

    @Subscribe(threadMode=ThreadMode.MainThread)
    public void OnEventMainThread(RunTask runTask ){
        mTextView.setText(runTask.getResult());
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
