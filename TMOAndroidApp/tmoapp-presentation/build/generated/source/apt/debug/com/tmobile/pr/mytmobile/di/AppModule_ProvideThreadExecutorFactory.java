package com.tmobile.pr.mytmobile.di;

import com.tmobile.pr.mytmobile.data.executor.JobExecutor;
import com.tmobile.pr.mytmobile.domain.executor.ThreadExecutor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideThreadExecutorFactory implements Factory<ThreadExecutor> {
  private final AppModule module;

  private final Provider<JobExecutor> jobExecutorProvider;

  public AppModule_ProvideThreadExecutorFactory(
      AppModule module, Provider<JobExecutor> jobExecutorProvider) {
    assert module != null;
    this.module = module;
    assert jobExecutorProvider != null;
    this.jobExecutorProvider = jobExecutorProvider;
  }

  @Override
  public ThreadExecutor get() {
    return Preconditions.checkNotNull(
        module.provideThreadExecutor(jobExecutorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ThreadExecutor> create(
      AppModule module, Provider<JobExecutor> jobExecutorProvider) {
    return new AppModule_ProvideThreadExecutorFactory(module, jobExecutorProvider);
  }

  /** Proxies {@link AppModule#provideThreadExecutor(JobExecutor)}. */
  public static ThreadExecutor proxyProvideThreadExecutor(
      AppModule instance, JobExecutor jobExecutor) {
    return instance.provideThreadExecutor(jobExecutor);
  }
}
