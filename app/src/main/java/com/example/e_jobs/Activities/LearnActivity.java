package com.example.e_jobs.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.e_jobs.Adapter.CourseAdapter;
import com.example.e_jobs.Data.CourseData;
import com.example.e_jobs.Expert.CourseExpert;
import com.example.e_jobs.Expert.UserExpert;
import com.example.e_jobs.FireBaseDrivers.CourseDriver;
import com.example.e_jobs.FireBaseDrivers.UserDriver;
import com.example.e_jobs.Modal.User;
import com.example.e_jobs.R;

public class LearnActivity extends AppCompatActivity implements CourseAdapter.OnCourseListener {

    RecyclerView recyclerViewRecommendedCourse;
    RecyclerView recyclerViewAdditionalCourse;
    CourseDriver courseDriver = new CourseDriver();
    CourseExpert courseExpert = new CourseExpert(courseDriver);
    CourseAdapter courseAdapter;
    UserExpert userExpert;
    UserDriver userDriver;
    String userField = "self-employeed";
    Intent intent;
    CourseData courseData;
    String userId ;
    User user;

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
        userDriver = new UserDriver();
        userExpert = new UserExpert(userDriver);
        intent = getIntent();
        courseData = new CourseData();
        userId = intent.getStringExtra("userId");
        user = userExpert.getUser(userId);
    }

    private void setUpInitializer()
    {
        recyclerViewRecommendedCourse.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        courseAdapter = new CourseAdapter(this, courseExpert, this, userField, 0);
        recyclerViewRecommendedCourse.setAdapter(courseAdapter);

        recyclerViewAdditionalCourse.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        courseAdapter = new CourseAdapter(this, courseExpert, this, userField, 1);
        recyclerViewAdditionalCourse.setAdapter(courseAdapter);
    }

    @Override
    public void onCourseClick1(int position) {

        Intent intent = new Intent(this, ViewCourseActivity.class);
        intent.putExtra("courseId",courseData.getCourseOfIndex(position).getId());
        startActivity(intent);
    }
}