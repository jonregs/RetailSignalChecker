package com.tmobile.pr.mytmobile.data.executor;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class JobExecutor_Factory implements Factory<JobExecutor> {
  private static final JobExecutor_Factory INSTANCE = new JobExecutor_Factory();

  @Override
  public JobExecutor get() {
    return new JobExecutor();
  }

  public static Factory<JobExecutor> create() {
    return INSTANCE;
  }

  /** Proxies {@link JobExecutor#JobExecutor()}. */
  public static JobExecutor newJobExecutor() {
    return new JobExecutor();
  }
}
