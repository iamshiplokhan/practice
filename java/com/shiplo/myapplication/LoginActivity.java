package com.shiplo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private boolean passwordShowing = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEt = findViewById(R.id.usernameEt);
        final EditText passwordEt = findViewById(R.id.passwordEt);
        final ImageView passwordIcon = findViewById(R.id.passwordIcon);
        final TextView signupBtn = findViewById(R.id.signupBtn);


        passwordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordShowing){
                    passwordShowing = false;

                    passwordEt.setInputType(InputType.TYPE_CLASS_TEXT| InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.password_show);
                }
               else {
                   passwordShowing = true;

                    passwordEt.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.hide_password);
                }

               passwordEt.setSelection(passwordEt.length());

            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent myIntent = new Intent(LoginActivity.this, Register_Activity.class);
               startActivity(myIntent);
            }

        });
    }
}