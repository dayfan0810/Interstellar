package cn.intersteller.darkintersteller.ui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;

import cn.intersteller.darkintersteller.MainActivity;
import cn.intersteller.darkintersteller.login.LoginActivity;
import cn.intersteller.darkintersteller.utils.SharedPreferenceUtils;

public class SpalashActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 利用消息处理器实现延迟跳转到登录窗口
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().post(() -> {
            // 如果登录就直接启动MainActivity
            Long login_user_id = SharedPreferenceUtils.getPrefLong("login_user_id", 0l);
            Log.i("denglogin_user_id", "login_user_id = " + login_user_id);
            if (login_user_id == 0) {
                startActivity(new Intent(SpalashActivity.this, LoginActivity.class));
                overridePendingTransition(0, 0);

            } else {
                startActivity(new Intent(SpalashActivity.this, MainActivity.class));
                overridePendingTransition(0, 0);

            }
            // 关闭启动画面
            finish();

        });

    }
}
