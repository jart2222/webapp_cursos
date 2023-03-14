<%@page contentType="text/html" pageEncoding="UTF-8" import=" java.util.*, org.jose.apiservlet.webapp.cursos.headers.models.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="layout/header.jsp" />

<div class="row my-4">
    <p><a href="/webapp-cursos/cursos" class="btn btn-light">Volver</a></p>
</div>


<form action="${pageContext.request.contextPath}/cursos/form" method="post">
    <div class="row mb-2">
        <label for="nombre" class="col-form-label col-sm-2">Nombre</label>
        <div class="col-sm-4">
            <input type="text" id="nombre" name="nombre"  value="${curso.nombre}" class="form-control" >
        </div>

         <c:if test="${errores!=null && errores.containsKey('nombre') }">
             <div style="color:red;">${errores.nombre}</div>
         </c:if>

    </div>
    <div class="row mb-2">
        <label for="instructor" class="col-form-label col-sm-2">Instructor</label>
        <div class="col-sm-4">
            <input type="text" id="instructor" name="instructor" value="${curso.instructor}" class="form-control" >
        </div>

         <c:if test="${errores!=null && errores.containsKey('instructor') }">
             <div style="color:red;">${errores.instructor}</div>
         </c:if>
    </div>
    <div class="row mb-2">
        <label for="duracion" class="col-form-label col-sm-2">Duracion</label>
        <div class="col-sm-4">
            <input type="number" id="duracion" name="duracion" value="${curso.duracion}" class="form-control" >
        </div>

        <c:if test="${errores!=null && errores.containsKey('duracion') }">
            <div style="color:red;">${errores.duracion}</div>
        </c:if>

    </div>
    <div class="row mb-2">
        <label for="descripcion" class="col-form-label col-sm-2">Descripcion</label>
        <div class="col-sm-4">
            <textarea name="descripcion" rows="5" cols="20" class="form-control" >${curso.descripcion}</textarea>
        </div>

        <c:if test="${errores!=null && errores.containsKey('descripcion') }">
            <div style="color:red;">${errores.descripcion}</div>
        </c:if>

    </div>
    <div><input type="submit" value="${curso.id!=null && curso.id>0?"Editar":"Crear"}" class="btn btn-sm btn-primary"></div>
    <input type="hidden" name="id" value="${curso.id}">

</form>

<jsp:include page="layout/footer.jsp" />
