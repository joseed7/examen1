package com.agenda.model;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private int id;
    private String nombre;
    private List<Contacto> contactos;

    public Grupo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.contactos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }
}

