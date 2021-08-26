<%
    // Si existe una session mandamos al usuario a la pagina home
    if (session.getAttribute("user") != null) {
        response.sendRedirect("views/home.jsp");
    }
%>
<%-- HEADER DEL SISTEMA  --%>
<jsp:include page = "/WEB-INF/template/header.jsp" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="container center-block my-5" >
    <div class="row justify-content-center">
        <div class="card" style="width: 18rem;">
            <img src="assets/ventas.png" class="card-img-top my-2" alt="LOGO" style ="width: 40%; display:block; margin: auto" >

            <c:if test="${message != null}" >
                <div class="alert alert-warning alert-dismissible m-2" role="alert">
                    <strong>Oops.</strong> ${message}
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>

            <div class="card-body">
                <form method="POST"  id="formLogin" action="${pageContext.request.contextPath}/login" >
                    <div class="form-group">
                        <label for ="email"  >Correo electrónico<span class="text-danger" >*</span>  </label>
                        <input type="email" class="form-control" name="email" id = "email" placeholder ="ejemplo@gmail.com" >
                    </div>
                    <div class="form-group">
                        <label for="password">Contraseña<span class ="text-danger" >*</span> </label>
                        <input type="password" class="form-control" id="password" name="password" placeholder ="******" >
                        <small> Ingrese una contraseña mayor a 5 dígitos  </small>
                    </div>
                    <button type="submit" class="btn btn-success btn-block" name="action" id="action" value="login">Ingresar</button>
                </form>
            </div>
        </div>
    </div>  
</div>

<%-- FOOTER DEL SISTEMA --%>
<script src="assets/js/login.js" charset="UTF-8"></script>
<jsp:include page = "/WEB-INF/template/footer.jsp" />        
