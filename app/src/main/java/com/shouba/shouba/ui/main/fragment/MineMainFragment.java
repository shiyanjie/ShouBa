package com.shouba.shouba.ui.main.fragment;

import android.support.v7.widget.Toolbar;

import com.jaydenxiao.common.base.BaseFragment;
import com.shouba.shouba.R;

import butterknife.Bind;


/**
 * des:我的 主页
 * Created by xsf
 * on 2016.09.17:07
 */
public class MineMainFragment extends BaseFragment {
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutResource() {
        return R.layout.fra_mine_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }
}
