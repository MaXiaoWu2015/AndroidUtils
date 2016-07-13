package com.example.xiaowu.androidutils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by xiaowu on 2016-7-13.
 */
public class PicassoLoadImageActivity extends Activity {
    private ListView listView;
    private ArrayList<String> urls=new ArrayList<>(Arrays.asList("http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E7%8C%AB&step_word=&pn=10&spn=0&di=34824521930&pi=&rn=1&tn=baiduimagedetail&is=&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=3625844925%2C4286367426&os=2764463278%2C2040434329&simid=0%2C0&adpicid=0&ln=1000&fr=&fmq=1468401784964_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fpic72.nipic.com%2Ffile%2F20150714%2F20189787_162248346000_2.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bgtrtv_z%26e3Bv54AzdH3Ffi5oAzdH3F8dbla80a_z%26e3Bip4s&gsm=0&rpstart=0&rpnum=0",
            "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E7%8C%AB&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&cs=4179009277,1727118498&os=1177998450,3161705755&simid=3414218232,127427140&pn=12&rn=1&di=149346028920&ln=1000&fr=&fmq=1468401784964_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=&istype=0&ist=&jit=&bdtype=0&gsm=0&objurl=http%3A%2F%2Fqzone.qqjay.com%2Fu%2Ffiles%2F2012%2F0205%2Fad99246a4f267cc0082cfaf52b42757c.jpg&rpstart=0&rpnum=0",
             "http://img4.imgtn.bdimg.com/it/u=2656521927,321608059&fm=21&gp=0.jpg","http://img0.imgtn.bdimg.com/it/u=1600853217,3338986549&fm=21&gp=0.jpg",
              "http://img4.imgtn.bdimg.com/it/u=2262413897,3754053237&fm=21&gp=0.jpg","http://img3.imgtn.bdimg.com/it/u=414388703,27764692&fm=21&gp=0.jpg"));
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        listView= (ListView) findViewById(R.id.lv_images);
        listView.setAdapter(new MyAdpater());
    }

    class MyAdpater extends BaseAdapter{

        @Override
        public int getCount() {
            return urls.size();
        }

        @Override
        public Object getItem(int i) {
            return urls.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view==null)
            {
                view= LayoutInflater.from(PicassoLoadImageActivity.this).inflate(R.layout.picasso_item,viewGroup,false);

            }
            ImageView imageView= (ImageView) view.findViewById(R.id.iv_pic);


           Picasso.Builder builder= new Picasso.Builder(PicassoLoadImageActivity.this);
            builder.memoryCache(new LruCache(PicassoLoadImageActivity.this){
                @Override
                public Bitmap get(String key) {
                    return super.get(key);
                }

                @Override
                public void set(String key, Bitmap bitmap) {
                    super.set(key, bitmap);
                }
            });
           Picasso picasso= builder.build();
                    picasso.load(urls.get(i))
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.drawable.index)
                    .noFade()
                    .into(imageView);



            return view;
        }
    }
}
