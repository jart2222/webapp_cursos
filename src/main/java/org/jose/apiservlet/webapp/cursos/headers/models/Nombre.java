package org.jose.apiservlet.webapp.cursos.headers.models;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Nombre {
    private String nombre;

    public Nombre() {
        nombre="###################si me ejecuto";
    }

    public String getNombre() {
        return nombre;
    }
}
