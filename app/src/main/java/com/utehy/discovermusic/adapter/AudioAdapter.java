package com.utehy.discovermusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.utehy.discovermusic.R;
import com.utehy.discovermusic.models.Audio;

import java.util.Collections;
import java.util.List;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.ViewHolder> {

    List<Audio> list = Collections.emptyList();
    Context context;

    public AudioAdapter(List<Audio> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView play_pause;

        ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            play_pause = (ImageView) itemView.findViewById(R.id.play_pause);
        }
    }
}

