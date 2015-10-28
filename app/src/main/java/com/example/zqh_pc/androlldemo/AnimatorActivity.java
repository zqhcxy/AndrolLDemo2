package com.example.zqh_pc.androlldemo;

import android.animation.Animator;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 动画效果
 */
public class AnimatorActivity extends Activity implements View.OnClickListener {
    private TextView anmator_tv1;
    private ImageView anmator_iv1;
    private ImageView anmator_iv2;
    private ImageView anmator_iv3;
    private Button anmator_bt1;

    private int picIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api大于21就执行
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Fade());
            getWindow().setExitTransition(new Fade());
        }
        setContentView(R.layout.animator_activity);

        initView();
    }

    private void initView() {
        anmator_tv1 = (TextView) findViewById(R.id.anmator_tv1);
        anmator_iv1 = (ImageView) findViewById(R.id.anmator_iv1);
        anmator_iv2 = (ImageView) findViewById(R.id.anmator_iv2);
        anmator_iv3 = (ImageView) findViewById(R.id.anmator_iv3);
        anmator_bt1 = (Button) findViewById(R.id.anmator_bt1);


        anmator_iv3.setOnClickListener(this);
        anmator_bt1.setOnClickListener(this);
        anmator_tv1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.anmator_iv3:
                Animator animator1 = createAnimation(anmator_iv3, true);
                if (animator1 != null) {
                    animator1.start();
                    animator1.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            if (picIndex == 0) {
                                picIndex = 1;
                                anmator_iv3.setImageResource(R.mipmap.picture1);
//                                anmator_iv3.setImageDrawable(getDrawable(R.mipmap.picture1));
                            } else {
                                picIndex = 0;
                                anmator_iv3.setImageResource(R.mipmap.picture2);
                            }
                            doSecondAnim();
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                }
                break;
            case R.id.anmator_tv1:
                Animator animator2 = createAnimation(anmator_tv1, true);
                if (animator2 != null) {
                    animator2.start();
                }
                break;
            case R.id.anmator_bt1: {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api大于21就执行

                    Animator animator;
                    if (anmator_iv2.getVisibility() == View.INVISIBLE) {
                        anmator_iv2.setVisibility(View.VISIBLE);
                        animator = ViewAnimationUtils.createCircularReveal(
                                anmator_iv2,
                                anmator_iv1.getWidth() - anmator_bt1.getWidth() / 2,
                                anmator_iv1.getHeight() - anmator_bt1.getHeight() / 2,
                                0,
                                (float) Math.hypot(anmator_iv2.getWidth(), anmator_iv2.getHeight()));


                    } else {
                        animator = ViewAnimationUtils.createCircularReveal(
                                anmator_iv2,
                                anmator_iv1.getWidth() - anmator_bt1.getWidth() / 2,
                                anmator_iv1.getHeight() - anmator_bt1.getHeight() / 2,
                                (float) Math.hypot(anmator_iv2.getWidth(), anmator_iv2.getHeight()), 0);
                        animator.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                anmator_iv2.setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });
                    }
                    animator.setInterpolator(new AccelerateInterpolator());
                    animator.setDuration(500);
                    animator.start();
                }
            }
            break;

        }
    }

    /**
     * create CircularReveal animation with first and second sequence
     */
    public Animator createAnimation(View v, Boolean isFirst) {

        Animator animator = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api大于21就执行

            if (isFirst) {
                animator = ViewAnimationUtils.createCircularReveal(
                        v,
                        v.getWidth() / 2,
                        v.getHeight() / 2,
                        v.getWidth(),
                        0);
            } else {
                animator = ViewAnimationUtils.createCircularReveal(
                        v,
                        v.getWidth() / 2,
                        v.getHeight() / 2,
                        0,
                        v.getWidth());
            }

            animator.setInterpolator(new DecelerateInterpolator());
            animator.setDuration(500);
        }
        return animator;
    }

    /**
     * exec second animation for pic view
     */
    private void doSecondAnim() {
        Animator animator = createAnimation(anmator_iv3, false);
        animator.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api大于21就执行
            finishAfterTransition();
        }
    }
}
