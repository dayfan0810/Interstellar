package cn.intersteller.darkintersteller.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ImageLoaderUtils {

    public static void display(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            Toast.makeText(context, "ImageLoaderUtils image == nulll", Toast.LENGTH_SHORT).show();
            return;
        }

//        if (isDestroy((Activity) context)) {
////            Toast.makeText(context, "ImageLoaderUtils isDestroy", Toast.LENGTH_SHORT).show();
//            return;
//        }

//        Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher).crossFade().into(imageView);
        Glide.with(context)
                .load(url)
//                .placeholder(R.drawable.default_cover)
//                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }


    //判断Activity是否Destroy
    public static boolean isDestroy(Activity activity) {
        if (activity == null) {
            Toast.makeText(activity, "ImageLoaderUtils activity == null", Toast.LENGTH_SHORT).show();

            return true;
        } else if (activity.isDestroyed()) {
            Toast.makeText(activity, "ImageLoaderUtils activity == isDestroyed", Toast.LENGTH_SHORT).show();

            return true;
        } else if (activity.isFinishing()) {
            Toast.makeText(activity, "ImageLoaderUtils isFinishing", Toast.LENGTH_SHORT).show();

            return true;
        } else {
            return false;
        }
    }

}
