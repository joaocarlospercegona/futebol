package com.example.futebol.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.futebol.R;
import com.example.futebol.RecyclerItemClickListener;
import com.example.futebol.adapter.AdapterTimes;
import com.example.futebol.model.Time;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTimes;
    private List<Time> listTimes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewTimes = findViewById(R.id.recyclerViewTimes);

        this.createTime();

        AdapterTimes adapter = new AdapterTimes(listTimes);
        
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewTimes.setLayoutManager(layoutManager);

        recyclerViewTimes.setHasFixedSize(true);

        recyclerViewTimes.addItemDecoration(
                new DividerItemDecoration(this , LinearLayout.VERTICAL)
        );

        recyclerViewTimes.setAdapter(adapter);
        //evento de clique
        recyclerViewTimes.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerViewTimes,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Time obj = listTimes.get(position);


                                Intent it = new Intent(this, SecondActivity.class);
                                Bundle params = new Bundle();
                                params.putString("nome",obj);
                                it.putExtras(params);
                                startActivity(it);
                                finish();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Clique longo",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
    }

    private void createTime() {
        ArrayList<String> conquistas = new ArrayList<String>();
        conquistas.add("Campeao Paranaense");
        conquistas.add("Campeao Brasileiro");

        Time obj = new Time(R.drawable.flash, "Curitiba", "Parana / Curitiba", conquistas);
        listTimes.add(obj);
        obj = new Time(R.drawable.ironman, "Atletico", "Parana / Curitiba", conquistas);
        listTimes.add(obj);
        obj = new Time(R.drawable.ironman, "Flamengo", "Rio de Janeiro / Literoi" , conquistas);
        listTimes.add(obj);
        obj = new Time(R.drawable.ironman, "São Paulo", "São Paulo / Cidade de São Paulo", conquistas);
        listTimes.add(obj);

    }
}