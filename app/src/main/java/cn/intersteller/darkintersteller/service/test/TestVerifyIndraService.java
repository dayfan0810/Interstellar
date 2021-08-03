package cn.intersteller.darkintersteller.service.test;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import cn.intersteller.darkintersteller.IMyAidlInterface;

public class TestVerifyIndraService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyStub();
    }

    class MyStub extends IMyAidlInterface.Stub {

        @Override
        public void sendStringData(String aString) {
            String callingApp = getApplicationContext().getPackageManager().getNameForUid(Binder.getCallingUid());
            Log.i("dengdawda", "callingApp = " + callingApp);
        }

        @Override
        public void sendIntData(int aInt) {

        }
    }


    //新建一个APP,实现下面即可从那边传数据到interstellar应用
    /*
    public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private IMyAidlInterface iMyAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewById = findViewById(R.id.send);
        viewById.setOnClickListener(this);
        Intent sendstring = new Intent("sendstring");
        sendstring.setPackage("cn.intersteller.darkintersteller");
        bindService(sendstring, new ServiceConnection() {

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

                iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        try {
            iMyAidlInterface.sendStringData("hahahahhahaha");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
     */
}
