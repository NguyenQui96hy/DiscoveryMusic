package com.utehy.discovermusic.ui.fragment.songdetail;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.utehy.discovermusic.R;
import com.utehy.discovermusic.core.BaseFragment;
import com.vmodev.cibes.widget.CustomFontTextView;

public class SongDetailFragment extends BaseFragment {
    private CustomFontTextView customFontTextView;
    private RecyclerView rvDataSong;

    @Override
    public int initLayout() {
        return R.layout.fragment_song_detail;
    }

    @Override
    public void initMappingScreen(View view) {
        customFontTextView = view.findViewById(R.id.toolbarTitle);
        rvDataSong = view.findViewById(R.id.rvDataSong);
    }

    @Override
    public void initComponent() {
        customFontTextView.setText("Danh sách bài hát");
    }

    @Override
    public void setEvent() {
        getBaseActivity().showToolbar(false);


    }
}
