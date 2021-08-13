<%
    // Si no existe una session mandamos al usuario a la pagina login
    if (session.getAttribute("user") == null) {
        response.sendRedirect("../");
    }
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Sistema de ventas</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link">Inicio</a>
            </li>
            <li class="nav-item <%= request.getAttribute("active_products") != null ? "active" : ""  %> ">
                <a class="nav-link" href="${pageContext.request.contextPath}/main-controller?view=products" >Productos</a>
            </li>
            <li class="nav-item <%= request.getAttribute("active_employe") != null ? "active" : ""  %>">
                <a class="nav-link"  href="${pageContext.request.contextPath}/main-controller?view=employes" >Empleados</a>
            </li>
            <li class="nav-item <%= request.getAttribute("active_clients") != null ? "active" : ""  %> ">
                <a class="nav-link"  href="${pageContext.request.contextPath}/main-controller?view=clients" target ="my-container">Clientes</a>
            </li>
            <li class="nav-item  <%= request.getAttribute("active_sales") != null ? "active" : ""  %>" >
                <a class="nav-link"  href="${pageContext.request.contextPath}/main-controller?view=sales" target ="my-container">Ventas</a>
            </li>
        </ul>
        <div class="btn-group">
            <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${user.name} ${user.surname}
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#"><i class="fas fa-user"></i></a>
                <a class="dropdown-item" href="#">${user.email}</a>
                <div class="dropdown-divider"></div>
                <form class="dropdown-item" method="POST" action="${pageContext.request.contextPath}/logout">
                    <button class="btn btn-danger center-block" type="submit" name="action" value="logout">Cerrar sesión </button>
                </form>
            </div>
        </div>
    </div>
</nav>