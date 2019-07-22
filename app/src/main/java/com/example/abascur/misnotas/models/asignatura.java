package com.example.abascur.misnotas.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Antonio Bascur Q. on 20/7/2019.
 */

public class asignatura {

    private String id;
    private String nombre;
    private String tipo;
    private int creditos;
    private double promedio;
    private double notaEximicion;

    public asignatura(String id, String nombre, String tipo, int creditos, double promedio, double notaEximicion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.creditos = creditos;
        this.promedio = promedio;
        this.notaEximicion = notaEximicion;
    }

    public double getNotaEximicion() {
        return notaEximicion;
    }

    public void setNotaEximicion(double notaEximicion) {
        this.notaEximicion = notaEximicion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public JSONObject getJson(){
        JSONObject json= new JSONObject();
        try {
            json.put ("id",getId());
            json.put ("nombre",getNombre());
            json.put ("tipo",getTipo());
            json.put ("creditos",getCreditos());
            json.put ("promedio",getPromedio());
            json.put ("notaEximicion",getNotaEximicion());



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;

    }
}
