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
import com.shouba.shouba.ui.mine.activity.personalData.PersonalDataShowActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * des:我的 主页
 * Created by xsf
 * on 2016.09.17:07
 */
public class MineMainFragment extends BaseFragment {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.ll_daynight_userinfo)
    LinearLayout llDaynightUserinfo;
    @Bind(R.id.ll_daynight_jianzhongmubiao)
    LinearLayout llDaynightJianzhongmubiao;
    @Bind(R.id.ll_daynight_dingdan)
    LinearLayout llDaynightDingdan;
    @Bind(R.id.ll_daynight_shezhi)
    LinearLayout llDaynightShezhi;
    @Bind(R.id.ll_daynight_about)
    LinearLayout llDaynightAbout;

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
        return R.layout.fra_mine_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

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
            default:
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.ll_daynight_userinfo, R.id.ll_daynight_jianzhongmubiao, R.id.ll_daynight_dingdan, R.id.ll_daynight_shezhi, R.id.ll_daynight_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_daynight_userinfo:
                startActivity(PersonalDataShowActivity.class);
                break;
            case R.id.ll_daynight_jianzhongmubiao:
                break;
            case R.id.ll_daynight_dingdan:
                break;
            case R.id.ll_daynight_shezhi:
                break;
            case R.id.ll_daynight_about:
                break;
        }
    }
}
