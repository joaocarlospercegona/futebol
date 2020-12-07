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
                                detaliedScreen(view, position);
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

    public void detaliedScreen(View view, int position){
        Intent it = new Intent(this, SecondActivity.class);

        Time time = listTimes.get(position);
        it.putExtra("time", time);

        startActivity(it);
    }

    private void createTime() {
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("Taça Brasil de 1966");
        a1.add("Década de 70 - A conquista da América");
        a1.add("Série de títulos nas décadas de 1990 e 2000");
        Time t1 = new Time(R.drawable.cruzeiro, "Cruzeiro", "Belo Horizonte", "Minas Gerais", a1);
        listTimes.add(t1);

        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("Copa Intercontinental - 1981");
        a2.add("2000 a 2009: o tricampeonato carioca");
        Time t2 = new Time(R.drawable.flamengo, "Flamengo", "Rio de Janeiro","Rio de Janeiro", a2);
        listTimes.add(t2);

        ArrayList<String> a3 = new ArrayList<String>();
        a3.add("Quádrupla coroa - 1962, 1963 e 1968");
        a3.add("Copa Intercontinental - 1962 e 1963");
        Time t3  = new Time(R.drawable.santos, "Santos", "Santos","São Paulo" , a3);
        listTimes.add(t3);

        ArrayList<String> a4 = new ArrayList<String>();
        a4.add("1981-1990 – Década de ouro e a conquista do mundial");
        a4.add("Copa Intercontinental - 1983");
        a4.add("Copa Sanwa Bank - 1995");
        Time t4  = new Time(R.drawable.gremio, "Grêmio", "Porto Alegre", "Rio grande do Sul", a4);
        listTimes.add(t4);
    }
}