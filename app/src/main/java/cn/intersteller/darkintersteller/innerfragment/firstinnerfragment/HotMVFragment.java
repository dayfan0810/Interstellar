package cn.intersteller.darkintersteller.innerfragment.firstinnerfragment;

import android.content.Context;
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
import cn.intersteller.darkintersteller.adapter.HotMVRecyclerViewAdapter;
import cn.intersteller.darkintersteller.bean.HotMVBean;
import cn.intersteller.darkintersteller.outterfragment.BaseLazyFragment;
import cn.intersteller.darkintersteller.utils.Constant;
import cn.intersteller.darkintersteller.utils.HttpUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class HotMVFragment extends BaseLazyFragment implements SwipeRefreshLayout.OnRefreshListener {
    //    private View mHotmusicfragment;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private List<HotMVBean.DataBean> mHotMusicBeanList = new ArrayList<>();
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

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        return view;
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void findViewById(View view) {
        mSwipeRefreshLayout = view.findViewById(R.id.hotmusic_swipeRefreshLayout);
        mPb = view.findViewById(R.id.pb);
        mRecyclerView = view.findViewById(R.id.hotmusic_recyclerView);

        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.blue
                , R.color.oriange
                , R.color.black
                , R.color.red);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hotmusicfragment, container, false);
    }

    @Override
    public void onRefresh() {
        mHotMusicBeanList.clear();
        requestHotMusic();
    }

    public void requestHotMusic() {
        //一次性获取前100名
//        Log.i("deng", "Constant.NETEASE_TOP_MV = " + Constant.NETEASE_TOP_MV);
        HttpUtil.getHttpUtilInstance().sendOkHttpRequest(Constant.NETEASE_TOP_MV, new Callback() {


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                Log.i("deng-onResponse", "responseText = " + responseText);
                try {
                    JSONObject jsonObject = new JSONObject(responseText);
                    String resultCode = jsonObject.optString("code");
                    if (!resultCode.equals("200")) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "MV API获取错误,检查URL", Toast.LENGTH_SHORT).show();
                                mSwipeRefreshLayout.setRefreshing(false);
                            }
                        });
                        return;
                    }
                    final JSONArray mvData = jsonObject.getJSONArray("data");
                    for (int i = 0; i < mvData.length(); i++) {

                        JSONObject dataItem = (JSONObject) mvData.get(i);

                        String cover = dataItem.optString("cover");
                        String name = dataItem.optString("name");
                        int playCount = dataItem.optInt("playCount");
                        int lastRank = dataItem.optInt("lastRank");
                        int id = dataItem.optInt("id");

                        HotMVBean.DataBean dataBean = new HotMVBean.DataBean();
                        dataBean.setCover(cover);
                        dataBean.setName(name);
                        dataBean.setId(id);
                        dataBean.setPlayCount(playCount);
                        dataBean.setLastRank(lastRank);
                        mHotMusicBeanList.add(dataBean);

                    }
                    if (getActivity() == null) {
                        return;
                    }
                    getActivity().runOnUiThread(new Runnable() {

                        private HotMVRecyclerViewAdapter hotMVRecyclerViewAdapter;

                        @Override
                        public void run() {
                            LinearLayoutManager manager = new LinearLayoutManager(getContext());
                            mRecyclerView.setLayoutManager(manager);
                            hotMVRecyclerViewAdapter = new HotMVRecyclerViewAdapter(getContext(), mHotMusicBeanList, mRecyclerView, manager);
                            hotMVRecyclerViewAdapter.setmOnItemClickListener(new HotMVRecyclerViewAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Log.i("deng", "onItemClick ");
                                    if (mHotMusicBeanList.size() <= 0) {
                                        Log.i("deng", "onItemClick no data, return");
                                        return;
                                    }

                                    HotMVBean.DataBean item = hotMVRecyclerViewAdapter.getItem(position);
//                                    Intent intent = new Intent(getActivity(), MvDetailActivity.class);
                                    Bundle mBundle = new Bundle();
                                    mBundle.putSerializable("mvitem", item);
//                                    intent.putExtras(mBundle);
//                                    startActivity(intent);
                                    mSendMessageToMainAcvtyCallBack.messageFromFragment(mBundle);

                                }

                                @Override
                                public void onItemLongClick(View view, int position) {

                                }
                            });
                            mRecyclerView.setAdapter(hotMVRecyclerViewAdapter);
                            mSwipeRefreshLayout.setRefreshing(false);

                        }
                    });

                    Log.i("HotMVFragment", "mHotMusicBeanList.size = " + mHotMusicBeanList.size());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                if (getActivity() == null) {
                    Log.i("deng-HotMVFragment", "onFailure1");
                    return;
                }
                Log.i("deng-HotMVFragment", "onFailure2");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Toast.makeText(getContext(), "获取MV信息失败", Toast.LENGTH_SHORT).show();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }
}
