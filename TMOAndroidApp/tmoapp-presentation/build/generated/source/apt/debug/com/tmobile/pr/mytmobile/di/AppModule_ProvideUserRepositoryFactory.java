package com.tmobile.pr.mytmobile.di;

import com.tmobile.pr.mytmobile.data.repository.UserDataRepository;
import com.tmobile.pr.mytmobile.domain.repository.UserRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideUserRepositoryFactory implements Factory<UserRepository> {
  private final AppModule module;

  private final Provider<UserDataRepository> userDataRepositoryProvider;

  public AppModule_ProvideUserRepositoryFactory(
      AppModule module, Provider<UserDataRepository> userDataRepositoryProvider) {
    assert module != null;
    this.module = module;
    assert userDataRepositoryProvider != null;
    this.userDataRepositoryProvider = userDataRepositoryProvider;
  }

  @Override
  public UserRepository get() {
    return Preconditions.checkNotNull(
        module.provideUserRepository(userDataRepositoryProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<UserRepository> create(
      AppModule module, Provider<UserDataRepository> userDataRepositoryProvider) {
    return new AppModule_ProvideUserRepositoryFactory(module, userDataRepositoryProvider);
  }

  /** Proxies {@link AppModule#provideUserRepository(UserDataRepository)}. */
  public static UserRepository proxyProvideUserRepository(
      AppModule instance, UserDataRepository userDataRepository) {
    return instance.provideUserRepository(userDataRepository);
  }
}
