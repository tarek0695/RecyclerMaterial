package com.pixelhubllc.recyclermaterial;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {

    private ArrayList<Sport> mSportsData;
    private Context mContext;

    public SportsAdapter(Context mContext, ArrayList<Sport> mSportsData) {
        this.mSportsData = mSportsData;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Sport currentSport = mSportsData.get(position);
        holder.bindTo(currentSport);
        Glide.with(mContext).load(currentSport.getImageResource()).into(holder.mSportsImage);
    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mSportsImage;
        private TextView mTitleText;
        private TextView mInfoText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mSportsImage = (ImageView) itemView.findViewById(R.id.sportsImage);
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
        }

        public void bindTo(Sport currentSport) {
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
        }

        @Override
        public void onClick(View v) {
            itemView.setOnClickListener(this);
            Sport currentSport = mSportsData.get(getAdapterPosition());

            Intent detailIntent = new Intent(mContext, DetailsActivity.class);
            detailIntent.putExtra("title", currentSport.getTitle());
            detailIntent.putExtra("image_resource", currentSport.getImageResource());

            mContext.startActivity(detailIntent);

        }
    }
}
