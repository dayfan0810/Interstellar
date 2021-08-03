package cn.intersteller.darkintersteller.powertools;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.king.view.circleprogressview.CircleProgressView;

import cn.intersteller.darkintersteller.R;

public class PowerToolActivity extends AppCompatActivity {
    private CircleProgressView cpv;
    private int[] mShaderColors = new int[]{0xFF4FEAAC,0xFFA8DD51,0xFFE8D30F,0xFFA8DD51,0xFF4FEAAC};


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powertool);
        cpv = findViewById(R.id.cpv);
        cpv.setShowTick(true);
        cpv.setTurn(true);
        cpv.setProgressColor(0xFF4FEAAC);
        cpv.showAnimation(100,3000);
    }

}
