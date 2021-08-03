package cn.intersteller.darkintersteller.innerfragment.firstinnerfragment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.adapter.CloudPanRecyclerViewAdapter;
import cn.intersteller.darkintersteller.bean.CloudPanBean;
import cn.intersteller.darkintersteller.database.MySQLiteOpenHelper;
import cn.intersteller.darkintersteller.database.MySQLite_CloudPan_Bean;
import cn.intersteller.darkintersteller.outterfragment.BaseLazyFragment;
import cn.intersteller.darkintersteller.utils.Constant;
import cn.intersteller.darkintersteller.utils.HttpUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CloudPanFragment extends BaseLazyFragment implements SwipeRefreshLayout.OnRefreshListener {
    //    private View mCloudpanfragment_layout;
    private RecyclerView mCloudpan_fragment_recyclerview;
    private SwipeRefreshLayout mCloudpan_fragment_swiperefresh;
    List<CloudPanBean.DataBean.SimpleSongBean> mSimpleSongBeans = new ArrayList<>();
    List<CloudPanBean.DataBean.SimpleSongBean.AlBean> alBeans = new ArrayList<>();
    List<CloudPanBean.DataBean.SimpleSongBean.ArBean> arBeans = new ArrayList<>();
    List<MySQLite_CloudPan_Bean> mySQLite_cloudPan_beans = new ArrayList<>();

    private MyHandler myHandler;
    private ProgressBar mPb;

    @Override
    public void loadDataStart() {
        new Handler().post(() -> {
            // 一旦获取到数据, 就应该立刻标记数据加载完成
            mLoadDataFinished = true;
            if (mViewInflateFinished) {
                onRefresh();
                mPb.setVisibility(View.GONE);
            }

        });
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        return mCloudpanfragment_layout;
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myHandler = new MyHandler(getContext());
    }

    @Override
    protected void findViewById(View view) {
        mCloudpan_fragment_recyclerview = view.findViewById(R.id.cloudpan_fragment_recyclerview);
        mCloudpan_fragment_swiperefresh = view.findViewById(R.id.cloudpan_fragment_swiperefresh);
        mPb = view.findViewById(R.id.pb);

        mCloudpan_fragment_swiperefresh.setColorSchemeResources(
                R.color.blue
                , R.color.oriange
                , R.color.black
                , R.color.red);
        mCloudpan_fragment_swiperefresh.setOnRefreshListener(this);

//        onRefresh();
    }

    @Override
    protected View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return mCloudpanfragment_layout = inflater.inflate(R.layout.cloudpanfragment, container, false);
        return inflater.inflate(R.layout.cloudpanfragment, container, false);
    }

    @Override
    public void onRefresh() {
        mSimpleSongBeans.clear();
        arBeans.clear();
        alBeans.clear();
        mySQLite_cloudPan_beans.clear();
        requestCloudPanMusic();

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
                        getActivity().runOnUiThread(() -> {
                            Toast.makeText(getActivity(), "还没登陆，请先登录", Toast.LENGTH_LONG).show();
                            mCloudpan_fragment_swiperefresh.setRefreshing(false);
                        });
//                        Intent intent = new Intent(getContext(), LoginActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        startActivity(intent);
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
                            myHandler.sendMessageDelayed(message1, 5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }).start();

                    if (getActivity() == null) {
                        return;
                    }
                    getActivity().runOnUiThread(new Runnable() {

                        private CloudPanRecyclerViewAdapter cloudPanRecyclerViewAdapter;

                        @Override
                        public void run() {

                            LinearLayoutManager manager = new LinearLayoutManager(getContext());
                            mCloudpan_fragment_recyclerview.setLayoutManager(manager);
                            cloudPanRecyclerViewAdapter = new CloudPanRecyclerViewAdapter(getContext(), mSimpleSongBeans, alBeans, arBeans, mCloudpan_fragment_recyclerview, manager);
                            cloudPanRecyclerViewAdapter.setmOnItemClickListener(new CloudPanRecyclerViewAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Log.i("deng", "onItemClick ");
                                    if (mSimpleSongBeans.size() <= 0) {
                                        Log.i("deng", "onItemClick no data, return");
                                        return;
                                    }

                                    CloudPanBean.DataBean.SimpleSongBean item = cloudPanRecyclerViewAdapter.getItem(position);
                                    Bundle mBundle = new Bundle();
                                    mBundle.putSerializable("mvitem", item);
                                    mSendMessageToMainAcvtyCallBack.messageFromFragment(mBundle);
                                }

                                @Override
                                public void onItemLongClick(View view, int position) {

                                }
                            });
                            mCloudpan_fragment_recyclerview.setAdapter(cloudPanRecyclerViewAdapter);
                            mCloudpan_fragment_swiperefresh.setRefreshing(false);
                        }
                    });
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
            Toast.makeText(mContext, "云盘数据库" + mySQLite_CloudPan_Bean.size() + "首歌,写入耗时" + (end - start) + "ms", Toast.LENGTH_SHORT).show();

        }

    }

}
