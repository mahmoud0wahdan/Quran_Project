package com.example.mahmoud_ebrahim.Base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class BaseDialogActivity extends AppCompatActivity {

    public AppCompatActivity activity;

    MaterialDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=this;
    }

    public MaterialDialog showMessage(int titleResId, int contentResId, int positiveMessageResId){
        dialog=new MaterialDialog.Builder(this)
                .title(titleResId)
                .content(contentResId)
                .positiveText(positiveMessageResId)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
        return dialog;

    }
    public MaterialDialog showMessage(String title, String content, String positiveMessage){
        dialog=new MaterialDialog.Builder(this)
                .title(title)
                .content(content)
                .positiveText(positiveMessage)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
        return dialog;

    }

    public MaterialDialog showConfirmationMessage(String title, String content, String positiveMessage , MaterialDialog.SingleButtonCallback action){
        dialog=new MaterialDialog.Builder(activity)
                .title(title)
                .content(content)
                .positiveText(positiveMessage)
                .onPositive(action)
                .show();

        return dialog;
    }

    public MaterialDialog showConfirmationMessage(int titleResId, int contentResId, int positiveMessageResId , MaterialDialog.SingleButtonCallback action){
        dialog=new MaterialDialog.Builder(activity)
                .title(titleResId)
                .content(contentResId)
                .positiveText(positiveMessageResId)
                .onPositive(action)
                .show();

        return dialog;
    }
    public MaterialDialog showProgressBar(String message){

        dialog=new MaterialDialog.Builder(this)
                .progress(true,0)
                .cancelable(false)
                .title(message)
                .show();
        return dialog;
    }
    public MaterialDialog showProgressBar(int message){

        dialog=new MaterialDialog.Builder(this)
                .progress(true,0)
                .cancelable(false)
                .title(message)
                .show();
        return dialog;
    }
    public void dismissProgressBar(){
        if (dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
        }
    }
}
