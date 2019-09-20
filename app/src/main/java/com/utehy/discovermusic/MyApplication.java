package com.utehy.discovermusic;

import android.app.Application;
import android.os.Build;

//import com.utehy.discovermusic.permissions.PermissionUtils;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            PermissionUtils.init(this);
        }
    }
}
