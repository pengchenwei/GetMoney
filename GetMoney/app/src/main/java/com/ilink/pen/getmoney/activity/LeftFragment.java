package com.ilink.pen.getmoney.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ilink.pen.getmoney.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {

    public LeftFragment() {
        // Required empty public constructor
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void onAttach(Context context) {
        Log.e("LeftFragment", "onAttach()");
        super.onAttach(context);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("LeftFragment", "onCreate()");
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("LeftFragment", "onCreateView()");
        return inflater.inflate(R.layout.fragment_left, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e("LeftFragment", "onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.e("LeftFragment", "onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e("LeftFragment", "onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("LeftFragment", "onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e("LeftFragment", "onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e("LeftFragment", "onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("LeftFragment", "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("LeftFragment", "onDetach()");
        super.onDetach();
    }

}
