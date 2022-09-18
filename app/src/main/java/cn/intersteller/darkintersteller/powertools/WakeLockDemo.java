package cn.intersteller.darkintersteller.powertools;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

import androidx.annotation.Nullable;

import cn.intersteller.darkintersteller.R;

public class WakeLockDemo extends Activity {
    private PowerManager.WakeLock mWakeLock;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wakelockdemo);
        acquire_ACQUIRE_CAUSES_WAKEUP_WakeLock(this);
    }


    public void releaseWakeLock(Context context) {
        if (mWakeLock != null && mWakeLock.isHeld()) {
            mWakeLock.release();
            mWakeLock = null;
        }
    }

    public void acquire_SCREEN_DIM_WAKE_LOCK_WakeLock(Context context) {
        if (mWakeLock == null) {
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            mWakeLock = powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, context.getClass().getSimpleName());
            mWakeLock.acquire();
        }
    }

    public void acquire_ACQUIRE_CAUSES_WAKEUP_WakeLock(Context context) {
        if (mWakeLock == null) {
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            mWakeLock = powerManager.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP, context.getClass().getSimpleName());
            mWakeLock.acquire();
        }
    }

}
