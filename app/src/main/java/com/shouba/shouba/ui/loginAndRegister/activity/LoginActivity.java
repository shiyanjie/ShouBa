package com.shouba.shouba.ui.loginAndRegister.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.shouba.shouba.R;
import com.shouba.shouba.ui.main.activity.MainActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/5/27.
 */

public class LoginActivity extends BaseActivity {


    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.usernameWrapper)
    TextInputLayout usernameWrapper;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.passwordWrapper)
    TextInputLayout passwordWrapper;
    @Bind(R.id.bt_go)
    Button btGo;
    //@Bind(R.id.cv)
    //CardView cv;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.tv_forgot_password)
    TextView tvForgotPassword;
    @Bind(R.id.tv_try)
    TextView tvTry;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.login_qq)
    ImageView loginQq;
    @Bind(R.id.login_weixin)
    ImageView loginWeixin;
    @Bind(R.id.login_weibo)
    ImageView loginWeibo;

    UMAuthListener authListener;

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @Override
    public int getLayoutId() {
        return R.layout.act_login;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        toolbar.setTitle(R.string.welcomeLogin);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.bt_go, R.id.fab, R.id.tv_forgot_password, R.id.tv_try, R.id.login_qq, R.id.login_weixin, R.id.login_weibo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_go:
                MainActivity.startAction(LoginActivity.this);
                finish();
                break;
            case R.id.fab:
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options =
                            ActivityOptions.makeSceneTransitionAnimation(this, fab, fab.getTransitionName());
                    startActivity(new Intent(this, RegisterActivity.class), options.toBundle());
                } else {
                    startActivity(new Intent(this, RegisterActivity.class));
                }
                break;
            case R.id.tv_forgot_password:
                break;
            case R.id.tv_try:
                MainActivity.startAction(LoginActivity.this);
                finish();
                break;
            case R.id.login_qq:
                SHARE_MEDIA share_media_qq = SHARE_MEDIA.QQ.toSnsPlatform().mPlatform;
                UMShareAPI.get(LoginActivity.this).getPlatformInfo(LoginActivity.this, share_media_qq, authListener);
                break;
            case R.id.login_weixin:
                SHARE_MEDIA share_media_weixin = SHARE_MEDIA.WEIXIN.toSnsPlatform().mPlatform;
                UMShareAPI.get(LoginActivity.this).getPlatformInfo(LoginActivity.this, share_media_weixin, authListener);
                break;
            case R.id.login_weibo:
                SHARE_MEDIA share_media_weibo = SHARE_MEDIA.SINA.toSnsPlatform().mPlatform;
                UMShareAPI.get(LoginActivity.this).getPlatformInfo(LoginActivity.this, share_media_weibo, authListener);
                break;
        }

        authListener = new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA platform) {
                toastSuccess("开始授权");
                Log.i("syj", "onStart: 开始授权");
            }

            @Override
            public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
                String temp = "";
                for (String key : data.keySet()) {
                    temp = temp + key + " : " + data.get(key) + "\n";
                }
                if (data!=null){

                    toastSuccess(temp);
                }


            }

            @Override
            public void onError(SHARE_MEDIA platform, int action, Throwable t) {
                toastFail("错误" + t.getMessage());
                Log.i("syj", "onError: 错误授权");
            }

            @Override
            public void onCancel(SHARE_MEDIA platform, int action) {
                toastSuccess("onCancel授权");
            }
        };

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }
}
