package com.example.e_jobs.Adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_jobs.Data.CourseData;
import com.example.e_jobs.Expert.CourseExpert;
import com.example.e_jobs.Modal.Course;
import com.example.e_jobs.R;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyCourseViewHolder>
{
    private Context context;
    private CourseExpert courseExpert;
    private CourseData courseData;
    private TextView courseName;
    private ImageView imageView;
    ArrayList<Course> courses;
    private String field;
    int i;
    private OnCourseListener onCourseListener;

    public CourseAdapter(Context context, CourseExpert courseExpert, OnCourseListener onCourseListener, String field, int i)
    {
        this.context = context;
        this.courseExpert = courseExpert;
        this.onCourseListener = onCourseListener;
        courseData = new CourseData();
        this.field = field;
        this.i = i;
        if(i == 0) {
            courses = courseData.getCoursesOfField(field);
        }
        else {
            courses = courseData.getCoursesOfFieldOtherThanField(field);
        }
    }

    @NonNull
    @Override
    public MyCourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.course_items, parent, false);
        return new MyCourseViewHolder(view, onCourseListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCourseViewHolder holder, int position)
    {
        View view = holder.view;
        bindViews(view);
        courseName.setText(courses.get(position).getCourseName());
        imageView.setImageResource(courses.get(position).getCourseId());
    }

    private void bindViews(View v)
    {
        courseName = v.findViewById(R.id.courseName);
        imageView =  v.findViewById(R.id.imageView);
    }

    @Override
    public int getItemCount()
    {
        return courses.size();
    }

    public static class MyCourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        View view;
        OnCourseListener onCourseListener;
        public MyCourseViewHolder(@NonNull View itemView, OnCourseListener onCourseListener) {
            super(itemView);
            this.view = itemView;
            this.onCourseListener = onCourseListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            onCourseListener.onCourseClick1(getAdapterPosition());
        }
    }

    public interface OnCourseListener
    {
        void onCourseClick1(int position);
    }
}