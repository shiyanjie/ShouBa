package com.shouba.shouba.ui.mine.activity.personalData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jackuhan.flowlayouttags.FlowlayoutTags;
import com.jaydenxiao.common.baseapp.AppManager;
import com.shouba.shouba.R;
import com.shouba.shouba.ui.main.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

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
//        activity.overridePendingTransition(R.anim.fade_in,
//                R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_personal_data_livinghabits);
        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        ButterKnife.bind(this);  //依赖注入

        init();
    }

    private void init() {
        toolbar.setTitle(R.string.set_personal_data);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        this.flred2 = (FlowlayoutTags) findViewById(R.id.fl_red2);
        final List<String> list = new ArrayList<String>();
        list.add("饮食油腻");
        list.add("爱吃零食");
        list.add("常喝饮料（含糖、碳酸）");
        list.add("经常喝酒");
        list.add("爱吃肥肉");
        list.add("爱吃坚果（腰果、杏仁）");
        list.add("常吃宵夜（每周一次）");
        list.add("吃饭很晚（晚上8点以后）");
        list.add("吃饭很快（20分钟内）");
        list.add("饭量时多时少");
        list.add("饮食不规律");
        list.add("通常每天都坐着");
        list.add("基本不运动");
        list.add("经常熬夜");
        refreshCategorys(flred2, list);

        flred2.setOnTagClickListener(new FlowlayoutTags.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                Log.i("Hanjh flred2", flred2.getCheckedTagsTextsArrayList().toString());
//                ArrayList<Integer> tagList = flred2.getCheckedTagsIndexArrayList();
//                String mCategory = "";
//                for (int i = 0; i < tagList.size(); i++) {
//                    mCategory += list.get(tagList.get(i)) + ",";
//                }
//                Log.e("Hanjh","mCategory "+mCategory +" "+tagList);
            }
        });


    }

    public void refreshCategorys(FlowlayoutTags flowlayoutTags,List<String> list) {
        flowlayoutTags.removeAllViews();

        flowlayoutTags.setTags(list);
        flowlayoutTags.setTagsUncheckedColorAnimal(false);

    }

    @OnClick(R.id.btn_choose_next)
    void onChooseResultClick() {
        Toast.makeText(this, "选择,生活习惯： " +flred2.getCheckedTagsTextsArrayList().toString(), Toast.LENGTH_SHORT).show();
        MainActivity.startAction(LivingHabitsActivity.this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
