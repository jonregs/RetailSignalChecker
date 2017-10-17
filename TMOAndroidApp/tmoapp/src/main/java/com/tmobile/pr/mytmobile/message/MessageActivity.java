package com.tmobile.pr.mytmobile.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.home.view.HomeActivity;
import com.tmobile.pr.mytmobile.common.BaseActivity;
import com.tmobile.pr.mytmobile.common.BaseToolbar;

/**
 * Activity for customer chat
 */
public class MessageActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getToolbar().setToolbarIconColor(R.color.black);
        getToolbar().getToolbarTitle().setText(R.string.chat);
        getToolbar().setListener(new BaseToolbar.ToolbarClickListener() {
            @Override
            public void onHomeIconClick() {
                Intent intent = new Intent(MessageActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("isHome", true);
                startActivity(intent);
            }

            @Override
            public void onMessageIconClick() {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected boolean setUpToolbar() {
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
