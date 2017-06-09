package com.shouba.shouba.ui.loginAndRegister.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.shouba.shouba.R;
import com.shouba.shouba.ui.main.activity.MainActivity;

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
    @OnClick({R.id.bt_go, R.id.fab, R.id.tv_forgot_password, R.id.tv_try})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_go:
//                Explode explode = new Explode();
//                explode.setDuration(500);
//
//                getWindow().setExitTransition(explode);
//                getWindow().setEnterTransition(explode);
//                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
//                Intent i2 = new Intent(this, MainActivity.class);
//                startActivity(i2, oc2.toBundle());
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
//                Explode explode2 = new Explode();
//                explode2.setDuration(500);
//
//                getWindow().setExitTransition(explode2);
//                getWindow().setEnterTransition(explode2);
//                ActivityOptionsCompat oc3 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
//                Intent i3 = new Intent(this, MainActivity.class);
//                startActivity(i3, oc3.toBundle());
                MainActivity.startAction(LoginActivity.this);
                finish();
                break;
        }
    }

}
