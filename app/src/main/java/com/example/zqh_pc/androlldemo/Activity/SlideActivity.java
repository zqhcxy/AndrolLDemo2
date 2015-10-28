package com.example.zqh_pc.androlldemo.Activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Window;

import com.example.zqh_pc.androlldemo.R;

public class SlideActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Slide());
            getWindow().setExitTransition(new Slide());
        }
        setContentView(R.layout.slide_activity);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            finishAfterTransition();
    }
}
