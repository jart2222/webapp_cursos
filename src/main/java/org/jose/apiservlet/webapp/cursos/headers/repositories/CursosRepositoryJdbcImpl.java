package org.jose.apiservlet.webapp.cursos.headers.repositories;

import org.jose.apiservlet.webapp.cursos.headers.models.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursosRepositoryJdbcImpl implements Repository<Curso>{
    private Connection conn;

    public CursosRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Curso> listar() throws SQLException {
        List<Curso> cursos =new ArrayList<>();
        try(Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM java_curso.cursos");
        ) {
            while (rs.next()){
                Curso curso = getCurso(rs);
                cursos.add(curso);
            }
            return cursos;
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) throws SQLException {
        List<Curso> cursos =new ArrayList<>();
        try(PreparedStatement stmt= conn.prepareStatement("SELECT * FROM cursos as c WHERE c.nombre like ?")) {
            stmt.setString(1, "%" + nombre + "%");
            try(ResultSet rs=stmt.executeQuery()) {
                while (rs.next()){
                    Curso curso = getCurso(rs);
                    cursos.add(curso);
                }
            }
        }
        return cursos;
    }

    @Override
    public Curso porId(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Curso curso) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    private static Curso getCurso(ResultSet rs) throws SQLException {
        Curso curso= new Curso();
        curso.setId(rs.getInt(1));
        curso.setNombre(rs.getString(2));
        curso.setDescripcion(rs.getString(3));
        curso.setInstructor(rs.getString(4));
        curso.setDuracion(rs.getLong(5));
        return curso;
    }
}
