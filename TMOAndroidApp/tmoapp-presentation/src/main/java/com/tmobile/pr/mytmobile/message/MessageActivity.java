package com.tmobile.pr.mytmobile.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.home.HomeActivity;
import com.tmobile.pr.mytmobile.ui.BaseActivity;
import com.tmobile.pr.mytmobile.ui.common.BaseToolbar;

public class MessageActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setToolbarIconColor(R.color.black);
        toolbar.getToolbarTitle().setText("Chat");
        toolbar.setListener(new BaseToolbar.ToolbarClickListener() {
            @Override
            public void onHomeIconClick() {
                Intent intent = new Intent(MessageActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                intent.putExtra("isHome",true);
                startActivity(intent);
            }

            @Override
            public void onMessageIconClick() {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

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
