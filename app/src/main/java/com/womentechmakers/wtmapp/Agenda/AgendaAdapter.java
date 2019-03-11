package com.womentechmakers.wtmapp.Agenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.womentechmakers.wtmapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class AgendaAdapter extends RecyclerView.Adapter {

    private ArrayList<Agenda> dataSet;
    int total_types;

    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;

        public TextTypeViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
            //  this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;

        public ImageTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
        }

    }


    public AgendaAdapter(ArrayList<Agenda> data) {
        this.dataSet = data;
        total_types = dataSet.size();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {


        View view;
        switch (viewType) {
            case AgendaData.TEXT_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_agenda_item
                                , parent, false);
                return new TextTypeViewHolder(view);
            case AgendaData.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_agenda_item
                                , parent, false);
                return new ImageTypeViewHolder(view);

        }
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.fragment_agenda_item
//                        , parent, false);
//
////        view.setOnClickListener(MainActivity.myOnClickListener);
//
//        MyViewHolder myViewHolder = new MyViewHolder(view);
//        return myViewHolder;

        return null;
    }

//    @Override
//    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
//
//        TextView textViewName = holder.textViewName;
//        TextView textViewVersion = holder.textViewVersion;
//        //ImageView imageView = holder.imageViewIcon;
//
//        textViewName.setText(dataSet.get(listPosition).getName());
//        textViewVersion.setText(dataSet.get(listPosition).getVersion());
//        // imageView.setImageResource(dataSet.get(listPosition).getImage());
//    }


    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        TextView textViewName = ((AgendaAdapter.TextTypeViewHolder) holder).textViewName;
        TextView textViewVersion = ((TextTypeViewHolder) holder).textViewVersion;
        ;
        Agenda object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.id_) {
                case AgendaData.TEXT_TYPE:

                    textViewName.setText(dataSet.get(listPosition).getName());
                    textViewVersion.setText(dataSet.get(listPosition).getVersion());

                    break;
                case AgendaData.IMAGE_TYPE:
                    textViewName.setText(dataSet.get(listPosition).getName());
                    textViewVersion.setText(dataSet.get(listPosition).getVersion());

                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
