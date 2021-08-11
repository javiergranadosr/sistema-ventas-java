<%
    // Si no existe una session mandamos al usuario a la pagina login
    if (session.getAttribute("user") == null) {
        response.sendRedirect("../");
    }
%>

<!doctype html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <title>Sistema de ventas - Inicio</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Sistema de ventas</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/main-controller?view=products" target ="my-container" >Productos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"  href="${pageContext.request.contextPath}/main-controller?view=employes" target ="my-container">Empleados</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"  href="${pageContext.request.contextPath}/main-controller?view=clients" target ="my-container">Clientes</a>
                    </li>
                    <li class="nav-item" >
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
                        <form class="dropdown-item" method="POST" action="${pageContext.request.contextPath}/user-controller">
                            <button class="btn btn-danger center-block" type="submit" name="action" value="logout">Cerrar sesión </button>
                        </form>
                    </div>
                </div>
            </div>
        </nav>

        <div class="my-3">
            <iframe name="my-container" style="height:100%; width:100%;" frameBorder="0"></iframe>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
