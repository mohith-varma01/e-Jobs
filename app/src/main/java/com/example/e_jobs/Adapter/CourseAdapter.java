package com.example.e_jobs.Adapter;

import androidx.annotation.NonNull;

import com.example.e_jobs.Modal.Course;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CourseAdapter
{
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private ArrayList<Course> courses;

    public CourseAdapter()
    {
        setupDatabase();
    }

    private void setupDatabase()
    {
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("courses");
    }

    public void addCourseToDb(Course course)
    {
        databaseReference.push().setValue(course);
    }

    public ArrayList<Course> getAllCourse()
    {
        courses = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot subTree: snapshot.getChildren())
                {
                    Course course = subTree.getValue(Course.class);
                    courses.add(course);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return courses;
    }
}
