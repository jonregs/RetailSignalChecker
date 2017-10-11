package com.tmobile.pr.mytmobile.di;

import android.arch.lifecycle.ViewModelProvider;

import com.tmobile.pr.mytmobile.UIThread;
import com.tmobile.pr.mytmobile.data.executor.JobExecutor;
import com.tmobile.pr.mytmobile.data.repository.UserDataRepository;
import com.tmobile.pr.mytmobile.domain.executor.PostExecutionThread;
import com.tmobile.pr.mytmobile.domain.executor.ThreadExecutor;
import com.tmobile.pr.mytmobile.domain.repository.UserRepository;
import com.tmobile.pr.mytmobile.viewmodel.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = ViewModelSubComponent.class)
class AppModule {

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
        ViewModelSubComponent.Builder viewModelSubComponent) {

        return new ViewModelFactory(viewModelSubComponent.build());
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }
}
