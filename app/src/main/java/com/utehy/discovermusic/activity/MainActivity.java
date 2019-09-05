package com.utehy.discovermusic.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.utehy.discovermusic.R;
import com.utehy.discovermusic.base.BaseActivity;
import com.utehy.discovermusic.fragment.MainFragment;
import com.utehy.discovermusic.permissions.PermissionCallback;
import com.utehy.discovermusic.permissions.PermissionUtils;
import com.utehy.discovermusic.widgets.slidingup.SlidingUpPanelLayout;

public class MainActivity extends BaseActivity {
    private SlidingUpPanelLayout panelLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        setEvent();
    }


    private void setEvent() {
        setPanelSlideListeners(panelLayout);
        replaceFragment(R.id.container, MainFragment.newInstance());
        checkPermissionAndThenLoad();
    }

    private void initComponent() {
        panelLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);

    }

    public void setPanelSlideListeners(SlidingUpPanelLayout panelLayout) {
        panelLayout.setPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {

            @Override
            public void onPanelSlide(View panel, float slideOffset) {
//                View nowPlayingCard = QuickControlsFragment.topContainer;
//                nowPlayingCard.setAlpha(1 - slideOffset);
            }

            @Override
            public void onPanelCollapsed(View panel) {
//                View nowPlayingCard = QuickControlsFragment.topContainer;
//                nowPlayingCard.setAlpha(1);
            }

            @Override
            public void onPanelExpanded(View panel) {
//                View nowPlayingCard = QuickControlsFragment.topContainer;
//                nowPlayingCard.setAlpha(0);
            }

            @Override
            public void onPanelAnchored(View panel) {

            }

            @Override
            public void onPanelHidden(View panel) {

            }
        });
    }


    /**
     * Kiểm tra quyền truy cập
     */

    private void checkPermissionAndThenLoad() {
        //check for permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (PermissionUtils.checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE) && PermissionUtils.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                if (PermissionUtils.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    Snackbar.make(panelLayout, "Timber will need to read external storage to display songs on your device.",
                            Snackbar.LENGTH_INDEFINITE)
                            .setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    PermissionUtils.askForPermission(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, permissionReadstorageCallback);
                                }
                            }).show();
                } else {
                    PermissionUtils.askForPermission(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, permissionReadstorageCallback);
                }
            }
        }
    }
    private final PermissionCallback permissionReadstorageCallback = new PermissionCallback() {
        @Override
        public void permissionGranted() {
        }

        @Override
        public void permissionRefused() {
            finish();
        }
    };

}
