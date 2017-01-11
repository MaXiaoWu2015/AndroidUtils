package com.example.xiaowu.AndroidDataStorage.DataBase.greendao;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.xiaowu.androidutils.R;
import com.example.xiaowu.AndroidDataStorage.DataBase.greendao.generate.ChannelDao;
import com.example.xiaowu.AndroidDataStorage.DataBase.greendao.generate.DaoMaster;
import com.example.xiaowu.AndroidDataStorage.DataBase.greendao.generate.DaoSession;
import com.example.xiaowu.AndroidDataStorage.DataBase.greendao.generate.MessageDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class GreenDaoTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao_test);
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "SystemMessage.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        MessageDao messageDao = daoSession.getMessageDao();
        ChannelDao channelDao=daoSession.getChannelDao();
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;

        for (int j=0;j<20;j++){
            Message message=new Message(null,100+j,(long)12+j,"testTitle",1,473923874,765843929,0,1,1,"http",1,0,"#00ff00",1,1,"gotoparam","dian","http");
            messageDao.insertOrReplace(message);
        }


        for (int i=0;i<5;i++){
            Channel channel=new Channel((long) (12+i),"腾讯视频",1);
            channelDao.insertOrReplace(channel);
        }

        QueryBuilder queryBuilder=messageDao.queryBuilder();
        List<Message> messages=queryBuilder.orderDesc(MessageDao.Properties.Create_time).limit(12).offset(0).list();

        QueryBuilder queryBuilder1=channelDao.queryBuilder();
        List<Channel> channelList=queryBuilder1.list();

        //测试Contentprovider
        Uri uri=Uri.parse("content://com.konka.message.contentprovider/MessageTable");
        String where="ReadedFlag=0";
        Cursor cursor=getContentResolver().query(uri,new String[]{MessageDao.Properties.Id.columnName+"",MessageDao.Properties.Is_pop.columnName+""},where,null,null);


    }
}
