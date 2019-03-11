package com.womentechmakers.wtmapp.Sponsor;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.womentechmakers.wtmapp.R;

import java.util.List;

public class SponsorAdapter  extends RecyclerView.Adapter<SponsorAdapter.ViewHolder> {

    private List<Sponsor> sponsorData;


    public SponsorAdapter(List<Sponsor> sponsorData) {
        this.sponsorData = sponsorData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.fragment_sponsor_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.image.setCropToPadding(true);
        Glide.with(holder.itemView.getContext())
                .load(sponsorData.get(position).getSponsorImage())
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return sponsorData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
