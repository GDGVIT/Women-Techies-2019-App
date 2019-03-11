package com.womentechmakers.wtmapp.Question;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.womentechmakers.wtmapp.R;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.MyViewHolder> {

    private ArrayList<Question> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewQuestion;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewQuestion = (TextView) itemView.findViewById(R.id.text_view_question);
        }
    }

    public QuestionAdapter(ArrayList<Question> data) {
        this.dataSet = data;
    }

    @Override
    public QuestionAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_question_items
                        , parent, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        QuestionAdapter.MyViewHolder myViewHolder = new QuestionAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final QuestionAdapter.MyViewHolder holder, final int listPosition) {

        TextView textViewQuestion = holder.textViewQuestion;

        textViewQuestion.setText(dataSet.get(listPosition).getQuestion());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
