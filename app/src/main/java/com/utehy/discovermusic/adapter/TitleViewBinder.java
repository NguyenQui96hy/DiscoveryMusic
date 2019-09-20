package com.utehy.discovermusic.adapter;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.utehy.discovermusic.R;
import com.utehy.discovermusic.adapter.models.ItemTitle;
import com.vmodev.cibes.widget.CustomFontTextView;


public class TitleViewBinder extends ItemViewBinder<ItemTitle, TitleViewBinder.TitleHolder> {

    @NonNull
    @Override
    public TitleHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_title_song, parent, false);
        return new TitleHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull TitleHolder holder, @NonNull ItemTitle item) {
        if(!TextUtils.isEmpty(item.getTitle())){
            holder.tvTitle.setText(item.getTitle());
        }
    }

    static class TitleHolder extends RecyclerView.ViewHolder {
        private @Nullable
        CustomFontTextView tvTitle;
        TitleHolder(@NonNull View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }


}