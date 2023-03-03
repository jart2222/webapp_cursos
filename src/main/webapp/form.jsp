<%@page contentType="text/html" pageEncoding="UTF-8" import=" java.util.*, org.jose.apiservlet.webapp.cursos.headers.models.*"%>

<%
  Curso curso= (Curso) request.getAttribute("curso");
  Map<String, String> errores=(Map<String, String>) request.getAttribute("errores");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Cursos</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/cursos/form" method="post">
    <div>
        <label for="nombre">Nombre</label>
        <div>
            <input type="text" id="nombre" name="nombre"  value="<%=curso.getNombre()!=null?curso.getNombre():""%>">
        </div>
        <% if (errores!=null && errores.containsKey("nombre")){%>
            <div style="color:red;"><%=errores.get("nombre")%></div>
        <%}%>

    </div>
    <div>
        <label for="instructor">Instructor</label>
        <div>
            <input type="text" id="instructor" name="instructor" value="<%=curso.getInstructor()!=null?curso.getInstructor():""%>">
        </div>
        <% if (errores!=null && errores.containsKey("instructor")){%>
            <div style="color:red;"><%=errores.get("instructor")%></div>
        <%}%>
    </div>
    <div>
        <label for="duracion">Duracion</label>
        <div>
            <input type="number" id="duracion" name="duracion" value="<%=curso.getDuracion()!=null?curso.getDuracion():""%>">
        <div>
        <% if (errores!=null && errores.containsKey("duracion")){%>
            <div style="color:red;"><%=errores.get("duracion")%></div>
        <%}%>
    </div>
    <div>
        <label>Descripcion</label>
        <div>
            <textarea name="descripcion" rows="5" cols="20" ><%=curso.getDescripcion()!=null?curso.getDescripcion():""%></textarea>
        <div>
        <%if (errores!=null && errores.containsKey("descripcion")){%>
            <div style="color:red;"><%=errores.get("descripcion")%></div>
        <%}%>
    </div>
    <div><input type="submit" value="<%=curso.getId()!=null && curso.getId()>0?"Editar":"Crear"%>"></div>
    <input type="hidden" name="id" value="<%=curso.getId()%>">

</form>

</body>
</html>