package com.example.e_jobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_jobs.Adapter.CertificateAdapter;
import com.example.e_jobs.Adapter.UserAdapter;

public class USerProfilePageActivity extends AppCompatActivity implements CertificateAdapter.OnRoomListerner {

    private TextView textViewAboutUser;
    private TextView textViewRankUser;
    private ImageView imageViewUserProfileImage;
    private RecyclerView recyclerView;
    CertificateAdapter certificateAdapter;
    UserExpert userExpert;
    UserAdapter userAdapter;
    String email = "mohithvarmais@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_ser_profile_page);

        bindViews();
        setupInitializer();
    }

    private void bindViews()
    {
        textViewAboutUser = findViewById(R.id.textView_aboutUser);
        //textViewRankUser = findViewById(R.id.textView_rank);
        imageViewUserProfileImage = findViewById(R.id.ImageView_UserProfileImage);
        recyclerView = findViewById(R.id.recyclerView);
        userAdapter = new UserAdapter();
        userExpert = new UserExpert(userAdapter);
        certificateAdapter = new CertificateAdapter(this, userExpert,this, email );
    }

    private void setupInitializer()
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(certificateAdapter);
    }

    @Override
    public void onRoomClick(int position) {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
    }
}