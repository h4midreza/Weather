package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.HourlyAdapter;
import com.example.domain.Hourly;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        TextView next7Days = findViewById(R.id.nextBtn);
        next7Days.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, FutureActivity.class));
                    }
                }
        );
    }

    private void initRecyclerView() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly("9 am", 20, "sunny"));
        items.add(new Hourly("12 am", 18, "sunny"));
        items.add(new Hourly("3 pm", 23, "cloudy_sunny"));
        items.add(new Hourly("6 pm", 21, "rainy"));
        items.add(new Hourly("9 pm", 15, "cloudy_sunny"));
        items.add(new Hourly("12 pm", 17, "cloudy_sunny"));

        recyclerView= findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterHourly = new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);
    }
}
