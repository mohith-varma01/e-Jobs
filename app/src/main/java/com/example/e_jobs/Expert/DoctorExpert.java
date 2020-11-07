package com.example.e_jobs.Expert;

import com.example.e_jobs.FireBaseDrivers.DoctorDriver;
import com.example.e_jobs.FireBaseDrivers.QuestionDriver;
import com.example.e_jobs.Modal.Doctor;
import com.example.e_jobs.Modal.Question;

import java.util.ArrayList;

public class DoctorExpert
{
    DoctorDriver doctorDriver;
    ArrayList<Doctor> doctors;

    public DoctorExpert(DoctorDriver doctorDriver)
    {
        this.doctorDriver = doctorDriver;
        this.doctors = doctorDriver.getAllDoctors();
    }

    public void addDoctors(Doctor doctor)
    {
        doctors.add(doctor);
    }

    public Doctor getDoctorById(String cId)
    {
        for (int i = 0; i < doctors.size(); i++) {
            if(doctors.get(i).getDocId().equals(cId))
            {
                return doctors.get(i);
            }
        }
        return null;
    }

    public int getTotalDoctors()
    {
        return doctors.size();
    }
}
