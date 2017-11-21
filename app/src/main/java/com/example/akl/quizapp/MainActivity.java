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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView score,questionNumber,questionTextView;
    RadioButton radio1,radio2,radio3,radio4;
    ImageView imageView;
    RadioGroup radioGroup;
    ArrayList<Question> questions = new ArrayList<>();
    Button submit;

    int answerIndex = 0;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.question_image);
        score = findViewById(R.id.score_textview);
        questionNumber = findViewById(R.id.question_number_textview);
        questionTextView = findViewById(R.id.question_textview);
        submit = findViewById(R.id.submit);
        radio1 = findViewById(R.id.answer1);
        radio2 = findViewById(R.id.answer2);
        radio3 = findViewById(R.id.answer3);
        radio4 = findViewById(R.id.answer4);


        Question question1 = new Question();
        Question question2 = new Question();
        Question question3 = new Question();
        Question question4 = new Question();
        Question question5 = new Question();
        //question 1
        question1.setQuestion(getResources().getString(R.string.question1_statement));
        String[] answers1 = {getResources().getString(R.string.question1_answerAright),getResources().getString(R.string.question1_answerB),getResources().getString(R.string.question1_answerC),getResources().getString(R.string.question1_answerD)};
        question1.setAnswers(answers1);
        question1.setCorrectAnswer(1);
        question1.setQuestionId(1);
        question1.setQuestionImage(ContextCompat.getDrawable(getApplicationContext(),R.drawable.question1));
        questions.add(question1);


        //question 2
        question2.setQuestion(getResources().getString(R.string.question2_statement));
        String[] answers2 = {getResources().getString(R.string.question2_answerA),getResources().getString(R.string.question2_answerB),getResources().getString(R.string.question2_answerC),getResources().getString(R.string.question2_answerDright)};
        question2.setAnswers(answers2);
        question2.setCorrectAnswer(4);
        question2.setQuestionId(2);
        question2.setQuestionImage(ContextCompat.getDrawable(getApplicationContext(),R.drawable.question2));
        questions.add(question2);

        //question 3
        question3.setQuestion(getResources().getString(R.string.question3_statement));
        String[] answers3 = {getResources().getString(R.string.question3_answerAright),getResources().getString(R.string.question3_answerB),getResources().getString(R.string.question3_answerC),getResources().getString(R.string.question3_answerD)};
        question3.setAnswers(answers3);
        question3.setCorrectAnswer(1);
        question3.setQuestionId(3);
        question3.setQuestionImage(ContextCompat.getDrawable(getApplicationContext(),R.drawable.question3));
        questions.add(question3);

        //question 4
        question4.setQuestion(getResources().getString(R.string.question4_statement));
        String[] answers4 = {getResources().getString(R.string.question4_answerAright),getResources().getString(R.string.question4_answerB),getResources().getString(R.string.question4_answerC),getResources().getString(R.string.question4_answerD)};
        question4.setAnswers(answers4);
        question4.setCorrectAnswer(1);
        question4.setQuestionId(4);
        question4.setQuestionImage(ContextCompat.getDrawable(getApplicationContext(),R.drawable.question4));
        questions.add(question4);

        //question 5
        question5.setQuestion(getResources().getString(R.string.question5_statement));
        String[] answers5 = {getResources().getString(R.string.question5_answerA),getResources().getString(R.string.question5_answerBright),getResources().getString(R.string.question5_answerC),getResources().getString(R.string.question5_answerD)};
        question5.setAnswers(answers5);
        question5.setCorrectAnswer(2);
        question5.setQuestionId(5);
        question5.setQuestionImage(ContextCompat.getDrawable(getApplicationContext(),R.drawable.question5));
        questions.add(question5);

        updateUI(questions,0);

        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(i <= 4){
                    int answer = answerIndex;
                    answerIndex = 0;
                    int correct = questions.get(i).getCorrectAnswer();
                    if(correct == answer){
                        int playerScore = Integer.parseInt(score.getText().toString());
                        playerScore++;
                        score.setText(Integer.toString(playerScore));
                        Toast.makeText(getApplicationContext(),"Correct", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    }
                    i++;
                    if(i != 5){
                        updateUI(questions,i);
                    }else{
                        submit.setText("Finish");
                    }

                }
                else{
                    Toast.makeText(getApplicationContext(),"Quiz Finished",Toast.LENGTH_LONG).show();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                        }
                    }, 5000);
                    System.exit(0);
                }
            }
        });
    }

    public void updateUI(ArrayList<Question> questions1,int index){

        radioGroup.clearCheck();
        Question questionDisplay = questions.get(index);
        String[] answers = questionDisplay.getAnswers();
        String text = questionNumber.getText().toString();
        questionNumber.setText(String.format("%s%s", text, Integer.toString(index + 1)));
        imageView.setImageDrawable(questionDisplay.getQuestionImage());

        questionTextView.setText(questionDisplay.getQuestion());
        radio1.setText(answers[0]);
        radio2.setText(answers[1]);
        radio3.setText(answers[2]);
        radio4.setText(answers[3]);
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.answer1:
                if (checked)
                    answerIndex = 1;
                    break;
            case R.id.answer2:
                if (checked)
                    answerIndex = 2;
                    break;
            case R.id.answer3:
                if (checked)
                    answerIndex = 3;
                break;
            case R.id.answer4:
                if (checked)
                    answerIndex = 4;
                break;
        }
    }


}
