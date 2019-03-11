package com.womentechmakers.wtmapp.About;

public class FAQ {

    private String Question;
    private String Answer;
    private boolean isExpanded;


    public FAQ(String question, String answer) {
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
