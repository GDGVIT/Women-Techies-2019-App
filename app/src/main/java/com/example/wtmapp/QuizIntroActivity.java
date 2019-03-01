package com.example.wtmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuizIntroActivity extends AppCompatActivity {

    TextView quizInstructions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_intro);
        quizInstructions = findViewById(R.id.quiz_instructions);
        quizInstructions.setText("You will have 10 seconds for every " +
                "question\n\n" +
                "You can attempt this quiz only once\n\n" +
                "Wrong answer will end the quiz");

    }

    public void startQuiz(View view) {
        startActivity(new Intent(this,QuizActivity.class));
    }
}
