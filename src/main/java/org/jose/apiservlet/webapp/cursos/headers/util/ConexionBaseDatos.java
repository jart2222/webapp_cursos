package org.jose.apiservlet.webapp.cursos.headers.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url= "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Mexico_City";
    private static String username="root";
    private static String password="MyNewPass";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
