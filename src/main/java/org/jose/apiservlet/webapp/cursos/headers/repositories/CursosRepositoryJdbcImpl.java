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
        Curso curso=null;
        try(PreparedStatement stmt=conn.prepareStatement("select * from cursos as c where c.id=?")) {
            stmt.setLong(1, id);
            try(ResultSet rs= stmt.executeQuery()) {
                if (rs.next()){
                    curso=getCurso(rs);
                }
            }
        }
        return curso;
    }

    @Override
    public void guardar(Curso curso) throws SQLException {
        String sql;

        if (curso.getId()!=null && curso.getId()>0){
            sql="update cursos set  nombre=?, descripcion=?,instructor=?, duracion=? where id=?";
        }else {
            sql="INSERT INTO cursos (nombre, descripcion, instructor, duracion) VALUES (?, ?, ?, ?)";
        }
        try (PreparedStatement stmt=conn.prepareStatement(sql)) {
            stmt.setString(1,curso.getNombre());
            stmt.setString(2,curso.getDescripcion());
            stmt.setString(3,curso.getInstructor());
            stmt.setLong(4, curso.getDuracion());

            if (curso.getId()!=null && curso.getId()>0){
            stmt.setLong(5, curso.getId());
            }

            stmt.executeUpdate();

        }

    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(PreparedStatement stmt= conn.prepareStatement("DELETE FROM cursos WHERE (id = ?)")) {
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }

    }

    private static Curso getCurso(ResultSet rs) throws SQLException {
        Curso curso= new Curso();
        curso.setId(rs.getLong(1));
        curso.setNombre(rs.getString(2));
        curso.setDescripcion(rs.getString(3));
        curso.setInstructor(rs.getString(4));
        curso.setDuracion(rs.getLong(5));
        return curso;
    }
}
