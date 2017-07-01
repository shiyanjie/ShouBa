package com.shouba.shouba.app;

import android.content.Context;
import android.content.SharedPreferences;

import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.shouba.shouba.BuildConfig;
import com.shouba.shouba.util.MyConfig;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;

import scaleruler.utils.DrawUtil;

/**
 * APPLICATION
 */
public class AppApplication extends BaseApplication {
    private static String PREF_NAME = MyConfig.APP + ".pref";
    private static final String PROPERTY_RECORD_DATE = "date";

    private static AppApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //初始化logger
        LogUtils.logInit(BuildConfig.LOG_DEBUG);
        DrawUtil.resetDensity(this);
        //开启debug模式，方便定位错误，具体错误检查方式可以查看http://dev.umeng.com/social/android/quick-integration的报错必看，正式发布，请关闭该模式
        Config.DEBUG = true;
        //全局配置友盟
        UMShareAPI.get(this);
        //完整版
        Config.isUmengSina= false;
        Config.isUmengQQ = false;
        Config.isUmengWx = false;

        UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        config.isOpenShareEditActivity(true);
        config.setSinaAuthType(UMShareConfig.AUTH_TYPE_SSO);
        //config.setFacebookAuthType(UMShareConfig.AUTH_TYPE_SSO);
        //config.setShareToLinkedInFriendScope(UMShareConfig.LINKED_IN_FRIEND_SCOPE_ANYONE);
    }

    //各个平台的配置，建议放在全局Application或者程序入口
    {
        PlatformConfig.setWeixin("wxb6f24f06c15cb7f1", "4cf62bed6129cdda17657a5162285ac6");
        PlatformConfig.setQQZone("1106170061", "AddJP1S2BI3N5XEm");
        PlatformConfig.setSinaWeibo("1864837974", "d514d4ab0250293cfe641e7d4da9f2c7", "https://api.weibo.com/oauth2/default.html");
    }

    /**
     * 保存日期
     * @return
     */
    public void save(String date){
        setProperty(PROPERTY_RECORD_DATE,date);
    }
    /**
     * 获取日期
     * @return
     */
    public String getDate(){
        return getProperty(PROPERTY_RECORD_DATE);
    }

    /**
     * 设置
     * @param key
     * @param value
     */
    public static void setProperty(String key, String value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(key, value);
        apply(editor);
    }

    /**
     * 获取
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        return getPreferences().getString(key, "");
    }

    /**
     * 删除
     * @param keys
     */
    public static void removeProperty(String... keys) {
        for (String key : keys) {
            SharedPreferences.Editor editor = getPreferences().edit();
            editor.putString(key, null);
            apply(editor);
        }
    }

    public static SharedPreferences getPreferences() {
        return context().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void apply(SharedPreferences.Editor editor) {
        editor.apply();
    }

    public static AppApplication instance() {
        return instance;
    }

}

