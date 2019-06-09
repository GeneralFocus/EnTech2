package com.capriquota.entech.signin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.capriquota.entech.R;
import com.capriquota.entech.home.DashActivity;
import com.capriquota.entech.signup.SignUpActivity;

public class LoginActivity extends AppCompatActivity {
    AppCompatButton appCompatButtonRegister;
    AppCompatTextView appCompatTextViewLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        appCompatButtonRegister = findViewById(R.id.appCompatButtonRegister);
        appCompatButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, DashActivity.class);
                startActivity(i);
                finish();
            }
            });
        appCompatTextViewLoginLink = findViewById(R.id.appCompatTextViewLoginLink);
        appCompatTextViewLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
