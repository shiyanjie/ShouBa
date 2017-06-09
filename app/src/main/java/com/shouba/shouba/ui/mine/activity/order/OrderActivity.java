package com.shouba.shouba.ui.mine.activity.order;

import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.shouba.shouba.R;

import butterknife.Bind;
import butterknife.OnClick;


/**
 * des:订单
 * Created by syj
 * on 2017.05.04 09:12
 */
public class OrderActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.orders_delete)
    TextView ordersDelete;
    @Bind(R.id.oeders_share)
    TextView oedersShare;
    @Bind(R.id.cardView)
    CardView cardView;
    @Bind(R.id.cardView2)
    CardView cardView2;

    @Override
    public int getLayoutId() {
        return R.layout.act_orders;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        toolbar.setTitle(R.string.myOrder);
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


    @OnClick({R.id.orders_delete, R.id.oeders_share, R.id.cardView, R.id.cardView2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.orders_delete:
                break;
            case R.id.oeders_share:
                break;
            case R.id.cardView:
                startActivity(OrderDetialActivity.class);
                break;
            case R.id.cardView2:
                startActivity(OrderDetialActivity.class);
                break;
        }
    }
}
