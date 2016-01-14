package com.example.zqh_pc.androlldemo.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.zqh_pc.androlldemo.R;

public class MyToolBarActivity extends AppCompatActivity {
    private Toolbar my_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api大于21就执行
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Fade());
            getWindow().setExitTransition(new Fade());
        }
        setTheme(R.style.NewTheme1);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_tool_bar_activity);
        my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        if (my_toolbar != null) {
            setSupportActionBar(my_toolbar);
        }
        initTitleBar();


    }

    private void initTitleBar() {
        my_toolbar.setBackgroundColor(ContextCompat.getColor(this,R.color.skin3));
        // 标题与颜色
        my_toolbar.setTitle("自定义Toolabr的实现");
        my_toolbar.setTitleTextColor(Color.WHITE);
        // 次标题与颜色
        my_toolbar.setSubtitle("次标题");
        my_toolbar.setSubtitleTextColor(Color.WHITE);
        //导航按钮
        my_toolbar.setNavigationIcon(R.mipmap.nav_return);
        my_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //logo图标(没有点击事件)
        my_toolbar.setLogo(R.mipmap.ic_head);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        String result = "";
        int id = item.getItemId();
        switch (id) {
            case R.id.ac_toolbar_copy:
                result = "复制";
                break;
            case R.id.ac_toolbar_cut:
                result = "剪切";
                break;
            case R.id.ac_toolbar_del:
                result = "删除";
                break;
            case R.id.ac_toolbar_edit:
                result = "编辑";
                break;
            case R.id.ac_toolbar_email:
                result = "邮件";
                break;
        }
        Toast.makeText(MyToolBarActivity.this, result, Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

}
