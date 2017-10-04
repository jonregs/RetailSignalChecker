package com.tmobile.pr.mytmobile.di;

import com.tmobile.pr.mytmobile.viewmodel.UserListViewModel;

import dagger.Subcomponent;

/**
 * A sub component to create ViewModels.
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }
    UserListViewModel userListViewModel();
}
