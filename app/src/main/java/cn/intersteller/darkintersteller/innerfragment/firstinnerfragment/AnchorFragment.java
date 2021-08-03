package cn.intersteller.darkintersteller.innerfragment.firstinnerfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.outterfragment.BaseLazyFragment;

public class AnchorFragment extends BaseLazyFragment {
    private View v;

    @Override
    public void loadDataStart() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.anchorfragment, container, false);
        return v;
    }

    @Override
    protected void findViewById(View view) {

    }

    @Override
    protected View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

}
