package com.example.zqh_pc.androlldemo.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.zqh_pc.androlldemo.Adapter.MyTabLatoutAdapter;
import com.example.zqh_pc.androlldemo.R;
import com.example.zqh_pc.androlldemo.frament.TabFragment1;
import com.example.zqh_pc.androlldemo.frament.TabFragment2;

import java.util.ArrayList;
import java.util.List;

;

/**
 * 一些其他控件的界面
 */

public class CoordinatorLayoutToolbarScroolActivity extends FragmentActivity implements View.OnClickListener {
    //    private TextInputLayout mTextInputLayout;// 新的编辑框父布局
    private FloatingActionButton mFloatingActionButton;//浮动按钮
    private TabLayout mTabLayout;
    private ViewPager mviewpager;
    public Toolbar mToolbar;
//    public CoordinatorLayout.Behavior behavior;

    CoordinatorLayout mycoordinatorly;
    AppBarLayout appBarLayout;
    AppBarLayout.Behavior behavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.NewTheme1);
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//api大于21就执行
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                    | WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        setContentView(R.layout.activity_coordinator_scroll);
        initView();
    }

    private void initView() {

        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        if (mToolbar != null) {
//            setSupportActionBar(mToolbar);
//        }
        initTitleBar();


        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab1);
        mFloatingActionButton.setOnClickListener(this);

        mTabLayout = (TabLayout) findViewById(R.id.mtablay);
        List<String> tabList = new ArrayList<>();
        tabList.add("第一页");
        tabList.add("第二页");
        tabList.add("第三页");
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        List<Fragment> viewList = new ArrayList<>();
        TabFragment2 tabFragment2=new TabFragment2();

        viewList.add(new TabFragment1());
        viewList.add(new TabFragment1());
        viewList.add(tabFragment2);
        mviewpager = (ViewPager) findViewById(R.id.mviewpager);
        MyTabLatoutAdapter myTabLatoutAdapter = new MyTabLatoutAdapter(getSupportFragmentManager(), viewList, tabList);
        mviewpager.setAdapter(myTabLatoutAdapter);//viewpager设置适配器
        mTabLayout.setupWithViewPager(mviewpager);//tablay绑定Viewpager
        mTabLayout.setTabsFromPagerAdapter(myTabLatoutAdapter);//给tablay绑定适配器

        //重置toolbar位置
         mycoordinatorly = (CoordinatorLayout) findViewById(R.id.mycoordinatorly);
         appBarLayout = (AppBarLayout) findViewById(R.id.myappbar);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
         behavior = (AppBarLayout.Behavior) params.getBehavior();
//        recyclerView=tabFragment2.getView();
    }

    public CoordinatorLayout getMycoordinatorly(){
        return mycoordinatorly;
    }

    public AppBarLayout getAppBarLayout(){
        return appBarLayout;
    }

    public  AppBarLayout.Behavior getBehavior(){
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        behavior = (AppBarLayout.Behavior) params.getBehavior();
        return  behavior;
    }

    private void initTitleBar() {
        // 标题与颜色
        mToolbar.setTitle("自定义Toolabr的实现");
        mToolbar.setTitleTextColor(Color.WHITE);
        // 次标题与颜色
        mToolbar.setSubtitle("次标题");
        mToolbar.setSubtitleTextColor(Color.WHITE);
        //导航按钮
        mToolbar.setNavigationIcon(R.mipmap.nav_return);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        mToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.skin3));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setElevation(0f);
        }
        //logo图标(没有点击事件)
        mToolbar.setLogo(R.mipmap.ic_launcher);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab1:
                Intent intent = new Intent(CoordinatorLayoutToolbarScroolActivity.this, CoordinatorLayoutToolbarUnScrollActivity.class);
                startActivity(intent);
                break;
        }
    }
}
