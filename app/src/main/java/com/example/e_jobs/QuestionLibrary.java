package com.example.e_jobs;

public class QuestionLibrary {

    private String mQuestions[] = {
            "Which of the following is not correct about plantation farming?",
            "Which of the following are plantation crops?",
            "The three major cropping seasons of India are:his part of the plant attracts bees, butterflies and hummingbirds.",
            "Rabi crops are.",
            "Kharif crops are grown:",
            "The main food crop of Kharif season is:",
            "The main food crop of Rabi season is:"
    };

    private String mChoices[][] = {
            {"In this type of farming, a single crop is grown on a large area." , "The plantation has an interface of agriculture and industry." , "Farmers clear a patch of land by felling trees and burning them, to produce cereals and other food crops" },
            {"Rice and maize", "Wheat and pulses", "Tea, coffee, banana and sugarcane"},
            {"Aus, Aman and Boro", "Rabi, Kharif and Zaid", "Baisakh, Paus and Chait"},
            {"sown in winter and harvested in summer", "sown during rainy season and harvested in winter", "sown in summer and harvested in winter"},
            {"with the onset of monsoon and harvested in September-October","with the onset of winter and harvested in summer","with onset of Autumn and harvested in summer"},
            {"Mustard","Pulses","Rice"},
            {"Wheat","Rice","Maize"}
    };


    private String mCorrectAnswers[] = {"Farmers clear a patch of land by felling trees and burning them, to produce cereals and other food crops", "ea, coffee, banana and sugarcane", "Rabi, Kharif and Zaid", "sown in winter and harvested in summer", "with the onset of monsoon and harvested in September-October","Rice","Wheat"};


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}