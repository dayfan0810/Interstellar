package cn.intersteller.darkintersteller.login;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.intersteller.darkintersteller.MainActivity;
import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.bean.CloudPanBean;
import cn.intersteller.darkintersteller.database.MySQLiteOpenHelper;
import cn.intersteller.darkintersteller.database.MySQLite_CloudPan_Bean;
import cn.intersteller.darkintersteller.login.presenter.ILoginPresenter;
import cn.intersteller.darkintersteller.login.presenter.LoginPresenterCompl;
import cn.intersteller.darkintersteller.login.view.ILoginView;
import cn.intersteller.darkintersteller.utils.Constant;
import cn.intersteller.darkintersteller.utils.HttpUtil;
import cn.intersteller.darkintersteller.utils.SharedPreferenceUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    List<CloudPanBean.DataBean.SimpleSongBean> mSimpleSongBeans = new ArrayList<>();
    List<CloudPanBean.DataBean.SimpleSongBean.AlBean> alBeans = new ArrayList<>();
    List<CloudPanBean.DataBean.SimpleSongBean.ArBean> arBeans = new ArrayList<>();
    List<MySQLite_CloudPan_Bean> mySQLite_cloudPan_beans = new ArrayList<>();
    private EditText editUser;
    private EditText editPass;
    private Button btnLogin;
    private Button skip_login_login;
    ILoginPresenter loginPresenter;
    private ProgressBar progressBar;
    private MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("dengsb222222onCreate","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myHandler = new MyHandler(this);

        //find view
        editUser = this.findViewById(R.id.et_login_username);
        editPass = this.findViewById(R.id.et_login_password);
        btnLogin = this.findViewById(R.id.btn_login_login);
        progressBar = this.findViewById(R.id.progress_login);
        skip_login_login = this.findViewById(R.id.skip_login_login);

        //set listener
        btnLogin.setOnClickListener(this);
        skip_login_login.setOnClickListener(this);

        //init
        loginPresenter = new LoginPresenterCompl(this);
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);

        StringBuilder userAndPasswordUrl = getUserAndPasswordUrl("mr_day@163.com", "razrjay1234");
        Log.i("dengsb222222", "userAndPasswordUrl = " + userAndPasswordUrl.toString());
        asyncValidate(userAndPasswordUrl.toString());
    }

    private StringBuilder getUserAndPasswordUrl(String name, String passwd) {
        StringBuilder sb = new StringBuilder();
        sb.append(Constant.NETEASEBASE).append("login?email=").append(name).append("&password=").append(passwd);
        return sb;
    }

    private void asyncValidate(final String account) {
        //account:http://42.192.43.247:3000/login?email=mr_day@163.com&password=razrjay1234
        new Thread(() -> {
            HttpUtil.getHttpUtilInstance().sendOkHttpRequest(account, new Callback() {
                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    final String responseText = response.body().string();
                    try {
                        boolean isLoginSuccess = true;
                        JSONObject jsonObject = new JSONObject(responseText);
                        String resultCode = jsonObject.optString("code");
                        Log.i("deng-impl", "resultCode = " + resultCode);
                        if (!resultCode.equals("200")) {
                            isLoginSuccess = false;
                            return;
                        }
                        JSONObject account1 = jsonObject.getJSONObject("account");
                        long id = account1.optLong("id");


                        final Boolean result = true;
                        myHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                requestCloudPanMusic();
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } finally {
                    }
                }

                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    Log.i("deng-impl", "登陆失败");
                }
            });
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_login:
                loginPresenter.setProgressBarVisiblity(View.VISIBLE);
                btnLogin.setEnabled(false);
                loginPresenter.doLogin(editUser.getText().toString(), editPass.getText().toString());

//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                if (imm != null) {
//                    imm.toggleSoftInput(0, 0);
//                }
                break;
            case R.id.skip_login_login:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    @Override
    public void onClearText() {
        editUser.setText("");
        editPass.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code, long userid) {
        loginPresenter.setProgressBarVisiblity(View.GONE);
        btnLogin.setEnabled(true);
        if (code == 200) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
            //保存用户ID到本地,启动splashactivity界面时会使用这个id来判断是否已经登录过
            //这次我采用的方案时, loginactiivty的oncreate方法中直接把我自己的账号先登录
            //不要把自己的id存到sp里面
            SharedPreferenceUtils.removeByKey(this, "login_user_id");
            SharedPreferenceUtils.savePref("login_user_id", userid);
            finish();
        } else
            Toast.makeText(this, "登录失败，code = " + code, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }


    public void requestCloudPanMusic() {
        HttpUtil.getHttpUtilInstance().sendOkHttpRequest(Constant.NETEASE_CLOUD_PAN, new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                Log.i("deng-pan", "Constant.NETEASE_CLOUD_PAN = " + Constant.NETEASE_CLOUD_PAN);
                //http://39.108.131.225:3000/user/cloud?limit=500
                try {
                    JSONObject jsonObject = new JSONObject(responseText);
                    String resultCode = jsonObject.optString("code");
                    if (resultCode.equals("301")) {
                        runOnUiThread(() -> {
                            Toast.makeText(LoginActivity.this, "还没登陆，请先登录", Toast.LENGTH_LONG).show();
                        });
                        return;
                    }

                    JSONArray cloudPandata = jsonObject.getJSONArray("data");

                    long all_songs_count = jsonObject.optLong("count");

                    for (int i = 0; i < cloudPandata.length(); i++) {
                        JSONObject cloudPanItem = (JSONObject) cloudPandata.get(i);
                        CloudPanBean.DataBean.SimpleSongBean simpleSongBean = new CloudPanBean.DataBean.SimpleSongBean();
                        JSONObject simpleSong = cloudPanItem.getJSONObject("simpleSong");
                        String song_name = simpleSong.optString("name");//歌名
                        String song_id = simpleSong.optString("id");//歌曲ID
                        simpleSongBean.setName(song_name);
                        simpleSongBean.setId(song_id);
                        mSimpleSongBeans.add(simpleSongBean);
                        JSONObject al = simpleSong.getJSONObject("al");
                        String album_name = al.optString("name");//专辑名
                        String album_id = al.optString("id");//专辑名
                        CloudPanBean.DataBean.SimpleSongBean.AlBean alBean = new CloudPanBean.DataBean.SimpleSongBean.AlBean();
                        alBean.setName(album_name);
                        alBean.setId(album_id);
                        alBeans.add(alBean);

                        JSONArray ar = simpleSong.getJSONArray("ar");


                        StringBuilder sb = new StringBuilder();

                        //TODO 云盘的数据里面有很多的歌手和专辑名都是null,没法解决
                        for (int j = 0; j < ar.length(); j++) {
                            JSONObject ar_name = (JSONObject) ar.get(j);
                            String singer_name = ar_name.optString("name");

                            if (sb.length() > 0) {//该步即不会第一位有逗号，也防止最后一位拼接逗号！
                                sb.append("/");//一首歌可能有多个人唱,要拼接
                            }
                            sb.append(singer_name);
                        }
                        CloudPanBean.DataBean.SimpleSongBean.ArBean arBean = new CloudPanBean.DataBean.SimpleSongBean.ArBean();
                        arBean.setName(sb.toString());
                        arBeans.add(arBean);
                        MySQLite_CloudPan_Bean mySQLite_cloudPan_bean = new MySQLite_CloudPan_Bean(song_name, song_id, album_name, album_id, sb.toString());
                        mySQLite_cloudPan_beans.add(mySQLite_cloudPan_bean);
                        //再构建一个专门给云盘数据库查询的bean

                    }
                    new Thread(() -> {
                        try {
                            Message message1 = new Message();
                            message1.obj = mySQLite_cloudPan_beans;
                            message1.what = 0;
                            Log.i("dengmySQLite_cloudPan_beans", "mySQLite_cloudPan_beans.size = " + mySQLite_cloudPan_beans.size());
                            myHandler.sendMessageDelayed(message1, 3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }).start();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {

            }
        });


    }

    private static class MyHandler extends Handler {
        private MySQLiteOpenHelper mySQLiteOpenHelper;
        private Context mContext;

        public MyHandler(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            List<MySQLite_CloudPan_Bean> mySQLite_CloudPan_Bean = (List<MySQLite_CloudPan_Bean>) msg.obj;
            Log.i("dengdb", "m111CloudPanBeans = " + mySQLite_CloudPan_Bean.size());
            //创建云盘的数据库
            mySQLiteOpenHelper = new MySQLiteOpenHelper(mContext);
            SQLiteDatabase writableDatabase = mySQLiteOpenHelper.getWritableDatabase();
            writableDatabase.beginTransaction();//开启数据库事务可以提升一倍的时间
            long start = System.currentTimeMillis();
            new Thread(() -> {
                for (int i = 0; i < mySQLite_CloudPan_Bean.size(); i++) {
//                String sql = "INSERT or IGNORE INTO " + Constant.CLOUDPAN_DATABASE_TABLE_NAME
//                        + " (song_id,song_name,album_name,singer_name)"
//                        + "VALUES ('"
//                        + mySQLite_CloudPan_Bean.get(i).getSong_id()
//                        + "', '"
//                        + mySQLite_CloudPan_Bean.get(i).getSong_name()
//                        + "', '"
//                        + mySQLite_CloudPan_Bean.get(i).getAlbum_name()
//                        + "', '"
//                        + mySQLite_CloudPan_Bean.get(i).getSinger_name()
//                        + "')";
//                writableDatabase.execSQL(sql);

                    /*
                     *TODO 上面那段建表的有时候有问题,就是比如英文歌中有'这种单引号时,会报错
                     * 复现:云盘放一首有  's  字样的歌曲,就会报错
                     * 解决办法: 用下面的方式,不仅可以解决这个问题还可以防止sql注入
                     */
                    //sql:create table table_name( song_id intger,song_name carchar(20),album_name carchar(20),singer_name carchar(20))
                    String sql = "INSERT or IGNORE INTO " + Constant.CLOUDPAN_DATABASE_TABLE_NAME +
                            "(song_id,song_name,album_name,singer_name) values(?,?,?,?  )";
                    writableDatabase.execSQL(sql, new Object[]{mySQLite_CloudPan_Bean.get(i).getSong_id(),
                            mySQLite_CloudPan_Bean.get(i).getSong_name(),
                            mySQLite_CloudPan_Bean.get(i).getAlbum_name(),
                            mySQLite_CloudPan_Bean.get(i).getSinger_name()
                    });

                    //TODO 数据库没有同步
                }
            }).start();
            writableDatabase.endTransaction();
            long end = System.currentTimeMillis();
            Toast.makeText(mContext, "已初始化核心歌曲库: " + mySQLite_CloudPan_Bean.size() + "首歌,写入耗时" + (end - start) + "ms", Toast.LENGTH_SHORT).show();

        }

    }

}
