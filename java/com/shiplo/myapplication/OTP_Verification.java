package com.shiplo.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OTP_Verification extends AppCompatActivity {


    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable s) {

         if (s.length() > 0){
             if (selectedEtPosition == 0){

                 selectedEtPosition = 1;
                 showKeyboard(otp2);

             }
             else if (selectedEtPosition == 1){
                 selectedEtPosition = 2;
                 showKeyboard(otp3);

             }
             else if (selectedEtPosition == 2){
                 selectedEtPosition = 3;
                 showKeyboard(otp4);
             }
         }

        }
    };

    private EditText otp1, otp2, otp3, otp4;
    private TextView resendBtn;

    ///true after 60 seconds///
    private boolean resendEnabled = false;

    /// resend time in seconds///
    private int resendTime = 60;

    private int selectedEtPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);

        resendBtn = findViewById(R.id.resendBtn);
        final Button verifyBtn = findViewById(R.id.verifyBtn);


        final String getEmail = getIntent().getStringExtra("email");
        final String getMobile = getIntent().getStringExtra("mobile");

        /// setting email and mobile to text view//

        otp1.addTextChangedListener(textWatcher);
        otp2.addTextChangedListener(textWatcher);
        otp3.addTextChangedListener(textWatcher);
        otp4.addTextChangedListener(textWatcher);


        ///by default open keyboard///

        showKeyboard(otp1);

        /// start countdown timer//
        startCountDownTime();

        resendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (resendEnabled){
                    ///handle your resend code here//


                    /// start new countdown time///

                    startCountDownTime();

                }



            }
        });


        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String generateOtp = otp1.getText().toString()+otp2.getText().toString()+otp3.getText().toString()+otp4.getText().toString();

                if (generateOtp.length()==4);

                ///// handle your verification here//


            }
        });


    }

    private void showKeyboard(EditText otpEt){
        otpEt.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(otpEt, InputMethodManager.SHOW_IMPLICIT);
    }

    private void startCountDownTime(){
        resendEnabled = false;
        resendBtn.setTextColor(Color.parseColor("#99000000"));

        new CountDownTimer(resendTime *1000, 1000){



            @Override
            public void onTick(long millisUntilFinished) {

                resendBtn.setText("Resend Code ("+(millisUntilFinished / 1000)+")");

            }

            @Override
            public void onFinish() {

                resendEnabled = true;
                resendBtn.setText("Resend Code");
                resendBtn.setTextColor(getResources().getColor(R.color.teal_200));

            }
        }.start();
    }



    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_DEL) {
            if ( selectedEtPosition == 3){
                selectedEtPosition = 2;
                showKeyboard(otp3);
            }


            else if( selectedEtPosition == 2){
                 selectedEtPosition = 1;

                 showKeyboard(otp2);
            }

            else if(selectedEtPosition == 1){

                selectedEtPosition = 0;
                showKeyboard(otp1);
            }

            return true;

        }
        else {
            return super.onKeyUp(keyCode, event);

        }



    }
}