package com.shouba.shouba.app;

import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.shouba.shouba.BuildConfig;

/**
 * APPLICATION
 */
public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger
        LogUtils.logInit(BuildConfig.LOG_DEBUG);
    }
}
