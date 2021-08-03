package cn.intersteller.darkintersteller.skin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.ui.BaseActivity;

public class MySkinChangeActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myskin_change_main);
        Button start_2act = findViewById(R.id.start_2act);
        start_2act.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start_2act) {
            Intent intent = new Intent(MySkinChangeActivity.this, ToShangeActivity.class);
            startActivity(intent);
        }
    }


}
