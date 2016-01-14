package com.example.zqh_pc.androlldemo.Activity;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.zqh_pc.androlldemo.R;

/**
 * Drawable Tinting着色功能
 */
public class DrawableTitingActivity extends AppCompatActivity {
    private ImageView tinting_iv1;
    private ImageButton tinting_iv2;
    private Toolbar my_toolbar;
//    private Button tinting_bt1;
//    private Button tinting_bt2;
//    private Button tinting_bt3;
//    private Button tinting_bt4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api大于21就执行
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Slide());
        }
        setTheme(R.style.NewTheme2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_titing_activity);

        initView();
    }

    private void initView() {
        tinting_iv1 = (ImageView) findViewById(R.id.tinting_iv1);
        tinting_iv2 = (ImageButton) findViewById(R.id.tinting_iv2);
        my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        if (my_toolbar != null) {
            setSupportActionBar(my_toolbar);
        }
//        my_toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.blue1));
        my_toolbar.setTitle("Image着色");
        my_toolbar.setNavigationIcon(R.mipmap.nav_return);
        my_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tinting_iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//        tinting_bt1 = (Button) findViewById(R.id.tinting_bt1);
//        tinting_bt2 = (Button) findViewById(R.id.tinting_bt2);
//        tinting_bt3 = (Button) findViewById(R.id.tinting_bt3);
//        tinting_bt4 = (Button) findViewById(R.id.tinting_bt4);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_drawable_titing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.tinting_bt1:
                drawableTinting(ContextCompat.getColor(this, R.color.skin1));
                break;
            case R.id.tinting_bt2:
                drawableTinting(ContextCompat.getColor(this, R.color.skin2));
//                tinting_iv1.setColorFilter(null);
//                tinting_iv1.setImageTintList(null);
                break;
            case R.id.tinting_bt3:
                drawableTinting(ContextCompat.getColor(this, R.color.skin3));
                break;
            case R.id.tinting_bt4:
                drawableTinting(ContextCompat.getColor(this, R.color.skin4));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 多种方式实现着色效果
     *
     * @param color <p><设置为空就是清空设置的颜色/>
     */
    private void drawableTinting(int color) {
        //TODO 其实实现的效果都是一样的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api大于21就执行
            //  这是21以上才有的
            tinting_iv1.setImageTintList(ColorStateList.valueOf(color));
//            tinting_iv1.setImageTintMode(PorterDuff.Mode.MULTIPLY);
        } else {// 颜色渲染都可以使用
            tinting_iv1.setColorFilter(color);
        }
    }
}
