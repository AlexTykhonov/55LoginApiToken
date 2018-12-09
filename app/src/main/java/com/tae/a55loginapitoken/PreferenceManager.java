package com.tae.a55loginapitoken;

import android.content.SharedPreferences;
import android.media.session.MediaSession;

public class PreferenceManager {

    public static SharedPreferences sharedPreferences;

    public PreferenceManager () {
        sharedPreferences = App.getSharedPreferences();
    }

    public static void setAuth(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", token);
        editor.apply();

    }
public static String getAuth(){

    return sharedPreferences.getString("token", null);

}
}
