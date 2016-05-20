package com.example.sh.viewpagerdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sh on 2016/5/13.
 * 基类Fragment
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        initViews(rootView);
        return rootView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getExtras();
    }

    /**
     * 实现getIntent().getExtra()
     */
    protected abstract void getExtras();

    /**
     * @return 返回布局id
     */
    protected abstract int getLayoutId();

    /**
     * 实现findViewById的方法
     * @param rootview
     * @return
     */
    protected abstract void initViews(View rootview);


    protected abstract void getData();


    /**
     * 等于<code>findViewById(id)</code>，已经处理过强转，不需要再处理
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T $(View v, int id) {
        return (T) v.findViewById(id);
    }

    /**
     * 为单个或者多个View <code>setOnClickListener(this)</code>
     */
    protected void $c(View v, int... ids) {
        for (int id : ids) {
            v.findViewById(id).setOnClickListener(this);
        }
    }

    /**
     * 1.<code>findViewById(id)</code><br>
     * 2.<code>setOnClickListener(this)</code><br>
     * 3.返回强转过的View
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T $r(View v, int id) {
        T t = (T) v.findViewById(id);
        t.setOnClickListener(this);
        return t;
    }

    @Override
    public void onClick(View v) {

    }
}
