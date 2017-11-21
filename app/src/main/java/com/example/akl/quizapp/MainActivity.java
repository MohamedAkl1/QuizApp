package com.example.akl.quizapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.Image;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ImageView question1Image,question2Image,question3Image,question4Image,question5Image;
    TextView question1Number,question1TextView,question2Number,question2TextView,question3Number,question3TextView,question4Number,question4TextView,question5Number,question5TextView;
    RadioButton radio11,radio12,radio13,radio14,radio21,radio22,radio23,radio24,radio31,radio32,radio33,radio34;
    Button submit;
    CheckBox one,two,three,four;
    EditText editText;
    int score,s1,s2,s3,s4,s5;
    Question question1 = new Question();
    Question question2 = new Question();
    Question question3 = new Question();
    Question question4 = new Question();
    Question question5 = new Question();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s4=0;
                s5=0;
                if(Objects.equals(editText.getText().toString(), "wubba lubba dub dub")){
                    s4 = 1;
                }
                if(two.isChecked() && four.isChecked()){
                    s5 = 1;
                }
                score = s1+s2+s3+s4+s5;
                Toast.makeText(getApplicationContext(),"Your Score Is: " + score,Toast.LENGTH_LONG).show();
            }
        });
        question1Image = findViewById(R.id.question1_image);
        question2Image = findViewById(R.id.question2_image);
        question3Image = findViewById(R.id.question3_image);
        question4Image = findViewById(R.id.question4_image);
        question5Image = findViewById(R.id.question5_image);

        question1TextView = findViewById(R.id.question1_textview);
        question2TextView = findViewById(R.id.question2_textview);
        question3TextView = findViewById(R.id.question3_textview);
        question4TextView = findViewById(R.id.question4_textview);
        question5TextView = findViewById(R.id.question5_textview);

        radio11 = findViewById(R.id.answer11);
        radio12 = findViewById(R.id.answer12);
        radio13 = findViewById(R.id.answer13);
        radio14 = findViewById(R.id.answer14);

        radio21 = findViewById(R.id.answer21);
        radio22 = findViewById(R.id.answer22);
        radio23 = findViewById(R.id.answer23);
        radio24 = findViewById(R.id.answer24);

        radio31 = findViewById(R.id.answer31);
        radio32 = findViewById(R.id.answer32);
        radio33 = findViewById(R.id.answer33);
        radio34 = findViewById(R.id.answer34);

        editText = findViewById(R.id.question4_answeredit);

        one = findViewById(R.id.mr_meeseeks);
        two = findViewById(R.id.morty_right);
        three = findViewById(R.id.rick);
        four = findViewById(R.id.summer);

        //question 1
        question1.setQuestion(getResources().getString(R.string.question1_statement));
        String[] answers1 = {getResources().getString(R.string.question1_answerAright), getResources().getString(R.string.question1_answerB), getResources().getString(R.string.question1_answerC), getResources().getString(R.string.question1_answerD)};
        question1.setAnswers(answers1);
        question1.setCorrectAnswer(1);
        question1.setQuestionId(1);
        question1.setQuestionImage(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question1));
        question1Image.setImageDrawable(question1.getQuestionImage());
        question1TextView.setText(question1.getQuestion());
        radio11.setText(answers1[0]);
        radio12.setText(answers1[1]);
        radio13.setText(answers1[2]);
        radio14.setText(answers1[3]);

        //question 2
        question2.setQuestion(getResources().getString(R.string.question2_statement));
        String[] answers2 = {getResources().getString(R.string.question2_answerA), getResources().getString(R.string.question2_answerB), getResources().getString(R.string.question2_answerC), getResources().getString(R.string.question2_answerDright)};
        question2.setAnswers(answers2);
        question2.setCorrectAnswer(4);
        question2.setQuestionId(2);
        question2.setQuestionImage(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question2));
        question2Image.setImageDrawable(question2.getQuestionImage());
        question2TextView.setText(question2.getQuestion());
        radio21.setText(answers2[0]);
        radio22.setText(answers2[1]);
        radio23.setText(answers2[2]);
        radio24.setText(answers2[3]);

        //question 3
        question3.setQuestion(getResources().getString(R.string.question3_statement));
        String[] answers3 = {getResources().getString(R.string.question3_answerAright), getResources().getString(R.string.question3_answerB), getResources().getString(R.string.question3_answerC), getResources().getString(R.string.question3_answerD)};
        question3.setAnswers(answers3);
        question3.setCorrectAnswer(1);
        question3.setQuestionId(3);
        question3.setQuestionImage(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question3));
        question3Image.setImageDrawable(question3.getQuestionImage());
        question3TextView.setText(question3.getQuestion());
        radio31.setText(answers3[0]);
        radio32.setText(answers3[1]);
        radio33.setText(answers3[2]);
        radio34.setText(answers3[3]);

        question4.setQuestionImage(ContextCompat.getDrawable(getApplicationContext(),R.drawable.question6_answer));
        question4.setQuestion(getResources().getString(R.string.what_s_rick_s_most_famous_catchphrase));
        question4TextView.setText(question4.getQuestion());
        question4Image.setImageDrawable(question4.getQuestionImage());

        question5.setQuestionImage(ContextCompat.getDrawable(getApplicationContext(),R.drawable.checkbox_question));
        question5.setQuestion(getResources().getString(R.string.question7_checkbox));
        question5TextView.setText(question5.getQuestion());
        question5Image.setImageDrawable(question5.getQuestionImage());
    }

    public void onRadioButton1Clicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.answer11:
                if(question1.getCorrectAnswer() == 1){
                    s1=1;
                }else{
                    s1=0;
                }
                break;
            case R.id.answer12:
                if(question1.getCorrectAnswer() == 2){
                    s1=1;
                }else{
                    s1=0;
                }
                break;
            case R.id.answer13:
                if(question1.getCorrectAnswer() == 3){
                    s1=1;
                }else{
                    s1=0;
                }
                break;
            case R.id.answer14:
                if(question1.getCorrectAnswer() == 4){
                    s1=1;
                }else{
                    s1=0;
                }
                break;
        }
    }

    public void onRadioButton2Clicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.answer21:
                if(question2.getCorrectAnswer() == 1){
                    s2=1;
                }else{
                    s2=0;
                }
                break;
            case R.id.answer22:
                if(question2.getCorrectAnswer() == 2){
                    s2=1;
                }else{
                    s2=0;
                }
                break;
            case R.id.answer23:
                if(question2.getCorrectAnswer() == 3){
                    s2=1;
                }else{
                    s2=0;
                }
                break;
            case R.id.answer24:
                if(question2.getCorrectAnswer() == 4){
                    s2=1;
                }else{
                    s2 = 0;
                }
                break;
        }
    }

    public void onRadioButton3Clicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.answer31:
                if(question3.getCorrectAnswer() == 1){
                    s3=1;
                }else{
                    s3=0;
                }
                break;
            case R.id.answer32:
                if(question3.getCorrectAnswer() == 2){
                    s3=1;
                }else{
                    s3 = 0;
                }
                break;
            case R.id.answer33:
                if(question3.getCorrectAnswer() == 3){
                    s3=1;
                }else{
                    s3 = 0;
                }
                break;
            case R.id.answer34:
                if(question3.getCorrectAnswer() == 4){
                    s3=1;
                }else {
                    s3 = 0;
                }
                break;
        }
    }
}
