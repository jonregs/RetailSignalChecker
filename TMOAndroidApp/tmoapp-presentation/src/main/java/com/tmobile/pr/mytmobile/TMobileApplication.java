package com.tmobile.pr.mytmobile;

import android.app.Activity;
import android.app.Application;

import com.tmobile.pr.mytmobile.di.AppInjector;
import com.tmobile.pr.mytmobile.util.TimberAppLog;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

public class TMobileApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        //Timber Integration
        if (BuildConfig.DEBUG) {
            Timber.plant(new TimberAppLog());
        }
        AppInjector.init(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
