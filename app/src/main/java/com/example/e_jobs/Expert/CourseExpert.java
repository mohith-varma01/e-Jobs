package com.example.e_jobs.Expert;

import com.example.e_jobs.FireBaseDrivers.CourseDriver;
import com.example.e_jobs.Modal.Course;

import java.util.ArrayList;

public class CourseExpert
{
    CourseDriver courseDriver;
    ArrayList<Course> courses;

    public CourseExpert(CourseDriver courseDriver)
    {
        this.courseDriver = courseDriver;
        this.courses = courseDriver.getAllCourse();
    }

    public void addCourse(Course course)
    {
        courses.add(course);
    }

    public Course getCourseOfId(String cId)
    {
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseId() == Integer.parseInt(cId))
            {
                return courses.get(i);
            }
        }
        return null;
    }

    public Course getCourseOfPosition(int position)
    {
        return courses.get(position);
    }

    public int getTotalCourses()
    {
        return courses.size();
    }
}
