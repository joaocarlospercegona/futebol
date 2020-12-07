package com.example.futebol.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.futebol.R;
import com.example.futebol.model.Time;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent it = getIntent();
        Time time = it.getParcelableExtra("time");

        TextView nome = findViewById(R.id.nome);
        TextView estado = findViewById(R.id.estado);
        TextView cidade = findViewById(R.id.cidade);
        TextView conquistas = findViewById(R.id.conquistas);
        ImageView emblema = findViewById(R.id.emblema);

        emblema.setImageResource(time.getImage());
        nome.setText(time.getName());
        estado.setText(time.getState());
        cidade.setText(time.getCity());

        String conquistasText = "";
        for (int i = 0; i < time.getAchievements().size(); i++)
        {
            String titulo = time.getAchievements().get(i);
            conquistasText = conquistasText + "\n --> " + titulo;
        }
        conquistas.setText(conquistasText);


    }
}