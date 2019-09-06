package com.utehy.discovermusic.fragment;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.utehy.discovermusic.R;
import com.utehy.discovermusic.adapter.AudioAdapter;
import com.utehy.discovermusic.adapter.CustomTouchListener;
import com.utehy.discovermusic.adapter.onItemClickListener;
import com.utehy.discovermusic.base.BaseFragment;
import com.utehy.discovermusic.models.Audio;
import com.utehy.discovermusic.service.MediaPlayerService;
import com.utehy.discovermusic.utils.MediaUtils;
import com.utehy.discovermusic.utils.StorageUtil;

import java.util.ArrayList;
import java.util.List;

public class SongsFragment extends BaseFragment {
    public static final String Broadcast_PLAY_NEW_AUDIO = "com.valdioveliu.valdio.audioplayer.PlayNewAudio";


    private MediaPlayerService player;
    boolean serviceBound = false;
    private ArrayList<Audio> audioList;


    int imageIndex = 0;


    public static SongsFragment newInstance() {
        SongsFragment songsFragment = new SongsFragment();
        return songsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_song, container, false);
        audioList= MediaUtils.getMediaLocal(getActivity());

        initComponent(rootView);
        setEvent();
        return rootView;

    }

    public void initComponent(View rootView) {
        initRecyclerView(rootView);
    }


    public void setEvent() {

    }

    private void initRecyclerView(View view) {
        if (audioList.size() > 0) {
            RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
            AudioAdapter adapter = new AudioAdapter(audioList, getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.addOnItemTouchListener(new CustomTouchListener(getActivity(), new onItemClickListener() {
                @Override
                public void onClick(View view, int index) {
                    getBaseActivity().playAudio(index,audioList);
                }
            }));

        }
    }


}


