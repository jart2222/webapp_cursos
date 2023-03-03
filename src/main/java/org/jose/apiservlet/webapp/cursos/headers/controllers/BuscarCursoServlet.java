package org.jose.apiservlet.webapp.cursos.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jose.apiservlet.webapp.cursos.headers.models.Curso;
import org.jose.apiservlet.webapp.cursos.headers.service.CursoService;
import org.jose.apiservlet.webapp.cursos.headers.service.CursosServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet({"/cursos/inpeccionar"})
public class BuscarCursoServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> parametroBuscar = Optional.ofNullable((String) req.getParameter("buscar"));
        Connection conn=(Connection)req.getAttribute("conn");
        CursoService cursoService= new CursosServiceJdbcImpl(conn);
        List<Curso> cursos;
        if (parametroBuscar.isPresent()){
            cursos=cursoService.porNombre(parametroBuscar.get());
        }else {
            cursos=cursoService.listar();

        }
        req.setAttribute("cursos", cursos);
        getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);


    }
}
