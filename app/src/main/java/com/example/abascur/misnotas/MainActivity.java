package com.example.abascur.misnotas;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.abascur.misnotas.adapters.asigAdapters;
import com.example.abascur.misnotas.dialogs.AgregarAsignaturaFragment;
import com.example.abascur.misnotas.models.asignatura;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //variables a utilizar en la app
    private FloatingActionButton agregarAsignatura;

    private RecyclerView recyclerView;
    private asigAdapters adapter;
    private ArrayList<asignatura> listAsig = new ArrayList<asignatura>();

    public static final String[] Asignaturas= {"Calculo I","Calculo II", "Calculo III"};
    public static final double[] Prom= {4.5,4.5,5.5};
    public static final double[] Meta= {4.5,4.5,5.5};


    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //siempre tienen que estar al comienzo del oncreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("Preference", Context.MODE_PRIVATE);

        //rellenamos con datos temporales el listado de asignaturas
      /*  for(int i=0;i<Asignaturas.length;i++)
        {
            asignatura a = new asignatura("id"+i,Asignaturas[i],"Normal",6,Prom[i],Meta[i]);
            listAsig.add(a);
        }*/

        /* actualizamos el listado*/
        atualizarListado();

        //se asocia la variable con el elelemento creado en el layaout (XML)
        agregarAsignatura=(FloatingActionButton) findViewById(R.id.fab);
        //Definición de la interfaz para que se invoque una devolución de llamada cuando se hace clic en una vista.
        agregarAsignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Se agregara una nueva asignatura!!", Toast.LENGTH_SHORT).show();
                Log.d("DebugMain","Se agregara una nueva asignatura!!");
                DialogAgregarAsignatura();
            }
        });


        /*Para cargar el listado de asignaturas a traves del adapatador*/
        adapter = new asigAdapters(listAsig);
        recyclerView = (RecyclerView)findViewById(R.id.RecyclerAsig);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);



    }

    public  void DialogAgregarAsignatura(){

        FragmentManager fm =  getSupportFragmentManager();
        AgregarAsignaturaFragment dialogFragment = new AgregarAsignaturaFragment().setAdapter(adapter).setArrayList(listAsig);
        dialogFragment.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                Toast.makeText(getApplicationContext(), "Se cerro la modal", Toast.LENGTH_LONG).show();

            }
        });
        dialogFragment.show(fm, "Sample Fragment");
    }

    public void atualizarListado(){
        String ListadoAsigString = prefs.getString("ListadoAsig", "");

        Log.d("DebugMain",ListadoAsigString.toString());
        Gson gson = new Gson();
        if (ListadoAsigString.isEmpty()) {
            Toast.makeText(getApplicationContext(),"Sin asignaturas agregadas",Toast.LENGTH_LONG).show();
        } else {
            Type type = new TypeToken<ArrayList<asignatura>>() {
            }.getType();
            listAsig = gson.fromJson(ListadoAsigString, type);
            //adapter.notifyDataSetChanged();
        }

    }
}
