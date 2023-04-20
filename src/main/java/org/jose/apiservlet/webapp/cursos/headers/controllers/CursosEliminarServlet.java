package org.jose.apiservlet.webapp.cursos.headers.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jose.apiservlet.webapp.cursos.headers.configs.CursosServicePrincipal;
import org.jose.apiservlet.webapp.cursos.headers.models.Curso;
import org.jose.apiservlet.webapp.cursos.headers.service.CursoService;
import org.jose.apiservlet.webapp.cursos.headers.service.CursosServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/cursos/eliminar")
public class CursosEliminarServlet extends HttpServlet {
    @Inject
    @CursosServicePrincipal
    private  CursoService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id;
        try {
            id=Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id=0L;
        }
        if (id>0){
            Optional<Curso> c =service.porId(id);
            if (c.isPresent()){
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath()+"/cursos");
            }else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el curso en la base de datos!");
            }
        }else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id es null, se debe enviar como parametro en la url");
        }
    }
}
