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

import java.util.ArrayList;
import java.util.List;

import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.bean.CloudPanBean;

public class CloudPanRecyclerViewAdapter extends RecyclerView.Adapter<CloudPanRecyclerViewAdapter.ItemViewHolder> {
    Context mContext;
    List<CloudPanBean.DataBean.SimpleSongBean> mSimpleSongBeans = new ArrayList<>();
    List<CloudPanBean.DataBean.SimpleSongBean.AlBean> alBeans = new ArrayList<>();
    List<CloudPanBean.DataBean.SimpleSongBean.ArBean> arBeans = new ArrayList<>();
    RecyclerView recyclerView;
    LinearLayoutManager manager;

    public CloudPanRecyclerViewAdapter(Context mContext, List<CloudPanBean.DataBean.SimpleSongBean> mSimpleSongBeans, List<CloudPanBean.DataBean.SimpleSongBean.AlBean> alBeans, List<CloudPanBean.DataBean.SimpleSongBean.ArBean> arBeans, RecyclerView recyclerView, LinearLayoutManager manager) {
        this.mContext = mContext;
        this.mSimpleSongBeans = mSimpleSongBeans;
        this.alBeans = alBeans;
        this.arBeans = arBeans;
        this.recyclerView = recyclerView;
        this.manager = manager;
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

    public CloudPanBean.DataBean.SimpleSongBean getItem(int position) {
        return mSimpleSongBeans == null ? null : mSimpleSongBeans.get(position);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_cloud_pan_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mSimpleSongBeans.size();
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        CloudPanBean.DataBean.SimpleSongBean simpleSongBean = mSimpleSongBeans.get(position);
        CloudPanBean.DataBean.SimpleSongBean.AlBean alBean = alBeans.get(position);
        CloudPanBean.DataBean.SimpleSongBean.ArBean arBean = arBeans.get(position);
        if (simpleSongBean == null) {
            Log.i("deng", "onBindViewHolder  =  null");
            return;
        }
        holder.tv_item_cloud_pan_num.setText(String.valueOf(position + 1));
        holder.tv_item_cloud_pan_song_name.setText(simpleSongBean.getName() + "      " + arBean.getName());
        holder.tv_item_cloud_pan_al_name.setText(alBean.getName());
        if (mOnItemClickListener != null) {
//            ImageLoaderUtils.display(mContext, ((ItemViewHolder) holder).item_mv_list_iv_cover, mvBean.getCover());
            (holder).itemView.setOnClickListener(v -> mOnItemClickListener.onItemClick(((ItemViewHolder) holder).itemView, position));

            holder.itemView.setOnLongClickListener(v -> {
                mOnItemClickListener.onItemLongClick(holder.itemView, position);
                return false;
            });
        }
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


    class ItemViewHolder extends RecyclerView.ViewHolder {


        private final ImageView iv_item_cloud_pan_has_mv;
        private final ImageView iv_item_cloud_pan_singlesong_menu;
        private final TextView tv_item_cloud_pan_num;
        private final TextView tv_item_cloud_pan_song_name;
        private final TextView tv_item_cloud_pan_al_name;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_item_cloud_pan_num = itemView.findViewById(R.id.tv_item_cloud_pan_num);
            tv_item_cloud_pan_song_name = itemView.findViewById(R.id.tv_item_cloud_pan_song_name);
            tv_item_cloud_pan_al_name = itemView.findViewById(R.id.tv_item_cloud_pan_al_name);
            iv_item_cloud_pan_has_mv = itemView.findViewById(R.id.iv_item_cloud_pan_has_mv);
            iv_item_cloud_pan_singlesong_menu = itemView.findViewById(R.id.iv_item_cloud_pan_singlesong_menu);
        }

    }
}
