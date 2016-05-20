package com.example.sh.viewpagerdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sh.viewpagerdemo.fragment.BaseFragment;
import com.example.sh.viewpagerdemo.fragment.PagerFragment;

/**
 * Created by sh on 2016/5/12.
 */
public class MyPagerFragment02 extends PagerFragment {
    private int mNumber;
    private TextView mTextView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("TAG", "Fragment02--onAttach ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAG", "Fragment02--onCreate ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("TAG", "Fragment02--onCreateView");
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("TAG", "Fragment02--onActivityCreated");
        getData();
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i("TAG", "Fragment02--onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("TAG","Fragment02--onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("TAG","Fragment02--onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("TAG","Fragment02--onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("TAG","Fragment02--onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("TAG","Fragment02--onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("TAG","Fragment02--onDetach");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("TAG","Fragment02--isVisible=="+isVisibleToUser);
    }

    @Override
    protected void umengStart() {
        Log.i("TAG","Fragment02-------------UmengStart");
    }

    @Override
    protected void umengEnd() {
        Log.i("TAG","Fragment02-------------UmengEnd");

    }

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
        mTextView.setText("这是第" + mNumber + "个------MyPagerFragment02");
    }



    public Fragment setNumber(int no) {
        this.mNumber = no;
        return this;
    }
}
