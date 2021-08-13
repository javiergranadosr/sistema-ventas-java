<%-- HEADER DEL SISTEMA  --%>
<jsp:include page = "../WEB-INF/template/header.jsp" />
<%-- MENU NAVEGACION DEL SISTEMA --%>
<jsp:include page = "../WEB-INF/template/navbar.jsp" />


<div class ="container" >
    <div class="jumbotron my-5">
        <h1 class="display-4">Bienvenido ${user.name} ${user.surname} </h1>
        <p class="lead"> Sistema de ventas desarrollado con Java Web.</p>
    </div>
</div>

<%-- FOOTER DEL SISTEMA --%>
<jsp:include page = "../WEB-INF/template/footer.jsp" />        
