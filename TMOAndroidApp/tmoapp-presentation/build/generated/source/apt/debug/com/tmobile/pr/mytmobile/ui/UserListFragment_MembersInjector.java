package com.tmobile.pr.mytmobile.ui;

import android.arch.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserListFragment_MembersInjector implements MembersInjector<UserListFragment> {
  private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

  public UserListFragment_MembersInjector(
      Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    assert viewModelFactoryProvider != null;
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<UserListFragment> create(
      Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    return new UserListFragment_MembersInjector(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(UserListFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.viewModelFactory = viewModelFactoryProvider.get();
  }

  public static void injectViewModelFactory(
      UserListFragment instance, Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    instance.viewModelFactory = viewModelFactoryProvider.get();
  }
}
