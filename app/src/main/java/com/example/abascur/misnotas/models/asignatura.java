package com.example.abascur.misnotas.models;

/**
 * Created by Antonio Bascur Q. on 20/7/2019.
 */

public class asignatura {

    private String id;
    private String nombre;
    private String tipo;
    private int creditos;
    private double promedio;
    private double meta;

    public asignatura(String id, String nombre, String tipo, int creditos, double promedio, double meta) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.creditos = creditos;
        this.promedio = promedio;
        this.meta=meta;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
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
}
