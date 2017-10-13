package com.tmobile.pr.mytmobile.viewmodel;

import com.tmobile.pr.mytmobile.di.ViewModelSubComponent;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ViewModelFactory_Factory implements Factory<ViewModelFactory> {
  private final Provider<ViewModelSubComponent> viewModelSubComponentProvider;

  public ViewModelFactory_Factory(Provider<ViewModelSubComponent> viewModelSubComponentProvider) {
    assert viewModelSubComponentProvider != null;
    this.viewModelSubComponentProvider = viewModelSubComponentProvider;
  }

  @Override
  public ViewModelFactory get() {
    return new ViewModelFactory(viewModelSubComponentProvider.get());
  }

  public static Factory<ViewModelFactory> create(
      Provider<ViewModelSubComponent> viewModelSubComponentProvider) {
    return new ViewModelFactory_Factory(viewModelSubComponentProvider);
  }
}
