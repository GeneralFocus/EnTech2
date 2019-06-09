package com.capriquota.entech.signin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.capriquota.entech.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
