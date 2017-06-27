package com.shouba.shouba.app;

import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.shouba.shouba.BuildConfig;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import scaleruler.utils.DrawUtil;

/**
 * APPLICATION
 */
public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
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
    }

    //各个平台的配置，建议放在全局Application或者程序入口
    {
        PlatformConfig.setWeixin("wxb6f24f06c15cb7f1", "4cf62bed6129cdda17657a5162285ac6");
        PlatformConfig.setQQZone("1106170061", "AddJP1S2BI3N5XEm");
        PlatformConfig.setSinaWeibo("1864837974", "d514d4ab0250293cfe641e7d4da9f2c7", "https://api.weibo.com/oauth2/default.html");
    }
    
}

