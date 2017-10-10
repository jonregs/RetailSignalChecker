package com.tmobile.pr.mytmobile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by asaifudeen on 10/9/17.
 */

public class AnalyticsModel {
    private String page_id;
    private String page_name;
    private String page_uuid;
    private String ui_element_type;
    private String header_id;
    private String icon_id;
    private String icon_name;
    private String footer_id;
    private String element_location;

    public void setPage_id(String page_id) {
        this.page_id = page_id;
    }

    public void setPage_name(String page_name) {
        this.page_name = page_name;
    }

    public void setPage_uuid(String page_uuid) {
        this.page_uuid = page_uuid;
    }

    public void setUi_element_type(String ui_element_type) {
        this.ui_element_type = ui_element_type;
    }

    public void setHeader_id(String header_id) {
        this.header_id = header_id;
    }

    public void setIcon_id(String icon_id) {
        this.icon_id = icon_id;
    }

    public void setIcon_name(String icon_name) {
        this.icon_name = icon_name;
    }

    public void setFooter_id(String footer_id) {
        this.footer_id = footer_id;
    }

    public void setElement_location(String element_location) {
        this.element_location = element_location;
    }

    @Override
    public String toString() {

        return new Gson().toJson(this);
    }
}
