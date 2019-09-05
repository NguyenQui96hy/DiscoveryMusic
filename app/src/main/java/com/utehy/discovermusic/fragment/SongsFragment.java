package com.utehy.discovermusic.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.utehy.discovermusic.R;
import com.utehy.discovermusic.models.Music;

import java.util.ArrayList;
import java.util.List;

public class SongsFragment extends Fragment {
    public static SongsFragment newInstance(){
        SongsFragment songsFragment = new SongsFragment();
        return  songsFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_song, container, false);
        initComponent(rootView);
        setEvent();
        return rootView;

    }

    public void initComponent(View rootView) {
        List<Music> datas= getMultiDatas(getActivity());
        Toast.makeText(getActivity(),datas.size()+"",Toast.LENGTH_LONG).show();

    }

    public void setEvent() {

    }
    public static ArrayList<Music> getMultiDatas(Context context) {
        ArrayList<Music> musics = new ArrayList<Music>();

        ContentResolver resolver = context.getContentResolver();
        Cursor musicCursor = resolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                null);
        int musicColumnIndex;
        Music music;

        if (null != musicCursor && musicCursor.getCount() > 0) {
            for (musicCursor.moveToFirst(); !musicCursor.isAfterLast(); musicCursor
                    .moveToNext()) {
                music = new Music();

                music.setId(musicCursor.getInt(musicCursor
                        .getColumnIndex("_id")));
                musicColumnIndex = musicCursor
                        .getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
                music.setMusicName(musicCursor.getString(musicColumnIndex));
                musicColumnIndex = musicCursor
                        .getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
                music.setSavePath(musicCursor.getString(musicColumnIndex));
                musicColumnIndex = musicCursor
                        .getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM);
                music.setAlbumName(musicCursor.getString(musicColumnIndex));
                musicColumnIndex = musicCursor
                        .getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);
                music.setSinger(musicCursor.getString(musicColumnIndex));
                musicColumnIndex = musicCursor
                        .getColumnIndex(MediaStore.Audio.AudioColumns.DURATION);
                music.setTime(musicCursor.getString(musicColumnIndex));
                musicColumnIndex = musicCursor
                        .getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM_KEY);
                music.setAlbumkey(musicCursor.getString(musicColumnIndex));
                musics.add(music);
            }
            musicCursor.close();
        }
        return musics;
    }
}
