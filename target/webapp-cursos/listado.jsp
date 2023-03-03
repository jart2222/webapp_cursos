<%@page contentType="text/html" pageEncoding="UTF-8" import=" java.util.*, org.jose.apiservlet.webapp.cursos.headers.models.*"%>
<%
    List<Curso> cursos=( List<Curso>)request.getAttribute("cursos");

%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Cursos 1</title>
</head>
<body>
    <h1>Tarea 9: Listado de cursos</h1>

    <p><a href="/webapp-cursos/cursos/form" >Crear<a></p>

    <form  role="search" action="<%=request.getContextPath()%>/cursos/inpeccionar" method="get">
      <input name="buscar" id="buscar" type="search" >
      <button type="submit">Buscar</button>
    </form>
    <%if(cursos.size()>0){%>
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
        <% for (Curso curso: cursos){%>
            <tr>
                <td><%=curso.getId()%></td>
                <td><%=curso.getNombre()%></td>
                <td><%=curso.getDescripcion()%></td>
                <td><%=curso.getInstructor()%></td>
                <td><%=curso.getDuracion()%></td>
                <td><a href="<%=request.getContextPath()%>/cursos/form?id=<%=curso.getId()%>" >editar</a></td>
                <td><a href="<%=request.getContextPath()%>/cursos/eliminar?id=<%=curso.getId()%>" >eliminar</a></td>
            </tr>
        <%}%>
        </table>
    <%} else{%>
        <h2> No se encontraron datos </h2>
    <%}%>
</body>
</html>
