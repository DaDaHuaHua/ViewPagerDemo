package com.example.sh.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {


    private ViewPager mViewPager;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }


    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void initData() {
        mFragments.add(new MyLazyFragment01().setNumber(1));
        mFragments.add(new MyLazyFragment02().setNumber(2));
        mFragments.add(new MyLazyFragment03().setNumber(3));
        mFragments.add(new CommonFragment().setNumber(4));
        mFragments.add(new CommonFragment().setNumber(5));
        mFragments.add(new CommonFragment().setNumber(6));
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mFragments));
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

}
