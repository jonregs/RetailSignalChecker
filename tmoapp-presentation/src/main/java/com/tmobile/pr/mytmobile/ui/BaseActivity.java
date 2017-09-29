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

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

/**
 * A base activity that handles common functionality in the app.
 * Created by Srikanth Roopa on 09/29/2017
 */
//TODO Implement the common functionalities like toolbar customization, material bottomnavigationview in the base activity.
public abstract class BaseActivity extends LifecycleActivity {

  @Override
  protected void onCreate(@Nullable final Bundle savedInstanceState) {
    setContentView(getLayoutId());
    super.onCreate(savedInstanceState);
  }

  @LayoutRes
  protected abstract int getLayoutId();

}
