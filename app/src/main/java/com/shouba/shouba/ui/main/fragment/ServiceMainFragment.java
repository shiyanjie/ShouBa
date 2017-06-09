package com.shouba.shouba.ui.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseFragment;
import com.shouba.shouba.R;

import butterknife.Bind;


/**
 * des:服务 主页
 * Created by syj
 * on 2017.05.04 13:26
 */
public class ServiceMainFragment extends BaseFragment {


    @Bind(R.id.toolbar)
    Toolbar toolbar;

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
        toolbar.setTitle(R.string.service_main_title);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.toolbar,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.message:
                Toast.makeText(getActivity(), "点击了消息", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
