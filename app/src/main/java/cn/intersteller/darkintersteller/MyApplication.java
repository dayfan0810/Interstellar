package cn.intersteller.darkintersteller;

import android.app.Application;

import com.google.gson.Gson;

import cn.intersteller.darkintersteller.skin.SkinManager;

public class MyApplication extends Application {
    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    private static Gson gson;

    public static Gson gsonInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

//    private OutterFragmentAdapter outterFragmentAdapter;
//    private UshkNewsGrabber mUshkNewsGrabber = new UshkNewsGrabber();
//    private CnbetaNewsGrabber mCnbetaNewsGrabber = new CnbetaNewsGrabber();

    @Override
    public void onCreate() {
        super.onCreate();

        if (instance == null) {
            instance = this;
//            initOKHttpClient();//移动到cnbetafragment里面去
//            EventBus.getDefault().register(this);
        }

        SkinManager.getInstance().setmContext(this);
//        TinyDancer.create()
//                .show(getApplicationContext());
        /*

        //        TinyDancer.create()
//                .show(getApplicationContext());

        //alternatively
//        TinyDancer.create()
//                .redFlagPercentage(.1f) // set red indicator for 10%....different from default
//                .startingXPosition(200)
//                .startingYPosition(600)
//                .show(getApplicationContext());

        //you can add a callback to get frame times and the calculated
        //number of dropped frames within that window
        TinyDancer.create()
                .addFrameDataCallback(new FrameDataCallback() {
                    @Override
                    public void doFrame(long previousFrameNS, long currentFrameNS, int droppedFrames) {
                        //collect your stats here
//                        Log.i("dengfdoframe", "previousFrameNS = "+previousFrameNS);
                    }
                })
                .show(getApplicationContext());

        Takt.stock(this)
                .seat(Seat.BOTTOM_RIGHT)
                .interval(250)
                .color(Color.RED)
                .size(14f)
                .alpha(.5f)
                .listener(new Audience() {
                    @Override
                    public void updatefps(double fps) {
                    }
                });


         */

    }


}
