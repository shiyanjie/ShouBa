package com.shouba.shouba.ui.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseFragment;
import com.shouba.shouba.R;
import com.shouba.shouba.ui.record.activity.FoodRecordActivity;
import com.shouba.shouba.ui.record.activity.PeriodRecordActivity;
import com.shouba.shouba.ui.record.activity.WeiduRecordActivity;
import com.shouba.shouba.ui.record.activity.WeightRecordActivity;
import com.shouba.shouba.ui.service.activity.MouldingActivity;
import com.shouba.shouba.ui.service.activity.WorkandrestActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * des:服务 主页
 * Created by syj
 * on 2017.05.04 13:26
 */
public class ServiceMainFragment extends BaseFragment {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.ll_record_weight)
    LinearLayout llRecordWeight;
    @Bind(R.id.ll_record_weidu)
    LinearLayout llRecordWeidu;
    @Bind(R.id.ll_record_period)
    LinearLayout llRecordPeriod;
    @Bind(R.id.ll_daynight_recommend)
    LinearLayout llDaynightRecommend;
    @Bind(R.id.ll_record_breakfast)
    LinearLayout llRecordBreakfast;
    @Bind(R.id.ll_record_lunch)
    LinearLayout llRecordLunch;
    @Bind(R.id.ll_record_supper)
    LinearLayout llRecordSupper;
    @Bind(R.id.ll_service_moulding)
    LinearLayout llServiceMoulding;
    @Bind(R.id.ll_service_plaster)
    LinearLayout llServicePlaster;
    @Bind(R.id.ll_record_workandrest)
    LinearLayout llRecordWorkandrest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//加上这句话，menu才会显示出来
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.toolbar);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fra_service_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        toolbar.setTitle(R.string.to_store_service);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.message:
                Toast.makeText(getActivity(), "点击了消息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                Toast.makeText(getActivity(), "点击了添加", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.ll_service_moulding, R.id.ll_record_workandrest, R.id.ll_record_weight, R.id.ll_record_weidu, R.id.ll_record_period, R.id.ll_daynight_recommend, R.id.ll_record_breakfast, R.id.ll_record_lunch, R.id.ll_record_supper})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_service_moulding:
                startActivity(MouldingActivity.class);
                break;
            case R.id.ll_record_workandrest:
                startActivity(WorkandrestActivity.class);
                break;
            case R.id.ll_record_weight:
                startActivity(WeightRecordActivity.class);
                break;
            case R.id.ll_record_weidu:
                startActivity(WeiduRecordActivity.class);
                break;
            case R.id.ll_record_period:
                startActivity(PeriodRecordActivity.class);
                break;
            case R.id.ll_daynight_recommend:
                break;
            case R.id.ll_record_breakfast:
                startActivity(FoodRecordActivity.class);
                break;
            case R.id.ll_record_lunch:
                startActivity(FoodRecordActivity.class);
                break;
            case R.id.ll_record_supper:
                startActivity(FoodRecordActivity.class);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
