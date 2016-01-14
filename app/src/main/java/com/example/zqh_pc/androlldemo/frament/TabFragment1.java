package com.example.zqh_pc.androlldemo.frament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.zqh_pc.androlldemo.R;

/**
 * Created by zqh-pc on 2016/1/12.
 */
public class TabFragment1 extends Fragment {

    private View view;

    private TextInputLayout mTextInputLayout;// 新的编辑框父布局

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.tablayout_1,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTextInputLayout=(TextInputLayout)view.findViewById(R.id.mytextly);
        EditText editText=mTextInputLayout.getEditText();
        mTextInputLayout.setHint("最多输入6个字");
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 6) {
                    mTextInputLayout.setError("输入错误！！！");
                    mTextInputLayout.setErrorEnabled(true);
                } else {
                    mTextInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
