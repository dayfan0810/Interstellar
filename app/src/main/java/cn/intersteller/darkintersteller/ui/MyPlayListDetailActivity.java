package cn.intersteller.darkintersteller.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.adapter.MyPlayListDetailActivityRecyclerViewAdapter;
import cn.intersteller.darkintersteller.bean.MyPlayListDetailBean;
import cn.intersteller.darkintersteller.bean.SongOfTrackidsBean;
import cn.intersteller.darkintersteller.utils.Constant;
import cn.intersteller.darkintersteller.utils.HttpUtil;
import cn.intersteller.darkintersteller.utils.ImageLoaderUtils;
import cn.intersteller.darkintersteller.utils.SharedPreferenceUtils;
import cn.intersteller.darkintersteller.utils.StatusBarUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static cn.intersteller.darkintersteller.utils.StatusBarUtils.getStatusBarHeight;

public class MyPlayListDetailActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "MyPlayListDetailActivity";
    private ImageView mHeaderBg;
    //    private RelativeLayout fl_head_content;
    public RecyclerView my_playlist_details_recyclerview;
    public SwipeRefreshLayout my_playlist_details_swiperefresh;
    private String id;
    //这个mTrackIdsBeans用来保存歌单中的歌曲的id,用来再次请求
    ArrayList<MyPlayListDetailBean.PlaylistBean.TrackIdsBean> mTrackIdsBeans = new ArrayList<>();
    //还要把my_playlist_details_recyclerview传进来,不然里面的使用不到
    private MyHandler myHandler;
    List<SongOfTrackidsBean.SongsBean> mSongsBeans = new ArrayList<>();
    List<SongOfTrackidsBean.SongsBean.ArBean> mArBeans = new ArrayList<>();
    List<SongOfTrackidsBean.SongsBean.AlBean> mAlBeans = new ArrayList<>();
    public String playlist_name;
    private static ProgressBar details_pb;

    private static class MyHandler extends Handler {
        RecyclerView my_playlist_details_recyclerview;
        List<SongOfTrackidsBean.SongsBean> mSongsBeans;
        List<SongOfTrackidsBean.SongsBean.ArBean> mArBeans;
        List<SongOfTrackidsBean.SongsBean.AlBean> mAlBeans;
        MyPlayListDetailActivity myPlayListDetailActivity;
        SwipeRefreshLayout my_playlist_details_swiperefresh;

        MyHandler(MyPlayListDetailActivity mAct,
                  RecyclerView my_playlist_details_recyclerview,
                  SwipeRefreshLayout my_playlist_details_swiperefresh,
                  List<SongOfTrackidsBean.SongsBean> mSongsBeans,
                  List<SongOfTrackidsBean.SongsBean.ArBean> mArBeans,
                  List<SongOfTrackidsBean.SongsBean.AlBean> mAlBeans) {
            this.myPlayListDetailActivity = mAct;
            this.my_playlist_details_swiperefresh = my_playlist_details_swiperefresh;
            this.my_playlist_details_recyclerview = my_playlist_details_recyclerview;
            this.mSongsBeans = mSongsBeans;
            this.mArBeans = mArBeans;
            this.mAlBeans = mAlBeans;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            if (myPlayListDetailActivity != null) {
                ArrayList<MyPlayListDetailBean.PlaylistBean.TrackIdsBean> mTrackIdsBeans =
                        (ArrayList<MyPlayListDetailBean.PlaylistBean.TrackIdsBean>) msg.obj;
//                ArrayList<MyPlayListDetailBean.PlaylistBean.TrackIdsBean> mTrackIdsBeans =
//                        (ArrayList<MyPlayListDetailBean.PlaylistBean.TrackIdsBean>) Message.obtain().obj;

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mTrackIdsBeans.size(); i++) {
                    long id = mTrackIdsBeans.get(i).getId();
                    if (sb.length() > 0) {//该步即不会第一位有逗号，也防止最后一位拼接逗号！
                        sb.append(",");
                    }
                    sb.append(id);
                }

                new Handler().post(() -> {
                    HttpUtil.getHttpUtilInstance().
                            sendOkHttpRequest(Constant.NETEASE_MYPLAYLIST_DETAIL_SONG_DETAIL + sb, new okhttp3.Callback() {
                                @Override
                                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                                Log.i("dengar1111", "111 = " + Constant.NETEASE_MYPLAYLIST_DETAIL_SONG_DETAIL + sb);

                                    final String responseText = response.body().string();
                                    Log.i("dengar11211", "responseText = " + responseText);

                                    JSONObject jsonObject;
                                    try {
                                        jsonObject = new JSONObject(responseText);
                                        String resultCode = jsonObject.optString("code");
                                        if (resultCode.equals("301")) {
                                            Looper.prepare();
                                            Toast.makeText(myPlayListDetailActivity, "搜索失败", Toast.LENGTH_SHORT).show();
                                            Looper.loop();
                                            return;
                                        }
                                        JSONArray songs = jsonObject.getJSONArray("songs");
                                        for (int i = 0; i < songs.length(); i++) {
                                            //这个放在内部new,放在外面会被冲掉
                                            SongOfTrackidsBean.SongsBean songsBean = new SongOfTrackidsBean.SongsBean();
                                            //AR
                                            SongOfTrackidsBean.SongsBean.ArBean arBean = new SongOfTrackidsBean.SongsBean.ArBean();
                                            //AL
                                            SongOfTrackidsBean.SongsBean.AlBean alBean = new SongOfTrackidsBean.SongsBean.AlBean();

                                            JSONObject songItem = (JSONObject) songs.get(i);
                                            String song_name = songItem.optString("name");//歌曲名
                                            long song_id = songItem.optLong("id");//歌曲ID,此时json还没有提供歌曲url,需要再次解析id
                                            JSONObject arg_0 = songItem.getJSONArray("ar").getJSONObject(0);
                                            String picUrl = songItem.getJSONObject("al").optString("picUrl");
                                            String singger_name = arg_0.optString("name");//歌曲携带的歌手名
                                            long singer_id = arg_0.optLong("id");//歌曲携带的歌手的id

                                            Log.i("denaddg", "song_name = " + song_name);
                                            //显示用
                                            songsBean.setName(song_name);
                                            arBean.setName(singger_name);
                                            alBean.setPicUrl(picUrl);
                                            //item点击用
                                            songsBean.setId(song_id);
                                            arBean.setId(singer_id);
                                            mAlBeans.add(alBean);
                                            mArBeans.add(arBean);
                                            mSongsBeans.add(songsBean);

                                        }
                                        myPlayListDetailActivity.runOnUiThread(() -> {

                                            MyPlayListDetailActivityRecyclerViewAdapter myPlayListDetailActivityRecyclerViewAdapter;
                                            LinearLayoutManager manager = new LinearLayoutManager(myPlayListDetailActivity);
                                            my_playlist_details_recyclerview.setLayoutManager(manager);
                                            myPlayListDetailActivityRecyclerViewAdapter =
                                                    new MyPlayListDetailActivityRecyclerViewAdapter(myPlayListDetailActivity,
                                                            mSongsBeans,
                                                            mArBeans,
                                                            mAlBeans,
                                                            my_playlist_details_recyclerview,
                                                            manager);
                                            Log.i("denaddg", "mSongsBeans size = " + mSongsBeans.size());
                                            myPlayListDetailActivityRecyclerViewAdapter.setmOnItemClickListener(new MyPlayListDetailActivityRecyclerViewAdapter.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(View view, int position) {

                                                }

                                                @Override
                                                public void onItemLongClick(View view, int position) {

                                                }
                                            });
                                            my_playlist_details_recyclerview.setAdapter(myPlayListDetailActivityRecyclerViewAdapter);
                                            my_playlist_details_swiperefresh.setRefreshing(false);
                                            details_pb.setVisibility(View.GONE);

                                        });

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                }

                                @Override
                                public void onFailure(@NotNull Call call, @NotNull IOException e) {

                                }
                            });
                });

            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        setContentView(R.layout.activity_playlist_details);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        Toolbar toolbar = findViewById(R.id.my_playlist_details_toolbar);
        details_pb = findViewById(R.id.details_pb);
        mHeaderBg = findViewById(R.id.my_playlist_details_image_scrolling_top);
        // toolbar 的高
        int toolbarHeight = toolbar.getLayoutParams().height;
        Log.i(TAG, "toolbar height:" + toolbarHeight);
        final int headerBgHeight = toolbarHeight + getStatusBarHeight(this);
        Log.i(TAG, "headerBgHeight:" + headerBgHeight);
        ViewGroup.LayoutParams params = mHeaderBg.getLayoutParams();
//        ViewGroup.LayoutParams params = fl_head_content.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = headerBgHeight;
        mHeaderBg.setImageAlpha(0);
        StatusBarUtils.setTranslucentImageHeader(this, 0, toolbar);
        Intent intent = getIntent();
        playlist_name = intent.getStringExtra("playlist_name");
        SharedPreferenceUtils.savePref("playlist_name", playlist_name);
        id = intent.getStringExtra("id");
        String coverImgUrl = intent.getStringExtra("coverImgUrl");
        my_playlist_details_recyclerview = findViewById(R.id.my_playlist_details_recyclerview);
        my_playlist_details_swiperefresh = findViewById(R.id.my_playlist_details_swiperefresh);
        my_playlist_details_swiperefresh.setOnRefreshListener(this);
        my_playlist_details_recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                View headerView = null;

                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int firstVisibleItem = manager.findFirstVisibleItemPosition();
                if (firstVisibleItem == 0) {
                    headerView = recyclerView.getChildAt(firstVisibleItem);
                }
                float alpha = 0;
                if (headerView == null) {
                    alpha = 1;// 如果headerView 为null ,说明已经到达header滑动的最大高度了
                } else {
                    alpha = Math.abs(headerView.getTop()) * 1.0f / headerView.getHeight();
                    Log.i(TAG, "alpha1:" + alpha + "top :" + headerView.getTop() + " height: " + headerView.getHeight());
                }

                Drawable drawable = mHeaderBg.getDrawable();
                if (drawable != null) {
                    drawable.mutate().setAlpha((int) (alpha * 255));
                    mHeaderBg.setImageDrawable(drawable);
                }

//                Drawable background = fl_head_content.getBackground();
//                if (background != null) {
//                    background.mutate().setAlpha((int) (alpha * 255));
//                    fl_head_content.setBackground(background);
//                }

            }
        });
//        setSupportActionBar(toolbar);
//        if (getSupportActionBar() != null) {
//            //TODO 用来显示返回箭头,点击貌似不可用,后面在搞
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setHomeButtonEnabled(true);
//        }

//        Glide.with(this).load(coverImgUrl).apply(new RequestOptions().fitCenter()).into(image_scrolling_top);
        ImageLoaderUtils.display(this, mHeaderBg, coverImgUrl);
        myHandler = new MyHandler(this, my_playlist_details_recyclerview, my_playlist_details_swiperefresh, mSongsBeans, mArBeans, mAlBeans);
        Log.i("playl1ist_name", "playlist_name = " + playlist_name);

        onRefresh();
    }

    @Override
    public void onRefresh() {
        mSongsBeans.clear();
        mArBeans.clear();
        mAlBeans.clear();
        //1.这里可以获取各个歌单的所有tackids
        requestPlaylistDetails(id);//这里可以获取各个歌单的所有tackids
        //2.使用handler再fori获取每个TrackId对应的歌曲信息再显示在控件上

    }

    /*
     *这个Constant.NETEASE_MYPLAYLIST_DETAIL + playlistid只能获取到trackIds
     * trackIds里面只有每首歌的id,我们要把这个id保存起来,然后再去请求一次
     */
    public void requestPlaylistDetails(String playlistid) {
        HttpUtil.getHttpUtilInstance().sendOkHttpRequest(Constant.NETEASE_MYPLAYLIST_DETAIL + playlistid, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                Log.i("deng111", "dengdeng222222 = " + Constant.NETEASE_MYPLAYLIST_DETAIL + playlistid);

                try {
                    JSONObject jsonObject = new JSONObject(responseText);
                    String resultCode = jsonObject.optString("code");
                    if (resultCode.equals("301")) {
                        runOnUiThread(() -> {
                            Toast.makeText(getApplicationContext(), "还没登陆，请先登录", Toast.LENGTH_LONG).show();
                            my_playlist_details_swiperefresh.setRefreshing(false);
                        });
                        return;
                    }

                    JSONObject playlistdata = jsonObject.getJSONObject("playlist");
                    JSONArray trackIds = playlistdata.getJSONArray("trackIds");
                    for (int i = 0; i < trackIds.length(); i++) {

                        JSONObject trackId = (JSONObject) trackIds.get(i);
                        long i1 = trackId.optLong("id");
                        MyPlayListDetailBean.PlaylistBean.TrackIdsBean trackIdsBean = new MyPlayListDetailBean.PlaylistBean.TrackIdsBean();
                        trackIdsBean.setId(i1);
                        mTrackIdsBeans.add(trackIdsBean);
                    }
                    String playlist_name = playlistdata.optString("name");
                    new Thread(() -> {
                        try {
                            Message message = new Message();
                            message.obj = mTrackIdsBeans;
                            myHandler.sendMessageDelayed(message, 300);
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

}
