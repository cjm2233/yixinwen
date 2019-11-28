package com.cjm.test2;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cjm.test2.adapter.MyViewPagerAdapter;
import com.cjm.test2.fragment.AttentionFragment;
import com.cjm.test2.fragment.DiscoverFragment;
import com.cjm.test2.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragments;
    private List<String> tabs;
    private TabLayout mTableLayout;
    private ViewPager mViewPager;
    private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //状态栏中的文字颜色和图标颜色，需要android系统6.0以上，而且目前只有一种可以修改（一种是深色，一种是浅色即白色）
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //修改为深色，因为我们把状态栏的背景色修改为主题色白色，默认的文字及图标颜色为白色，导致看不到了。
            this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        initView();
        initData();
        mFragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new MyViewPagerAdapter(mFragmentManager,fragments,tabs));
        mViewPager.setCurrentItem(0);
        mTableLayout.setupWithViewPager(mViewPager);
    }

    private void initView() {
        mTableLayout=findViewById(R.id.main_tabs);
        mViewPager=findViewById(R.id.main_vg);
    }

    private void initData() {
        fragments= new ArrayList<>();
        fragments.add(new AttentionFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new MyFragment());
        tabs=new ArrayList<>();
        tabs.add("关注");
        tabs.add("发现");
        tabs.add("个人");
    }
}
