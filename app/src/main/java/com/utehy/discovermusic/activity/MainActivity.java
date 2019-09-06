package com.utehy.discovermusic.activity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.utehy.discovermusic.R;
import com.utehy.discovermusic.base.BaseActivity;
import com.utehy.discovermusic.fragment.MainFragment;
import com.utehy.discovermusic.permissions.PermissionCallback;
import com.utehy.discovermusic.permissions.PermissionUtils;
import com.utehy.discovermusic.service.MediaPlayerService;
import com.utehy.discovermusic.widgets.slidingup.SlidingUpPanelLayout;

public class MainActivity extends BaseActivity {
    private SlidingUpPanelLayout panelLayout;

    private MediaPlayerService player;
    boolean serviceBound = false;

    public static final String Broadcast_PLAY_NEW_AUDIO = "com.utehy.discovermusic.PlayNewAudio";


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


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            MediaPlayerService.LocalBinder binder = (MediaPlayerService.LocalBinder) service;
            player = binder.getService();
            serviceBound = true;

            Toast.makeText(MainActivity.this, "Service Bound", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            serviceBound = false;
        }
    };

    private void playAudio(String media) {
        //Check is service is active
        if (!serviceBound) {
            Intent playerIntent = new Intent(this, MediaPlayerService.class);
            playerIntent.putExtra("media", media);
            startService(playerIntent);
            bindService(playerIntent, serviceConnection, Context.BIND_AUTO_CREATE);
        } else {
            //Service is active
            //Send media with BroadcastReceiver
        }
    }

}
