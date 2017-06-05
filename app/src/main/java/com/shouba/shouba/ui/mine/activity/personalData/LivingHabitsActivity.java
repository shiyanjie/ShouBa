package com.shouba.shouba.ui.mine.activity.personalData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.shouba.shouba.R;
import com.shouba.shouba.ui.main.activity.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by zoubo on 16/3/16.
 * 横向滚动刻度尺测试类
 */

public class LivingHabitsActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    private FlowlayoutTags flred2;


    /**
     * 入口
     * @param activity
     */
    public static void startAction(Activity activity){
        Intent intent = new Intent(activity, LivingHabitsActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_personal_data_heightandweight);

        ButterKnife.bind(this);  //依赖注入

        init();
    }

    private void init() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

    @OnClick(R.id.btn_choose_next)
    void onChooseResultClick() {
        Toast.makeText(this, "选择,身高： " + mHeight + " 体重： " + mWeight, Toast.LENGTH_LONG).show();
        MainActivity.startAction(LivingHabitsActivity.this);
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
