package com.womentechmakers.wtmapp.About;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.womentechmakers.wtmapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AboutDscFaqAdapter extends RecyclerView.Adapter<AboutDscFaqAdapter.FaqHolder>{

    ArrayList<FAQ> faqArrayList;
    AssetManager assetManager;
    Context context;

    public AboutDscFaqAdapter(ArrayList<FAQ> faqArrayList) {
        this.faqArrayList = faqArrayList;
    }

    @NonNull
    @Override
    public FaqHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_card_item, parent, false);
        assetManager = parent.getContext().getAssets();
        context = parent.getContext();
        return new FaqHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull FaqHolder holder, final int position) {
        final FAQ faq = faqArrayList.get(position);

        boolean expanded = faq.isExpanded();
        holder.answer.setVisibility(expanded ? View.VISIBLE : View.GONE);

        holder.question.setText(faq.getQuestion());
        holder.answer.setText(faq.getAnswer());



        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean expanded = faq.isExpanded();
                faq.setExpanded(!expanded);
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return faqArrayList.size();
    }

    class FaqHolder extends RecyclerView.ViewHolder {

        TextView question, answer;
        CardView cardView;

        public FaqHolder(@NonNull View itemView) {
            super(itemView);
            question= itemView.findViewById(R.id.question);
            answer = itemView.findViewById(R.id.answer);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }

}
