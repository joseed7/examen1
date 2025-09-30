package com.agenda.model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private List<Grupo> grupos;

    public Agenda() {
        this.contactos = new ArrayList<>();
        this.grupos = new ArrayList<>();
    }

    public void agregarContacto(Contacto c) {
        contactos.add(c);
    }

    public void eliminarContacto(int id) {
        contactos.removeIf(c -> c.getId() == id);
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public List<Contacto> listarContactos() {
        return contactos;
    }

    // --- Métodos de Grupo ---
    public void crearGrupo(int id, String nombre) {
        Grupo g = new Grupo(id, nombre);
        grupos.add(g);
    }

    public List<Grupo> listarGrupos() {
        return grupos;
    }

    public void asignarAGrupo(Contacto c, Grupo g) {
        if (c != null && g != null) {
            if (!g.getContactos().contains(c)) {
                g.getContactos().add(c);
            }
        }
    }
}


