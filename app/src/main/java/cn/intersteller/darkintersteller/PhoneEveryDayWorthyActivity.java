package cn.intersteller.darkintersteller;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PhoneEveryDayWorthyActivity extends Activity {
    Handler myHandler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(@NonNull Message message) {
            float daysGap = message.getData().getFloat("daysGap");
            float aLong = (4500+1500-700+4200) / daysGap;
            tv_daysGap1.setText(aLong + "元");
            tv_daysGap2.setText("距离8元每天还要: " + (int)((4500+1500-700+4200)/ 8- daysGap) + "天");
            tv_daysGap3.setText("距离7元每天还要: " + (int)((4500+1500-700+4200)/ 7- daysGap) + "天");
            tv_daysGap4.setText("距离6元每天还要: " + (int)((4500+1500-700+4200) / 6 - daysGap) + "天");
            tv_daysGap5.setText("距离5元每天还要: " + (int)((4500+1500-700+4200) / 5 - daysGap) + "天");
            ObjectAnimator colorAnim1 = ObjectAnimator.ofInt(tv_daysGap1, "textColor",
                    0xFF228080, 0xFF8080FF);
            colorAnim1.setDuration(3000);
            colorAnim1.setEvaluator(new ArgbEvaluator());
            colorAnim1.setRepeatCount(ValueAnimator.INFINITE);
            colorAnim1.setRepeatMode(ValueAnimator.REVERSE);
            colorAnim1.start();
            ObjectAnimator colorAnim2 = ObjectAnimator.ofInt(tv_daysGap2, "textColor",
                    0xFF008080, 0xFF8080FF);
            colorAnim2.setDuration(3000);
            colorAnim2.setEvaluator(new ArgbEvaluator());
            colorAnim2.setRepeatCount(ValueAnimator.INFINITE);
            colorAnim2.setRepeatMode(ValueAnimator.REVERSE);
            colorAnim2.start();

            ObjectAnimator colorAnim3 = ObjectAnimator.ofInt(tv_daysGap3, "textColor",
                    0xFF008080, 0xFF8080FF);
            colorAnim3.setDuration(3000);
            colorAnim3.setEvaluator(new ArgbEvaluator());
            colorAnim3.setRepeatCount(ValueAnimator.INFINITE);
            colorAnim3.setRepeatMode(ValueAnimator.REVERSE);
            colorAnim3.start();

            ObjectAnimator colorAnim4 = ObjectAnimator.ofInt(tv_daysGap4, "textColor",
                    0xFF008080, 0xFF8080FF);
            colorAnim4.setDuration(3000);
            colorAnim4.setEvaluator(new ArgbEvaluator());
            colorAnim4.setRepeatCount(ValueAnimator.INFINITE);
            colorAnim4.setRepeatMode(ValueAnimator.REVERSE);
            colorAnim4.start();
            ObjectAnimator colorAnim5 = ObjectAnimator.ofInt(tv_daysGap5, "textColor",
                    0xFF008080, 0xFF8080FF);
            colorAnim5.setDuration(3000);
            colorAnim5.setEvaluator(new ArgbEvaluator());
            colorAnim5.setRepeatCount(ValueAnimator.INFINITE);
            colorAnim5.setRepeatMode(ValueAnimator.REVERSE);
            colorAnim5.start();


            return false;
        }
    });
    private TextView tv_daysGap1;
    private TextView tv_daysGap2;
    private TextView tv_daysGap3;
    private TextView tv_daysGap4;
    private TextView tv_daysGap5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phoneeverydayworthy);
        tv_daysGap1 = findViewById(R.id.tv_phoneeverydayworthyactivity_1);
        tv_daysGap2 = findViewById(R.id.tv_phoneeverydayworthyactivity_2);
        tv_daysGap3 = findViewById(R.id.tv_phoneeverydayworthyactivity_3);
        tv_daysGap4 = findViewById(R.id.tv_phoneeverydayworthyactivity_4);
        tv_daysGap5 = findViewById(R.id.tv_phoneeverydayworthyactivity_5);
        new Thread(() -> {
            float daysGap = getDaysGap();
            Bundle bundle = new Bundle();
            bundle.putFloat("daysGap", daysGap);
            Message msg = Message.obtain();
            msg.setData(bundle);
            myHandler.sendMessage(msg);
        }).start();
    }


    private float getDaysGap() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //给定的时间
        Date d = null;
        try {
            d = format.parse("2018-05-30 00:10:05");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //当前时e799bee5baa6e4b893e5b19e31333332613132间处理
        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        //给定时间处理
        Calendar setCal = Calendar.getInstance();
        setCal.setTime(d);
        setCal.set(Calendar.HOUR_OF_DAY, 0);
        setCal.set(Calendar.MINUTE, 0);
        setCal.set(Calendar.SECOND, 0);
        setCal.set(Calendar.MILLISECOND, 0);
        float dayDiff = (now.getTimeInMillis() - setCal.getTimeInMillis()) / (1000 * 60 * 60 * 24);
        return dayDiff;
    }
}
