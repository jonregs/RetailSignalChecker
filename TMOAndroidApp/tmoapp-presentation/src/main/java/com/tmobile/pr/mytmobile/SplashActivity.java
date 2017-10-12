package com.tmobile.pr.mytmobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tmobile.pr.mytmobile.login.LoginActivity;

/**
 * Created by prokarma on 10/6/2017.
 */

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 200;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
