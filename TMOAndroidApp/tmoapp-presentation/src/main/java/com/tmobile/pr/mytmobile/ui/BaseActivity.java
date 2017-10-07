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


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tmobile.pr.mytmobile.ui.common.BaseToolbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tmobile.pr.mytmobile.R;

/**
 * A base activity that handles common functionality in the app.
 * Created by Srikanth Roopa on 09/29/2017
 */
//TODO Implement the common functionalities like mToolbar customization, material bottomnavigationview in the base activity.
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    @Nullable
    protected BaseToolbar mToolbar;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        setContentView(getLayoutId());
        super.onCreate(savedInstanceState);
        initToolbar(setUpToolbar());

    }

    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * Specify toolbar requirement
     * NOTE : Before instantiating make sure that @layout/toolbar is included in activity_layout.xml
     */
    protected abstract boolean setUpToolbar();

    private void initToolbar(boolean isExist){
        if (isExist){
            mToolbar = new BaseToolbar(this);
            Log.i(TAG, "Toolbar Initialised:"+ mToolbar);

            setSupportActionBar(mToolbar.getToolbar());
            // We use our own mToolbar title, so hide the default one
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

}
