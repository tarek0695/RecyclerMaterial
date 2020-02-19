package com.pixelhubllc.recyclermaterial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {

    private ArrayList<Sport> mSportsData;
    private Context mContext;

    public SportsAdapter(ArrayList<Sport> mSportsData, Context mContext) {
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
    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitleText;
        private TextView mInfoText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
        }

        public void bindTo(Sport currentSport) {
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
        }
    }
}
