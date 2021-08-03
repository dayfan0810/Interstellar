package cn.intersteller.darkintersteller.ui;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;

import java.io.File;
import java.lang.reflect.Field;

import cn.intersteller.darkintersteller.skin.SkinFactory2;
import cn.intersteller.darkintersteller.skin.SkinManager;

/**
 * Created by Day on 2016/12/25.
 */

public class BaseActivity extends AppCompatActivity {
    protected static String mCurrentSkin;
    private SkinFactory2 skinFactory2;
    private String[] skins = {"skin1.apk", "skin2.apk"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        skinFactory2 = new SkinFactory2();
//        skinFactory2.setDelegate(getDelegate());
        setLayoutInflaterFactory(getLayoutInflater());
        LayoutInflaterCompat.setFactory2(getLayoutInflater(), skinFactory2);
        super.onCreate(savedInstanceState);
    }

    /*
     *反射私有成员
     */
    public void setLayoutInflaterFactory(LayoutInflater original) {
        LayoutInflater layoutInflater = original;
        try {
            Field mFactorySet = LayoutInflater.class.getDeclaredField("mFactorySet");
            mFactorySet.setAccessible(true);
            mFactorySet.set(layoutInflater, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void changeSkin(String path) {
        File skinFile = new File(Environment.getExternalStorageDirectory(), path);
        SkinManager.getInstance().loadSkinApk(skinFile.getAbsolutePath());
        skinFactory2.changeSkin();
        mCurrentSkin = path;
        Log.d("changeSkindas", "mCurrentSkin = " + mCurrentSkin);

    }

    /**
     * 做一个切换方法
     *
     * @return
     */
    protected String getPath() {
        String path;
        if (null == mCurrentSkin) {
            path = skins[0];
        } else if (skins[0].equals(mCurrentSkin)) {
            path = skins[1];
        } else if (skins[1].equals(mCurrentSkin)) {
            path = skins[0];
        } else {
            return "unknown skin";
        }
        return path;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("changeTag", null == mCurrentSkin ? "currentSkin是空" : mCurrentSkin);

        if (null != mCurrentSkin)
            changeSkin(mCurrentSkin); // 换肤操作必须在setContentView之后
    }
}
