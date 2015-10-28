package com.example.zqh_pc.androlldemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.zqh_pc.androlldemo.Activity.DrawableTitingActivity;
import com.example.zqh_pc.androlldemo.Activity.MyToolBarActivity;
import com.example.zqh_pc.androlldemo.Adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //    private RecyclerView mRecyclerView;
    private List<String> lists;
    private Toolbar my_toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initTooblbar();
        initView();

    }

    private void initTooblbar() {
        my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        if (my_toolbar != null) {
            setSupportActionBar(my_toolbar);
        }

        // 标题与颜色
        my_toolbar.setTitle("主界面");
        my_toolbar.setTitleTextColor(Color.WHITE);
        // 次标题与颜色
        //导航按钮
        my_toolbar.setNavigationIcon(R.mipmap.nav_return);
        my_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }


    private void initView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);//设置所有item都一致

        lists = new ArrayList<>();
        lists.add("Button按钮阴影与波纹");
        lists.add("Reveal effect（揭露效果）");
        lists.add("Activity transitions（Activity转换效果）");
        lists.add("Toolbar");
        lists.add("Drawable Tinting(着色)");
        lists.add("第三方库控件");
        MyAdapter myAdapter = new MyAdapter(lists);
        mRecyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemOnClickLitener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = null;
                switch (position) {
                    case 0://按钮特效
                        intent = new Intent(MainActivity.this, ButtonActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, AnimatorActivity.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, TransitionActivity.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, MyToolBarActivity.class);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, DrawableTitingActivity.class);
                        break;
                }

                if (intent != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        startActivity(intent,
                                ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                    } else {
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }

    // 对外界开放的回调接口因为Recy控件没有提供点击事件
    public interface OnItemClickLitener {
        public void onItemClick(View view, int position);

        public void onItemLongClick(View view, int position);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
