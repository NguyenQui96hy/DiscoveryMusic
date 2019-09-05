package com.utehy.discovermusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.utehy.discovermusic.R;
import com.utehy.discovermusic.adapter.MainViewPagerAdapter;
import com.utehy.discovermusic.base.BaseFragment;


public class MainFragment extends BaseFragment {
    private ViewPager viewPager;
    public static MainFragment newInstance(){
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_main, container, false);
        initComponent(rootView);
        setEvent();
        return rootView;

    }

    public void initComponent(View rootView) {
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
            viewPager.setOffscreenPageLimit(2);
        }

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void setEvent() {

    }
    private void setupViewPager(ViewPager viewPager) {
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(SongsFragment.newInstance(), this.getString(R.string.str_song));
        adapter.addFragment(new DiscoverFragment(), this.getString(R.string.str_discover));
        adapter.addFragment(new SettingFragment(), this.getString(R.string.str_setting));
        viewPager.setAdapter(adapter);
    }
}
