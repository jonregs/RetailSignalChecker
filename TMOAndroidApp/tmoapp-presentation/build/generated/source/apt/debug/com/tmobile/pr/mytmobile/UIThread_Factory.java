package com.tmobile.pr.mytmobile;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UIThread_Factory implements Factory<UIThread> {
  private static final UIThread_Factory INSTANCE = new UIThread_Factory();

  @Override
  public UIThread get() {
    return new UIThread();
  }

  public static Factory<UIThread> create() {
    return INSTANCE;
  }

  /** Proxies {@link UIThread#UIThread()}. */
  public static UIThread newUIThread() {
    return new UIThread();
  }
}
