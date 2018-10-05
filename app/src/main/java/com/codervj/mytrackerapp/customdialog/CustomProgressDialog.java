package com.codervj.mytrackerapp.customdialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;

import com.codervj.mytrackerapp.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by viraj.jage on 13-04-2018.
 */

public class CustomProgressDialog extends Dialog {

    public Activity activity;
    public Dialog d;
    private AVLoadingIndicatorView avi;
    private String indicator;
    private Boolean cancelable;


    public CustomProgressDialog(@NonNull Activity activity, String inidicator, boolean cancelable) {
        super(activity);
        this.activity = activity;
        this.indicator = inidicator;
        this.cancelable = cancelable;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.custom_dialog);
        setCancelable(cancelable);
        setCanceledOnTouchOutside(cancelable);

        avi = (AVLoadingIndicatorView) findViewById(R.id.avi);
        avi.setIndicator(indicator);
    }

    @Override
    public boolean isShowing() {
        avi.show();
        return super.isShowing();
    }

    @Override
    public void dismiss() {
        avi.hide();
        super.dismiss();
    }

}
