package com.example.sh.viewpagerdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by sh on 2016/5/13.
 * 懒加载Fragment,当Fragment显示在用户界面上才开始加载数据，同时实现了友盟统计功能
 *
 */
public abstract class LazyFragment extends PagerFragment {

    private boolean isActivityCreated;
    private boolean isFirstLoad = true;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isActivityCreated = true;
        isFirstLoad = true;
        lazyLoad();
    }

    /**
     * 此方法仅会在onActivityCreated中执行一次，setUserVisibleHint中仅为了不让其重复执行
     * 实现懒加载必须满足三个条件
     * （1）isVisible -- 当前Fragment是否显示在屏幕上
     * （2）isActivityCreated -- 在onActivityCreated之前会走setUserVisibleHint，需要将其过滤掉
     * （3）isFirstLoad -- 执行过一次后不需要再次执行
     */
    protected void lazyLoad(){
        if(isVisible && isActivityCreated && isFirstLoad){
            getData();
            isFirstLoad = false;
        }
    }
}
