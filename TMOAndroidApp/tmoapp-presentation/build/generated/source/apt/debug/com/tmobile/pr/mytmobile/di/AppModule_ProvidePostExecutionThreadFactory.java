package com.tmobile.pr.mytmobile.di;

import com.tmobile.pr.mytmobile.UIThread;
import com.tmobile.pr.mytmobile.domain.executor.PostExecutionThread;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvidePostExecutionThreadFactory
    implements Factory<PostExecutionThread> {
  private final AppModule module;

  private final Provider<UIThread> uiThreadProvider;

  public AppModule_ProvidePostExecutionThreadFactory(
      AppModule module, Provider<UIThread> uiThreadProvider) {
    assert module != null;
    this.module = module;
    assert uiThreadProvider != null;
    this.uiThreadProvider = uiThreadProvider;
  }

  @Override
  public PostExecutionThread get() {
    return Preconditions.checkNotNull(
        module.providePostExecutionThread(uiThreadProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PostExecutionThread> create(
      AppModule module, Provider<UIThread> uiThreadProvider) {
    return new AppModule_ProvidePostExecutionThreadFactory(module, uiThreadProvider);
  }

  /** Proxies {@link AppModule#providePostExecutionThread(UIThread)}. */
  public static PostExecutionThread proxyProvidePostExecutionThread(
      AppModule instance, UIThread uiThread) {
    return instance.providePostExecutionThread(uiThread);
  }
}
