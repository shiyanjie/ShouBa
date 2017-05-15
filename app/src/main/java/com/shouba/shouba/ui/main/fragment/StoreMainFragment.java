package com.shouba.shouba.ui.main.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaydenxiao.common.base.BaseFragment;
import com.shouba.shouba.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * des:商城 主页
 * Created by syj
 * on 2017.05.04 13:26
 */
public class StoreMainFragment extends BaseFragment {


    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutResource() {
        return R.layout.fra_store_main;
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
}
