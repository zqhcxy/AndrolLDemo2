package com.example.zqh_pc.androlldemo.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zqh_pc.androlldemo.MainActivity;
import com.example.zqh_pc.androlldemo.R;

import java.util.List;

/**
 * Created by zqh-pc on 2015/10/19.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> lists;
    MainActivity.OnItemClickLitener mOnItemClickLitener;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public CardView cardView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.info_text);
            cardView = (CardView) v;
        }
    }

    public void setOnItemOnClickLitener(MainActivity.OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public MyAdapter(List<String> lists) {
        this.lists = lists;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
//        TextView tv = (TextView) v.findViewById(R.id.info_text);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTextView.setText(lists.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickLitener.onItemClick(holder.mTextView, position);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return lists.size();
    }
}
