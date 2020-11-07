package com.example.e_jobs.Expert;

import com.example.e_jobs.FireBaseDrivers.QuestionDriver;
import com.example.e_jobs.Modal.Question;

import java.util.ArrayList;

public class QuestionExpert
{
    QuestionDriver questionDriver;
    ArrayList<Question> questions;

    public QuestionExpert(QuestionDriver questionDriver)
    {
        this.questionDriver = questionDriver;
        this.questions = questionDriver.getAllQuestions();
    }

    public void addQuestion(Question question)
    {
        questions.add(question);
    }

    public Question getQuestionOfId(String cId)
    {
        for (int i = 0; i < questions.size(); i++) {
            if(questions.get(i).getQuestionId().equals(cId))
            {
                return questions.get(i);
            }
        }
        return null;
    }

    public int getTotalQuestions()
    {
        return questions.size();
    }
}
