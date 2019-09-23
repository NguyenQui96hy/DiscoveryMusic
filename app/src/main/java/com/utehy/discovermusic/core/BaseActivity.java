package com.utehy.discovermusic.core;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        setEvent();
        setComponent();
    }

    public abstract int initLayout();

    public abstract void setEvent();

    public abstract void setComponent();

    public abstract void showToolbar(boolean isShowToolBar);





}
