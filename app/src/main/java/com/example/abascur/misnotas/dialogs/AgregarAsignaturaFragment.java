package com.example.abascur.misnotas.dialogs;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.abascur.misnotas.R;
import com.example.abascur.misnotas.adapters.asigAdapters;
import com.example.abascur.misnotas.models.asignatura;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarAsignaturaFragment extends DialogFragment {


    private ArrayList<asignatura> listAsig;

    public AgregarAsignaturaFragment() {
        // Required empty public constructor
    }

    private EditText editID,editNombre,editCreditos,editNotaExim;
    private Spinner spinnerTipo;
    private Button buttonGuardar;
    private SharedPreferences prefs;
    private asigAdapters adapter;

    private DialogInterface.OnDismissListener onDismissListener;

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }
    public AgregarAsignaturaFragment setAdapter(asigAdapters adapter){
        this.adapter = adapter;
        return this;
    }

    public AgregarAsignaturaFragment setArrayList(ArrayList<asignatura> list){
        this.listAsig = list;
        return this;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_agregar_asignatura, container, false);
        prefs = getActivity().getSharedPreferences("Preference", Context.MODE_PRIVATE);

        //se inicializan las variables
        editID=v.findViewById(R.id.editID);
        editNombre=v.findViewById(R.id.editNombre);
        editCreditos=v.findViewById(R.id.editCreditos);
        editNotaExim=v.findViewById(R.id.editNotaExim);
        spinnerTipo=v.findViewById(R.id.spinnerTipo);
        buttonGuardar =v.findViewById(R.id.buttonGuardar);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asignatura nuevaAsig= new asignatura(
                        editID.getText().toString(),
                        editNombre.getText().toString(),
                        spinnerTipo.getSelectedItem().toString(),
                        Integer.parseInt(editCreditos.getText().toString()),
                        0,
                        Double.parseDouble(editNotaExim.getText().toString()));

                Gson gson = new Gson();

                listAsig.add(nuevaAsig);
                adapter.notifyDataSetChanged();

                String json2 = gson.toJson(listAsig);
                //se guarda con sharedpreference
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("ListadoAsig", String.valueOf(json2));
                editor.apply();

                Toast.makeText(getContext(), "Se guardo de forma correcta", Toast.LENGTH_SHORT).show();
                dismiss();
                //Toast.makeText(getContext(), "Model:" + nuevaAsig.getJson().toString(), Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }

}
