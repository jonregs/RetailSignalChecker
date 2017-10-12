package com.tmobile.pr.mytmobile;

import android.app.Application;

import com.tmobile.pr.mytmobile.utils.TimberAppLog;

import timber.log.Timber;

public class TMobileApplication extends Application  {


    @Override
    public void onCreate() {
        super.onCreate();
        //Timber Integration
        if (BuildConfig.DEBUG) {
            Timber.plant(new TimberAppLog());
        }
    }
}
