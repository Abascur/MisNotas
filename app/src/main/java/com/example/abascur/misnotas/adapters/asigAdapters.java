package com.example.abascur.misnotas.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abascur.misnotas.R;
import com.example.abascur.misnotas.models.asignatura;

import java.util.List;

/**
 * Created by Antonio Bascur Q. on 20/7/2019.
 */
public class asigAdapters extends RecyclerView.Adapter<asigAdapters.ViewHolder>{

    List<asignatura> ShowList;
    Context context;

    public asigAdapters(List<asignatura> showList) {
        ShowList = showList;
    }

    @NonNull
    @Override
    public asigAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_asignatura,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = viewGroup.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull asigAdapters.ViewHolder viewHolder, final int i) {
        final asignatura asig = ShowList.get(i);

        viewHolder.textNombreAsig.setText(asig.getNombre());
        viewHolder.textPromAsig.setText("Prom. Actual : " + asig.getPromedio());
        viewHolder.textPromMetaAsig.setText("Meta Actual : " + asig.getMeta());


        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"La posición es:"+i+" Codigo: "+asig.getId(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ShowList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textNombreAsig;
        TextView textPromAsig;
        TextView textPromMetaAsig;
        CardView cv;

        public ViewHolder(View itemView)
        {
            super(itemView);

            textNombreAsig = (TextView)itemView.findViewById(R.id.textNombreAsig);
            textPromAsig = (TextView)itemView.findViewById(R.id.textPromAsig);
            textPromMetaAsig = (TextView)itemView.findViewById(R.id.textPromMetaAsig);

            cv = (CardView)itemView.findViewById(R.id.cardviewItemAsig);
        }
    }
}
