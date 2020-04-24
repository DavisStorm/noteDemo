package com.davis.mall.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * @author 王阳
 * @time 2019/12/19  1:29
 * @desc
 */
public class SimpleAlertDialogUtil {

    public static void showConfirmDialog(Context ctx, String msg, final DialogCallBack listner){
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setMessage(msg).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listner.cancelCallback();
                dialogInterface.dismiss();
            }
        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listner.confirmCallback();
                dialogInterface.dismiss();
            }
        }).create().show();

    }
    public abstract static class DialogCallBack{
        protected abstract void confirmCallback();
        protected abstract void cancelCallback();
    }
}
