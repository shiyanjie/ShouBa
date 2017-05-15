package com.jaydenxiao.common.baseapp;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

/**
 * APPLICATION
 */
public class BaseApplication extends Application {

    private static BaseApplication baseApplication;
    public static Context _context;
    public static Resources _resource;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        _context = getApplicationContext();
        _resource = _context.getResources();
    }

    public static BaseApplication getAppContext() {
        return baseApplication;
    }
    public static Resources getAppResources() {
        return baseApplication.getResources();
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 分包
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    public static synchronized BaseApplication context() {
        return (BaseApplication) _context;
    }

    public static Resources resources() {
        return _resource;
    }


}
