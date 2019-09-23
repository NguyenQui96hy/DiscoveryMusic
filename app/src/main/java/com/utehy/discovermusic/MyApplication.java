package com.utehy.discovermusic;

import android.app.Application;
import android.os.Build;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.L;
import com.utehy.discovermusic.utils.PreferencesUtility;
import com.utehy.discovermusic.utils.permission.Nammu;

import java.io.IOException;
import java.io.InputStream;

//import com.utehy.discovermusic.permissions.PermissionUtils;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration localImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(this).imageDownloader(new BaseImageDownloader(this) {
            PreferencesUtility prefs = PreferencesUtility.getInstance(MyApplication.this);


            @Override
            protected InputStream getStreamFromNetwork(String imageUri, Object extra) throws IOException {
                if (prefs.loadArtistAndAlbumImages())
                    return super.getStreamFromNetwork(imageUri, extra);
                throw new IOException();
            }
        }).build();

        ImageLoader.getInstance().init(localImageLoaderConfiguration);
        L.writeLogs(false);
        L.disableLogging();
        L.writeDebugLogs(false);
        Nammu.init(this);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
////            PermissionUtils.init(this);
//        }
//    }
//}
    }
}