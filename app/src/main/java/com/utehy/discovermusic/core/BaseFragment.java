package com.utehy.discovermusic.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(initLayout(), container, false);
        initMappingScreen(root);
        initComponent();
        setEvent();
        return root;
    }

    public abstract int initLayout();

    public abstract void initMappingScreen(View view);

    public abstract void initComponent();

    public abstract void setEvent();


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public BaseActivity getBaseActivity() {
        return ((BaseActivity) getActivity());
    }
}
