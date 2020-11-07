package com.example.e_jobs.FireBaseDrivers;

import androidx.annotation.NonNull;

import com.example.e_jobs.Modal.Doctor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DoctorDriver {

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private ArrayList<Doctor> doctors;

    public DoctorDriver()
    {
        setUpDatabaseLink();
    }

    private void setUpDatabaseLink()
    {
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("doctors");
    }

    public void addDocsToDb(Doctor doctor)
    {
        databaseReference.push().setValue(doctor);
    }

    public ArrayList<Doctor> getAllDoctors()
    {
        doctors = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot subTree: snapshot.getChildren())
                {
                    Doctor doctor = subTree.getValue(Doctor.class);
                    doctors.add(doctor);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return doctors;
    }
}
