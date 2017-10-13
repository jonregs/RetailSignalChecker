package com.tmobile.pr.mytmobile.mapper;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserModelDataMapper_Factory implements Factory<UserModelDataMapper> {
  private static final UserModelDataMapper_Factory INSTANCE = new UserModelDataMapper_Factory();

  @Override
  public UserModelDataMapper get() {
    return new UserModelDataMapper();
  }

  public static Factory<UserModelDataMapper> create() {
    return INSTANCE;
  }
}
