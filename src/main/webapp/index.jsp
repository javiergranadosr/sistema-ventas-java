<% 
    // Si existe una session mandamos al usuario a la pagina home
    if(session.getAttribute("user") != null) {
        response.sendRedirect("views/home.jsp");
    }
%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title>Sistema de ventas</title>
    </head>
    <body>
        <div class="container center-block my-5" >
            <div class="row justify-content-center">
                <div class="card" style="width: 18rem;">
                    <img src="assets/ventas.png" class="card-img-top my-2" alt="LOGO" style ="width: 40%; display:block; margin: auto" >
                    <div class="card-body">
                        <form method="POST" action="${pageContext.request.contextPath}/user-controller">
                            <div class="form-group">
                                <label for ="email"  >Correo electrónico </label>
                                <input type="email" class="form-control" name="email" id = "email">
                            </div>
                            <div class="form-group">
                                <label for="password">Contraseña</label>
                                <input type="password" class="form-control" id="password" name="password">
                            </div>
                            <button type="submit" class="btn btn-success btn-block" name="action" value="login">Ingresar</button>
                        </form>
                    </div>
                </div>
            </div>  
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
