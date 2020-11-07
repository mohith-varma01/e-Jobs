package com.example.e_jobs.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.e_jobs.Modal.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserAdapter {

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private ArrayList<User> users;

    public UserAdapter()
    {
        setUpDatabaseLink();
    }

    private void setUpDatabaseLink()
    {
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("users");
    }

    public void addUserToDb(User user)
    {
        databaseReference.push().setValue(user);
    }

    public ArrayList<User> getAllUsers()
    {
        users = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot subTree: snapshot.getChildren())
                {
                    User user = subTree.getValue(User.class);
                    users.add(user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return users;
    }
}