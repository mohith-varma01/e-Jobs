package com.example.e_jobs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {
    EditText emailEditText;
    EditText passwordEditText;
    String emailAddress;
    String password;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        bindViews();
        mAuth = FirebaseAuth.getInstance();
    }

    private void bindViews()
    {
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
    }

    public void SignIn(View view) {
        if(emailEditText == null || emailEditText.getText() == null|| emailEditText.equals(""))
        {
            Toast.makeText(this, "Please enter valid email address", Toast.LENGTH_SHORT).show();
        }
        else
        {
            emailAddress = emailEditText.getText().toString();
            password = passwordEditText.getText().toString();
            mAuth.signInWithEmailAndPassword(emailAddress, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(SignUpActivity.TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(SignInActivity.this, USerProfilePageActivity.class);
                                intent.putExtra("email", user.getEmail());
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(SignUpActivity.TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(SignInActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                // ...
                            }
                        }
                    });

        }
    }

    public void SignUp(View view) {
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}