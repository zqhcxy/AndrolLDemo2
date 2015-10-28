package com.example.zqh_pc.androlldemo.Activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.example.zqh_pc.androlldemo.R;

public class ShareElementsActivity extends Activity {
    private ImageView share_iv1;
    private Button share_bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Explode());
        }
        setContentView(R.layout.share_elements_activity);

        share_iv1 = (ImageView) findViewById(R.id.share_iv1);
        share_bt1 = (Button) findViewById(R.id.shar_bt1);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            share_iv1.setTransitionName("mypic");
            share_bt1.setTransitionName("ShareBtn");
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            finishAfterTransition();
    }
}
