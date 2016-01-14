package com.example.zqh_pc.androlldemo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by zqh-pc on 2016/1/12.
 */
public class MyTabLatoutAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mViewList;
    private List<String> mTitles;


    public MyTabLatoutAdapter(FragmentManager fm, List<Fragment> viewList, List<String> titles) {
        super(fm);
        mViewList = viewList;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mViewList.get(position);
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
