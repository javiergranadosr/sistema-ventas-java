<%-- HEADER DEL SISTEMA  --%>
<jsp:include page = "../WEB-INF/template/header.jsp" />
<%-- MENU NAVEGACION DEL SISTEMA --%>
<jsp:include page = "../WEB-INF/template/navbar.jsp" />

<%-- VERIFICAR SESSION --%>
<%
    // Si no existe una session mandamos al usuario a la pagina login
    if (session.getAttribute("user") == null || session.getAttribute("user").equals("") ) {
        response.sendRedirect("../index.jsp");
    }
%>

<div class ="container" >
    <div class="jumbotron my-5">
        <h1 class="display-4">Bienvenido ${user.name} ${user.surname} </h1>
        <p class="lead"> Sistema de ventas desarrollado con Java Web.</p>
    </div>
</div>

<%-- FOOTER DEL SISTEMA --%>
<jsp:include page = "../WEB-INF/template/footer.jsp" />        
