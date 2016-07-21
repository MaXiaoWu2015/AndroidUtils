package com.example.xiaowu.network;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.xiaowu.androidutils.R;

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
        //2.ImageLoader
        ImageLoader imageLoader=new ImageLoader(requestQueue, new BitmapCache());
        //ImageListener
        ImageLoader.ImageListener imageListener= ImageLoader.getImageListener(imageView,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        //
        imageLoader.get("http://img4.imgtn.bdimg.com/it/u=2262413897,3754053237&fm=21&gp=0.jpg"
                         ,imageListener);

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
