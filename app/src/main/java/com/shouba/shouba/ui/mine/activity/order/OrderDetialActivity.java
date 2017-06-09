package com.shouba.shouba.ui.mine.activity.order;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaydenxiao.common.base.BaseActivity;
import com.shouba.shouba.R;

import butterknife.Bind;


/**
 * des:订单详情
 * Created by syj
 * on 2017.05.04 09:12
 */
public class OrderDetialActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;


    @Override
    public int getLayoutId() {
        return R.layout.act_orders_detials;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        toolbar.setTitle(R.string.orders_detail);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
