package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.FutureAdapter;
import com.example.domain.FutureDomain;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(FutureActivity.this, MainActivity.class));
                    }
                }
        );
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items = new ArrayList<>();

        items.add(new FutureDomain("Sat", "storm", "storm", 25, 10));
        items.add(new FutureDomain("Sun", "cloudy", "cloudy", 23, 11));
        items.add(new FutureDomain("Mon", "windy", "windy", 22, 9));
        items.add(new FutureDomain("Tue", "cloudy_sunny", "cloudy sunny", 26, 10));
        items.add(new FutureDomain("Wed", "sunny", "sunny", 27, 13));
        items.add(new FutureDomain("Thu", "rainy", "rainy", 25, 12));
        items.add(new FutureDomain("Fri", "cloudy", "cloudy", 23, 11));

        recyclerView = findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterTomorrow = new FutureAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);
    }
}
