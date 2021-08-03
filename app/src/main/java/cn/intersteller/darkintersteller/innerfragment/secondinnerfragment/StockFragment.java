package cn.intersteller.darkintersteller.innerfragment.secondinnerfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.WebGrabber.USHK.USHKNewsBean;
import cn.intersteller.darkintersteller.WebGrabber.USHK.UshkNewsGrabber;
import cn.intersteller.darkintersteller.adapter.Jin10RecyclerViewAdapter;
import cn.intersteller.darkintersteller.outterfragment.BaseLazyFragment;


public class StockFragment extends BaseLazyFragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private UshkNewsGrabber mUshkNewsGrabber = new UshkNewsGrabber();
    //    private CnbetaNewsGrabber mCnbetaNewsGrabber = new CnbetaNewsGrabber();
    private Jin10RecyclerViewAdapter newsAdapter;

    //    private View view;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private List<USHKNewsBean> mNewsBeanList = new ArrayList<>();

    @Override
    public void loadDataStart() {

    }


    @Override
    public void onClick(View v) {

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("deng11111333-onViewCreated", "onViewCreated");
        onRefresh();
    }

    @Override
    protected void findViewById(View view) {
        mSwipeRefreshLayout = view.findViewById(R.id.stock_fragment_swipeRefreshLayout);
        mRecyclerView = view.findViewById(R.id.stock_fragment_recyclerView);
        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.blue
                , R.color.oriange
                , R.color.black
                , R.color.red);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.stock_fragment, container, false);

    }

    @Override
    public void onRefresh() {
        mNewsBeanList.clear();
        requestNews();
    }


    public void requestNews() {
        //美港电讯用的是jsoup
        //1.USHKNEWS
//        ArrayList ushkNewsBeanByCallable = mUshkNewsGrabber.getUSHKNewsBeanDerectely();
        ArrayList ushkNewsBeanByCallable = mUshkNewsGrabber.getUSHKNewsBeanByCallable();
        if (ushkNewsBeanByCallable == null) {
            return;
        }
        for (int i = 0; i < ushkNewsBeanByCallable.size(); i++) {
            USHKNewsBean uSHKNewsBean = (USHKNewsBean) ushkNewsBeanByCallable.get(i);
            String text = uSHKNewsBean.getText();
            String time = uSHKNewsBean.getTime();
            mNewsBeanList.add(uSHKNewsBean);
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                mRecyclerView.setLayoutManager(manager);
                newsAdapter = new Jin10RecyclerViewAdapter(getContext(), mNewsBeanList, mRecyclerView, manager);
                newsAdapter.setmOnItemClickListener(new Jin10RecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (mNewsBeanList.size() <= 0) {
                            Log.i("deng", "onItemClick no data, return");
                            return;
                        }

                        USHKNewsBean item = newsAdapter.getItem(position);

                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        Log.i("deng", "onItemLongClick ");


                    }
                });
                newsAdapter.notifyDataSetChanged();
                mRecyclerView.setAdapter(newsAdapter);
//                mSwipeRefreshLayout.setRefreshing(false);

            }
        });
//        ushkNewsBeanByCallable.clear();
        mSwipeRefreshLayout.setRefreshing(false);
    }


}
