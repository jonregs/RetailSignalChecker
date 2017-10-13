package com.tmobile.pr.mytmobile.viewmodel;

import android.app.Application;
import com.tmobile.pr.mytmobile.domain.interactor.browse.GetUserList;
import com.tmobile.pr.mytmobile.mapper.UserModelDataMapper;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserListViewModel_Factory implements Factory<UserListViewModel> {
  private final MembersInjector<UserListViewModel> userListViewModelMembersInjector;

  private final Provider<Application> applicationProvider;

  private final Provider<GetUserList> getUserListUserCaseProvider;

  private final Provider<UserModelDataMapper> userModelDataMapperProvider;

  public UserListViewModel_Factory(
      MembersInjector<UserListViewModel> userListViewModelMembersInjector,
      Provider<Application> applicationProvider,
      Provider<GetUserList> getUserListUserCaseProvider,
      Provider<UserModelDataMapper> userModelDataMapperProvider) {
    assert userListViewModelMembersInjector != null;
    this.userListViewModelMembersInjector = userListViewModelMembersInjector;
    assert applicationProvider != null;
    this.applicationProvider = applicationProvider;
    assert getUserListUserCaseProvider != null;
    this.getUserListUserCaseProvider = getUserListUserCaseProvider;
    assert userModelDataMapperProvider != null;
    this.userModelDataMapperProvider = userModelDataMapperProvider;
  }

  @Override
  public UserListViewModel get() {
    return MembersInjectors.injectMembers(
        userListViewModelMembersInjector,
        new UserListViewModel(
            applicationProvider.get(),
            getUserListUserCaseProvider.get(),
            userModelDataMapperProvider.get()));
  }

  public static Factory<UserListViewModel> create(
      MembersInjector<UserListViewModel> userListViewModelMembersInjector,
      Provider<Application> applicationProvider,
      Provider<GetUserList> getUserListUserCaseProvider,
      Provider<UserModelDataMapper> userModelDataMapperProvider) {
    return new UserListViewModel_Factory(
        userListViewModelMembersInjector,
        applicationProvider,
        getUserListUserCaseProvider,
        userModelDataMapperProvider);
  }
}
