package com.example.e_jobs.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_jobs.FireBaseDrivers.UserDriver;
import com.example.e_jobs.Expert.UserExpert;
import com.example.e_jobs.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class USerProfilePageActivity extends AppCompatActivity {

    private static final String TAG ="myTag" ;
    private TextView textViewAboutUser;
    private TextView textViewUserEmail;
    private TextView textViewRankUser;
    private ImageView imageViewUserProfileImage;
    private RecyclerView recyclerView;
    private Button uploadPhotoButton;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;
    String userId;
    UserExpert userExpert;
    UserDriver userDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_ser_profile_page);

        bindViews();
    }

    private void bindViews()
    {
        textViewAboutUser = findViewById(R.id.textView_aboutUser);
        //textViewRankUser = findViewById(R.id.textView_rank);
        imageViewUserProfileImage = findViewById(R.id.ImageView_UserProfileImage);
        uploadPhotoButton = findViewById(R.id.button_uploadPhoto);
        textViewUserEmail = findViewById(R.id.user_email);
        //recyclerView = findViewById(R.id.recyclerView);
        userDriver = new UserDriver();
        userExpert = new UserExpert(userDriver);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        userId = firebaseAuth.getCurrentUser().getUid();
        storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference profileRef = storageReference.child("users/"+ userId+"/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(imageViewUserProfileImage);
            }
        });
        DocumentReference documentReference = firebaseFirestore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                Log.d(TAG, "onEvent: " + value.getString("fullName"));
                textViewAboutUser.setText(value.getString("fullName"));
                textViewUserEmail.setText(value.getString("email"));
            }
        });
        //certificateAdapter = new CertificateAdapter(this, userExpert,this, email );
    }


    public void onClickLearn(View view)
    {
        Intent intent = new Intent(this, LearnActivity.class);
        startActivity(intent);
    }

    public void onClickPractise(View view)
    {

    }

    public void editProfilePage(View view) {
        Intent editIntent = new Intent(USerProfilePageActivity.this, EditProfileActivity.class);
        startActivity(editIntent);
//        Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(openGallery, 1000);
    }


}