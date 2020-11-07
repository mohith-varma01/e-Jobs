package com.example.e_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public void onClickBuy(View view)
    {

    }

    public void onClickSell(View view)
    {

    }


    public void onClickLearn(View view)
    {
        Intent intent = new Intent(this, WannaTeachWannaLearn.class);
        startActivity(intent);
    }

    public void onClickPractise(View view)
    {

    }

    public void onClickBoostConfidence(View view)
    {

    }

    public void onClickContactDoc(View view)
    {
        Intent intent = new Intent(this, ContactDocActivity.class);
        startActivity(intent);
    }
}