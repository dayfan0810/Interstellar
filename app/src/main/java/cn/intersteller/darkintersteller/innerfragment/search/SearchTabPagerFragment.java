package cn.intersteller.darkintersteller.innerfragment.search;

import android.os.Bundle;
import android.util.Log;
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

public class SearchTabPagerFragment extends AttachFragment {
    private String TAG = "SearchTabPagerFragment";


    private ViewPager fragment_searchtabpager_viewPager;
    private TabLayout fragment_searchtabpager_tab;

    SearchTabPagerFragment searchTabPagerFragment;
    private List<String> mTitleList = new ArrayList<>(4);
    private List<Fragment> fragments = new ArrayList<>(4);
    private NeteaseFragment neteaseFragment;
    private QQFragment qqFragment;
    private View v;
    String submit_string;

//    public SearchTabPagerFragment newInstance(String submit_string) {
//
//        if (searchTabPagerFragment == null) {
//            searchTabPagerFragment = new SearchTabPagerFragment();
//        }
//        //把在NetSearchActivity中query的字符串放到这个fragment的new中
//        //然后再加载布局时就searchAll
//        Bundle bdl = new Bundle(1);
//        bdl.putString("submit_string", submit_string);
//        searchTabPagerFragment.setArguments(bdl);
//        return searchTabPagerFragment;
//    }


    public SearchTabPagerFragment(String submit_string) {
        Log.i("searchsearch----SearchTabPagerFragment", submit_string);

//        if (searchTabPagerFragment == null) {
            searchTabPagerFragment = new SearchTabPagerFragment();
            this.submit_string = submit_string;
            //把在NetSearchActivity中query的字符串放到这个fragment的new中
            //然后再加载布局时就searchAll
            Bundle bdl = new Bundle(1);
            bdl.putString("submit_string", submit_string);
            setArguments(bdl);
//        }
    }

    public SearchTabPagerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_searchtabpager, container, false);
        fragment_searchtabpager_tab = v.findViewById(R.id.fragment_searchtabpager_tab);
        fragment_searchtabpager_viewPager = v.findViewById(R.id.fragment_searchtabpager_viewPager);

        addView();
        SearchTabPagerFragment.MyAdapter myAdapter = new SearchTabPagerFragment.MyAdapter(getChildFragmentManager());
        myAdapter.notifyDataSetChanged();
        fragment_searchtabpager_viewPager.setAdapter(myAdapter);
        fragment_searchtabpager_viewPager.setOffscreenPageLimit(2);
        fragment_searchtabpager_tab.setTabMode(TabLayout.MODE_FIXED);
        fragment_searchtabpager_tab.setupWithViewPager(fragment_searchtabpager_viewPager);
        return v;
    }

    private void addView() {
        mTitleList.add("网易云");
        mTitleList.add("QQ");
        if (getArguments() != null) {
            String submit_string = getArguments().getString("submit_string");
            Log.i("deng222222", "submit_string = " + submit_string);
            if (neteaseFragment == null) {
                neteaseFragment = new NeteaseFragment(submit_string);
                fragments.add(neteaseFragment);
            }
            if (qqFragment == null) {
                qqFragment = new QQFragment(submit_string);
                fragments.add(qqFragment);
            }
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

