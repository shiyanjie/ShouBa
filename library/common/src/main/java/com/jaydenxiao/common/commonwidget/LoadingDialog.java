package com.jaydenxiao.common.commonwidget;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaydenxiao.common.R;


/**
 * description:弹窗浮动加载进度条
 * Created by xsf
 * on 2016.07.17:22
 */
public class LoadingDialog {
    /** 加载数据对话框 */
    private static Dialog mLoadingDialog;

    /**
     * 显示提醒对话框
     * @param context 上下文
     * @param msg 对话框显示内容
     * @param cancelable 对话框是否可以取消
     */
    public static Dialog showDialogForAwoke(Activity context, String msg, boolean cancelable) {
        View view = LayoutInflater.from(context).inflate(R.layout.anim_dialog_layout, null);
//        TextView loadingText = (TextView)view.findViewById(R.id.id_tv_loading_dialog_text);
//        loadingText.setText(msg);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelDialogForLoading();
            }
        });

        mLoadingDialog = new Dialog(context, R.style.CustomProgressDialog);
        mLoadingDialog.setCancelable(cancelable);
        mLoadingDialog.setCanceledOnTouchOutside(false);
//        mLoadingDialog.setContentView(view);
//        WindowManager.LayoutParams params = mLoadingDialog.getWindow().getAttributes();
//        params.width = WindowManager.LayoutParams.MATCH_PARENT;
//        params.height = WindowManager.LayoutParams.MATCH_PARENT;
//        mLoadingDialog.getWindow().setAttributes(params);
//        mLoadingDialog.getWindow().getDecorView().setPadding(0,0,0,0);
        mLoadingDialog.setContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        mLoadingDialog.show();
        return  mLoadingDialog;
    }


    /**
     * 显示加载对话框
     * @param context 上下文
     * @param msg 对话框显示内容
     * @param cancelable 对话框是否可以取消
     */
    public static Dialog showDialogForLoading(Activity context, String msg, boolean cancelable) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        TextView loadingText = (TextView)view.findViewById(R.id.id_tv_loading_dialog_text);
        loadingText.setText(msg);

        mLoadingDialog = new Dialog(context, R.style.CustomProgressDialog);
        mLoadingDialog.setCancelable(cancelable);
        mLoadingDialog.setCanceledOnTouchOutside(false);
        mLoadingDialog.setContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        mLoadingDialog.show();
        return  mLoadingDialog;
    }

    public static Dialog showDialogForLoading(Activity context) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        TextView loadingText = (TextView)view.findViewById(R.id.id_tv_loading_dialog_text);
        loadingText.setText("加载中...");

        mLoadingDialog = new Dialog(context, R.style.CustomProgressDialog);
        mLoadingDialog.setCancelable(true);
        mLoadingDialog.setCanceledOnTouchOutside(false);
        mLoadingDialog.setContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        mLoadingDialog.show();
        return  mLoadingDialog;
    }

    /**
     * 关闭加载对话框
     */
    public static void cancelDialogForLoading() {
        if(mLoadingDialog != null) {
            mLoadingDialog.cancel();
        }
    }
}
