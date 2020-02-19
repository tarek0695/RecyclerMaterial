package com.pixelhubllc.recyclermaterial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Sport> mSportsData;
    private SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView =findViewById(R.id.my_recycler_view);
        mSportsData = new ArrayList<>();
        mAdapter = new SportsAdapter(this, mSportsData);

        initializeData();
    }

    private void initializeData() {
        String[] sportList = getResources().getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        mSportsData.clear();

        for (int i=0; i<sportList.length; i++){
            mSportsData.add(new Sport(sportList[i], sportsInfo[i]));
        }
        mAdapter.notifyDataSetChanged();
    }
}
