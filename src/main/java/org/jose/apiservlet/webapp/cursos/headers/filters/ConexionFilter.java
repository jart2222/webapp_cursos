package org.jose.apiservlet.webapp.cursos.headers.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.jose.apiservlet.webapp.cursos.headers.service.ServiceJdbcException;
import org.jose.apiservlet.webapp.cursos.headers.util.ConexionBaseDatos;
import org.jose.apiservlet.webapp.cursos.headers.util.ConexionBaseDatosDS;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
@WebFilter("/*")
public class ConexionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request,response);
        }catch (ServiceJdbcException e){
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            e.printStackTrace();
        }

    }
}

