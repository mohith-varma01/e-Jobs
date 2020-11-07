package com.example.e_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.VideoView;

import com.example.e_jobs.Modal.Course;

public class AddCourse extends AppCompatActivity {

    EditText courseName;
    EditText courseDescription;
    Button takeImage;
    Button addVideo;
    ImageView imageView;
    VideoView videoView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        bindViews();
    }

    private void bindViews()
    {
        courseName = findViewById(R.id.editText3);
        courseDescription = findViewById(R.id.editText4);
        takeImage = findViewById(R.id.button3);
        addVideo = findViewById(R.id.button7);
        imageView = findViewById(R.id.imageView2);
        videoView = findViewById(R.id.videoView2);
        spinner();
    }

    private void spinner()
    {
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.names));
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onClickTakeImage(View view)
    {

    }


    public void onClickAddVideo(View view)
    {

    }

    public void onClickEnterDetails(View view)
    {
        //Course course = new Course(courseName.getText().toString(), );
    }
}