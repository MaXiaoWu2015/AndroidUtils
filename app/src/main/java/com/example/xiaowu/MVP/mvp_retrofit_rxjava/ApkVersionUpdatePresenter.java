package com.example.xiaowu.MVP.mvp_retrofit_rxjava;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xiaowu on 2016-9-26.
 */
public class ApkVersionUpdatePresenter {
    @Inject
    ApkInfoModel apkInfoModel;
    private ApkUpdateView updateView;
    private Retrofit retrofit;
    private RetrofitCall retrofitCall;


    @Inject
    public ApkVersionUpdatePresenter(ApkUpdateView view) {
        updateView=view;
    }

    public void getVersionInfoFromServer(String url){
        retrofit=new Retrofit.Builder()
                .baseUrl("http://api.github.com/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitCall=retrofit.create(RetrofitCall.class);
        Call<ApkInfoBean> mycall=retrofitCall.getVer("1");


    }

}
