package com.tmobile.pr.mytmobile.di;

import com.tmobile.pr.mytmobile.ui.UserListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract UserListFragment contributeProjectListFragment();
}
