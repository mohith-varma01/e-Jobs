package com.example.e_jobs.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.e_jobs.R;

public class ContactDocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_doc);
    }


    public void onClickTalktoDoc(View view)
    {
        Toast.makeText(this, "Kindly Contact helpline number", Toast.LENGTH_SHORT).show();
    }
}