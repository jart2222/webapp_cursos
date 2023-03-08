<%@page contentType="text/html" pageEncoding="UTF-8" import=" java.util.*, org.jose.apiservlet.webapp.cursos.headers.models.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Cursos 1</title>
</head>
<body>
    <h1>Tarea 9: Listado de cursos</h1>

    <p><a href="/webapp-cursos/cursos/form" >Crear<a></p>
    <form  role="search" action="${pageContext.request.contextPath}/cursos/inpeccionar" method="get">
      <input name="buscar" id="buscar" type="search" >
      <button type="submit">Buscar</button>
    </form>
    <c:choose>
        <c:when test = "${cursos.size()>0}">
        <table>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Insthuctor</th>
                    <th>Duracion</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
                    <c:forEach items="${cursos}" var="curso">
                        <tr>
                            <td>${curso.id}</td>
                            <td>${curso.nombre}</td>
                            <td>${curso.descripcion}</td>
                            <td>${curso.instructor}</td>
                            <td>${curso.duracion}</td>
                            <td><a href="${pageContext.request.contextPath}/cursos/form?id=${curso.id}" >editar</a></td>
                            <td><a onclick="return confirm('Esta seguro que desea eliminar ?');"
                            href="${pageContext.request.contextPath}/cursos/eliminar?id=${curso.id}" >eliminar</a></td>

                        </tr>
                    </c:forEach>
                </table>
        </c:when>

        <c:otherwise>
            <h2> No se encontraron datos </h2>
        </c:otherwise>
    </c:choose>
</body>
</html>
