package com.example.e_jobs.FireBaseDrivers;

import androidx.annotation.NonNull;

import com.example.e_jobs.Modal.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QuestionDriver
{
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private ArrayList<Question> questions;

    public QuestionDriver()
    {
        setupDatabase();
    }

    private void setupDatabase()
    {
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("questions");
    }

    public void addQuestionToDb(Question question)
    {
        databaseReference.push().setValue(question);
    }

    public ArrayList<Question> getAllQuestions()
    {
        questions = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot subTree: snapshot.getChildren())
                {
                    Question question = subTree.getValue(Question.class);
                    questions.add(question);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return questions;
    }
}
