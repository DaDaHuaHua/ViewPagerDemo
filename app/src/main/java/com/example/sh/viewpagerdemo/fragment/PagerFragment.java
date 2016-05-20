package com.example.sh.viewpagerdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sh on 2016/5/13.
 * 实现友盟统计的Fragment
 * getData()方法需要手动调用
 */
public abstract class PagerFragment extends BaseFragment {

    //当前Fragment是否为可见状态
    protected boolean isVisible;
    private boolean isPreparedStart;
    private boolean isPreparedEnd;
    private boolean isFirstStart;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //此处置为true为了过滤onCreate()之前调用的setUserVisibleHint()
        isPreparedStart = true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //为了解决从第三张滑向第二张的时候重复调用的问题
        isPreparedEnd = true;
        //此处置为true，与onDestoryView()中置为flase对应
        isPreparedStart = true;
        /**
         * 为了解决第一次加载时会走一次onResume导致重复执行umengSatrt()，在此先置为false。
         * 不可用isVisible代替，LazyFragment中会用到
         */
        isFirstStart = false;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isPreparedStart = false;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            isVisible = true;
            isFirstStart = true;
            umengStart();
            isPreparedEnd = true;

        } else {
            if (isPreparedStart && isPreparedEnd) {
                isVisible = false;
                isFirstStart = false;
                umengEnd();
                isPreparedEnd = false;

            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (isFirstStart) {
            umengEnd();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isFirstStart) {
            umengStart();
        }
    }

    protected abstract void umengStart();

    protected abstract void umengEnd();
}
