package com.example.e_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneNumberSignIn extends AppCompatActivity{

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private EditText phoneNumber;
    private EditText otp;
    private Button sendOTP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_sign_in);

        bindViews();
    }

    private void bindViews()
    {
        phoneNumber = findViewById(R.id.phone_button);
        otp = findViewById(R.id.otp);
        sendOTP = findViewById(R.id.sendOTP);
    }

    public void onCLickSendOtp(View view)
    {
//        PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                phoneNumber,                      // Phone number to verify
//                60,                               // Timeout duration
//                TimeUnit.SECONDS,                // Unit of timeout
//                activity,                       // Activity (for callback binding)
//                getVerificationCallback());
    }


}