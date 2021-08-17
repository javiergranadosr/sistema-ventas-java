<%-- HEADER DEL SISTEMA  --%>
<jsp:include page = "../WEB-INF/template/header.jsp" />
<%-- MENU NAVEGACION DEL SISTEMA --%>
<jsp:include page = "../WEB-INF/template/navbar.jsp" />

<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class ="container-fluid my-3" >
    <div class="row">
        <div class="card col-12 col-md-12 col-lg-3">
            <div class="card-body">
                <h5 class="card-title"> <i class ="fas fa-user-plus" ></i> Agregar nuevo empleado </h5>
                <br>
                <h6 class="card-subtitle mb-2 text-muted">En este panel podras gestionar los datos de los usuarios empleados del sistema.</h6>
                <div>
                    <form action="${pageContext.request.contextPath}/main-controller?view=employes" method="POST">
                        <div class="form-group">
                            <label for ="client_document" >Documento<span class="text-danger" >*</span></label>
                            <input type="number" class="form-control form-control-sm" name="client_document" id ="client_document" placeholder ="No. de documento" >
                            <small class="form-text text-muted"><strong>Ingrese el No de documento sin espacios ni caracteres especiales</strong> </small>
                        </div>
                        <div class="form-group">
                            <label for ="client_name" >Nombre<span class="text-danger" >*</span></label>
                            <input type="text" class="form-control form-control-sm" name="client_name"id="client_name" placeholder ="Nombre del empleado" >
                        </div>
                        <div class="form-group">
                            <label for="client_email" >Correo electrónico<span class="text-danger" >*</span></label>
                            <input type="email" class="form-control form-control-sm" name="client_email" id="client_email" placeholder="Correo electrónico" >
                        </div>
                        <div class="form-group">
                            <label for="client_password" >Contraseña<span class="text-danger" >*</span></label>
                            <input type="text" class="form-control form-control-sm" name="client_password" id ="client_password" placeholder ="******" >
                        </div>
                        <div class="form-group">
                            <label for="client_role" >Rol del empleado <span class="text-danger" >*</span> </label>
                            <select class="form-control form-control-sm" name="client_role" id="client_role" >
                                <option value ="empleado" >Empleado</option>
                                <option value= "cliente" >Cliente</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for ="client_state" >Estatus del empleado <span class="text-danger" >*</span></label>
                            <select class="form-control form-control-sm" name="client_state" id ="client_state" >
                                <option value ="activo" >Activo</option>
                                <option value ="inactivo" >Inactivo</option>
                            </select>
                        </div>

                        <input type="submit" class="btn btn-primary" name="action" value="Agregar empleado" >
                        <input type="submit" class="btn btn-success" name="action" value="Editar empleado" >
                    </form>
                </div>
            </div>
        </div>

        <div class="col-12 col-md-12 col-lg-9">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Documento</th>
                        <th scope="col">Nombres</th>
                        <th scope="col">Correo</th>
                        <th scope="col">Contraseña</th>
                        <th scope="col">Rol</th>
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
                        <td>${employe.rol}</td>
                        <td>${employe.status}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}"
                               ><i class="fas fa-edit text-primary"></i></a>
                            <a href="${pageContext.request.contextPath}"
                               ><i class="fas fa-trash text-danger"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%-- FOOTER DEL SISTEMA --%>
<jsp:include page = "../WEB-INF/template/footer.jsp" />        
