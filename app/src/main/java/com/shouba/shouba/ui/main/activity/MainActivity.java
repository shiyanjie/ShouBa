package com.shouba.shouba.ui.main.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.baseapp.AppManager;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.shouba.shouba.R;
import com.shouba.shouba.app.AppConstant;
import com.shouba.shouba.bean.TabEntity;
import com.shouba.shouba.ui.main.fragment.HomeMainFragment;
import com.shouba.shouba.ui.main.fragment.MineMainFragment;
import com.shouba.shouba.ui.main.fragment.RecordMainFragment;
import com.shouba.shouba.ui.main.fragment.ServiceMainFragment;
import com.shouba.shouba.ui.main.fragment.ShouBaMainFragment;

import java.util.ArrayList;

import butterknife.Bind;
import rx.functions.Action1;


/**
 * des:主界面
 * Created by syj
 * on 2017.05.04 09:12
 */
public class MainActivity extends BaseActivity {
    @Bind(R.id.tab_layout)
    CommonTabLayout tabLayout;

    private String[] mTitles = {"首页", "记录", "瘦吧", "服务", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.icon_shouye,
            R.mipmap.icon_record,
            R.mipmap.icon_pengyouquan,
            R.mipmap.icon_fuwu,
            //R.mipmap.icon_shangcheng,
            R.mipmap.icon_wode};
    private int[] mIconSelectIds = {
            R.mipmap.icon_shouye_selected,
            R.mipmap.icon_record_selector,
            R.mipmap.icon_pengyouquan_selected,
            R.mipmap.icon_fuwu_selector,
            //R.mipmap.icon_shangcheng_selected,
            R.mipmap.icon_wode_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private HomeMainFragment homeMainFragment;
    private RecordMainFragment recordMainFragment;
    private ShouBaMainFragment shoubaMainFragment;
    private ServiceMainFragment serviceMainFragment;
    //private StoreMainFragment storeMainFragment;
    private MineMainFragment mineMainFragment;
    private static int tabLayoutHeight;

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    @Override
    public int getLayoutId() {
        return R.layout.act_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        //初始化菜单
        initTab();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化frament
        initFragment(savedInstanceState);
        tabLayout.measure(0, 0);
        tabLayoutHeight = tabLayout.getMeasuredHeight();
        //监听菜单显示或隐藏
        mRxManager.on(AppConstant.MENU_SHOW_HIDE, new Action1<Boolean>() {

            @Override
            public void call(Boolean hideOrShow) {
                startAnimation(hideOrShow);
            }
        });
    }

    /**
     * 初始化tab
     */
    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        //点击监听
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                SwitchTo(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }

    /**
     * 初始化碎片
     */
    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (savedInstanceState != null) {
            homeMainFragment = (HomeMainFragment) getSupportFragmentManager().findFragmentByTag("homeMainFragment");
            recordMainFragment = (RecordMainFragment) getSupportFragmentManager().findFragmentByTag("recordMainFragment");
            shoubaMainFragment = (ShouBaMainFragment) getSupportFragmentManager().findFragmentByTag("shoubaMainFragment");
            serviceMainFragment = (ServiceMainFragment) getSupportFragmentManager().findFragmentByTag("serviceMainFragment");
            //storeMainFragment = (StoreMainFragment) getSupportFragmentManager().findFragmentByTag("storeMainFragment");
            mineMainFragment = (MineMainFragment) getSupportFragmentManager().findFragmentByTag("mineMainFragment");
            currentTabPosition = savedInstanceState.getInt(AppConstant.HOME_CURRENT_TAB_POSITION);
        } else {
            homeMainFragment = new HomeMainFragment();
            recordMainFragment = new RecordMainFragment();
            shoubaMainFragment = new ShouBaMainFragment();
            serviceMainFragment = new ServiceMainFragment();
            //storeMainFragment = new StoreMainFragment();
            mineMainFragment = new MineMainFragment();

            transaction.add(R.id.fl_body, homeMainFragment, "homeMainFragment");
            transaction.add(R.id.fl_body, recordMainFragment, "recordMainFragment");
            transaction.add(R.id.fl_body, shoubaMainFragment, "shoubaMainFragment");
            transaction.add(R.id.fl_body, serviceMainFragment, "serviceMainFragment");
            //transaction.add(R.id.fl_body, storeMainFragment, "storeMainFragment");
            transaction.add(R.id.fl_body, mineMainFragment, "mineMainFragment");
        }
        transaction.commit();
        SwitchTo(currentTabPosition);
        tabLayout.setCurrentTab(currentTabPosition);
    }

    /**
     * 切换
     */
    private void SwitchTo(int position) {
        LogUtils.logd("主页菜单position" + position);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            //首页
            case 0:
                transaction.hide(shoubaMainFragment);
                transaction.hide(serviceMainFragment);
                //transaction.hide(storeMainFragment);
                transaction.hide(mineMainFragment);
                transaction.hide(recordMainFragment);
                transaction.show(homeMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            //记录
            case 1:
                transaction.hide(shoubaMainFragment);
                transaction.hide(serviceMainFragment);
                //transaction.hide(storeMainFragment);
                transaction.hide(mineMainFragment);
                transaction.show(recordMainFragment);
                transaction.hide(homeMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            //瘦吧
            case 2:
                transaction.hide(homeMainFragment);
                transaction.hide(serviceMainFragment);
                //transaction.hide(storeMainFragment);
                transaction.hide(mineMainFragment);
                transaction.hide(recordMainFragment);
                transaction.show(shoubaMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            //服务
            case 3:
                transaction.hide(homeMainFragment);
                transaction.hide(shoubaMainFragment);
                transaction.hide(mineMainFragment);
                transaction.hide(recordMainFragment);
                //transaction.hide(storeMainFragment);
                transaction.show(serviceMainFragment);
                transaction.commitAllowingStateLoss();
                break;
//            //商城
//            case 3:
//                transaction.hide(homeMainFragment);
//                transaction.hide(shoubaMainFragment);
//                transaction.hide(mineMainFragment);
//                transaction.hide(serviceMainFragment);
//                transaction.show(storeMainFragment);
//                transaction.commitAllowingStateLoss();
//                break;
            //我的
            case 4:
                transaction.hide(homeMainFragment);
                transaction.hide(serviceMainFragment);
                transaction.hide(shoubaMainFragment);
                transaction.hide(recordMainFragment);
                //transaction.hide(storeMainFragment);
                transaction.show(mineMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            default:
                break;
        }
    }

    /**
     * 菜单显示隐藏动画
     *
     * @param showOrHide
     */
    private void startAnimation(boolean showOrHide) {
        final ViewGroup.LayoutParams layoutParams = tabLayout.getLayoutParams();
        ValueAnimator valueAnimator;
        ObjectAnimator alpha;
        if (!showOrHide) {
            valueAnimator = ValueAnimator.ofInt(tabLayoutHeight, 0);
            alpha = ObjectAnimator.ofFloat(tabLayout, "alpha", 1, 0);
        } else {
            valueAnimator = ValueAnimator.ofInt(0, tabLayoutHeight);
            alpha = ObjectAnimator.ofFloat(tabLayout, "alpha", 0, 1);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = (int) valueAnimator.getAnimatedValue();
                tabLayout.setLayoutParams(layoutParams);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.playTogether(valueAnimator, alpha);
        animatorSet.start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //奔溃前保存位置
        LogUtils.loge("onSaveInstanceState进来了1");
        if (tabLayout != null) {
            LogUtils.loge("onSaveInstanceState进来了2");
            outState.putInt(AppConstant.HOME_CURRENT_TAB_POSITION, tabLayout.getCurrentTab());
        }
    }

    // 定义一个变量，来标识是否退出运用
    private static boolean isExit = false;

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    public void onBackPressed() {
        exit();
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            toastSuccess("再按一次退出瘦吧");
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            AppManager.getAppManager().finishAllActivity();
            //System.exit(0);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
