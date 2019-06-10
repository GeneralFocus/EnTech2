package com.capriquota.entech.signup;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.capriquota.controllers.registerUser;
import com.capriquota.entech.R.id;
import com.capriquota.entech.R.layout;
import com.capriquota.entech.R.string;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {


    /**
     *
     * Define our required variables
     */
    Button registerBtn;
    AppCompatEditText fullName , email , password , confirmPassword;
    HashMap <Integer , String> store = new HashMap<Integer, String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_sign_up);

        this.initRegistration();
    }


    /**
     *  @method initRegistration: starts all the registration process and process to dashboard on
     *  successful registration
     */
    public void initRegistration(){


        this.registerBtn = this.findViewById(id.registerBtn);
        this.fullName = this.findViewById(id.textName);
        this.email = this.findViewById(id.textEmail);
        this.password = this.findViewById(id.textPassword);
        this.confirmPassword = this.findViewById(id.textConfirmPassword);

        this.registerBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                String Name = SignUpActivity.this.fullName.getText().toString();
                String Email = SignUpActivity.this.email.getText().toString();
                String Password = SignUpActivity.this.password.getText().toString();
                String ConfirmPassword = SignUpActivity.this.confirmPassword.getText().toString();

                if(Name != ""
                        || Email != ""
                        || Password != ""
                        || ConfirmPassword !=""){


                    SignUpActivity.this.store.put(1 , Name);
                    SignUpActivity.this.store.put(2, Email);
                    SignUpActivity.this.store.put(3, Password);
                    SignUpActivity.this.store.put(4, ConfirmPassword);

                    new registerUser(SignUpActivity.this.store);
                }
                else{
                    Builder alertBuilder = new Builder(SignUpActivity.this);
                    alertBuilder.setTitle(string.error_title);
                    alertBuilder.setMessage(string.error_empty);


                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                }
            }
        });
    }
}
