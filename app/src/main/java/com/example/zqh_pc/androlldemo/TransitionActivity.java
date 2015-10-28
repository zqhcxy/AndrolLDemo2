package com.example.zqh_pc.androlldemo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeTransform;
import android.transition.Transition;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.example.zqh_pc.androlldemo.Activity.ExplodeActivity;
import com.example.zqh_pc.androlldemo.Activity.FadeActivity;
import com.example.zqh_pc.androlldemo.Activity.ShareElementsActivity;
import com.example.zqh_pc.androlldemo.Activity.SlideActivity;

/**
 * 界面的切换动画
 * <p/>
 * <p><首先要想使用界面切换的动画必须要显示现在主题那里设置，界面切换动画可用。/>
 * <p><要注意的是，界面切换的动画必须要是5.0的系统才可以使用/>
 */
public class TransitionActivity extends Activity implements View.OnClickListener {

    private Button transition_explode;
    private Button transition_slide;
    private Button transition_fade;
    private Button transition_shared_elements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transition_activity);
        initView();

    }

    private void initView() {
        transition_explode = (Button) findViewById(R.id.transition_explode);
        transition_slide = (Button) findViewById(R.id.transition_slide);
        transition_fade = (Button) findViewById(R.id.transition_fade);
        transition_shared_elements = (Button) findViewById(R.id.transition_shared_elements);

        transition_explode.setOnClickListener(this);
        transition_slide.setOnClickListener(this);
        transition_fade.setOnClickListener(this);
        transition_shared_elements.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.transition_explode:
                intent.setClass(TransitionActivity.this, ExplodeActivity.class);
                changeView(intent);
                break;
            case R.id.transition_slide:
                intent.setClass(TransitionActivity.this, SlideActivity.class);
                changeView(intent);
                break;
            case R.id.transition_fade:
                intent.setClass(TransitionActivity.this, FadeActivity.class);
                changeView(intent);
                break;
            case R.id.transition_shared_elements:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    intent.setClass(TransitionActivity.this, ShareElementsActivity.class);
                    View transition_iv1 = findViewById(R.id.transition_iv1);
                    Transition ts = new ChangeTransform();
                    ts.setDuration(3000);
                    getWindow().setExitTransition(ts);

                    //单个共享元素
//                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, transition_iv1, "mypic").toBundle());

                    //多个共享元素
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(TransitionActivity.this,
                            Pair.create(transition_iv1, "mypic"),
                            Pair.create((View) transition_shared_elements, "ShareBtn")).toBundle();
                    startActivity(intent, bundle);
                }
                break;
        }
    }


    private void changeView(Intent intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(TransitionActivity.this).toBundle());
        } else {
            startActivity(intent);
        }
    }
}
