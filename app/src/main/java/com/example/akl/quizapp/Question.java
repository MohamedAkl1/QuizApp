package com.example.akl.quizapp;

import android.graphics.drawable.Drawable;

/**
 * Created by Moham on 11/21/2017.
 */

public class Question {
    private String question;
    private String answers[];
    private int questionId;
    private String submittedAnswer;
    private int correctAnswer;
    private Drawable questionImage;


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getSubmittedAnswer() {
        return submittedAnswer;
    }

    public void setSubmittedAnswer(String submittedAnswer) {
        this.submittedAnswer = submittedAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Drawable getQuestionImage() {
        return questionImage;
    }

    public void setQuestionImage(Drawable questionImage) {
        this.questionImage = questionImage;
    }
}
