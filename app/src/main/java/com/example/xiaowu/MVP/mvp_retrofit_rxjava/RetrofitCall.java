package com.example.xiaowu.MVP.mvp_retrofit_rxjava;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xiaowu on 2016-9-26.
 */
public interface RetrofitCall {
    @GET("app/index/type")
    Call<ApkInfoBean> getVer(@Query("version") String version);
}
