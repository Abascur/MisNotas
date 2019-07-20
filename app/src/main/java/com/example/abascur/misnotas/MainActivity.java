package com.example.abascur.misnotas;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.abascur.misnotas.adapters.asigAdapters;
import com.example.abascur.misnotas.models.asignatura;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //variables a utilizar en la app
    private FloatingActionButton agregarAsignatura;

    private RecyclerView recyclerView;
    private asigAdapters adapter;
    private ArrayList<asignatura> listAsig = new ArrayList<asignatura>();;

    public static final String[] Asignaturas= {"Calculo I","Calculo II", "Calculo III"};
    public static final double[] Prom= {4.5,4.5,5.5};
    public static final double[] Meta= {4.5,4.5,5.5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //siempre tienen que estar al comienzo del oncreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<Asignaturas.length;i++)
        {
            asignatura a = new asignatura("id"+i,Asignaturas[i],"Normal",6,Prom[i],Meta[i]);
            listAsig.add(a);
        }
        //se asocia la variable con el elelemento creado en el layaout (XML)
        agregarAsignatura=(FloatingActionButton) findViewById(R.id.fab);
        //Definición de la interfaz para que se invoque una devolución de llamada cuando se hace clic en una vista.
        agregarAsignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Se agregara una nueva asignatura!!", Toast.LENGTH_SHORT).show();
                Log.d("DebugMain","Se agregara una nueva asignatura!!");
            }
        });


        adapter = new asigAdapters(listAsig);

        recyclerView = (RecyclerView)findViewById(R.id.RecyclerAsig);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
