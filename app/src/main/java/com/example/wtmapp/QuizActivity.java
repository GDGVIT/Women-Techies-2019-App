package com.example.wtmapp;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    CardView option1, option2, option3, option4,finishQuiz;
    TextView option1text, option2text, option3text, option4text;
    TextView timeTextView, questionTextView,ScoreTextView;
    int index = 0;
    int answerCorrected = 0;
    CountDownTimer countDownTimer;
    public static final int TOTAL_QUESTIONS = 10;
    String[] allQuestions = {"Question1", "Question2", "Question3", "Question4", "Question5", "Question6",
            "Question7", "Question8", "Question9", "Question10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        option1text = findViewById(R.id.option1text);
        option2text = findViewById(R.id.option2text);
        option3text = findViewById(R.id.option3text);
        option4text = findViewById(R.id.option4text);
        timeTextView = findViewById(R.id.time_textview);
        questionTextView = findViewById(R.id.question);
        finishQuiz = findViewById(R.id.finish_quiz);
        ScoreTextView = findViewById(R.id.score_tv);
        checkCorrectAnswer(allQuestions[index++], "", "", "", "", 1);


    }

    int checkCorrectAnswer(String question, String optionOne, String optionTwo, String optionThree, String optionFour, final int correctOption) {
        questionTextView.setText(question);
        final int[] selectedOption = {0};
        final boolean[] isSelected = {false};
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected[0]) {
                    selectedOption[0] = 1;
                } else if (isSelected[0]) {
                    unmarkOption(selectedOption[0]);
                    selectedOption[0] = 1;
                }
                option1.setCardBackgroundColor(Color.parseColor("#408af2"));
                option1text.setTextColor(getResources().getColor(R.color.colorWhite));
                isSelected[0] = true;
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected[0]) {
                    selectedOption[0] = 2;
                } else if (isSelected[0]) {
                    unmarkOption(selectedOption[0]);
                    selectedOption[0] = 2;
                }
                option2.setCardBackgroundColor(Color.parseColor("#408af2"));
                option2text.setTextColor(getResources().getColor(R.color.colorWhite));
                isSelected[0] = true;
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected[0]) {
                    selectedOption[0] = 3;
                } else if (isSelected[0]) {
                    unmarkOption(selectedOption[0]);
                    selectedOption[0] = 3;
                }
                option3.setCardBackgroundColor(Color.parseColor("#408af2"));
                option3text.setTextColor(getResources().getColor(R.color.colorWhite));
                isSelected[0] = true;
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected[0]) {
                    selectedOption[0] = 4;
                } else if (isSelected[0]) {
                    unmarkOption(selectedOption[0]);
                    selectedOption[0] = 4;
                }
                isSelected[0] = true;
                option4.setCardBackgroundColor(Color.parseColor("#408af2"));
                option4text.setTextColor(getResources().getColor(R.color.colorWhite));
            }
        });

        countDownTimer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                timeTextView.setText("00" + ":0" + String.valueOf(millisUntilFinished / 1000));
            }
            public void onFinish() {
                if(index<TOTAL_QUESTIONS){
                    checkCorrectAnswer(allQuestions[index++],"","","","",1);
                    unmarkOption(selectedOption[0]);
                    if(selectedOption[0]==correctOption){
                        answerCorrected +=1;
                    }
                    Toast.makeText(QuizActivity.this, "Time Complete , Selected Option" + selectedOption[0], Toast.LENGTH_SHORT).show();
                }if(index==TOTAL_QUESTIONS){
                    finishQuiz.setVisibility(View.VISIBLE);
                }
                ScoreTextView.setText("Score : " + answerCorrected + "/" + (index-1));
            }
        };
        countDownTimer.start();
        return selectedOption[0];
    }

    void unmarkOption(int selectedOption) {

        switch (selectedOption) {
            case 1:
                option1.setCardBackgroundColor(Color.parseColor("#ffffff"));
                option1text.setTextColor(getResources().getColor(R.color.colorBlack));
                break;
            case 2:
                option2.setCardBackgroundColor(Color.parseColor("#ffffff"));
                option2text.setTextColor(getResources().getColor(R.color.colorBlack));
                break;
            case 3:
                option3.setCardBackgroundColor(Color.parseColor("#ffffff"));
                option3text.setTextColor(getResources().getColor(R.color.colorBlack));
                break;
            case 4:
                option4.setCardBackgroundColor(Color.parseColor("#ffffff"));
                option4text.setTextColor(getResources().getColor(R.color.colorBlack));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countDownTimer.cancel();

    }
}
