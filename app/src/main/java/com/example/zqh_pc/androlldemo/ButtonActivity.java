package com.example.zqh_pc.androlldemo;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class ButtonActivity extends Activity implements View.OnClickListener {

    TextView tv1;
    private static final String TAG = "触摸监听";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api大于21就执行
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Slide());
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_activity);
//        Button bt2 = (Button) findViewById(R.id.bt2);
        tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setOnClickListener(this);
//        tv1.setOnClickListener(this);


        //控件的点击悬浮感觉。
        tv1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "ACTION_DOWN on view.");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api大于21就执行
                            tv1.setTranslationZ(10);
                            tv1.setBackgroundResource(R.drawable.info_background);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "ACTION_UP on view.");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api大于21就执行
                            tv1.setTranslationZ(0);
                        }
                        break;
                    default:
                        return true;
                }

                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:

                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api大于21就执行
            finishAfterTransition();
        }
    }
}
