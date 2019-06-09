package com.capriquota.entech.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.capriquota.entech.R;
import com.capriquota.entech.signin.LoginActivity;

public class SignUpActivity extends AppCompatActivity {
    AppCompatTextView appCompatTextViewLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        appCompatTextViewLoginLink = findViewById(R.id.appCompatTextViewLoginLink);
        appCompatTextViewLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
