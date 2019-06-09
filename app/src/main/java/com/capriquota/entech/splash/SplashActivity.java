package com.capriquota.entech.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.capriquota.entech.R;
import com.capriquota.entech.slides.SlidesActivity;

public class SplashActivity extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SlidesActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_up, R.anim.push_down);
                finish();
            }
        }, 3000);
    }
}
