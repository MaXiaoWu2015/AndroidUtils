package com.example.xiaowu.MVP.mvp_retrofit_rxjava;

import javax.inject.Inject;

/**
 * Created by xiaowu on 2016-9-26.
 */
public class ApkInfoModel {
    private String apkVersion;
    private String updateInfo;

    @Inject
    public ApkInfoModel() {
    }

    public String getApkVersion() {
        return apkVersion;
    }

    public void setApkVersion(String apkVersion) {
        this.apkVersion = apkVersion;
    }

    public String getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }
}
