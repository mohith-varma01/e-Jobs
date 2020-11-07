package com.example.e_jobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.e_jobs.Adapter.CourseAdapter;
import com.example.e_jobs.Expert.CourseExpert;
import com.example.e_jobs.FireBaseDrivers.CourseDriver;

public class Teach_Activity extends AppCompatActivity implements CourseAdapter.OnCourseListener{

    RecyclerView recyclerView;
    CourseDriver courseDriver = new CourseDriver();
    CourseExpert courseExpert = new CourseExpert(courseDriver);
    CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach_);

        bindViews();
        setUpInitializer();
    }

    private void bindViews()
    {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void setUpInitializer() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        courseAdapter = new CourseAdapter(this, courseExpert, this);
        recyclerView.setAdapter(courseAdapter);
    }

    @Override
    public void onCourseClick1(int position)
    {

    }

    public void onClickAddCourse(View view) {
    }
}