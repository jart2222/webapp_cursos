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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet({"/cursos", "/index.html"})
public class CursosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn=(Connection)req.getAttribute("conn");
        CursoService cursoService= new CursosServiceJdbcImpl(conn);
        List<Curso> cursos= cursoService.listar();
        req.setAttribute("cursos", cursos);
        getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
    }
}
