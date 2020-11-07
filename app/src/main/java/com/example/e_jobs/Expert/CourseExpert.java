package com.example.e_jobs.Expert;

import com.example.e_jobs.Adapter.CourseAdapter;
import com.example.e_jobs.Modal.Course;

import java.util.ArrayList;

public class CourseExpert
{
    CourseAdapter courseAdapter;
    ArrayList<Course> courses;

    public CourseExpert(CourseAdapter courseAdapter)
    {
        this.courseAdapter = courseAdapter;
        this.courses = courseAdapter.getAllCourse();
    }

    public void addCourse(Course course)
    {
        courses.add(course);
    }

    public Course getCourseOfId(String cId)
    {
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseId().equals(cId))
            {
                return courses.get(i);
            }
        }
        return null;
    }

    public int getTotalCourses()
    {
        return courses.size();
    }
}
