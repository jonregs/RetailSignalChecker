package com.tmobile.pr.mytmobile.model;

/**
 * Created by jonegalado on 10/4/17, Gimmyo Project.
 */

public class Model {

    private String title;
    private String body;

    public Model(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
