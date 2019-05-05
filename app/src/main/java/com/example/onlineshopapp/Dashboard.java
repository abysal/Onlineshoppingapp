package com.example.onlineshopapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btnAdd;
    private ImageView refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recyclerview);
        btnAdd = findViewById(R.id.btnAdd);
        refresh = findViewById(R.id.refresh);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,Dashboard.class);
                startActivity(intent);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,AddItem.class);
                startActivity(intent);
            }
        });
        List<Pant> pantList = new ArrayList<>();
        try {
            FileInputStream fos = openFileInput("items.txt");
            InputStreamReader isr = new InputStreamReader(fos);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null){
                String[] parts = line.split("->");
                int image = getResources().getIdentifier(parts[2],"drawable",getPackageName());
                pantList.add(new Pant(parts[0],"Rs."+parts[1],parts[3],image));
                PantAdapter pantAdapter = new PantAdapter(this,pantList);
                recyclerView.setAdapter(pantAdapter);
                recyclerView.setLayoutManager(new GridLayoutManager(this,2));

            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
