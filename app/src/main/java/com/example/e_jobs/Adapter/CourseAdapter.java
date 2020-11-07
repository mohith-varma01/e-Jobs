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

import com.example.e_jobs.Expert.CourseExpert;
import com.example.e_jobs.Modal.Course;
import com.example.e_jobs.R;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyCourseViewHolder>
{
    private Context context;
    private CourseExpert courseExpert;
    private TextView courseName;
    private ImageView imageView;
    private OnCourseListener onCourseListener;
    //Course course = new Course("Random", "Vocabulary",
            //Uri.parse("https://en.wikipedia.org/wiki/Cristiano_Ronaldo#/media/File:Cristiano_Ronaldo_2018.jpg"),
            //Uri.parse("https://www.youtube.com/watch?v=4jq0PSjEOow"), "agriculture");

    public CourseAdapter(Context context, CourseExpert courseExpert, OnCourseListener onCourseListener)
    {
        this.context = context;
        this.courseExpert = courseExpert;
        this.onCourseListener = onCourseListener;
        //courseExpert.addCourse(course);
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
        courseName.setText(courseExpert.getCourseOfPosition(position).getCourseName());
        imageView.setImageURI(courseExpert.getCourseOfPosition(position).getCourseImageUri());
    }

    private void bindViews(View v)
    {
        courseName = v.findViewById(R.id.courseName);
        imageView =  v.findViewById(R.id.imageView);
    }

    @Override
    public int getItemCount()
    {
        return courseExpert.getTotalCourses();
    }

    public static class MyCourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        View view;
        OnCourseListener onCourseListener;
        public MyCourseViewHolder(@NonNull View itemView, OnCourseListener onCourseListener) {
            super(itemView);
            view = itemView;
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
