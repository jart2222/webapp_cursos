package org.jose.apiservlet.webapp.cursos.headers.service;

import jakarta.inject.Inject;
import org.jose.apiservlet.webapp.cursos.headers.configs.CursosServicePrincipal;
import org.jose.apiservlet.webapp.cursos.headers.configs.Service;
import org.jose.apiservlet.webapp.cursos.headers.models.Curso;
import org.jose.apiservlet.webapp.cursos.headers.repositories.CrudRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@CursosServicePrincipal
public class CursosServiceJdbcImpl implements CursoService{
    @Inject
    private CrudRepository<Curso> repositoryJdbc;


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
        try {
            return Optional.ofNullable(repositoryJdbc.porId(id));
        }catch (SQLException e){
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Curso curso) {
        try {
            repositoryJdbc.guardar(curso);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositoryJdbc.eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
