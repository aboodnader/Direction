package com.smart.abdelrahmanalabed.direction;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ScreenSlidePageFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate( R.layout.fragment_layout, container, false);

        TextView tv = (TextView) rootView.findViewById(R.id.text);
        tv.setText(getArguments().getString("msg"));

        return rootView;
    }

    public static ScreenSlidePageFragment newInstance(String text) {

        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("msg", text);
        fragment.setArguments(bundle);
        return fragment;
    }

}
