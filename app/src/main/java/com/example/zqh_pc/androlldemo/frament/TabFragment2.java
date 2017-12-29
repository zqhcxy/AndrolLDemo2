package com.example.zqh_pc.androlldemo.frament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zqh_pc.androlldemo.Activity.CoordinatorLayoutToolbarScroolActivity;
import com.example.zqh_pc.androlldemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zqh-pc on 2016/1/13.
 */
public class TabFragment2 extends Fragment {

    private static final String TAG = "zqh";
    private View view;
    private RecyclerView my_recyclerly;

    CoordinatorLayout mycoordinatorly;
    AppBarLayout appBarLayout;
    int[] consumed = new int[2];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tablayout_2, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        my_recyclerly = (RecyclerView) view.findViewById(R.id.my_recyclerly);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        my_recyclerly.setLayoutManager(linearLayoutManager);
        my_recyclerly.setHasFixedSize(true);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("世界上最遥远的距离，是我站在你面前你却不知道我爱你。");
        }
        ReayclerViewAdapter reayclerViewAdapter = new ReayclerViewAdapter(strings);
        my_recyclerly.setAdapter(reayclerViewAdapter);
//        mycoordinatorly = ((WidgetActivity) getActivity()).getMycoordinatorly();
        appBarLayout = ((CoordinatorLayoutToolbarScroolActivity) getActivity()).getAppBarLayout();
        my_recyclerly.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        appBarLayout.getLocationOnScreen(consumed);
                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        int[] consumed2 = new int[2];
//                        appBarLayout.getLocationOnScreen(consumed2);
//                        if (consumed[1] > consumed2[1]) {//上
//                            ((WidgetActivity) getActivity()).mToolbar.setVisibility(View.INVISIBLE);
//                        } else if (consumed[1] < consumed2[1]) {// 下
//                            ((WidgetActivity) getActivity()).mToolbar.setVisibility(View.VISIBLE);
//                        }
//                        break;
                    case MotionEvent.ACTION_UP:
                        int[] consumed1 = new int[2];
                        int f_y;
                        int c_y;
                        appBarLayout.getLocationOnScreen(consumed1);
                        f_y=Math.abs(consumed[1]);
                        c_y=Math.abs(consumed1[1]);
                        if (f_y > c_y) {//上
                            appBarLayout.setExpanded(true);
                            ((CoordinatorLayoutToolbarScroolActivity) getActivity()).mToolbar.setVisibility(View.VISIBLE);
                        } else if (f_y < c_y) {// 下
                            appBarLayout.setExpanded(false);
                            ((CoordinatorLayoutToolbarScroolActivity) getActivity()).mToolbar.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

                return false;
            }
        });

    }


    public class ReayclerViewAdapter extends RecyclerView.Adapter<ReayclerViewAdapter.ViewHolder> {

        private List<String> strings;

        public ReayclerViewAdapter(List<String> lists) {
            strings = lists;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item_layout, parent, false);
            parent.addView(view);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
//            holder.textView.setText(strings.get(position));
        }

        @Override
        public int getItemCount() {
            return strings.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.item_tv1);
            }
        }
    }


    public RecyclerView getrcview() {
        return my_recyclerly;
    }
}
