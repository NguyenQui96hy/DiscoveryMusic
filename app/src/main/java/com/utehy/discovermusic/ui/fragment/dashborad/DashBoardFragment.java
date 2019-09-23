package com.utehy.discovermusic.ui.fragment.dashborad;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.MultiTypeAdapter;
import com.utehy.discovermusic.R;
import com.utehy.discovermusic.adapter.TitleViewBinder;
import com.utehy.discovermusic.adapter.models.ItemTitle;
import com.utehy.discovermusic.core.BaseFragment;
import com.utehy.discovermusic.data.SongLoader;
import com.utehy.discovermusic.model.Song;
import com.utehy.discovermusic.ui.fragment.dashborad.adapter.SongDashboardViewBinder;
import com.utehy.discovermusic.utils.StoreDataRes;

import com.utehy.discovermusic.widget.slider.CustomSliderSlideShow;

import java.util.ArrayList;
import java.util.List;

import static androidx.navigation.Navigation.findNavController;


public class DashBoardFragment extends BaseFragment implements View.OnClickListener {
    private CustomSliderSlideShow customSliderSlideShow;
    private RecyclerView rvDataSong;

    private List<Object> items;
    private MultiTypeAdapter multiTypeAdapter;
    private LinearLayout llLoadMore;
     NavController navController ;

    @Override
    public int initLayout() {
        return R.layout.fragment_dashboard;
    }

    @Override
    public void initMappingScreen(View view) {
        customSliderSlideShow = view.findViewById(R.id.customSliderSlideShow);
        rvDataSong = view.findViewById(R.id.rvDataSong);
        llLoadMore = view.findViewById(R.id.llLoadMore);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = findNavController(view);

    }

    @Override
    public void initComponent() {
        customSliderSlideShow.setListImageURL(StoreDataRes.getListImageSlider());
        registerAdapter();
        reloadAdapter();


    }

    @Override
    public void setEvent() {
        llLoadMore.setOnClickListener(this);

    }

    public void registerAdapter() {
        items = new ArrayList<>();
        multiTypeAdapter = new MultiTypeAdapter();
        multiTypeAdapter.register(Song.class, new SongDashboardViewBinder());
        rvDataSong.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvDataSong.setAdapter(multiTypeAdapter);
//        items.add(new ItemTitle("Danh sách bài hát"));
        llLoadMore.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nav_gallery_to_songDetailFragment, null));


    }

    private void reloadAdapter() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(final Void... unused) {
                items.addAll(SongLoader.getAllSongs(getActivity()));
                multiTypeAdapter.setItems(items);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                multiTypeAdapter.notifyDataSetChanged();
            }
        }.execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llLoadMore:
                navController.navigate(R.id.action_nav_gallery_to_songDetailFragment);

                break;
        }
    }

    private class loadSongs extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            if (getActivity() != null) {
                items.addAll(SongLoader.getAllSongs(getActivity()));
            }


            return null;
        }

        @Override
        protected void onPostExecute(String result) {

//            if (getActivity() != null)
//                recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        }

        @Override
        protected void onPreExecute() {
        }
    }

}