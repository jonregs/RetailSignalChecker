package com.tmobile.pr.mytmobile.login;

import android.content.Intent;
import android.view.View;

import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.home.HomeActivity;
import com.tmobile.pr.mytmobile.ui.BaseActivity;

/**
 * Created by asaifudeen on 10/1/17.
 */

public class LoginActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    public void onLoginClicked(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
