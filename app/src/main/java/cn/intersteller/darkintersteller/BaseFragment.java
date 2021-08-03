package cn.intersteller.darkintersteller;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public interface SendMessageToMainAcvtyCallBack {
        /**
         * 从fragment发送消息
         *
         * @param bundle 消息内容
         */
        void messageFromFragment(Bundle bundle);
    }

    public SendMessageToMainAcvtyCallBack mSendMessageToMainAcvtyCallBack;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mSendMessageToMainAcvtyCallBack = (SendMessageToMainAcvtyCallBack) context;
    }
}
