package com.example.xiaowu.AndroidDataStorage.DataBase.greendao.greendao_contentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.aaron.library.MLog;
import com.example.xiaowu.AndroidDataStorage.DataBase.greendao.generate.DaoMaster;
import com.example.xiaowu.AndroidDataStorage.DataBase.greendao.generate.DaoSession;
import com.example.xiaowu.AndroidDataStorage.DataBase.greendao.generate.MessageDao;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * Created by xiaowu on 2016-8-31.
 */
public class MyContentProvider extends ContentProvider {
    private static final String TAG = "MyContentProvider";
    public static final int message=0;
    public static final int messages=1;
    public static final String AUTHORITY="com.konka.message.contentprovider";

    private static UriMatcher uriMatcher;

    private DaoMaster.DevOpenHelper helper;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private SQLiteDatabase sqLiteDatabase;
    private MessageDao messageModelDao;

    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, MessageDao.TABLENAME,messages);
//        uriMatcher.addURI(AUTHORITY,MessageDBController.MSG_TABLENAME+"/#",message);
    }

    @Override
    public boolean onCreate() {
        helper=new DaoMaster.DevOpenHelper(getContext(),"SystemMessage.db",null);
        sqLiteDatabase=helper.getReadableDatabase();
        daoMaster=new DaoMaster(sqLiteDatabase);
        daoSession=daoMaster.newSession();
        messageModelDao=daoSession.getMessageDao();
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
        return true;
    }
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
//        SQLiteDatabase sqLiteDatabase=helper.getReadableDatabase();

        Cursor cursor=null;
        MLog.d(TAG,"content_provider:"+uri);
        switch (uriMatcher.match(uri)) {
            case messages:
                if (strings!=null){
                StringBuffer buffer=new StringBuffer();
                for (int i = 0; i < strings.length; i++) {
                    buffer.append(strings[i]).append(",");
                }
                String colums=buffer.toString();
                colums=colums.substring(0,colums.length()-1);
                    cursor=daoSession.getDatabase().rawQuery("select "+colums+" from "+MessageDao.TABLENAME+" where "+s,strings1);
                }else {
                    cursor=daoSession.getDatabase().rawQuery("select *"+" from "+MessageDao.TABLENAME+" where "+s,strings1);
                }
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {

        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}