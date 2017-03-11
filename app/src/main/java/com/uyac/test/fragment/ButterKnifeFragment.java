package com.uyac.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.uyac.test.R;
import com.uyac.test.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/2.
 */

public class ButterKnifeFragment extends Fragment{

    @BindView(R.id.textView)
    TextView textView;

    @BindView(R.id.button)
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_butter_knife,null);
        ButterKnife.bind(getActivity(),view);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @OnClick({R.id.textView,R.id.button})
    public void onFragmentClick(View view)
    {
        switch (view.getId())
        {
            case R.id.textView:

                ToastUtils.show(getActivity(),"textView");

                break;
            case R.id.button:

                ToastUtils.show(getActivity(),"button");

                break;

        }
    }


}
