package com.shouba.shouba.ui.main.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jaydenxiao.common.base.BaseFragment;
import com.jaydenxiao.common.base.BaseFragmentAdapter;
import com.shouba.shouba.R;
import com.shouba.shouba.bean.ShouBaChannelTable;
import com.shouba.shouba.db.ShouBaChannelTableManager;
import com.shouba.shouba.ui.shouba.fragment.ShouBaBangFragment;
import com.shouba.shouba.ui.shouba.fragment.ShouBaQuanFragment;
import com.shouba.shouba.util.MyUtils;

import java.lang.reflect.Field;
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
        }
        mNewsFragmentList.add(new ShouBaQuanFragment());
        mNewsFragmentList.add(new ShouBaBangFragment());
        fragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), mNewsFragmentList, channelNames);
        viewPager.setAdapter(fragmentAdapter);
        tabs.setupWithViewPager(viewPager);
        //设置TabLayout子空间间距和下划线的长度,必须在TabLayout渲染后设置
        tabs.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(tabs,10,10);
            }
        });
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    /*
    * 设置TabLayout子空间间距和下划线的长度
    * */
    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }


    }


}
