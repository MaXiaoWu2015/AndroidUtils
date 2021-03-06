package com.example.xiaowu.network;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import com.example.xiaowu.androidutils.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by maxiaowu on 16/7/13.
 */
public class VolleyActivity extends Activity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        imageView= (ImageView) findViewById(R.id.iv_image);

        //la.RequestQueue
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        Volley.newRequestQueue(this,new HurlStack(null,null));
//        //2.ImageLoader
//        ImageLoader imageLoader=new ImageLoader(requestQueue, new BitmapCache());
//        //ImageListener
//        ImageLoader.ImageListener imageListener= ImageLoader.getImageListener(imageView,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
//        //
//        imageLoader.get("http://img4.imgtn.bdimg.com/it/u=2262413897,3754053237&fm=21&gp=0.jpg"
//                         ,imageListener);










    }

    public void httpUrlConnect(String urlStr) {
        try {
            URL url=new URL(urlStr);
            HttpURLConnection  connection= (HttpURLConnection) url.openConnection();
            if(connection.getResponseCode()==200)
            {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    class BitmapCache implements ImageLoader.ImageCache{
        LruCache<String,Bitmap> lruCache;
        public BitmapCache() {
             lruCache=new LruCache<String,Bitmap>(10*1024*1024){//此处MaxSize的单位要与sizeOf返回值得单位一致
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    value.getByteCount();
                    return value.getRowBytes()*value.getHeight();//等于value.getByteCount();但是此函数API12之后才有
                }
            };
        }

        @Override
        public Bitmap getBitmap(String s) {
            return lruCache.get(s);
        }

        @Override
        public void putBitmap(String s, Bitmap bitmap) {
            lruCache.put(s,bitmap);
        }
    }
}
