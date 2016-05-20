package com.example.sh.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sh on 2016/5/12.
 */
public class CommonFragment extends Fragment {

    private int mNumber;
    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_common_fragment, container, false);
        mTextView = (TextView) v.findViewById(R.id.text_no);
        mTextView.setText("这是第"+mNumber+"个-------普通Fragment");
        return v;
    }

    public Fragment setNumber(int no){
        this.mNumber = no;
        return this;
    }
}
