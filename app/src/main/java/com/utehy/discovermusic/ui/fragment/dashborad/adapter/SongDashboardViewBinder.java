package com.utehy.discovermusic.ui.fragment.dashborad.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.joooonho.SelectableRoundedImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.utehy.discovermusic.R;
import com.utehy.discovermusic.model.Song;
import com.utehy.discovermusic.utils.TimberUtils;
import com.vmodev.cibes.widget.CustomFontTextView;


public class SongDashboardViewBinder extends ItemViewBinder<Song, SongDashboardViewBinder.SongDashBoardHoder> {

    @NonNull
    @Override
    public SongDashBoardHoder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_song_dash_board, parent, false);
        return new SongDashBoardHoder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull SongDashBoardHoder holder, @NonNull Song item) {
        if (!TextUtils.isEmpty(item.artistName)) {
            holder.tvNameSong.setText(item.artistName);
        }
        if (!TextUtils.isEmpty(item.albumName)) {
            holder.tvAlbum.setText(item.albumName);
        }
        ImageLoader.getInstance().displayImage(TimberUtils.getAlbumArtUri(item.albumId).toString(),
                holder.imageSong, new DisplayImageOptions.Builder().cacheInMemory(true)
                        .showImageOnLoading(R.drawable.ic_empty_music2)
                        .resetViewBeforeLoading(true).build());

    }

    static class SongDashBoardHoder extends RecyclerView.ViewHolder {
        private @Nullable
        CustomFontTextView tvNameSong;
        private @Nullable
        CustomFontTextView tvAlbum;
        private @Nullable
        SelectableRoundedImageView imageSong;

        SongDashBoardHoder(@NonNull View itemView) {
            super(itemView);
            this.tvNameSong = itemView.findViewById(R.id.tvNameSong);
            this.tvAlbum = itemView.findViewById(R.id.tvAlbum);
            this.imageSong = itemView.findViewById(R.id.imageSong);
        }
    }
}

