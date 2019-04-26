package com.udemyandroid.introduccionconstraintlayout;

import android.arch.persistence.room.PrimaryKey;

public class NotaEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    private String titulo;
    private String Contenido;
    private boolean favorita;
    private int color;

    public NotaEntity() {
    }

    public NotaEntity(int id, String titulo, String contenido, boolean favorita, int color) {
        this.id = id;
        this.titulo = titulo;
        Contenido = contenido;
        this.favorita = favorita;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
