package cn.intersteller.darkintersteller.adapter;

import android.content.Context;
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
import cn.intersteller.darkintersteller.bean.NewsBean;
import cn.intersteller.darkintersteller.controller.ImageLoader;
import cn.intersteller.darkintersteller.utils.ImageLoaderUtils;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ItemViewHolder> {
    Context mContext;
    List<NewsBean> mNewsBeans;
    ImageLoader mImageLoader;

    public NewsRecyclerViewAdapter(Context context, List<NewsBean> beansList, RecyclerView recyclerView, final LinearLayoutManager manager) {
        this.mNewsBeans = beansList;
        this.mContext = context;
//        notifyDataSetChanged();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    //停止滚动时加载
//                    mImageLoader.load(manager.findFirstVisibleItemPosition(),
//                            manager.findLastVisibleItemPosition());

                } else {

                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
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

    public NewsBean getItem(int position) {
        return mNewsBeans == null ? null : mNewsBeans.get(position);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.top_news_item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mNewsBeans.size();
    }


    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        NewsBean newsBean = mNewsBeans.get(position);
        if (newsBean == null) {
            return;
        }
        holder.top_news_item_title.setText(newsBean.getNewsTitle());
        holder.top_news_item_date.setText(newsBean.getNewsDate());
//        holder.top_news_item_img.setTag(newsBean.newsIconUrl);
        if (mOnItemClickListener != null) {
            ImageLoaderUtils.display(mContext, holder.top_news_item_img, newsBean.getNewsIconUrl());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onItemLongClick(holder.itemView, position);
                    return false;
                }
            });
        }
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView top_news_item_title;
        private final ImageView top_news_item_img;
        private final TextView top_news_item_date;

        public ItemViewHolder(View itemView) {
            super(itemView);
            top_news_item_img = itemView.findViewById(R.id.top_news_item_icon);
            top_news_item_title = itemView.findViewById(R.id.top_news_item_title);
            top_news_item_date = itemView.findViewById(R.id.top_news_item_date);
        }
    }
}
