package com.tmobile.pr.mytmobile.message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.ui.BaseActivity;

public class MessageActivity extends BaseActivity {
    @Override
    protected void onResume() {
        super.onResume();
        mToolbar.setToolbarIconColor(R.color.black);
        mToolbar.getToolbarTitle().setText("Chat");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected boolean setUpToolbar() {
        return true;
    }
}
