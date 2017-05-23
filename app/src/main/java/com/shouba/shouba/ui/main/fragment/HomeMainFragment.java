package com.shouba.shouba.ui.main.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseFragment;
import com.shouba.shouba.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * des:首页 主页
 * Created by xsf
 * on 2016.09.16:45
 */
public class HomeMainFragment extends BaseFragment {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.iv_bg)
    ImageView ivBg;
    @Bind(R.id.tv_tizhong_lishi)
    TextView tvTizhongLishi;
    @Bind(R.id.tv_tizhong_show)
    TextView tvTizhongShow;
    @Bind(R.id.tv_tizhong_jilu)
    TextView tvTizhongJilu;
    @Bind(R.id.radio0_mendian_renqizuigao)
    RadioButton radio0MendianRenqizuigao;
    @Bind(R.id.radio1_mendian_julizuijin)
    RadioButton radio1MendianJulizuijin;
    @Bind(R.id.radio_topbar)
    RadioGroup radioTopbar;
    @Bind(R.id.tv_locate)
    TextView tvLocate;

    @Override
    protected int getLayoutResource() {
        return R.layout.fra_home_main;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void initView() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.tv_locate)
    public void onViewClicked() {
    }
}
