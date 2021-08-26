<%-- HEADER DEL SISTEMA  --%>
<jsp:include page = "../WEB-INF/template/header.jsp" />
<%-- MENU NAVEGACION DEL SISTEMA --%>
<jsp:include page = "../WEB-INF/template/navbar.jsp" />
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- VERIFICAR SESSION --%>
<%
    // Si no existe una session mandamos al usuario a la pagina login
    if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
        response.sendRedirect("index.jsp");
    }
%>
<div class ="container-fluid my-3" >
    <div class="row">
        <div class="card col-12 col-md-12 col-lg-3">
            <div class="card-body">
                <h5 class="card-title"> <i class="bi bi-person-plus-fill"></i> Agregar nuevo empleado </h5>
                <br>
                <div>
                    <form  id="formEmploye" action="${pageContext.request.contextPath}/employe?view=employes" method="POST">
                        <div class="form-group">
                            <label for ="employe_document" >Documento<span class="text-danger" >*</span></label>
                            <input type="number" class="form-control form-control-sm" name="employe_document" id ="employe_document" placeholder ="No. de documento"  value ="${dataUser.document}" >
                            <small class="form-text text-muted"><strong>Ingrese el No de documento sin espacios ni caracteres especiales</strong> </small>
                        </div>
                        <div class="form-group">
                            <label for ="employe_name" >Nombre<span class="text-danger" >*</span></label>
                            <input type="text" class="form-control form-control-sm" name="employe_name"id="employe_name" placeholder ="Nombre del empleado" value = "${dataUser.name}">
                        </div>
                        <div class="form-group">
                            <label for ="employe_surname" >Apellidos<span class="text-danger" >*</span></label>
                            <input type="text" class="form-control form-control-sm" name="employe_surname"id="employe_surname" placeholder ="Apellidos del empleado" value = "${dataUser.surname}">
                        </div>
                        <div class="form-group">
                            <label for="employe_email" >Correo electrónico<span class="text-danger" >*</span></label>
                            <input type="email" class="form-control form-control-sm" name="employe_email" id="employe_email" placeholder="Correo electrónico" value = "${dataUser.email}">
                        </div>
                        <div class="form-group">
                            <label for="employe_password" >Contraseña<span class="text-danger" >*</span></label>
                            <input type="text" class="form-control form-control-sm" name="employe_password" id ="employe_password" placeholder ="******" value = "${dataUser.password}">
                        </div>
                     
                        <div class="form-group">
                            <label for ="employe_state" >Estatus del empleado <span class="text-danger" >*</span></label>
                            <select class="form-control form-control-sm" name="employe_state" id ="employe_state" >
                                <option value ="activo"  ${dataUser.status == "Activo" ? "selected" : ""}   >Activo</option>
                                <option value ="inactivo" ${dataUser.status == "Inactivo" ? "selected" : ""}>Inactivo</option>
                            </select>
                        </div>
                      
                        <button type ="submit" name ="action" value="add"  class="btn btn-dark btn-sm" >   <i class="bi bi-plus-circle"></i> Agregar empleado</button>
                        <button type ="submit" name ="action" value="update" class ="btn btn-info btn-sm" > <i class="bi bi-check2-circle"></i> Editar empleado</button>

                    </form>
                </div>
            </div>
        </div>

        <div class="col-12 col-md-12 col-lg-9">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Documento</th>
                        <th scope="col">Empleado</th>
                        <th scope="col">Correo electrónico</th>
                        <th scope="col">Contraseña</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%--  Iteramos cada elemento de la lista de clientes--%>
                    <c:forEach var="employe"  items="${employes}" >
                        <tr>
                            <td>${employe.document} </td>
                            <td>${employe.name} ${employe.surname}</td>
                            <td>${employe.email}</td>
                            <td>${employe.password}</td>
                            <td>  <span class="badge badge-dark">  ${employe.status} </span> </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/employe?view=employes&action=load&id=${employe.id}"
                                    class ="btn btn-info btn-sm" ><i class="bi bi-pencil-square text-white"></i></a>
                                <a href="${pageContext.request.contextPath}/employe?view=employes&action=delete&id=${employe.id}"
                                   class ="btn btn-danger btn-sm" ><i class="bi bi-trash text-white"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%-- FOOTER DEL SISTEMA --%>
<script src="assets/js/employe.js" charset="UTF-8"></script>
<jsp:include page = "../WEB-INF/template/footer.jsp" />        
