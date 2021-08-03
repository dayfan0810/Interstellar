package cn.intersteller.darkintersteller.skin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.ui.BaseActivity;

public class ToShangeActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myskin_change);
        Button button_change_skin = findViewById(R.id.button_change_skin);
        button_change_skin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_change_skin) {
            changeSkin(getPath());
        }
    }
}
