package com.cjm.test2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjm.test2.R;
import com.cjm.test2.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cjm on 2019/3/24.
 */

public class DiscoverFragment extends Fragment {
    private View view;
    private List<Fragment> fragments;
    private List<String> tabs;
    private TabLayout mTableLayout;
    private ViewPager mViewPager;
    private FragmentManager mFragmentManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.discover_fragment,container,false);
        initView();
        initData();
        initListen();
        mFragmentManager=getChildFragmentManager();
        mViewPager.setAdapter(new MyViewPagerAdapter(mFragmentManager,fragments,tabs));
        mViewPager.setCurrentItem(0);
        mTableLayout.setupWithViewPager(mViewPager);
        return view;
    }

    private void initListen() {
    }

    private void initData() {
        tabs=new ArrayList<>();
        tabs.add("本校");
        tabs.add("热点");
        tabs.add("娱乐");
        tabs.add("科技");
        tabs.add("财经");
        tabs.add("军事");
        tabs.add("体育");
        tabs.add("国际");
        fragments= new ArrayList<>();
        fragments.add(new RecommendFragment());
        fragments.add(new HotspotFragment());
        fragments.add(new RecreationFragment());
        fragments.add(new SecienceFragment());
        fragments.add(new FinancialFragment());
        fragments.add(new MilitaryFragment());
        fragments.add(new SportsFragment());
        fragments.add(new InternationalFragment());
    }

    private void initView() {
        mTableLayout=view.findViewById(R.id.discover_tabs);
        mViewPager=view.findViewById(R.id.discover_vg);
    }
}
