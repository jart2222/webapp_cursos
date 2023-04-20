package org.jose.apiservlet.webapp.cursos.headers.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jose.apiservlet.webapp.cursos.headers.configs.CursosServicePrincipal;
import org.jose.apiservlet.webapp.cursos.headers.configs.MysqlConn;
import org.jose.apiservlet.webapp.cursos.headers.models.Curso;
import org.jose.apiservlet.webapp.cursos.headers.models.Nombre;
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

    @Inject
    @CursosServicePrincipal
    private  CursoService cursoService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Curso> cursos= cursoService.listar();
        req.setAttribute("cursos", cursos);
        req.setAttribute("title", req.getAttribute("title")+"Listado de cursos");
        getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
    }
}
