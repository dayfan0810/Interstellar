package cn.intersteller.darkintersteller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import cn.intersteller.darkintersteller.adapter.OutterFragmentAdapter;
import cn.intersteller.darkintersteller.bean.CloudPanBean;
import cn.intersteller.darkintersteller.bean.HotMVBean;
import cn.intersteller.darkintersteller.bean.MyPlayListBean;
import cn.intersteller.darkintersteller.custview.MyFrameLayoutMoveUp;
import cn.intersteller.darkintersteller.custview.PlayPauseView;
import cn.intersteller.darkintersteller.outterfragment.FirstFragment;
import cn.intersteller.darkintersteller.outterfragment.SecFragment;
import cn.intersteller.darkintersteller.outterfragment.ThirdFragment;
import cn.intersteller.darkintersteller.ui.NetSearchActivity;
import cn.intersteller.darkintersteller.utils.BroadCastManager;
import cn.intersteller.darkintersteller.utils.Constant;
import cn.intersteller.darkintersteller.utils.HttpUtil;
import cn.intersteller.darkintersteller.utils.PermissionUtils;
import cn.intersteller.darkintersteller.utils.ScreenUtils;
import cn.intersteller.darkintersteller.utils.SharedPreferenceUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyFrameLayoutMoveUp.VideoCallBack, BaseFragment.SendMessageToMainAcvtyCallBack {
    private long time = 0;
    private ImageView mBarDisco;
    private ImageView mBarMusic;
    private ImageView mBarFriends;
    private ImageView mBarSearch;
    //    String url_mv = "http://vodkgeyttp8.vod.126.net/cloudmusic/obj/core/632873387/14845ceb9062d95272bd27abdf78312e.mp4?wsSecret=21f642deb48add04a7803e8d927eecf9&wsTime=1588146320";
//    String mMV_URL = "http://ips.ifeng.com/video19.ifeng.com/video09/2017/05/24/4664192-102-008-1012.mp4";
    String mMV_URL;
    private LinearLayout mSearchLayout;
    private ViewPager mVpMianActivity;
    private Toolbar toolbar;
    private LocalReceiver mReceiver;
    public static List<Fragment> mFragmntList = new ArrayList<>();
//    private boolean isExit;

    private boolean pendingIntroAnimation;

    private OutterFragmentAdapter outterFragmentAdapter;
    private DrawerLayout drawer;
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private AppBarConfiguration mAppBarConfiguration;
    //    private UshkNewsGrabber mUshkNewsGrabber = new UshkNewsGrabber();
//    private CnbetaNewsGrabber mCnbetaNewsGrabber = new CnbetaNewsGrabber();
    private PlayerView mLikeyoutobe_video_view;
    private MyFrameLayoutMoveUp myframelayoutmoveup_container;
    private ExoPlayer mExoPlayer;
    private PlayPauseView likeyoutobe_play_pause;
//    private ImageButton exo_next;
//    private ImageButton exo_prev;
//    private String mMV_URL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setStatusBarColor(Color.TRANSPARENT);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        setContentView(R.layout.activity_main);
//        mDragView = (DragViewPanel) findViewById(R.id.dragview);
        Log.i("deng22222222", "wid = " + ScreenUtils.getAvailableScreenWidth(this) +
                ",   height" + ScreenUtils.getScreenHeight(this));

//        LayoutInflater inflater2 = LayoutInflater.from(this);
//        View selfView = inflater2.inflate(R.layout.include_likeyoutobeslideupview_min, null);
//        mDragView.addDragView(selfView, 0, 1430,
//                ScreenUtils.getAvailableScreenWidth(this), 1520, false, false);

        mBarDisco = findViewById(R.id.bar_disco);
        mBarMusic = findViewById(R.id.bar_music);
        mBarFriends = findViewById(R.id.bar_friends);
        mBarSearch = findViewById(R.id.bar_search);
//        mSearchLayout = findViewById(R.id.search_layout);
        mVpMianActivity = findViewById(R.id.vp_mian_activity);
        mVpMianActivity.setOffscreenPageLimit(3);
        addFragmet();
        initWidgets();

        toolbar = findViewById(R.id.toolbar);
//        fab = findViewById(R.id.fab);
        mDrawer = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.nav_view);
        mLikeyoutobe_video_view = findViewById(R.id.likeyoutobe_video_view);


        LayoutInflater inflater = LayoutInflater.from(this);
        likeyoutobe_play_pause = findViewById(R.id.likeyoutobe_play_pause);

        likeyoutobe_play_pause.setOnClickListener(this);
        // 得到默认合适的带宽
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        // 创建跟踪的工厂
        TrackSelection.Factory factory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
        // 创建跟踪器
        DefaultTrackSelector trackSelection = new DefaultTrackSelector(factory);
        mExoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelection);
//// 生成数据媒体实例，通过该实例加载媒体数据
//        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "exoplayerdemo"));
//// 创建资源
//        Uri uri = Uri.parse(mMV_URL);
//        MediaSource mediaSources = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
//// 将播放器附加到view
//        mLikeyoutobe_video_view.setPlayer(mExoPlayer);
//// 准备播放
//        mExoPlayer.prepare(mediaSources);
//// 准备好了之后自动播放，如果已经准备好了，调用该方法实现暂停、开始功能
//        mExoPlayer.setPlayWhenReady(true);
//        mLikeyoutobe_video_view.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
//            @Override
//            public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
//                openMediaPlayer(surface, mMV_URL);
//            }
//
//            @Override
//            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
//
//            }
//
//            @Override
//            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
//                return false;
//            }
//
//            @Override
//            public void onSurfaceTextureUpdated(SurfaceTexture surface) {
//
//            }
//        });
        //设置加载进度的布局

        myframelayoutmoveup_container = findViewById(R.id.myframelayoutmoveup_container);
        myframelayoutmoveup_container.setmVideoCallBack(this);
        myframelayoutmoveup_container.setVisibility(View.GONE);
//        fab.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), ImmersionTestActivity.class);
//            startActivity(intent);
////                SnackbarsetOffscreenPageLimit.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//        });
        mBarDisco.setOnClickListener(this);
        mBarMusic.setOnClickListener(this);
        mBarFriends.setOnClickListener(this);
        mBarSearch.setOnClickListener(this);
//        exo_next.setOnClickListener(this);
//        exo_prev.setOnClickListener(this);
        //1.USHKNEWS
        //        ArrayList ushkNewsBeanByCallable = mUshkNewsGrabber.getUSHKNewsBeanDerectely();
        //        ArrayList ushkNewsBeanByCallable = mUshkNewsGrabber.getUSHKNewsBeanByCallable();
        //        Log.i("deng4","ushkNewsBeanByCallable = "+ushkNewsBeanByCallable.size());

        setCurrentItem(0);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(mNavigationView, navController);
        getHotSearch();

        registerBroadCast();
        startIntroAnimation();
    }

    private void addFragmet() {
        mFragmntList.clear();
        mFragmntList.add(FirstFragment.newInstance());
        mFragmntList.add(SecFragment.newInstance());
        mFragmntList.add(ThirdFragment.newInstance());
    }

    private void registerBroadCast() {
        //接收广播
        try {
            IntentFilter filter = new IntentFilter();
            filter.addAction("neteasefragment_song_play_url");
            mReceiver = new LocalReceiver();
            BroadCastManager.getInstance().registerReceiver(this,
                    mReceiver, filter);//注册广播接收者
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String song_play_url = intent.getStringExtra("song_play_url");
        Log.i("dengreceive", "song_play_url =" + song_play_url);
        if (song_play_url != null) {

            playsong_by_id(song_play_url);
        }
    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //收到广播后的处理
            String song_play_url = intent.getStringExtra("song_play_url");
            Log.i("dengreceive", "song_play_url =" + song_play_url);
            playsong_by_id(song_play_url);
//            myframelayoutmoveup_container.setVisibility(View.VISIBLE);
//            myframelayoutmoveup_container.goMax();
        }


    }

    private void playsong_by_id(String song_play_url) {

        runOnUiThread(() -> {
            myframelayoutmoveup_container.setVisibility(View.VISIBLE);
            myframelayoutmoveup_container.goMax();
            // 生成数据媒体实例，通过该实例加载媒体数据
            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getApplicationContext(), Util.getUserAgent(getApplicationContext(), "exoplayerdemo"));
            // 创建资源
            Uri uri = Uri.parse(song_play_url);
            MediaSource mediaSources = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
            // 将播放器附加到view
            mLikeyoutobe_video_view.setPlayer(mExoPlayer);
            // 准备播放
            mExoPlayer.prepare(mediaSources);
            // 准备好了之后自动播放，如果已经准备好了，调用该方法实现暂停、开始功能
            mExoPlayer.setPlayWhenReady(true);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        startIntroAnimation();

    }

    private void setCurrentItem(int position) {
        boolean isOne = false;
        boolean isTwo = false;
        boolean isThree = false;
        switch (position) {
            case 0:
                isOne = true;
                break;
            case 1:
                isTwo = true;
                break;
            case 2:
                isThree = true;
                break;
            default:
                isTwo = true;
                break;
        }
        mVpMianActivity.setCurrentItem(position);
        mBarDisco.setSelected(isOne);
        mBarMusic.setSelected(isTwo);
        mBarFriends.setSelected(isThree);
    }

    private void initWidgets() {
        Log.i("dengpos", "mFragmntList.size = " + mFragmntList.size());
        outterFragmentAdapter = new OutterFragmentAdapter(getSupportFragmentManager(), mFragmntList);
        mVpMianActivity.setAdapter(outterFragmentAdapter);
        mVpMianActivity.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                //oncreate时不会走这个方法, 导致三个顶部图标都是灰色,没有被选取
                switch (position) {
                    case 0:
                        mBarDisco.setSelected(true);
                        mBarMusic.setSelected(false);
                        mBarFriends.setSelected(false);
                        break;
                    case 1:
                        mBarDisco.setSelected(false);
                        mBarMusic.setSelected(true);
                        mBarFriends.setSelected(false);
                        break;
                    case 2:
                        mBarDisco.setSelected(false);
                        mBarMusic.setSelected(false);
                        mBarFriends.setSelected(true);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bar_disco:
                if (mVpMianActivity.getCurrentItem() != 0) {
                    mVpMianActivity.setCurrentItem(0);
                    mBarDisco.setSelected(true);
                    mBarMusic.setSelected(false);
                    mBarFriends.setSelected(false);
                }
                break;
            case R.id.bar_music:
                if (mVpMianActivity.getCurrentItem() != 1) {
                    mVpMianActivity.setCurrentItem(1);
                    mBarMusic.setSelected(true);
                    mBarDisco.setSelected(false);
                    mBarFriends.setSelected(false);
                }
                break;
            case R.id.bar_friends:
                Log.i("dengclick", "bar_friends");

                if (mVpMianActivity.getCurrentItem() != 2) {
                    mVpMianActivity.setCurrentItem(2);
                    mBarFriends.setSelected(true);
                    mBarDisco.setSelected(false);
                    mBarMusic.setSelected(false);
                }
                break;
            case R.id.bar_search:
                final Intent intent = new Intent(MainActivity.this, NetSearchActivity.class);
                MainActivity.this.startActivity(intent);
//                try {
//                    DealThread t1 = new DealThread(this);
//                    t1.setFlag("a");
//
//                    Thread thread1 = new Thread(t1);
//                    thread1.start();
//
//                    Thread.sleep(100);
//
//                    t1.setFlag("b");
//                    Thread thread2 = new Thread(t1);
//                    thread2.start();
//
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }

                //测试volatile可见性
//                try {
//                    VolatileVisibleTest volatileVisibleTest = new VolatileVisibleTest();
//                    volatileVisibleTest.testVolatileVisibleTest();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                break;
            case R.id.fab:

                break;
            case R.id.likeyoutobe_play_prev:
                Log.i("dengclick", "likeyoutobe_play_prev");

                previous();
                break;
            case R.id.likeyoutobe_play_next:
                Log.i("dengclick", "likeyoutobe_play_next");

                next();
                break;

            case R.id.likeyoutobe_play_pause:
                Log.i("dengclick", "likeyoutobe_play_pause");

                pause_or_resume();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }


    private void startIntroAnimation() {
        Log.i("delay", "delay");
        int actionBarSzie = ScreenUtils.dpToPx(56);
        toolbar.setTranslationY(-actionBarSzie);
        toolbar.animate().translationY(0).setStartDelay(500);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (isExit) {
//                this.finish();
//            } else {
//                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
//                isExit = true;
//                new Handler().postDelayed(() -> isExit = false, 2000);
//            }
//            return true;

            if ((System.currentTimeMillis() - time > 1000)) {
                Toast.makeText(this, "再按一次返回桌面", Toast.LENGTH_SHORT).show();
                time = System.currentTimeMillis();
            } else {
                finish();
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_HOME);
//                startActivity(intent);
            }
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    protected void onDestroy() {
        BroadCastManager.getInstance().unregisterReceiver(this, mReceiver);//注销广播接收者
        super.onDestroy();
        if (null != mExoPlayer) {
            mExoPlayer.stop();
            mExoPlayer.release();
            mExoPlayer = null;
        }

        Log.i("deng", "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("deng", "onStop");
    }


    @Override
    public void onVideoClick() {
        pause_or_resume();
    }

    /**
     * 暂停/播放
     */
    public void pause_or_resume() {
        if (mExoPlayer.isPlaying()) {
            Toast.makeText(this, "暂停", Toast.LENGTH_SHORT).show();
            mExoPlayer.setPlayWhenReady(false);
            likeyoutobe_play_pause.pause();
        } else {
            mExoPlayer.setPlayWhenReady(true);
            Toast.makeText(this, "继续", Toast.LENGTH_SHORT).show();
            likeyoutobe_play_pause.play();

        }
    }

    /**
     * 停止
     */
    public void stop() {
        if (null != mExoPlayer) {
            mExoPlayer.stop();
        }
    }

    /**
     * 下一首
     */
    public void next() {

        if (null != mExoPlayer) {
            if (mExoPlayer.getCurrentTimeline().isEmpty()) {
                return;
            }
            int nextWindowIndex = mExoPlayer.getNextWindowIndex();
            if (nextWindowIndex != C.INDEX_UNSET) {
                mExoPlayer.seekTo(nextWindowIndex, C.TIME_UNSET);
            } else {
                Log.d("info", "已经是最后一个了");
            }
        }
    }

    /**
     * 上一首
     */
    public void previous() {

        if (null != mExoPlayer) {
            if (mExoPlayer.getCurrentTimeline().isEmpty()) {
                return;
            }
            int previousWindowIndex = mExoPlayer.getPreviousWindowIndex();
            if (previousWindowIndex != C.INDEX_UNSET) {
                mExoPlayer.seekTo(previousWindowIndex, C.TIME_UNSET);
            } else {
                Log.d("info", "已经是第一个了");
            }
        }
    }

    @Override
    public void messageFromFragment(Bundle bundle) {
        Serializable mvitem = bundle.getSerializable("mvitem");
        if (mvitem instanceof HotMVBean.DataBean) {
            Log.i("info", "HotMVBean");
            int mvID = ((HotMVBean.DataBean) mvitem).getId();
            requestURL_From_Fragment_msg(mvID);
        } else if (mvitem instanceof CloudPanBean.DataBean.SimpleSongBean) {
            Log.i("info", "CloudPanBean");
            String id = ((CloudPanBean.DataBean.SimpleSongBean) mvitem).getId();


            new Thread(() -> {
                String playUrl = HttpUtil.getPlayUrl(id);
                playsong_by_id(playUrl);
            }).start();

        } else if (mvitem instanceof MyPlayListBean) {
            Log.i("info", "MyPlayListBean");
        }
        //TODO 只能宿主activity(attach的fragment才能用此回调)
//        else if (mvitem instanceof SearchSongBean.ResultBean.SongsBean) {
//            Log.i("info", "SongsBean");
//        }

    }

    @Override
    public void onVideosweep() {

    }

    private void requestURL_From_Fragment_msg(int mv_id) {
        HttpUtil.getHttpUtilInstance().sendOkHttpRequest(Constant.NETEASE_MV_VIDEO + mv_id, new Callback() {

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Toast.makeText(getApplicationContext(), "获取MV的视频信息失败", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String responseText = Objects.requireNonNull(response.body()).string();
                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(responseText);
                    String resultCode = jsonObject.optString("code");
                    if (!resultCode.equals("200")) {
                        Toast.makeText(getApplicationContext(), "MV视频API获取错误,检查URL", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    final JSONObject mvData = jsonObject.getJSONObject("data");
                    mMV_URL = mvData.optString("url");
                    Log.d("mMV_URL", "mMV_URL = " + mMV_URL);

                    runOnUiThread(() -> {
                        myframelayoutmoveup_container.setVisibility(View.VISIBLE);
//                        myframelayoutmoveup_container.goMax();
                        // 生成数据媒体实例，通过该实例加载媒体数据
                        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getApplicationContext(), Util.getUserAgent(getApplicationContext(), "exoplayerdemo"));
                        // 创建资源
                        Uri uri = Uri.parse(mMV_URL);
                        MediaSource mediaSources = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
                        // 将播放器附加到view
                        mLikeyoutobe_video_view.setPlayer(mExoPlayer);
                        // 准备播放
                        mExoPlayer.prepare(mediaSources);
                        // 准备好了之后自动播放，如果已经准备好了，调用该方法实现暂停、开始功能
                        mExoPlayer.setPlayWhenReady(true);
                    });
                } catch (JSONException ignored) {
                }
            }
        });
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        PermissionUtils.initCheckSelfPermission(this);
    }

    private void getHotSearch() {
        HttpUtil.getHttpUtilInstance().sendOkHttpRequest(Constant.NETEASE_HOT_SEARCH_DETAIL, new Callback() {

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                mHotSearchBean.clear();
                SharedPreferenceUtils.clear();
                final String responseText = response.body().string();
                try {
                    JSONObject jsonObject = null;
                    jsonObject = new JSONObject(responseText);
                    String resultCode = jsonObject.optString("code");
                    if (!resultCode.equals("200")) {
                        Looper.prepare();
                        Toast.makeText(getApplicationContext(), "热搜搜索失败", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                        return;
                    }

                    JSONArray data = jsonObject.optJSONArray("data");
                    if (data == null) {
                        runOnUiThread(() -> {
//                            LinearLayoutManager manager = new LinearLayoutManager(mContext);
//                            mReclclerView.setLayoutManager(manager);
//                            searchSuggestRecyclerViewAdapter = new SearchSuggestRecyclerViewAdapter(mContext, mAllMatchBeans, mReclclerView, manager);
//                            mReclclerView.setAdapter(searchSuggestRecyclerViewAdapter);
                        });

                        return;
                    }
                    ArrayList<String> hot_searchWord_list = new ArrayList<String>();
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject allMatchItem = (JSONObject) data.get(i);
                        String hot_searchWord = allMatchItem.optString("searchWord");
                        hot_searchWord_list.add(hot_searchWord);
                    }
                    String[] array = hot_searchWord_list.toArray(new String[0]);
                    SharedPreferenceUtils.savePref("searchWord_hot", Arrays.toString(array));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
