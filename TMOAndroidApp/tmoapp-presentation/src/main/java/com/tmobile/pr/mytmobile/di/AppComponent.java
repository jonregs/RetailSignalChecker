package com.tmobile.pr.mytmobile.di;

import android.app.Application;

import com.tmobile.pr.mytmobile.TMobileApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
    AndroidInjectionModule.class,
    AppModule.class,
    MainActivityModule.class
})
interface AppComponent {
    void inject(TMobileApplication tMobileApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
