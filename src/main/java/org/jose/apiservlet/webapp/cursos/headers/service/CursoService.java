package org.jose.apiservlet.webapp.cursos.headers.service;

import org.jose.apiservlet.webapp.cursos.headers.models.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
    Optional<Curso> porId(Long id);

}
