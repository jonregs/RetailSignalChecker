package com.tmobile.pr.mytmobile.ui.common;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tmobile.pr.mytmobile.AnalyticsModel;
import com.tmobile.pr.mytmobile.R;

import timber.log.Timber;

/**
 * Wrapper class for toolbar
 * Includes All toolbar specific functions
 * NOTE : Before instantiating make sure that @layout/toolbar is included in activity_layout.xml
 * Created by Mukesh on 10/7/2017.
 */

public class BaseToolbar {
    private Toolbar toolbar;
    private ToolbarClickListener listener;
    private AppCompatActivity context;

    private ImageView homeIcon;
    private ImageView messageIcon;
    private TextView toolbarTitle;
    private AnalyticsModel analyticsModel;

    public BaseToolbar(AppCompatActivity appCompatActivity) {
        this.context = appCompatActivity;
        //getToolbar();
    }

    /**
     * Initialise and return toolbar
     *
     * @return
     */
    public Toolbar getToolbar() {
        if (toolbar == null) {
            toolbar = context.findViewById(R.id.global_header);
            toolbar.getBackground().setAlpha(0);

            getHomeIcon();
            getMessageIcon();
            getToolbarTitle();
            setHomeClickListener();
            setMessageClickListener();
        }
        return toolbar;
    }

    private void setMessageClickListener() {
        getMessageIcon().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onMessageIconClick();
                analyticsModel = new AnalyticsModel();
                analyticsModel.setHeader_id("global_header");
                analyticsModel.setUi_element_type("header");
                analyticsModel.setIcon_id("messaging_icon");
                analyticsModel.setIcon_name("Messaging Icon");
                analyticsModel.setUi_element_type("icon");
                analyticsModel.setElement_location("header");

            }
        });
    }

    private void setHomeClickListener() {
        getHomeIcon().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onHomeIconClick();
                analyticsModel = new AnalyticsModel();
                analyticsModel.setHeader_id("global_header");
                analyticsModel.setUi_element_type("header");
                analyticsModel.setIcon_id("home_icon");
                analyticsModel.setIcon_name("Home");
                analyticsModel.setUi_element_type("icon");
                analyticsModel.setElement_location("header");
            }
        });

    }

    /**
     * Initialise and return Home Icon for toolbar
     *
     * @return
     */
    public View getHomeIcon() {
        if (homeIcon == null) {
            homeIcon = context.findViewById(R.id.home_icon);
        }
        return homeIcon;
    }

    /**
     * Initialise and return Message Icon for toolbar
     *
     * @return
     */
    public View getMessageIcon() {
        if (messageIcon == null)
            messageIcon = context.findViewById(R.id.message_icon);
        return messageIcon;
    }

    /**
     * Initialise and return Title for toolbar
     *
     * @return
     */
    public TextView getToolbarTitle() {
        if (toolbarTitle == null) {
            toolbarTitle = context.findViewById(R.id.toolbar_title);
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
    public void setToolbarIconColor(@ColorRes int color) {
        int tint = ContextCompat.getColor(context, color);
        setVectorColor(homeIcon.getDrawable(), tint);
        setVectorColor(messageIcon.getDrawable(), tint);
    }

    /**
     * Change color of drawable based on color
     *
     * @param drawable
     * @param color
     */
    public void setVectorColor(Drawable drawable, int color) {
        DrawableCompat.setTint(drawable, color);
    }

    public void setBackgroundOpacity(int opacity) {
        getToolbar().getBackground().mutate().setAlpha(opacity);
    }

    public void setListener(ToolbarClickListener listener) {
        this.listener = listener;
    }

    public interface ToolbarClickListener {
        void onHomeIconClick();

        void onMessageIconClick();
    }
}
