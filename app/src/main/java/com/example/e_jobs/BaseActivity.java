package com.example.e_jobs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BaseActivity extends AppCompatActivity {

    FirebaseUser firebaseUser;
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
//        View view = navigationView.getHeaderView();
//        view.findViewById()

    }

    public void setUpNavigationDrawerIcon() {
        drawerLayout = findViewById(R.id.drawerLayouts);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.on_drawer_opened, R.string.on_drawer_closed);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    public void  onClickOpenUserProfile()
    {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String userId = firebaseUser.getUid();
        Intent intent = new Intent(this, LearnActivity.class);
        intent.putExtra("userId",userId );
        startActivity(intent);
    }
}
