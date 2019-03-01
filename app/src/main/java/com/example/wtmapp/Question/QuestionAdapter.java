package com.example.wtmapp.Question;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wtmapp.Agenda.Agenda;
import com.example.wtmapp.R;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class QuestionAdapter extends RecyclerView.Adapter<com.example.wtmapp.Question.QuestionAdapter.MyViewHolder> {

    private ArrayList<Question> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewQuestionCount;
        TextView textViewQuestion;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewQuestion = (TextView) itemView.findViewById(R.id.text_view_question);
            this.textViewQuestionCount = (TextView) itemView.findViewById(R.id.text_view_question_count);
        }
    }

    public QuestionAdapter(ArrayList<Question> data) {
        this.dataSet = data;
    }

    @Override
    public com.example.wtmapp.Question.QuestionAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                                   int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_question_items
                        , parent, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        com.example.wtmapp.Question.QuestionAdapter.MyViewHolder myViewHolder = new com.example.wtmapp.Question.QuestionAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final com.example.wtmapp.Question.QuestionAdapter.MyViewHolder holder, final int listPosition) {

        TextView textViewQuestion = holder.textViewQuestion;
        TextView textViewQuestionCount = holder.textViewQuestionCount;

        textViewQuestion.setText(dataSet.get(listPosition).getQuestion());
        textViewQuestionCount.setText(dataSet.get(listPosition).getCount());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
