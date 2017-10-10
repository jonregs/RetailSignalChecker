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

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import com.tmobile.pr.mytmobile.R;

import timber.log.Timber;

/**
 * A base activity that handles common functionality in the app.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();
    // Toolbar
    private Toolbar toolbar;
    private ImageView homeIcon;
    private ImageView messageIcon;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        setContentView(getLayoutId());
        super.onCreate(savedInstanceState);
        getToolbar();
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected Toolbar getToolbar() {
        if (toolbar == null) {
            toolbar = findViewById(R.id.global_header);
            if (toolbar != null) {
                Timber.i(TAG, "Toolbar:" + toolbar);
                setSupportActionBar(toolbar);
                // We use our own toolbar title, so hide the default one
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                toolbar.getBackground().setAlpha(0);
                getHomeIcon();
                getMessageIcon();
                getToolbarTitle();
                setUpIcons();
            }
        }
        return toolbar;
    }

    private void setUpIcons() {

    /*homeIcon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(getApplicationContext(), R.string.home_navigate, Toast.LENGTH_SHORT).show();
      }
    });


    messageIcon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(getApplicationContext(), R.string.customer_navigate, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);

      }
    });*/

        //TODO change from child activity
        //setToolbarIconColor(R.color.magenta);
    }


    protected View getHomeIcon() {
        if (homeIcon == null)
            homeIcon = findViewById(R.id.home_icon);
        return homeIcon;
    }

    protected View getMessageIcon() {
        if (homeIcon == null)
            messageIcon = findViewById(R.id.message_icon);
        return messageIcon;
    }

    protected View getToolbarTitle() {
        toolbarTitle = toolbar.findViewById(R.id.toolbar_title);
        if (toolbarTitle != null) {
            int titleId = getNavigationTitleId();
            if (titleId != 0) {
                toolbarTitle.setText(titleId);
            }
        }
        return toolbarTitle;
    }

    protected int getNavigationTitleId() {
        return 0;
    }

    /**
     * Change the color of Icons in toolbar
     *
     * @param color int value of color resource
     */
    private void changeToolbarIconColor(@ColorRes int color) {
        int tint = ContextCompat.getColor(this, color);
        changeVectorColor(homeIcon.getDrawable(), tint);
        changeVectorColor(messageIcon.getDrawable(), tint);
    }

    /**
     * Change color of drawable based on color
     *
     * @param drawable
     * @param color
     */
    public void changeVectorColor(Drawable drawable, int color) {
        DrawableCompat.setTint(drawable, color);
    }
}
