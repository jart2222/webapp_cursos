<%@page contentType="text/html" pageEncoding="UTF-8" import=" java.util.*, org.jose.apiservlet.webapp.cursos.headers.models.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Cursos</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/cursos/form" method="post">
    <div>
        <label for="nombre">Nombre</label>
        <div>
            <input type="text" id="nombre" name="nombre"  value="${curso.nombre}">
        </div>

         <c:if test="${errores!=null && errores.containsKey('nombre') }">
             <div style="color:red;">${errores.nombre}</div>
         </c:if>

    </div>
    <div>
        <label for="instructor">Instructor</label>
        <div>
            <input type="text" id="instructor" name="instructor" value="${curso.instructor}">
        </div>

         <c:if test="${errores!=null && errores.containsKey('instructor') }">
             <div style="color:red;">${errores.instructor}</div>
         </c:if>
    </div>
    <div>
        <label for="duracion">Duracion</label>
        <div>
            <input type="number" id="duracion" name="duracion" value="${curso.duracion}">
        </div>

        <c:if test="${errores!=null && errores.containsKey('duracion') }">
            <div style="color:red;">${errores.duracion}</div>
        </c:if>

    </div>
    <div>
        <label>Descripcion</label>
        <div>
            <textarea name="descripcion" rows="5" cols="20" >${curso.descripcion}</textarea>
        </div>

        <c:if test="${errores!=null && errores.containsKey('descripcion') }">
            <div style="color:red;">${errores.descripcion}</div>
        </c:if>

    </div>
    <div><input type="submit" value="${curso.id!=null && curso.id>0?"Editar":"Crear"}"></div>
    <input type="hidden" name="id" value="${curso.id}">

</form>

</body>
</html>