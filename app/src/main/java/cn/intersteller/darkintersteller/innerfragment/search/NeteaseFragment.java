package cn.intersteller.darkintersteller.innerfragment.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import cn.intersteller.darkintersteller.MainActivity;
import cn.intersteller.darkintersteller.MyApplication;
import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.adapter.NeteaseSearchFragmentRecyclerViewAdapter;
import cn.intersteller.darkintersteller.bean.SearchSongBean;
import cn.intersteller.darkintersteller.database.MySQLiteOpenHelper;
import cn.intersteller.darkintersteller.utils.Constant;
import cn.intersteller.darkintersteller.utils.HttpUtil;

public class NeteaseFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "NeteaseFragment";
    ArrayList<SearchSongBean.ResultBean.SongsBean> searchSongBeans = new ArrayList<>();
    ArrayList<String> artists_name_Beans = new ArrayList<>();
    ArrayList<String> album_name_Beans = new ArrayList<>();
    boolean needNetSearch = true;
    private View view;
    RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    static NeteaseFragment neteaseFragment;
    private String submit_string;

    public NeteaseFragment(String submit_string) {
//        if (neteaseFragment == null) {
        neteaseFragment = new NeteaseFragment();
        //把在NetSearchActivity中query的字符串放到这个fragment的new中
        //然后再加载布局时就searchAll
        this.submit_string = submit_string;
        Bundle bdl = new Bundle(1);
        bdl.putString("submit_string", submit_string);
        neteaseFragment.setArguments(bdl);
//        }
    }

    public NeteaseFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_netease_search, container, false);
        refreshLayout = view.findViewById(R.id.neteasefragment_swiperefreshlayout);
        recyclerView = view.findViewById(R.id.neteaseFragment_recyclerView);
        if (getArguments() != null) {
            submit_string = getArguments().getString("submit_string");
        }
        refreshLayout.setColorSchemeResources(
                R.color.blue
                , R.color.oriange
                , R.color.black
                , R.color.red);
        refreshLayout.setOnRefreshListener(this);
        onRefresh();
        return view;
    }

    @SuppressLint("StaticFieldLeak")
    private void search(String submit_string) {
//        new MyAsyncTask().execute(submit_string);
        new AsyncTask<Void, Void, Void>() {


            @Override
            protected Void doInBackground(Void... voids) {
                Log.i("dengdb", "searchsearch----NeteaseFragment = " + submit_string);

                //先查数据库的,有就显示到界面上,再差网易云的API
                MySQLiteOpenHelper mySQLiteOpenHelper = new MySQLiteOpenHelper(getContext());
                SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();

                db.beginTransaction();
                String sql = "select * from " + Constant.CLOUDPAN_DATABASE_TABLE_NAME +
                        " where song_name like ? or album_name like ? or singer_name like ?";
                String[] selectionArgs = new String[]{
                        "%" + submit_string + "%",
                        "%" + submit_string + "%",
                        "%" + submit_string + "%"};
                Cursor cursor = db.rawQuery(sql, selectionArgs);
                while (cursor.moveToNext()) {
                    int song_id = cursor.getInt(0);
                    String song_name = cursor.getString(1);
                    String album_name = cursor.getString(2);
                    String singer_name = cursor.getString(3);
                    Log.i("dengdb", "歌曲名=" + song_name + ", 专辑名=" + album_name + ",歌手名=" + singer_name);
                    SearchSongBean.ResultBean.SongsBean songbean =
                            new SearchSongBean.ResultBean.SongsBean();
                    SearchSongBean.ResultBean.SongsBean.ArBean artistsBean =
                            new SearchSongBean.ResultBean.SongsBean.ArBean();
                    songbean.setId(song_id);//id
                    songbean.setName(song_name);//歌名
                    searchSongBeans.add(songbean);
                    album_name_Beans.add(album_name);//专辑
                    artists_name_Beans.add(singer_name);


                }
                db.endTransaction();
                cursor.close();
                Log.i(TAG, "dengdb111--------11111111111 = " + artists_name_Beans.size());


                JsonObject resposeJsonObject = HttpUtil.getResposeJsonObject(Constant.NETEASE_SEARCH + submit_string);
                //http://1.15.151.241:3000/search?keywords=周杰伦
                JsonObject result = resposeJsonObject.get("result").getAsJsonObject();
                int songCount = result.get("songCount").getAsInt();
                if (songCount != 0) {
                    JsonArray songs = result.get("songs").getAsJsonArray();
                    for (JsonElement song : songs) {
                        SearchSongBean.ResultBean.SongsBean songsBean = MyApplication.gsonInstance().fromJson(song, SearchSongBean.ResultBean.SongsBean.class);
                        searchSongBeans.add(songsBean);
                        JsonObject a_songAsJsonObject = song.getAsJsonObject();


                        //给artists做分析--start/////////////////////////////////////////
                        JsonArray artists = a_songAsJsonObject.get("ar").getAsJsonArray();
                        StringBuilder sb = new StringBuilder();//放在需要遍历的外面
                        for (JsonElement artist : artists) {
                            JsonObject artist_item = artist.getAsJsonObject();
                            SearchSongBean.ResultBean.SongsBean.ArBean artist_item_1 = MyApplication.gsonInstance().fromJson(artist_item, SearchSongBean.ResultBean.SongsBean.ArBean.class);
                            String name = artist_item_1.getName();
                            if (sb.length() > 0) {//该步即不会第一位有逗号，也防止最后一位拼接逗号！
                                sb.append("/");
                            }
                            sb.append(name);
                        }
//                        Log.i(TAG, "sb name = " + sb.toString());
                        artists_name_Beans.add(sb.toString());
                        //给artists做分析--end/////////////////////////////////////////
                        //给album做分析--start/////////////////////////////////////////
                        JsonObject album = a_songAsJsonObject.getAsJsonObject("al");
                        String album_name = album.get("name").getAsString();
                        album_name_Beans.add(album_name);
                        //给album做分析--end/////////////////////////////////////////

                    }
//                    Log.i(TAG, "dengdb111--------22222222222222222 = " + artists_name_Beans.size());
                }
                getActivity().runOnUiThread(new Runnable() {

                    private NeteaseSearchFragmentRecyclerViewAdapter neteaseSearchFragmentRecyclerViewAdapter;

                    @Override
                    public void run() {
                        LinearLayoutManager manager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(manager);

                        neteaseSearchFragmentRecyclerViewAdapter = new NeteaseSearchFragmentRecyclerViewAdapter(
                                getContext(),
                                searchSongBeans,
                                artists_name_Beans,
                                album_name_Beans,
                                recyclerView,
                                manager);


                        neteaseSearchFragmentRecyclerViewAdapter.setmOnItemClickListener(new NeteaseSearchFragmentRecyclerViewAdapter.OnItemClickListener_NeteaseSearchFragment() {
                            @Override
                            public void onItemClick(View view, int position) {
                                if (searchSongBeans.size() <= 0) {
                                    Log.i(TAG, "onItemClick no data, return");
                                    return;
                                }
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        SearchSongBean.ResultBean.SongsBean item = neteaseSearchFragmentRecyclerViewAdapter.getItem(position);
                                        int a_song_id = item.getId().intValue();
                                        String playUrl = HttpUtil.getPlayUrl(a_song_id);
                                        Intent intent = new Intent(getActivity(), MainActivity.class);
                                        intent.putExtra("song_play_url", playUrl);
                                        intent.setAction("neteasefragment_song_play_url");
//                                        BroadCastManager.getInstance().sendBroadCast(getActivity(), intent);
//                                        Log.i(TAG, "onItemClick nsong_play_url = " + playUrl);
//                                        getActivity().finish();
                                        startActivity(intent);

                                    }
                                }).start();

                            }

                            @Override
                            public void onItemLongClick(View view, int position) {

                            }
                        });
                        recyclerView.setAdapter(neteaseSearchFragmentRecyclerViewAdapter);
                        refreshLayout.setRefreshing(false);
                    }
                });


                return null;
            }
        }.execute();
    }


    @Override
    public void onRefresh() {
        searchSongBeans.clear();
        artists_name_Beans.clear();
        album_name_Beans.clear();
        search(submit_string);
    }


    private static class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load((String) path)
                    .into(imageView);
        }
    }

//    private static class MyAsyncTask extends AsyncTask<String, Void, Void> {
//        ArrayList<SearchSongBean.ResultBean.SongsBean> searchSongBeans = new ArrayList<>();
//
//
//        @Override
//        protected Void doInBackground(String... strings) {
//            JsonObject resposeJsonObject = HttpUtil.getResposeJsonObject(Constant.NETEASE_SEARCH + strings[0]);
//            JsonObject result = resposeJsonObject.get("result").getAsJsonObject();
//            JsonArray songs = result.get("songs").getAsJsonArray();
//            for (JsonElement o : songs) {
//                SearchSongBean.ResultBean.SongsBean songsBean = MyApplication.gsonInstance().fromJson(o, SearchSongBean.ResultBean.SongsBean.class);
//                Log.e("songinfo", songsBean.getId());
//                searchSongBeans.add(songsBean);
//            }
//
//
//
//            return null;
//        }
//    }
}
