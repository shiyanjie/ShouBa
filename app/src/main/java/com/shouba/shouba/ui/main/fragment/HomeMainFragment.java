package com.shouba.shouba.ui.main.fragment;

import android.support.v7.widget.Toolbar;

import com.jaydenxiao.common.base.BaseFragment;
import com.shouba.shouba.R;

import butterknife.Bind;


/**
 * des:首页 主页
 * Created by xsf
 * on 2016.09.16:45
 */
public class HomeMainFragment extends BaseFragment{


    @Bind(R.id.toolbar)
    Toolbar toolbar;

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

}
