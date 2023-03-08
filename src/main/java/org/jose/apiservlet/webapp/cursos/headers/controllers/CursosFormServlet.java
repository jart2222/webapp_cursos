package org.jose.apiservlet.webapp.cursos.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jose.apiservlet.webapp.cursos.headers.models.Curso;
import org.jose.apiservlet.webapp.cursos.headers.service.CursoService;
import org.jose.apiservlet.webapp.cursos.headers.service.CursosServiceJdbcImpl;
import org.jose.apiservlet.webapp.cursos.headers.util.ConexionBaseDatos;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet({"/cursos/form"})
public class CursosFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn= (Connection) req.getAttribute("conn");
        CursoService service=new CursosServiceJdbcImpl(conn);
        Long id;
        try {
            id=Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id=0L;
        }
        Curso curso=new Curso();
        if (id>0){
            Optional<Curso> c =service.porId(id);
            if (c.isPresent()){
                curso=c.get();
            }
        }
        req.setAttribute("curso",curso);
        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn= (Connection) req.getAttribute("conn");
        CursoService service=new CursosServiceJdbcImpl(conn);


        Long duracion;
        try {
            duracion=Long.valueOf(req.getParameter("duracion"));
        }catch (NumberFormatException e){
            duracion= 0l;
        }
        Long id;
        try {
            id=Long.valueOf(req.getParameter("id"));
        }catch (NumberFormatException e){
            id=0L;
        }
        String nombre= req.getParameter("nombre");
        String descripcion= req.getParameter("descripcion");
        String instructor= req.getParameter("instructor");

        Map<String, String> errores=new HashMap<>();
        if (nombre==null|| nombre.isBlank()){
            errores.put("nombre", "el nombre es requerido!");
        }
        if (descripcion==null|| descripcion.isBlank()){
            errores.put("descripcion", "La descripcion es requerido!");
        }
        if (instructor==null|| instructor.isBlank()){
            errores.put("instructor", "El instructor es requerido!");
        }
        if (duracion==null||duracion<=0){
            errores.put("duracion", "La duracion es requerida!");
        }


        Curso curso=new Curso();
        curso.setId(id);
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setInstructor(instructor);
        curso.setDuracion(duracion);

        if (errores.isEmpty()){
            service.guardar(curso);
            resp.sendRedirect(req.getContextPath()+"/cursos");
        }else {
            req.setAttribute("curso",curso);
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/form.jsp").forward(req,resp);
        }
    }
}
