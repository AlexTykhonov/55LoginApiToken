package com.tae.a55loginapitoken;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class App extends Application {
    private static SharedPreferences sharedPreferences;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferences getSharedPreferences() {return sharedPreferences;
    }

    public static Context getContext() {
        return context;
    }
}
