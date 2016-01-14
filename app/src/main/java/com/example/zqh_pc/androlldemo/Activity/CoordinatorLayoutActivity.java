package com.example.zqh_pc.androlldemo.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zqh_pc.androlldemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * CoordinatorLayout与appbarlayout一起实现折叠头部功能
 *
 *
 */
public class CoordinatorLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);

        RecyclerView coor_recyclerView=(RecyclerView)findViewById(R.id.coor_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        coor_recyclerView.setLayoutManager(linearLayoutManager);
        coor_recyclerView.setHasFixedSize(true);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strings.add("有缘千里来相会，无缘对面手难牵。");
        }
        ReayclerViewAdapter reayclerViewAdapter=new ReayclerViewAdapter(strings);
        coor_recyclerView.setAdapter(reayclerViewAdapter);

        CollapsingToolbarLayout mCollapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collap_ly);
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        mCollapsingToolbarLayout.setTitle("飞鸟与<。)#)))≦");
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.skin3));//设置收缩后Toolbar上字体的颜色

    }
    public class ReayclerViewAdapter extends RecyclerView.Adapter<ReayclerViewAdapter.ViewHolder> {

        private List<String> strings;

        public ReayclerViewAdapter(List<String> lists) {
            strings = lists;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView textView = new TextView(CoordinatorLayoutActivity.this);
            parent.addView(textView);
            ViewHolder viewHolder = new ViewHolder(textView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(strings.get(position));
        }

        @Override
        public int getItemCount() {
            return strings.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView=(TextView)itemView;
            }
        }
    }
}
