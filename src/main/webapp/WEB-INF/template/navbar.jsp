<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Sistema de ventas</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item  <%= request.getAttribute("active_home") != null ? "active" : ""  %>" >
                <a class="nav-link"  href="${pageContext.request.contextPath}/home?view=home">Inicio</a>
            </li>
            <li class="nav-item <%= request.getAttribute("active_product") != null ? "active" : ""  %> ">
                <a class="nav-link" href="${pageContext.request.contextPath}/product?view=products&action=read" >Productos</a>
            </li>
            <li class="nav-item <%= request.getAttribute("active_employe") != null ? "active" : ""  %>">
                <a class="nav-link"  href="${pageContext.request.contextPath}/employe?view=employes&action=read" >Empleados</a>
            </li>
            <li class="nav-item <%= request.getAttribute("active_client") != null ? "active" : ""  %> ">
                <a class="nav-link"  href="${pageContext.request.contextPath}/client?view=clients&action=read">Clientes</a>
            </li>
            <li class="nav-item  <%= request.getAttribute("active_sales") != null ? "active" : ""  %>" >
                <a class="nav-link"  href="${pageContext.request.contextPath}/page?view=sales" target ="my-container">Ventas</a>
            </li>
        </ul>
        <div class="btn-group">
            <button type="button" class="btn btn-info btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="bi bi-person-circle"></i> ${user.name} ${user.surname}
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#"><i class="bi bi-envelope-open"></i> ${user.email} </a>
                <div class="dropdown-divider"></div>
                <form class="dropdown-item" method="POST" action="${pageContext.request.contextPath}/logout">
                    <button class="btn btn-danger  btn-sm center-block" type="submit" name="action" value="logout"><i class="bi bi-box-arrow-left"></i> Cerrar sesión </button>
                </form>
            </div>
        </div>
    </div>
</nav>