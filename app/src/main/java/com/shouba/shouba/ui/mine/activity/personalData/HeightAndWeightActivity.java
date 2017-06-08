package com.shouba.shouba.ui.mine.activity.personalData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.baseapp.AppManager;
import com.shouba.shouba.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import scaleruler.utils.DrawUtil;
import scaleruler.view.DecimalScaleRulerView;
import scaleruler.view.ScaleRulerView;


/**
 * Created by zoubo on 16/3/16.
 * 横向滚动刻度尺测试类
 */

public class HeightAndWeightActivity extends AppCompatActivity {

    @Bind(R.id.scaleWheelView_height)
    ScaleRulerView mHeightWheelView;
    @Bind(R.id.tv_user_height_value)
    TextView mHeightValue;

    @Bind(R.id.scaleWheelView_weight)
    DecimalScaleRulerView mWeightWheelView;
    @Bind(R.id.tv_user_weight_value)
    TextView mWeightValue;


    @Bind(R.id.ruler_weight)
    DecimalScaleRulerView mWeightRulerView;
    @Bind(R.id.tv_user_weight_value_two)
    TextView mWeightValueTwo;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private float mHeight = 170;
    private float mMaxHeight = 220;
    private float mMinHeight = 100;


    private float mWeight = 60.0f;
    private float mMaxWeight = 200;
    private float mMinWeight = 25;

    /**
     * 入口
     * @param activity
     */
    public static void startAction(Activity activity){
        Intent intent = new Intent(activity, HeightAndWeightActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_personal_data_heightandweight);
        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        ButterKnife.bind(this);  //依赖注入

        init();
    }

    private void init() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mHeightValue.setText((int) mHeight + "");
        mWeightValue.setText(mWeight + "kg");
        mWeightValueTwo.setText(mWeight + "kg");

        mHeightWheelView.initViewParam(mHeight, mMaxHeight, mMinHeight);
        mHeightWheelView.setValueChangeListener(new ScaleRulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                mHeightValue.setText((int) value + "");
                mHeight = value;
            }
        });

        mWeightWheelView.setParam(DrawUtil.dip2px(10), DrawUtil.dip2px(32), DrawUtil.dip2px(24),
                DrawUtil.dip2px(14), DrawUtil.dip2px(9), DrawUtil.dip2px(12));
        mWeightWheelView.initViewParam(mWeight, 20.0f, 200.0f, 1);
        mWeightWheelView.setValueChangeListener(new DecimalScaleRulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                mWeightValueTwo.setText(value + "kg");

                mWeight = value;
            }
        });


        mWeightRulerView.setParam(DrawUtil.dip2px(10), DrawUtil.dip2px(32), DrawUtil.dip2px(24),
                DrawUtil.dip2px(14), DrawUtil.dip2px(9), DrawUtil.dip2px(12));
        mWeightRulerView.initViewParam(mWeight, 20.0f, 200.0f, 1);
        mWeightRulerView.setValueChangeListener(new DecimalScaleRulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                mWeightValueTwo.setText(value + "kg");

                mWeight = value;
            }
        });
    }

    @OnClick(R.id.btn_choose_next)
    void onChooseResultClick() {
        Toast.makeText(this, "选择,身高： " + mHeight + " 体重： " + mWeight, Toast.LENGTH_SHORT).show();
        LivingHabitsActivity.startAction(HeightAndWeightActivity.this);
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