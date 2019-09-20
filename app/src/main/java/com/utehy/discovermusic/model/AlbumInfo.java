package com.utehy.discovermusic.model;

import com.google.gson.annotations.SerializedName;

public class AlbumInfo {

    private static final String ALBUM = "album";


    @SerializedName(ALBUM)
    public LastfmAlbum mAlbum;
}
