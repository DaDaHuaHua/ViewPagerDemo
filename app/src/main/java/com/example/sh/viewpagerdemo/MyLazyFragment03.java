package com.example.sh.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.sh.viewpagerdemo.fragment.LazyFragment;

/**
 * Created by sh on 2016/5/13.
 */
public class MyLazyFragment03 extends LazyFragment {
    private int mNumber;
    private TextView mTextView;
    @Override
    protected void getExtras() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_pager_fragment;
    }

    @Override
    protected void initViews(View rootView) {
        mTextView = (TextView) rootView.findViewById(R.id.text_no);
    }

    @Override
    protected void getData() {
        mTextView.setText("这是第" + mNumber + "个------MyLazyFragment03");
        Log.i("TAG" ,"getData--第 "+ mNumber + "个------MyLazyFragment03");
    }
    public Fragment setNumber(int no) {
        this.mNumber = no;
        return this;
    }

    @Override
    protected void umengStart() {
        Log.i("TAG","Lazy03--UmengStart");
    }

    @Override
    protected void umengEnd() {
        Log.i("TAG","Lazy03--UmengEnd");
    }
}
