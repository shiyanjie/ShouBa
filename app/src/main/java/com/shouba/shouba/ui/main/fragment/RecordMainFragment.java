package com.shouba.shouba.ui.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseFragment;
import com.shouba.shouba.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jodd.datetime.JDateTime;


/**
 * des:记录 主页
 * Created by xsf
 * on 2016.09.16:45
 */
public class RecordMainFragment extends BaseFragment {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.iv_bg)
    ImageView ivBg;
    @Bind(R.id.radio0_mendian_renqizuigao)
    RadioButton radio0MendianRenqizuigao;
    @Bind(R.id.radio1_mendian_julizuijin)
    RadioButton radio1MendianJulizuijin;
    @Bind(R.id.radio_topbar)
    RadioGroup radioTopbar;
    @Bind(R.id.tv_tizhong_lishi)
    TextView tvTizhongLishi;
    @Bind(R.id.tv_tizhong_show)
    TextView tvTizhongShow;
    @Bind(R.id.tv_tizhong_jilu)
    TextView tvTizhongJilu;
    @Bind(R.id.tv_locate)
    TextView tvLocate;

    private int mYear = Calendar.getInstance().get(Calendar.YEAR);
    private int mMonth = Calendar.getInstance().get(Calendar.MONTH);
    private int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);


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
        return R.layout.fra_record_main;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void initView() {
        toolbar.setTitle(R.string.record);
        JDateTime dateTime = new JDateTime();
        tvTizhongLishi.setText(dateTime.getMonth() + "月" + dateTime.getDayOfMonth() + "日");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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

    @OnClick({R.id.tv_tizhong_lishi, R.id.tv_tizhong_show, R.id.tv_tizhong_jilu, R.id.tv_locate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_tizhong_lishi:
                Calendar now = Calendar.getInstance();
                now.set(mYear, mMonth, mDay);
                DatePickerDialog dialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                        mYear = year;
                        mMonth = monthOfYear;
                        mDay = dayOfMonth;
                        Calendar temp = Calendar.getInstance();
                        temp.clear();
                        temp.set(year, monthOfYear, dayOfMonth);
                        tvTizhongLishi.setText(++monthOfYear + "月" + dayOfMonth + "日");
                        //presenter.loadPosts(temp.getTimeInMillis(), true);
                    }
                }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));

                dialog.setMaxDate(Calendar.getInstance());
                Calendar minDate = Calendar.getInstance();
                // 1992.9.1是石彦杰出生日期
                minDate.set(1992, 9, 1);
                dialog.setMinDate(minDate);
                dialog.vibrate(true);
                dialog.setThemeDark(true);
                dialog.setAccentColor(getResources().getColor(R.color.main_color));
                dialog.setVersion(DatePickerDialog.Version.VERSION_2);

                dialog.show(getActivity().getFragmentManager(), "DatePickerDialog");
                break;
            case R.id.tv_tizhong_show:
                break;
            case R.id.tv_tizhong_jilu:
                break;
            case R.id.tv_locate:
                break;
        }
    }
}
