package cn.intersteller.darkintersteller.innerfragment.firstinnerfragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import cn.intersteller.darkintersteller.adapter.MyPlayListRecyclerViewAdapter;
import cn.intersteller.darkintersteller.bean.MyPlayListBean;
import cn.intersteller.darkintersteller.outterfragment.BaseLazyFragment;
import cn.intersteller.darkintersteller.ui.MyPlayListDetailActivity;
import cn.intersteller.darkintersteller.utils.Constant;
import cn.intersteller.darkintersteller.utils.HttpUtil;
import cn.intersteller.darkintersteller.utils.SharedPreferenceUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static cn.intersteller.darkintersteller.utils.Constant.LOGIN_USER_ID;

public class MyPlaylistFragment extends BaseLazyFragment implements SwipeRefreshLayout.OnRefreshListener {
    //    private View myplaylistfragment;
    private RecyclerView myplaylist_fragment_recyclerview;
    private SwipeRefreshLayout myplaylist_fragment_swiperefresh;
    List<MyPlayListBean.PlaylistBean> mPlaylistBeans = new ArrayList<>();
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

    @Override
    protected void findViewById(View view) {
        myplaylist_fragment_recyclerview = view.findViewById(R.id.myplaylist_fragment_recyclerview);
        myplaylist_fragment_swiperefresh = view.findViewById(R.id.myplaylist_fragment_swiperefresh);
        mPb = view.findViewById(R.id.pb);

        myplaylist_fragment_swiperefresh.setColorSchemeResources(
                R.color.blue
                , R.color.oriange
                , R.color.black
                , R.color.red);
        myplaylist_fragment_swiperefresh.setOnRefreshListener(this);
    }

    @Override
    protected View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return myplaylistfragment = inflater.inflate(R.layout.myplaylistfragment, container, false);
        return inflater.inflate(R.layout.myplaylistfragment, container, false);

    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        onRefresh();
//        return myplaylistfragment;
//    }

    @Override
    public void onRefresh() {
        mPlaylistBeans.clear();
        requestCloudPanMusic();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        mLikeyoutobe_video_view = myplaylistfragment.findViewById(R.id.likeyoutobe_video_view);
//        mLikeyoutobe_video_view.setSurfaceTextureListener(this);
//        mMediaPlayer = MediaPlayer.create(getContext(), R.raw.test_video);
//        mMediaPlayer.setOnPreparedListener(this);
    }


    public void requestCloudPanMusic() {
        long pref = SharedPreferenceUtils.getPrefLong(LOGIN_USER_ID, (long) 0);
        HttpUtil.getHttpUtilInstance().sendOkHttpRequest(Constant.NETEASE_MYPLAYLIST + pref, new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("dengurl", "Constant.NETEASE_MYPLAYLIST + pref = " + Constant.NETEASE_MYPLAYLIST + pref);
                final String responseText = response.body().string();

                try {
                    JSONObject jsonObject = new JSONObject(responseText);
                    String resultCode = jsonObject.optString("code");
                    if (resultCode.equals("301")) {
                        getActivity().runOnUiThread(() -> {
                            Toast.makeText(getActivity(), "还没登陆，请先登录", Toast.LENGTH_LONG).show();
                            myplaylist_fragment_swiperefresh.setRefreshing(false);
                        });
                        return;
                    }

                    JSONArray playListdata = jsonObject.getJSONArray("playlist");
                    for (int i = 0; i < playListdata.length(); i++) {
                        JSONObject playListdataItem = (JSONObject) playListdata.get(i);

                        String playlistName = playListdataItem.optString("name");
                        long playlistId = playListdataItem.optLong("id");
                        int playlistTrackCount = playListdataItem.optInt("trackCount");

                        String coverImgUrl = playListdataItem.optString("coverImgUrl");

                        MyPlayListBean.PlaylistBean playlistBean = new MyPlayListBean.PlaylistBean();
                        playlistBean.setName(playlistName);
                        playlistBean.setTrackCount(playlistTrackCount);
                        playlistBean.setId(playlistId);
                        playlistBean.setCoverImgUrl(coverImgUrl);
                        mPlaylistBeans.add(playlistBean);
                    }

                    if (getActivity() == null) {
                        return;
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        MyPlayListRecyclerViewAdapter myPlayListRecyclerViewAdapter;

                        @Override
                        public void run() {
                            LinearLayoutManager manager = new LinearLayoutManager(getContext());
                            myplaylist_fragment_recyclerview.setLayoutManager(manager);

                            myPlayListRecyclerViewAdapter = new MyPlayListRecyclerViewAdapter(getActivity().getApplicationContext(), mPlaylistBeans, myplaylist_fragment_recyclerview, manager);
                            myplaylist_fragment_recyclerview.setAdapter(myPlayListRecyclerViewAdapter);
                            myplaylist_fragment_swiperefresh.setRefreshing(false);
                            myPlayListRecyclerViewAdapter.setmOnItemClickListener(new MyPlayListRecyclerViewAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    MyPlayListBean.PlaylistBean playlistBean = myPlayListRecyclerViewAdapter.getItem(position);
                                    String name = playlistBean.getName();
                                    String coverImgUrl = playlistBean.getCoverImgUrl();
                                    int cloudTrackCount = playlistBean.getCloudTrackCount();
                                    long id = playlistBean.getId();
                                    View imageView = view.findViewById(R.id.tv_item_my_playlist_coverImgUrl);
                                    Intent intent = new Intent(getActivity(), MyPlayListDetailActivity.class);
                                    intent.putExtra("playlist_name", name);
                                    intent.putExtra("id", id + "");
                                    intent.putExtra("coverImgUrl", coverImgUrl);
//                                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
//                                            imageView, "my_playlist_sharedView");//与xml文件对应
//                                    ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
                                    startActivity(intent);


                                }

                                @Override
                                public void onItemLongClick(View view, int position) {

                                }
                            });
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

//    @Override
//    public void onPrepared(MediaPlayer mp) {
//        mMediaPlayer.setLooping(true);
//    }
//
//    @Override
//    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
//        mMediaPlayer.setSurface(new Surface(surface));
//        mMediaPlayer.start();
////        mCamera = Camera.open();
////        Camera.Size previewSize = mCamera.getParameters().getPreviewSize();
////        try {
////            mCamera.setPreviewTexture(surface);
////        } catch (IOException t) {
////        }
////        mCamera.startPreview();
////        mLikeyoutobe_video_view.setAlpha(1.0f);
//    }
//
//
//    @Override
//    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
//
//    }
//
//    @Override
//    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
////        mCamera.stopPreview();
////        mCamera.release();
//        return true;
//    }
//
//    @Override
//    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
//
//    }

}
