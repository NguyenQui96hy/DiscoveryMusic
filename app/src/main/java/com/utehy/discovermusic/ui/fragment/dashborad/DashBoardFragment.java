package com.utehy.discovermusic.ui.fragment.dashborad;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.MultiTypeAdapter;
import com.utehy.discovermusic.R;
import com.utehy.discovermusic.adapter.TitleViewBinder;
import com.utehy.discovermusic.adapter.models.ItemTitle;
import com.utehy.discovermusic.core.BaseFragment;
import com.utehy.discovermusic.utils.StoreDataRes;

import com.utehy.discovermusic.widget.slider.CustomSliderSlideShow;

import java.util.ArrayList;
import java.util.List;




public class DashBoardFragment extends BaseFragment {
    private CustomSliderSlideShow customSliderSlideShow;
    private RecyclerView rvDataSong;

    private List<Object> items;
    private MultiTypeAdapter multiTypeAdapter;


    @Override
    public int initLayout() {
        return R.layout.fragment_dashboard;
    }

    @Override
    public void initMappingScreen(View view) {
        customSliderSlideShow = view.findViewById(R.id.customSliderSlideShow);
        rvDataSong = view.findViewById(R.id.rvDataSong);

    }

    @Override
    public void initComponent() {
        customSliderSlideShow.setListImageURL(StoreDataRes.getListImageSlider());
        registerAdapter();


    }

    @Override
    public void setEvent() {

    }

    public void registerAdapter() {
        items = new ArrayList<>();
        multiTypeAdapter = new MultiTypeAdapter();
        multiTypeAdapter.register(ItemTitle.class, new TitleViewBinder());
        rvDataSong.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDataSong.setAdapter(multiTypeAdapter);
        items.add(new ItemTitle("Danh sách bài hát"));


        multiTypeAdapter.setItems(items);
        multiTypeAdapter.notifyDataSetChanged();


    }

}