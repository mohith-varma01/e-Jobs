package com.example.e_jobs.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.e_jobs.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class BaseActivity extends AppCompatActivity {

    FirebaseUser firebaseUser;
    CircleImageView circleImageView;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setUpListeners();
        setUpNavigationDrawerIcon();
    }

    public void onClickBuy(View view)
    {
        startActivity(new Intent(this, BuyActivity.class));
    }

    public void onClickSell(View view)
    {
        startActivity(new Intent(this, SellActivity.class));
    }


    public void onClickLearn(View view) {
        Intent intent = new Intent(this, LearnActivity.class);
        startActivity(intent);
    }

    public void onClickPractise(View view) {
        startActivity(new Intent(this, QuizActivity.class));
    }

    public void onClickBoostConfidence(View view) {
        startActivity(new Intent(this, GovtSchemeActivity.class));

    }

    public void onClickContactDoc(View view) {
        Intent intent = new Intent(this, ContactDocActivity.class);
        startActivity(intent);
    }

    Toolbar toolbar;
    DrawerLayout drawerLayout;

    public void setUpListeners() {
        NavigationView navigationView = findViewById(R.id.navigation_view);
        View view = navigationView.getHeaderView(0);
        firebaseFirestore = FirebaseFirestore.getInstance();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        final String userId = firebaseAuth.getCurrentUser().getUid();
        final TextView profileName = view.findViewById(R.id.textView123);
        DocumentReference documentReference = firebaseFirestore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                Log.d("myTag", "onEvent: " + userId);
                profileName.setText(value.getString("fullName"));
            }
        });
        circleImageView  = view.findViewById(R.id.circleImageView);
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference profileRef = storageReference.child("users/"+ userId+"/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(circleImageView);
            }
        });
    }

    public void setUpNavigationDrawerIcon() {
        drawerLayout = findViewById(R.id.drawerLayouts);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.on_drawer_opened, R.string.on_drawer_closed);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    public void  onClickOpenUserProfile(View view)
    {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String userId = firebaseUser.getUid();
        Intent intent = new Intent(this, USerProfilePageActivity.class);
        intent.putExtra("userId",userId );
        startActivity(intent);
    }
}
