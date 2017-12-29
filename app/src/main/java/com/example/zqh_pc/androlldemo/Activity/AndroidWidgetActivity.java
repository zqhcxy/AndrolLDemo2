package com.example.zqh_pc.androlldemo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zqh_pc.androlldemo.R;

/**
 * material Design 控件
 */
public class AndroidWidgetActivity extends Activity implements View.OnClickListener {

    private Button widght_coordinator_scroll;
    private Button widght_coordinator_unscroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_widget);

        widght_coordinator_scroll= (Button) findViewById(R.id.widght_coordinator_scroll);
        widght_coordinator_unscroll= (Button) findViewById(R.id.widght_coordinator_unscroll);

        widght_coordinator_scroll.setOnClickListener(this);
        widght_coordinator_unscroll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.widght_coordinator_scroll:
                Intent scrollintent = new Intent(AndroidWidgetActivity.this, CoordinatorLayoutToolbarScroolActivity.class);
                startActivity(scrollintent);
                break;
            case R.id.widght_coordinator_unscroll:
                Intent unScrollintent = new Intent(AndroidWidgetActivity.this, CoordinatorLayoutToolbarUnScrollActivity.class);
                startActivity(unScrollintent);
                break;
        }

    }
}
