package org.jose.apiservlet.webapp.cursos.headers.repositories;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository<T> {
    List<T> listar() throws SQLException;
    T porId(Long id) throws SQLException;

    List<T> porNombre(String nombre) throws SQLException;
    void guardar(T t) throws SQLException;
    void eliminar(Long id) throws SQLException;
}
