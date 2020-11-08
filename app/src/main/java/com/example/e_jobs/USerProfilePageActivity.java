package com.example.e_jobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_jobs.FireBaseDrivers.UserDriver;
import com.example.e_jobs.Expert.UserExpert;

public class USerProfilePageActivity extends AppCompatActivity {

    private TextView textViewAboutUser;
    private TextView textViewRankUser;
    private ImageView imageViewUserProfileImage;
    private RecyclerView recyclerView;
    UserExpert userExpert;
    UserDriver userDriver;
    String email = "mohithvarmais@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_ser_profile_page);

        bindViews();
        spinner();
    }

    private void bindViews()
    {
        textViewAboutUser = findViewById(R.id.textView_aboutUser);
        //textViewRankUser = findViewById(R.id.textView_rank);
        imageViewUserProfileImage = findViewById(R.id.ImageView_UserProfileImage);
        //recyclerView = findViewById(R.id.recyclerView);
        userDriver = new UserDriver();
        userExpert = new UserExpert(userDriver);
        //certificateAdapter = new CertificateAdapter(this, userExpert,this, email );
    }

    private void spinner()
    {
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.names));
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onClickLearn(View view)
    {
        Intent intent = new Intent(this, LearnActivity.class);
        startActivity(intent);
    }

    public void onClickPractise(View view)
    {

    }
}