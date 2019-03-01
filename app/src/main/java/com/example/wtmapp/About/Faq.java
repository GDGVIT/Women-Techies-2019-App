package com.example.wtmapp.About;

import com.example.wtmapp.Question.Question;

public class Faq {

    private String Question;
    private String Answer;
    private boolean isExpanded;


    public Faq(String question, String answer) {
        Question = question;
        Answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
