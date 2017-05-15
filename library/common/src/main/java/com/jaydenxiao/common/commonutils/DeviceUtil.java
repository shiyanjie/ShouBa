package com.jaydenxiao.common.commonutils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.jaydenxiao.common.baseapp.BaseApplication;

import java.io.File;

/**
 * Created by Jerry on 2015/8/9 0009.
 */
public class DeviceUtil {
    private static Boolean _isTablet = null;

    public static DisplayMetrics getDisplayMetrics() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager) BaseApplication.context().getSystemService(
                Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(
                displaymetrics);
        return displaymetrics;
    }

    public static float getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }

    public static float getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }

    public static boolean isTablet() {
        if (_isTablet == null) {
            boolean flag;
            flag = (0xf & BaseApplication.context().getResources()
                    .getConfiguration().screenLayout) >= 3;
            _isTablet = Boolean.valueOf(flag);
        }
        return _isTablet.booleanValue();
    }


    public static float dpToPixel(float dp) {
        return dp * (getDisplayMetrics().densityDpi / 160F);
    }

    public static String getVersionName() {
        String name = "";
        try {
            name = BaseApplication.context().getPackageManager().getPackageInfo(BaseApplication.context().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException ex) {
            name = "";
        }
        return name;
    }

    public static int getVersionCode() {
        int code = 0;
        try {
            code = BaseApplication.context().getPackageManager().getPackageInfo(BaseApplication.context().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException ex) {
            code = 0;
        }
        return code;
    }

    public static void installAPK(Context context, File file) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static Intent getInstallApkIntent(File file) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        return intent;
    }

    /**
     * 判断当前版本是否兼容目标版本的方法
     *
     * @param VersionCode
     * @return
     */
    public static boolean isMethodsCompat(int VersionCode) {
        int currentVersion = android.os.Build.VERSION.SDK_INT;
        return currentVersion >= VersionCode;
    }

    public static boolean hasInternet() {
        boolean flag;
        if (((ConnectivityManager) BaseApplication.context().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static void showSoftKeyboard(View view) {
        ((InputMethodManager) BaseApplication.context().getSystemService(
                Context.INPUT_METHOD_SERVICE)).showSoftInput(view,
                InputMethodManager.SHOW_FORCED);
    }

    public static void toastFail(Context context, int msg) {
        toastFail(context, context.getString(msg));
    }

    public static void toastSuccess(Context context, int msg) {
        toastSuccess(context, context.getString(msg));
    }

    public static void toastFail(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void toastSuccess(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
