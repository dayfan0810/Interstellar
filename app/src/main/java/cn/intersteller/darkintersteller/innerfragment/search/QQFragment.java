package cn.intersteller.darkintersteller.innerfragment.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cn.intersteller.darkintersteller.R;

public class QQFragment extends Fragment {
    private View v;
    QQFragment mQQFragment;

    public QQFragment(String submit_string) {
        if (mQQFragment == null) {
            mQQFragment = new QQFragment();
            //把在NetSearchActivity中query的字符串放到这个fragment的new中
            //然后再加载布局时就searchAll
            Bundle bdl = new Bundle(1);
            bdl.putString("submit_string", submit_string);
            mQQFragment.setArguments(bdl);
        }
    }

    public QQFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_qq_search, container, false);
        return v;
    }

}
