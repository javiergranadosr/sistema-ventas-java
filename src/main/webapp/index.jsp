<%
    // Si existe una session mandamos al usuario a la pagina home
    if (session.getAttribute("user") != null) {
        response.sendRedirect("views/home.jsp");
    }
%>
<%-- HEADER DEL SISTEMA  --%>
<jsp:include page = "/WEB-INF/template/header.jsp" />

<div class="container center-block my-5" >
    <div class="row justify-content-center">
        <div class="card" style="width: 18rem;">
            <img src="assets/ventas.png" class="card-img-top my-2" alt="LOGO" style ="width: 40%; display:block; margin: auto" >
            <div class="card-body">
                <form method="POST" action="${pageContext.request.contextPath}/login">
                    <div class="form-group">
                        <label for ="email"  >Correo electrónico<span class="text-danger" >*</span>  </label>
                        <input type="email" class="form-control" name="email" id = "email" placeholder ="ejemplo@gmail.com" >
                    </div>
                    <div class="form-group">
                        <label for="password">Contraseña<span class ="text-danger" >*</span> </label>
                        <input type="password" class="form-control" id="password" name="password" placeholder ="******" >
                        <small> Ingrese una contraseña mayor a 5 dígitos  </small>
                    </div>
                    <button type="submit" class="btn btn-success btn-block" name="action" value="login">Ingresar</button>
                </form>
            </div>
        </div>
    </div>  
</div>

<%-- FOOTER DEL SISTEMA --%>
<jsp:include page = "/WEB-INF/template/footer.jsp" />        
