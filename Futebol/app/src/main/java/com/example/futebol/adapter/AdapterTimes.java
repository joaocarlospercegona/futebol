package com.example.futebol.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futebol.R;
import com.example.futebol.model.Time;

import java.util.List;

public class AdapterTimes extends RecyclerView.Adapter<AdapterTimes.MyViewHolder> {

    private List<Time> listTimes;

    public AdapterTimes(List<Time> list) {
        this.listTimes = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView adapterNome, adapterCidade, adapterEstado;
        ImageView adapterEmblema;

        public MyViewHolder(View view) {
            super(view);
            adapterNome = view.findViewById(R.id.adapterNome);
            adapterCidade = view.findViewById(R.id.adapterCidade);
            adapterEstado = view.findViewById(R.id.adapterEstado);
            adapterEmblema = view.findViewById(R.id.adapterEmblema);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_times, parent, false );
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Time t = listTimes.get(position);
        holder.adapterEmblema.setImageResource(t.getImage());
        holder.adapterNome.setText(t.getName());
        holder.adapterCidade.setText(t.getCity());
        holder.adapterEstado.setText(t.getState());
    }

    @Override
    public int getItemCount() {
        return listTimes.size();
    }

}
