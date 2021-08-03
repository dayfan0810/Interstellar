package cn.intersteller.darkintersteller.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.bean.SongOfTrackidsBean;
import cn.intersteller.darkintersteller.utils.ImageLoaderUtils;
import cn.intersteller.darkintersteller.utils.SharedPreferenceUtils;

public class MyPlayListDetailActivityRecyclerViewAdapter extends RecyclerView.Adapter {
    Context mContext;
    List<SongOfTrackidsBean.SongsBean> mSongsBeans;
    List<SongOfTrackidsBean.SongsBean.ArBean> mArBeans;
    List<SongOfTrackidsBean.SongsBean.AlBean> mAlBeans;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_CONTENT = 1;
    private View content_view;
    private View headerView;

    public MyPlayListDetailActivityRecyclerViewAdapter(Context context,
                                                       List<SongOfTrackidsBean.SongsBean> mSongsBeans,
                                                       List<SongOfTrackidsBean.SongsBean.ArBean> mArBeans,
                                                       List<SongOfTrackidsBean.SongsBean.AlBean> mAlBeans,
                                                       RecyclerView recyclerView, final LinearLayoutManager manager) {
        this.mSongsBeans = mSongsBeans;
        this.mArBeans = mArBeans;
        this.mContext = context;
        this.mAlBeans = mAlBeans;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    //供外部fragment去设置回调,回调在onBindViewHolder中触发
    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public SongOfTrackidsBean.SongsBean getItem(int position) {
        return mSongsBeans == null ? null : mSongsBeans.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT) {
            content_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cloud_pan_list, parent, false);
            return new MyViewHolder(content_view);
        } else {
            headerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout, null);
            return new HeaderViewHolder(headerView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_CONTENT) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            Log.i("dengonBindViewHolder", "onBindViewHolder = " + mSongsBeans.size());
            position -= 1;
            SongOfTrackidsBean.SongsBean songsBean = mSongsBeans.get(position);
            SongOfTrackidsBean.SongsBean.ArBean arBean = mArBeans.get(position);
            SongOfTrackidsBean.SongsBean.AlBean alBean = mAlBeans.get(position);
            if (songsBean == null) {
                Log.i("dengonBindViewHolder", "onBindViewHolder  =  null");
                return;
            }
            Log.i("dengonBindViewHolder", "songsBean.getName() = " + songsBean.getName());
            Log.i("dengonBindViewHolder", "alBean.getName() = " + alBean.getName());
            myViewHolder.tv_item_cloud_pan_num.setText(String.valueOf(position + 1));
            myViewHolder.tv_item_cloud_pan_song_name.setText(songsBean.getName());
            myViewHolder.tv_item_cloud_pan_al_name.setText(alBean.getName());
//        holder.tv_item_cloud_pan_al_name.setText(simpleSongBean.getName().equals("null") ? "": simpleSongBean.getName());
//        holder.iv_item_cloud_pan.setText(mvBean.getPlayCount() + "次");
//        holder.iv_item_cloud_pan.setText(mvBean.getName());
//        setSortNumTextSize(holder, position);
//        if (mOnItemClickListener != null) {
//            ImageLoaderUtils.display(mContext, ((ItemViewHolder) holder).item_mv_list_iv_cover, mvBean.getCover());
//            ((ItemViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mOnItemClickListener.onItemClick(((ItemViewHolder) holder).itemView, position);
//                }
//            });
//
//            ((ItemViewHolder) holder).itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    mOnItemClickListener.onItemLongClick(((ItemViewHolder) holder).itemView, position);
//                    return false;
//                }
//            });
//        }
        } else {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            SongOfTrackidsBean.SongsBean.AlBean alBean = mAlBeans.get(position);
            ImageLoaderUtils.display(mContext, headerView.findViewById(R.id.iv_header_image), alBean.getPicUrl());
            TextView playlist_name = headerView.findViewById(R.id.tv_playlist_name);
            String playlist_name1 = SharedPreferenceUtils.getPrefString("playlist_name", "");
            Log.i("playlist_name1","playlist_name1 = "+playlist_name1);
            playlist_name.setText(playlist_name1);
        }

    }

    @Override
    public int getItemCount() {
        return mSongsBeans == null ? 1 : 1 + mSongsBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? TYPE_HEADER : TYPE_CONTENT;
    }


//    private void setSortNumTextSize(ItemViewHolder itemViewHolder, int position) {
//        if (position == 0) {
//            itemViewHolder.item_mv_list_tv_num.setTextSize(26);
//            itemViewHolder.item_mv_list_tv_num.setTextColor(
//                    mContext.getResources().getColor(R.color.color_top_rank));
//        } else if (position == 1) {
//            itemViewHolder.item_mv_list_tv_num.setTextSize(24);
//            itemViewHolder.item_mv_list_tv_num.setTextColor(
//                    mContext.getResources().getColor(R.color.color_top_rank));
//        } else if (position == 2) {
//            itemViewHolder.item_mv_list_tv_num.setTextSize(22);
//            itemViewHolder.item_mv_list_tv_num.setTextColor(
//                    mContext.getResources().getColor(R.color.color_top_rank));
//        } else {
//            itemViewHolder.item_mv_list_tv_num.setTextSize(20);
//            itemViewHolder.item_mv_list_tv_num.setTextColor(
//                    mContext.getResources().getColor(R.color.text_color_white));
//        }
//    }


    class MyViewHolder extends RecyclerView.ViewHolder {


        private final ImageView iv_item_cloud_pan_has_mv;
        private final ImageView iv_item_cloud_pan_singlesong_menu;
        private final TextView tv_item_cloud_pan_num;
        private final TextView tv_item_cloud_pan_song_name;
        private final TextView tv_item_cloud_pan_al_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_item_cloud_pan_num = itemView.findViewById(R.id.tv_item_cloud_pan_num);
            tv_item_cloud_pan_song_name = itemView.findViewById(R.id.tv_item_cloud_pan_song_name);
            tv_item_cloud_pan_al_name = itemView.findViewById(R.id.tv_item_cloud_pan_al_name);
            iv_item_cloud_pan_has_mv = itemView.findViewById(R.id.iv_item_cloud_pan_has_mv);
            iv_item_cloud_pan_singlesong_menu = itemView.findViewById(R.id.iv_item_cloud_pan_singlesong_menu);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public ImageView headerImage;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerImage = itemView.findViewById(R.id.my_playlist_details_image_scrolling_top);
        }
    }
}
