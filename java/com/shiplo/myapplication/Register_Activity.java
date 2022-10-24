package com.shiplo.myapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Register_Activity extends AppCompatActivity {

    private boolean passwordShowing = false;
    private boolean conpasswordShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText emailEt = findViewById(R.id.emailEt);
        final EditText mobileEt = findViewById(R.id.mobileEt);

        final EditText passwordEt = findViewById(R.id.passwordEt);
        final EditText conpasswordEt = findViewById(R.id.conpasswordEt);
        final ImageView passwordIcon = findViewById(R.id.passwordIcon);
        final ImageView conpasswordIcon = findViewById(R.id.conpasswordIcon);

        final AppCompatButton signupBtn = findViewById(R.id.signupBtn);
        final TextView signinBtn = findViewById(R.id.signinBtn);


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

        conpasswordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (conpasswordShowing){
                    conpasswordShowing = false;

                    conpasswordEt.setInputType(InputType.TYPE_CLASS_TEXT| InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    conpasswordIcon.setImageResource(R.drawable.password_show);
                }
                else {
                    conpasswordShowing = true;

                    conpasswordEt.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    conpasswordIcon.setImageResource(R.drawable.hide_password);
                }

                conpasswordEt.setSelection(conpasswordEt.length());


            }
        });


        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getMobileTxt = mobileEt.getText().toString();
                final String getEmailTxt = emailEt.getText().toString();

                //opening otp verification activity along mobile and email///

                Intent myIntent = new Intent(Register_Activity.this, OTP_Verification.class);

                myIntent.putExtra("mobileEt", "getMobileTxt");
                myIntent.putExtra("emailEt", "getEmailTxt");

                startActivity(myIntent);
            }
        });


        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}