package cn.intersteller.darkintersteller.innerfragment.search;

import android.app.Activity;

import androidx.fragment.app.Fragment;

public class AttachFragment extends Fragment {

    public Activity mContext;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.mContext = activity;
    }


}
