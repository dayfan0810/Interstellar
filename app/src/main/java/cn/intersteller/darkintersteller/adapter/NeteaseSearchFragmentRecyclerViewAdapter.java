package cn.intersteller.darkintersteller.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.bean.SearchSongBean;

public class NeteaseSearchFragmentRecyclerViewAdapter extends RecyclerView.Adapter<NeteaseSearchFragmentRecyclerViewAdapter.ItemViewHolder> {
    Context mContext;
    List<SearchSongBean.ResultBean.SongsBean> songsBeans = new ArrayList<>();
    ArrayList<String> artists_name_Beans = new ArrayList<>();
    RecyclerView recyclerView;
    LinearLayoutManager manager;
    ArrayList<String> album_name_Beans = new ArrayList<>();

    public NeteaseSearchFragmentRecyclerViewAdapter(
            Context mContext,
            List<SearchSongBean.ResultBean.SongsBean> mSimpleSongBeans,
            ArrayList<String> artists_name_Beans,
            ArrayList<String> album_name_Beans,
            RecyclerView recyclerView,
            LinearLayoutManager manager) {
        this.mContext = mContext;
        this.recyclerView = recyclerView;
        this.manager = manager;
        this.songsBeans = mSimpleSongBeans;
        this.artists_name_Beans = artists_name_Beans;
        this.album_name_Beans = album_name_Beans;
    }

    public interface OnItemClickListener_NeteaseSearchFragment {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener_NeteaseSearchFragment mOnItemClickListener;

    //供外部fragment去设置回调,回调在onBindViewHolder中触发
    public void setmOnItemClickListener(OnItemClickListener_NeteaseSearchFragment mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public SearchSongBean.ResultBean.SongsBean getItem(int position) {
        return songsBeans == null ? null : songsBeans.get(position);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_search_result, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return songsBeans.size();
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        SearchSongBean.ResultBean.SongsBean songsBean = songsBeans.get(position);
        if (songsBeans == null) {
            Log.i("deng", "onBindViewHolder  =  null");
            return;
        }
        holder.tv_item_count_search_result.setText(String.valueOf(position + 1));
        Log.i("deng", "onBindViewHolder  =  songsBean.getName() = " + songsBean.getName());
        holder.tv_item_song_name_search_result.setText(songsBean.getName());
//        holder.tv_item_singer_search_result.setText(artists_name_Beans.get(position) + "");
        //用下面这种
        holder.tv_item_singer_search_result.setText(String.format("%s", "歌手: " + artists_name_Beans.get(position)));
        holder.tv_item_album_search_result.setText("    <<"+album_name_Beans.get(position)+">>");

        if (mOnItemClickListener != null) {
            (holder).itemView.setOnClickListener(v -> mOnItemClickListener.onItemClick(((ItemViewHolder) holder).itemView, position));

            (holder).itemView.setOnLongClickListener(v -> {
                mOnItemClickListener.onItemLongClick(holder.itemView, position);
                return false;
            });
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {


        private final TextView tv_item_count_search_result;
        private final TextView tv_item_song_name_search_result;
        private final TextView tv_item_singer_search_result;
        private final TextView tv_item_album_search_result;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_item_count_search_result = itemView.findViewById(R.id.tv_item_count_search_result);
            tv_item_song_name_search_result = itemView.findViewById(R.id.tv_item_song_name_search_result);
            tv_item_singer_search_result = itemView.findViewById(R.id.tv_item_singer_search_result);
            tv_item_album_search_result = itemView.findViewById(R.id.tv_item_album_search_result);
        }

    }
}
