package com.shouba.shouba.ui.mine.activity.personalData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.baseapp.AppManager;
import com.shouba.shouba.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jodd.datetime.JDateTime;
import scaleruler.view.ScaleRulerView;

/**
 * Created by zoubo on 16/3/16.
 * 横向滚动刻度尺测试类
 */

public class SexAndAgeActivity extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rb_male)
    RadioButton rbMale;
    @Bind(R.id.rb_female)
    RadioButton rbFemale;
    @Bind(R.id.rg_sex)
    RadioGroup rgSex;
    @Bind(R.id.tv_user_age_value)
    TextView tvUserAgeValue;
    @Bind(R.id.scaleWheelView_age)
    ScaleRulerView scaleWheelViewAge;
    @Bind(R.id.btn_choose_next)
    Button btnChooseNext;

    private float mAge;
    private float mMaxAge;
    private float mMinAge;

    /**
     * 入口
     * @param activity
     */
    public static void startAction(Activity activity){
        Intent intent = new Intent(activity, SexAndAgeActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_personal_data_sexeandage);
        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        JDateTime now = new JDateTime();
        mMaxAge = now.getYear();
        mAge = mMaxAge - 18;
        mMinAge = mMaxAge - 80;

        ButterKnife.bind(this);  //依赖注入

        init();
    }

    private void init() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tvUserAgeValue.setText((int) mAge + "");

        scaleWheelViewAge.initViewParam(mAge, mMaxAge, mMinAge);
        scaleWheelViewAge.setValueChangeListener(new ScaleRulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                tvUserAgeValue.setText((int) value + "");
                mAge = value;
            }
        });


    }

    @OnClick(R.id.btn_choose_next)
    public void onViewClicked() {
        Toast.makeText(this, "选择,性别： " + "男" + " 出生年： " + mAge, Toast.LENGTH_SHORT).show();
        HeightAndWeightActivity.startAction(SexAndAgeActivity.this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
