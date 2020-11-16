package com.example.e_jobs.StaticDatas;

import com.example.e_jobs.Modal.Course;
import com.example.e_jobs.R;

import java.util.ArrayList;

public class CourseData
{
    ArrayList<Course> courses = new ArrayList<>();

    Course course = new Course(1,"Farming", R.drawable.ic_action_name, "Farmer");
    Course course1 = new Course(2,"Industrial Technologies",R.drawable.agriculture_2, "Farmer");
    Course course2 = new Course(3,"How to implement e-farming", R.drawable.agriculture_3,"Farmer");
    Course course3 = new Course(4,"10 self_employment ideas",R.drawable.self_1 ,"self-employeed");
    Course course4 = new Course(5,"How to grow ",R.drawable.self_2 ,"self-employeed");
    Course course5 = new Course(6,"Self employment ",R.drawable.self_3 ,"self-employeed");

    public CourseData()
    {
        addCourses(course);
        addCourses(course1);
        addCourses(course2);
        addCourses(course3);
        addCourses(course4);
        addCourses(course5);
    }

    public ArrayList<Course> getCoursesOfField(String field)
    {
        ArrayList<Course> courses1= new ArrayList<>();
        for (int i = 0 ; i < courses.size(); i++)
        {
            if(courses.get(i).getCourseField().equals(field))
            {
                courses1.add(courses.get(i));
            }
        }
        return courses1;
    }

    public Course getCourseOfIndex(int i)
    {
        return courses.get(i);
    }

    public Course getCourseOfId(int id)
    {
        for (int i = 0; i <courses.size() ; i++) {
            if(courses.get(i).getCourseId() == id)
            {
                return courses.get(i);
            }
        }
        return course1;
    }

    public ArrayList<Course> getCoursesOfFieldOtherThanField(String field)
    {
        ArrayList<Course> courses1= new ArrayList<>();
        for (int i = 0 ; i < courses.size(); i++)
        {
            if(!courses.get(i).getCourseField().equals(field))
            {
                courses1.add(courses.get(i));
            }
        }
        return courses1;
    }

    public void addCourses(Course course)
    {
        courses.add(course);
    }
}
