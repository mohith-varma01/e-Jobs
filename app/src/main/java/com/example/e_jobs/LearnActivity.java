package com.example.e_jobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.e_jobs.Adapter.CourseAdapter;
import com.example.e_jobs.Expert.CourseExpert;
import com.example.e_jobs.FireBaseDrivers.CourseDriver;
import com.example.e_jobs.Modal.Course;

public class LearnActivity extends AppCompatActivity implements CourseAdapter.OnCourseListener {

    RecyclerView recyclerViewRecommendedCourse;
    RecyclerView recyclerViewAdditionalCourse;
    CourseDriver courseDriver = new CourseDriver();
    CourseExpert courseExpert = new CourseExpert(courseDriver);
    CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        bindViews();
        setUpInitializer();
    }

    private void bindViews()
    {
        recyclerViewRecommendedCourse = findViewById(R.id.recyclerView1);
        recyclerViewAdditionalCourse = findViewById(R.id.recyclerView2);
    }

    private void setUpInitializer()
    {
        recyclerViewRecommendedCourse.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        courseAdapter = new CourseAdapter(this, courseExpert, this);
        recyclerViewRecommendedCourse.setAdapter(courseAdapter);

        recyclerViewAdditionalCourse.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        courseAdapter = new CourseAdapter(this, courseExpert, this);
        recyclerViewAdditionalCourse.setAdapter(courseAdapter);
    }

    @Override
    public void onCourseClick1(int position) {
        Intent intent = new Intent(this, ViewCourse.class);
    }
}