package com.example.e_jobs.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.e_jobs.Adapter.DoctorAdapter;
import com.example.e_jobs.Expert.DoctorExpert;
import com.example.e_jobs.FireBaseDrivers.DoctorDriver;
import com.example.e_jobs.R;

public class DoctorActivity extends AppCompatActivity implements DoctorAdapter.OnDoctorListener {

    public static final String DOC_ID = "doc_id";
    RecyclerView recyclerView;
    DoctorAdapter doctorAdapter;
    DoctorExpert doctorExpert;
    DoctorDriver doctorDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        doctorDriver = new DoctorDriver();
        doctorExpert = new DoctorExpert(doctorDriver);
        doctorAdapter = new DoctorAdapter(this, doctorExpert, this);
        recyclerView = findViewById(R.id.recyclerView_doctors);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(doctorAdapter);
    }

    @Override
    public void onDoctorClick1(int position) {
        Intent intent = new Intent(DoctorActivity.this, MessageActivity.class);
        intent.putExtra(DOC_ID,doctorExpert.getDoctorByPos(position).getDocId());
        startActivity(intent);
    }
}