package com.tmobile.pr.mytmobile;

import android.app.Activity;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TMobileApplication_MembersInjector
    implements MembersInjector<TMobileApplication> {
  private final Provider<DispatchingAndroidInjector<Activity>> dispatchingAndroidInjectorProvider;

  public TMobileApplication_MembersInjector(
      Provider<DispatchingAndroidInjector<Activity>> dispatchingAndroidInjectorProvider) {
    assert dispatchingAndroidInjectorProvider != null;
    this.dispatchingAndroidInjectorProvider = dispatchingAndroidInjectorProvider;
  }

  public static MembersInjector<TMobileApplication> create(
      Provider<DispatchingAndroidInjector<Activity>> dispatchingAndroidInjectorProvider) {
    return new TMobileApplication_MembersInjector(dispatchingAndroidInjectorProvider);
  }

  @Override
  public void injectMembers(TMobileApplication instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.dispatchingAndroidInjector = dispatchingAndroidInjectorProvider.get();
  }

  public static void injectDispatchingAndroidInjector(
      TMobileApplication instance,
      Provider<DispatchingAndroidInjector<Activity>> dispatchingAndroidInjectorProvider) {
    instance.dispatchingAndroidInjector = dispatchingAndroidInjectorProvider.get();
  }
}
