package cn.intersteller.darkintersteller.skin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.io.File;
import java.lang.reflect.Method;

public class SkinManager {
    public static SkinManager mSkinManager;
    private Context mContext;
    private Resources mOutResource;
    private String mOutPkgName;

    public static SkinManager getInstance() {
        if (mSkinManager == null) {
            synchronized (SkinManager.class) {
                if (mSkinManager == null) {
                    mSkinManager = new SkinManager();
                }
            }
        }
        return mSkinManager;
    }


    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public void loadSkinApk(final String path) {//path 是外部传入的apk文件名
        File file = new File(path);
        if (!file.exists()) {
            Toast.makeText(mContext, "检查资源apk!!", Toast.LENGTH_LONG).show();
            return;
        }
        Log.i("dengpasth", "存在 ");
        //取得PackageManager引用
        PackageManager mPm = mContext.getPackageManager();
        //“检索在包归档文件中定义的应用程序包的总体信息”，说人话，外界传入了一个apk的文件路径，这个方法，拿到这个apk的包信息,这个包信息包含什么？
        PackageInfo mInfo = mPm.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES);
        mOutPkgName = mInfo.packageName;//先把包名存起来
        AssetManager assetManager;//资源管理器
        try {
            assetManager = AssetManager.class.newInstance();
            Method addAssetPath =
                    assetManager.getClass().getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, path);
            mOutResource = new Resources(assetManager,
                    mContext.getResources().getDisplayMetrics(),
                    mContext.getResources().getConfiguration());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提供外部资源包里面的颜色
     *
     * @param resId
     * @return
     */
    public int getColor(int resId) {
        if (mOutResource == null) {
            return resId;
        }

        String resourceTypeName = mContext.getResources().getResourceTypeName(resId);
        String resourceEntryName = mContext.getResources().getResourceEntryName(resId);
        int outResId = mOutResource.getIdentifier(resourceEntryName, resourceTypeName, mOutPkgName);
        if (outResId == 0) {
            return resId;
        }
        return mOutResource.getColor(outResId);
    }

    /**
     * 提供外部资源包里的图片资源
     *
     * @param
     * @return
     */
//    public int getDrawable(int resId) {//获取图片
//        Log.i("dengresName", "foriget =" + resId);
//        if (mOutResource == null) {
//            return resId;
//        }
//        String resourceTypeName = mContext.getResources().getResourceTypeName(resId);
//        String resourceEntryName = mContext.getResources().getResourceEntryName(resId);
//        int outResId = mOutResource.getIdentifier(resourceEntryName, resourceTypeName, mOutPkgName);
//        if (outResId == 0) {
//            return resId;
//        }
//        return outResId;
//    }

    public Drawable getDrawable(int resId) {//获取图片
        Log.i("dengresName", "foriget =" + resId);
        if (mOutResource == null) {
            return ContextCompat.getDrawable(mContext, resId);
        }
        String resourceTypeName = mContext.getResources().getResourceTypeName(resId);
        String resourceEntryName = mContext.getResources().getResourceEntryName(resId);
        int outResId = mOutResource.getIdentifier(resourceEntryName, resourceTypeName, mOutPkgName);
        if (outResId == 0) {
            return ContextCompat.getDrawable(mContext, resId);
        }
        return mOutResource.getDrawable(outResId);
    }

    //..... 这里还可以提供外部资源包里的String，font等等等，只不过要手动写代码来实现getXX方法
}
