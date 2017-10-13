package com.tmobile.pr.mytmobile.data.repository.datasource;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserDataStoreFactory_Factory implements Factory<UserDataStoreFactory> {
  private static final UserDataStoreFactory_Factory INSTANCE = new UserDataStoreFactory_Factory();

  @Override
  public UserDataStoreFactory get() {
    return new UserDataStoreFactory();
  }

  public static Factory<UserDataStoreFactory> create() {
    return INSTANCE;
  }
}
