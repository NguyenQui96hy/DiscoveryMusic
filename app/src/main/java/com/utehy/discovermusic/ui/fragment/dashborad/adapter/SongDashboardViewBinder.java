package com.utehy.discovermusic.ui.fragment.dashborad.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.utehy.discovermusic.R;
import com.utehy.discovermusic.model.Song;
import com.vmodev.cibes.widget.CustomFontTextView;



public class SongDashboardViewBinder  extends ItemViewBinder<Song, SongDashboardViewBinder.SongDashBoardHoder> {

    @NonNull
    @Override
    public SongDashBoardHoder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_song_dash_board, parent, false);
        return new SongDashBoardHoder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull SongDashBoardHoder holder, @NonNull Song item) {

    }

    static class SongDashBoardHoder extends RecyclerView.ViewHolder {
        private @Nullable
        CustomFontTextView tvTitle;

        SongDashBoardHoder(@NonNull View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}

