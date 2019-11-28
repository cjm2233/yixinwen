package com.cjm.test2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cjm.test2.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by cjm on 2019/3/24.
 */

public class MyFragment extends Fragment {
    private View view;
    private Button mFavourite, mTime, mMessage;
    private Button mButton1, mButton2, mButton3, mButton4, mButton5, mButton6;
    private CircleImageView mCircleImageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.my_fragment, container, false);
        initView();
        initData();
        initListen();
        return view;
    }

    private void initData() {
        mCircleImageView.setImageResource(R.mipmap.ic_head);
    }

    private void initListen() {

    }

    private void initView() {
        mButton1 = view.findViewById(R.id.my_button1);
        mButton2 = view.findViewById(R.id.my_button2);
        mButton3 = view.findViewById(R.id.my_button3);
        mButton4 = view.findViewById(R.id.my_button4);
        mButton5 = view.findViewById(R.id.my_button5);
        mButton6 = view.findViewById(R.id.my_button6);
        mFavourite = view.findViewById(R.id.my_favorite);
        mMessage = view.findViewById(R.id.my_message);
        mTime = view.findViewById(R.id.my_time);
        mCircleImageView = view.findViewById(R.id.my_image);
    }
}
