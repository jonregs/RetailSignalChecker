/*
 *
 *  * Copyright 2017 TMobile. All rights reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.tmobile.pr.mytmobile.ui;

import android.arch.lifecycle.LifecycleFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * BaseInjecting Fragment class which implements LifeCycleFragment Components.
 */
//TODO we need to provide the injection through dagger.
public abstract class BaseInjectingFragment extends LifecycleFragment {

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override
  @CallSuper
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(getLayoutId(), container, false);
  }

  public abstract void onInject();

  @LayoutRes
  protected abstract int getLayoutId();
}
