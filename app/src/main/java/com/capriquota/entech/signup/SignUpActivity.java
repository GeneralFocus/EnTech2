package com.capriquota.entech.signup;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.capriquota.entech.R;

public class SignUpActivity extends AppCompatActivity {


    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initRegistration();
    }

    public void initRegistration(){
        registerBtn = (Button)findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(SignUpActivity.this);
                alert.setTitle("App");
                alert.setMessage("Testing button");

                AlertDialog alertDialog = alert.create();
                alertDialog.show();
            }
        });
    }
}
