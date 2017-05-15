package com.shouba.shouba.ui.main.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaydenxiao.common.base.BaseFragment;
import com.jaydenxiao.common.base.BaseFragmentAdapter;
import com.shouba.shouba.R;
import com.shouba.shouba.bean.ShouBaChannelTable;
import com.shouba.shouba.db.ShouBaChannelTableManager;
import com.shouba.shouba.ui.shouba.ShouBaFragment;
import com.shouba.shouba.util.MyUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * des:瘦吧 主页
 * Created by syj
 * on 2017.05.04 13:09
 */
public class ShouBaMainFragment extends BaseFragment{
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    private BaseFragmentAdapter fragmentAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fra_shouba_main;
    }

    @Override
    public void initPresenter() {
    }


    @Override
    public void initView() {
        List<String> channelNames = new ArrayList<>();
        List<ShouBaChannelTable> shoubaChannelTableList = ShouBaChannelTableManager.loadShouBaChannelsMine();
        List<Fragment> mNewsFragmentList = new ArrayList<>();
        for (int i = 0; i < shoubaChannelTableList.size(); i++) {
            channelNames.add(shoubaChannelTableList.get(i).getChannelName());
            mNewsFragmentList.add(createListFragments(shoubaChannelTableList.get(i)));
        }
        fragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), mNewsFragmentList, channelNames);
        viewPager.setAdapter(fragmentAdapter);
        tabs.setupWithViewPager(viewPager);
        MyUtils.dynamicSetTabLayoutMode(tabs);
        setPageChangeListener();

    }

    private void setPageChangeListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private ShouBaFragment createListFragments(ShouBaChannelTable shouBaChannelTable) {
        ShouBaFragment fragment = new ShouBaFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(AppConstant.VIDEO_TYPE, videoChannelTable.getChannelId());
//        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
