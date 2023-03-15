<%@page contentType="text/html" pageEncoding="UTF-8" import=" java.util.*, org.jose.apiservlet.webapp.cursos.headers.models.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="layout/header.jsp" />
   <div class="row my-4">
       <div class='col-3'>
            <form  role="search" action="${pageContext.request.contextPath}/cursos/inpeccionar" method="get" class="d-flex" >
              <input name="buscar" id="buscar" class="form-control me-2" type="search"  placeholder="Nombre del curso" aria-label="Search" >
              <button type="submit" class="btn btn-outline-success" ><i class="bi bi-search"></i></button>
            </form>
        </div>
        <div class='col-7'>
        </div>
        <div class='col-2'>
           <p><a href="/webapp-cursos/cursos/form" class="btn btn-primary my-2"><i class="bi bi-file-earmark-plus"></i><a></p>
        </div>
   </div>

   <div class="row my-4">
        <div class='col-12'>
            <c:choose>
                <c:when test = "${cursos.size()>0}">
                <table class="table table-hover table-striped">
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Descripcion</th>
                            <th>Instructor</th>
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
                                    <td><a class="btn btn-sm btn-primary"  href="${pageContext.request.contextPath}/cursos/form?id=${curso.id}" ><i class="bi bi-pencil-square"></i></a></td>
                                    <td><a class="btn btn-sm btn-danger" onclick="return confirm('Esta seguro que desea eliminar ?');"
                                    href="${pageContext.request.contextPath}/cursos/eliminar?id=${curso.id}" ><i class="bi bi-trash3"></i></a></td>

                                </tr>
                            </c:forEach>
                        </table>
                </c:when>

                <c:otherwise>
                    <h2> No se encontraron datos </h2>
                </c:otherwise>
            </c:choose>
        </div>
   </div>


<jsp:include page="layout/footer.jsp" />
