package cn.intersteller.darkintersteller.outterfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.innerfragment.firstinnerfragment.AnchorFragment;
import cn.intersteller.darkintersteller.innerfragment.firstinnerfragment.HotMVFragment;
import cn.intersteller.darkintersteller.innerfragment.firstinnerfragment.MyPlaylistFragment;
import cn.intersteller.darkintersteller.innerfragment.firstinnerfragment.RecommendFragment;

public class FirstFragment extends Fragment {
    private String TAG = "FirstFragment";


    private ViewPager mDisco_viewPager;
    private TabLayout mDisco_tab;


    private List<String> mTitleList = new ArrayList<>(4);
    private List<Fragment> fragments = new ArrayList<>(4);
    private RecommendFragment recommendFragment;
//    private CloudPanFragment cloudPanFragment;
    private AnchorFragment anchorFragment;
    private HotMVFragment hotMusicFragment;
    private MyPlaylistFragment myPlaylistFragment;
    private View v;
    private static FirstFragment firstFragment;


    public static FirstFragment newInstance() {
        if (firstFragment == null) {
            firstFragment = new FirstFragment();
        }
        return firstFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.firstfragment, container, false);
        mDisco_tab = v.findViewById(R.id.disco_tab);
        mDisco_viewPager = v.findViewById(R.id.disco_viewPager);

        addView();
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        myAdapter.notifyDataSetChanged();
        mDisco_viewPager.setAdapter(myAdapter);
        mDisco_viewPager.setOffscreenPageLimit(2);
        mDisco_tab.setTabMode(TabLayout.MODE_FIXED);
        mDisco_tab.setupWithViewPager(mDisco_viewPager);
        return v;
    }

    private void addView() {
        mTitleList.add("我的歌单");
//        mTitleList.add("云盘");
        mTitleList.add("MV排行");
        mTitleList.add("个性推荐");
        mTitleList.add("常用明星");

        if (myPlaylistFragment == null) {
            myPlaylistFragment = new MyPlaylistFragment();
            fragments.add(myPlaylistFragment);
        }

//        if (cloudPanFragment == null) {
//            cloudPanFragment = new CloudPanFragment();
//            fragments.add(cloudPanFragment);
//        }
        if (hotMusicFragment == null) {
            hotMusicFragment = new HotMVFragment();
            fragments.add(hotMusicFragment);
        }
        if (recommendFragment == null) {
            recommendFragment = new RecommendFragment();
            fragments.add(recommendFragment);
        }
        if (anchorFragment == null) {
            anchorFragment = new AnchorFragment();
            fragments.add(anchorFragment);
        }


    }


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }


}
