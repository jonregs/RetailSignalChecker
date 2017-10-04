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

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.tmobile.pr.mytmobile.R;

/**
 * A base activity that handles common functionality in the app.
 */
public abstract class BaseActivity extends AppCompatActivity {
  // Toolbar
  private Toolbar mToolbar;
  private TextView mToolbarTitle;

  @Override
  public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    getToolbar();
  }

  public Toolbar getToolbar() {
    if (mToolbar == null) {
      mToolbar = (Toolbar) findViewById(R.id.toolbar);
      if (mToolbar != null) {
        setSupportActionBar(mToolbar);
        mToolbarTitle = (TextView) mToolbar.findViewById(R.id.toolbar_title);
        if (mToolbarTitle != null) {
          int titleId = getNavigationTitleId();
          if (titleId != 0) {
            mToolbarTitle.setText(titleId);
          }
        }

        // We use our own toolbar title, so hide the default one
        getSupportActionBar().setDisplayShowTitleEnabled(false);
      }
    }
    return mToolbar;
  }

  protected int getNavigationTitleId() {
    return 0;
  }
}
