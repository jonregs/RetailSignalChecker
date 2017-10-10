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

package com.tmobile.pr.mytmobile.ui.common;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * BaseInjecting Fragment class which implements LifeCycleFragment Components.
 */
public abstract class BaseInjectingFragment extends Fragment {
  View view;
  @Override
  @CallSuper
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
      view = inflater.inflate(getLayoutId(), container, false);
    return view;
  }

  @LayoutRes
  protected abstract int getLayoutId();

  protected View getFragmentView(){
    return view;
  }
}
