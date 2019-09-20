package com.utehy.discovermusic.remote;

import com.utehy.discovermusic.model.LastfmAlbum;

public interface AlbumInfoListener {

    void albumInfoSuccess(LastfmAlbum album);

    void albumInfoFailed();

}
