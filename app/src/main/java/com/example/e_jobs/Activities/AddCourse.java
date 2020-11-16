package com.example.e_jobs.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.e_jobs.Modal.Course;
import com.example.e_jobs.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AddCourse extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int PICK_VIDEO_REQUEST = 2;
    EditText courseName;
    EditText courseDescription;
    Button takeImage;
    Button addVideo;
    ImageView imageView;
    VideoView videoView;
    Spinner spinner;
    Intent intent;
    private Button mButtonChooseImage;
    private Button mButtonUpload;
    private TextView mTextViewShowUploads;
    private EditText mEditTextFileName;
    private ProgressBar mProgressBar;
    private Uri mImageUri;
    private Uri mVideoUri;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;
    private ProgressBar mProgressCircle;
    String usieId;
    private String courseField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        bindViews();
    }

    private void bindViews() {
        courseName = findViewById(R.id.editText3);
        courseDescription = findViewById(R.id.editText4);
        takeImage = findViewById(R.id.button3);
        addVideo = findViewById(R.id.button7);
        imageView = findViewById(R.id.imageView2);
        videoView = findViewById(R.id.videoView2);
        intent = getIntent();
        usieId = intent.getStringExtra("userId");
        spinner();
    }

    private void spinner() {
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.names));
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        courseField = spinner.getSelectedItem().toString();
    }

    public void onClickTakeImage(View view) {
    }

    public void onClickEnterDetails(View view) {
    }

    public void onClickAddVideo(View view) {
    }
}