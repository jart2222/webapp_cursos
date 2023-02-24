package org.jose.apiservlet.webapp.cursos.headers.service;

import org.jose.apiservlet.webapp.cursos.headers.models.Curso;
import org.jose.apiservlet.webapp.cursos.headers.repositories.CursosRepositoryJdbcImpl;
import org.jose.apiservlet.webapp.cursos.headers.repositories.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CursosServiceJdbcImpl implements CursoService{
    private Repository repositoryJdbc;

    public CursosServiceJdbcImpl(Connection connection) {
        this.repositoryJdbc=new CursosRepositoryJdbcImpl(connection);
    }

    @Override
    public List<Curso> listar() {
        try {
            return repositoryJdbc.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        try {
            return repositoryJdbc.porNombre(nombre);
        }catch (SQLException e){
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Curso> porId(Long id) {
        return Optional.empty();
    }
}
