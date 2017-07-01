package com.shouba.shouba.util;

import android.os.Environment;

/**
 * Created by Jerry on 2015/8/9 0009.
 */
public class MyConfig {
    public static final String APP = "shouba";

    public final static String BASE_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + APP;
    public final static String UPDATE_APK_PAHT = BASE_DIR + "/" + "update";
    public final static String IMAGE_SAVE_PAHT = BASE_DIR + "/" + "images";
    public final static String IMAGE = "/" + APP + "/" + "images/";
    public final static String CACHE_IMAGE_SAVE_PAHT = IMAGE_SAVE_PAHT + "/" + "cache/";
}
