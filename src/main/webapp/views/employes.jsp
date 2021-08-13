<%-- HEADER DEL SISTEMA  --%>
<jsp:include page = "../WEB-INF/template/header.jsp" />
<%-- MENU NAVEGACION DEL SISTEMA --%>
<jsp:include page = "../WEB-INF/template/navbar.jsp" />


<div class ="container-fluid my-5" >
    <div class="row">
        <div class="card col-md-3">
            <div class="card-body">
                <h5 class="card-title"> <i class ="fas fa-user-plus" ></i> Agregar nuevo empleado </h5>
                <br>
                <h6 class="card-subtitle mb-2 text-muted">En este panel podras gestionar los datos de los usuarios empleados del sistema.</h6>
                <div>
                    <form action="${pageContext.request.contextPath}/main-controller?view=employes" method="POST">
                        <div class="form-group">
                            <label for ="client_document" >Documento<span class="text-danger" >*</span></label>
                            <input type="number" class="form-control" name="client_document" id ="client_document">
                            <small class="form-text text-muted"><strong>Ingrese el No de documento sin espacios ni caracteres especiales</strong> </small>
                        </div>
                        <div class="form-group">
                            <label for ="client_name" >Nombre<span class="text-danger" >*</span></label>
                            <input type="text" class="form-control" name="client_name"id="client_name" >
                        </div>
                        <div class="form-group">
                            <label for="client_email" >Correo electrónico<span class="text-danger" >*</span></label>
                            <input type="email" class="form-control" name="client_email" id="client_email" >
                        </div>
                        <div class="form-group">
                            <label for="client_password" >Contraseña<span class="text-danger" >*</span></label>
                            <input type="text" class="form-control" name="client_password" id ="client_password" >
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

        <div class="col-md-9">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">id</th>
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


                </tbody>
            </table>
        </div>
    </div>
</div>

<%-- FOOTER DEL SISTEMA --%>
<jsp:include page = "../WEB-INF/template/footer.jsp" />        
