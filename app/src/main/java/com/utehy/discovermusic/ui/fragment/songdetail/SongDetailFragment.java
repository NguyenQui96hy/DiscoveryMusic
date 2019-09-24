package com.utehy.discovermusic.ui.fragment.songdetail;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.MultiTypeAdapter;
import com.utehy.discovermusic.R;
import com.utehy.discovermusic.core.BaseFragment;
import com.utehy.discovermusic.model.Song;
import com.utehy.discovermusic.ui.fragment.dashborad.adapter.SongDashboardViewBinder;
import com.vmodev.cibes.widget.CustomFontTextView;

import java.util.ArrayList;
import java.util.List;

public class SongDetailFragment extends BaseFragment {
    private CustomFontTextView customFontTextView;
    private RecyclerView rvDataSong;
    private ArrayList<Song> songList;
    private List<Object> items;
    private MultiTypeAdapter multiTypeAdapter;

    @Override
    public int initLayout() {
        return R.layout.fragment_song_detail;
    }

    @Override
    public void initMappingScreen(View view) {
        customFontTextView = view.findViewById(R.id.toolbarTitle);
        rvDataSong = view.findViewById(R.id.rvDataSong);
        songList = getArguments().getParcelableArrayList("LIST_ALL_SONG");
    }


    @Override
    public void initComponent() {
        customFontTextView.setText("Danh sách bài hát");
        registerAdapter();
    }

    @Override
    public void setEvent() {
        getBaseActivity().showToolbar(false);


    }

    @Override
    public void bundleData(Bundle bundle) {

    }

    public void registerAdapter() {
        items = new ArrayList<>();
        multiTypeAdapter = new MultiTypeAdapter();
        multiTypeAdapter.register(Song.class, new SongDashboardViewBinder());
        items.addAll(songList);
        multiTypeAdapter.setItems(items);
        rvDataSong.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvDataSong.setAdapter(multiTypeAdapter);


    }
}
