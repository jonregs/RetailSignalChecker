package com.tmobile.pr.mytmobile.ui.common;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tmobile.pr.mytmobile.AnalyticsModel;
import com.tmobile.pr.mytmobile.R;

/**
 * Wrapper class for toolbar
 * Includes All toolbar specific functions
 * NOTE : Before instantiating make sure that @layout/toolbar is included in activity_layout.xml
 */

public class BaseToolbar {
    private final AppCompatActivity activity;
    private Toolbar toolbar;
    private ToolbarClickListener listener;
    private ImageView homeIcon;
    private ImageView messageIcon;
    private TextView toolbarTitle;
    private AnalyticsModel analyticsModel;

    public BaseToolbar(AppCompatActivity appCompatActivity) {
        this.activity = appCompatActivity;
    }

    /**
     * Change the color of Icons in toolbar
     *
     * @param color int value of color resource
     */
    @Nullable
    public void setToolbarIconColor(@ColorRes int color) {
        int tint = ContextCompat.getColor(activity, color);
        setVectorColor(homeIcon.getDrawable(), tint);
        setVectorColor(messageIcon.getDrawable(), tint);
    }

    /**
     * Change color of drawable based on color
     *
     * @param drawable to change color
     * @param color    to be changed
     */
    public void setVectorColor(Drawable drawable, int color) {
        DrawableCompat.setTint(drawable, color);
    }

    public void setBackgroundOpacity(int opacity) {
        getToolbar().getBackground().mutate().setAlpha(opacity);
    }

    /**
     * Initialise and return toolbar
     *
     * @return Toolbar object for appbar
     */
    public Toolbar getToolbar() {
        if (toolbar == null) {
            toolbar = activity.findViewById(R.id.global_header);
            toolbar.getBackground().setAlpha(0);

            getHomeIcon();
            getMessageIcon();
            getToolbarTitle();
            setHomeClickListener();
            setMessageClickListener();
        }
        return toolbar;
    }

    /**
     * Initialise and return Home Icon for toolbar
     *
     * @return HomeIcon from toolbar
     */
    public View getHomeIcon() {
        if (homeIcon == null) {
            homeIcon = activity.findViewById(R.id.home_icon);
        }
        return homeIcon;
    }

    /**
     * Initialise and return Message Icon for toolbar
     *
     * @return Message Icon from toolbar
     */
    public View getMessageIcon() {
        if (messageIcon == null) {
            messageIcon = activity.findViewById(R.id.message_icon);
        }
        return messageIcon;
    }

    /**
     * Initialise and return Title for toolbar
     *
     * @return Toolbar title TextView
     */
    public TextView getToolbarTitle() {
        if (toolbarTitle == null) {
            toolbarTitle = activity.findViewById(R.id.toolbar_title);
        }
        return toolbarTitle;
    }

    /**
     * Sets homeClickListener to ToolbarListener.
     * Sets analytics Data for home btn click.
     */
    private void setHomeClickListener() {
        getHomeIcon().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onHomeIconClick();
                }
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
     * Sets messageClickListener to ToolbarListener.
     * Sets analytics Data for home btn click.
     */
    private void setMessageClickListener() {
        getMessageIcon().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onMessageIconClick();
                }
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

    public void setListener(ToolbarClickListener listener) {
        this.listener = listener;
    }

    /**
     * Interface for implementing toolbar icon clicks
     */
    public interface ToolbarClickListener {
        void onHomeIconClick();

        void onMessageIconClick();
    }
}
