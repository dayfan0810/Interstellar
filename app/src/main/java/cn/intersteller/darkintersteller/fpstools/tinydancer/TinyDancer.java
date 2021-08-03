package cn.intersteller.darkintersteller.fpstools.tinydancer;

import android.content.Context;

/**
 * Created by brianplummer on 8/29/15.
 */
public class TinyDancer
{
    public static TinyDancerBuilder create(){
        return new TinyDancerBuilder();
    }

    public static void hide(Context context) {
        TinyDancerBuilder.hide(context.getApplicationContext());
    }

}
