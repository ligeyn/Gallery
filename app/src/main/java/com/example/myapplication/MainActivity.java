package com.example.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static ArrayList<Integer> cards;
    private static RecyclerView recyclerView;
    private ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));


        fetchCards();
        adapter = new ItemAdapter(MainActivity.this, cards);
        recyclerView.setAdapter(adapter);
        adapter.setListener(new OnItemClick() {
            @Override
            public void onItemClick(Integer card) {
                Intent intent = new Intent(MainActivity.this, Image.class);
                intent.putExtra("image", card);
                startActivity(intent);
            }
        });
    }
    public void fetchCards(){
        cards = new ArrayList<>();
        cards.add(R.drawable.mirror);
        cards.add(R.drawable.crowded);
        cards.add(R.drawable.night);
        cards.add(R.drawable.alone);
        cards.add(R.drawable.couple);
        cards.add(R.drawable.insane);
        cards.add(R.drawable.moon);
        cards.add(R.drawable.moth);
        cards.add(R.drawable.soul);
        cards.add(R.drawable.bird);
        cards.add(R.drawable.blood);
        cards.add(R.drawable.drown);


    }
}
