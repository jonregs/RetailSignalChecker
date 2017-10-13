package com.tmobile.pr.mytmobile.data.entity.mapper;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserEntityDataMapper_Factory implements Factory<UserEntityDataMapper> {
  private static final UserEntityDataMapper_Factory INSTANCE = new UserEntityDataMapper_Factory();

  @Override
  public UserEntityDataMapper get() {
    return new UserEntityDataMapper();
  }

  public static Factory<UserEntityDataMapper> create() {
    return INSTANCE;
  }

  /** Proxies {@link UserEntityDataMapper#UserEntityDataMapper()}. */
  public static UserEntityDataMapper newUserEntityDataMapper() {
    return new UserEntityDataMapper();
  }
}
