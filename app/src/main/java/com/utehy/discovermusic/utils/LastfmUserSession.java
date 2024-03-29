package com.utehy.discovermusic.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.annotations.SerializedName;

public class LastfmUserSession {
    private static final String USERNAME = "name";
    private static final String TOKEN = "key";
    private static LastfmUserSession session;


    public static LastfmUserSession getSession(Context context) {
        if (session != null) return session;
        SharedPreferences preferences = context.getSharedPreferences("Lastfm", Context.MODE_PRIVATE);
        session = new LastfmUserSession();
        session.mToken = preferences.getString(TOKEN, null);
        session.mUsername = preferences.getString(USERNAME, null);
        return session;
    }

    public boolean isLogedin(){
        return session.mToken != null && session.mUsername != null;
    }

    public void update(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("Lastfm", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (this.mToken == null || this.mUsername == null) {
            editor.clear();
        } else {
            editor.putString(TOKEN, this.mToken);
            editor.putString(USERNAME, this.mUsername);
        }
        editor.apply();
    }

    @SerializedName(USERNAME)
    public String mUsername;

    @SerializedName(TOKEN)
    public String mToken;
}
