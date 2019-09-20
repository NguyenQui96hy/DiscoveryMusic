package com.utehy.discovermusic.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.utehy.discovermusic.R;
import com.utehy.discovermusic.ui.fragment.dashborad.GalleryViewModel;

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
}
