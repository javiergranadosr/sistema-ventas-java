<% 
    // Si no existe una session mandamos al usuario a la pagina login
    if(session.getAttribute("user") == null) {
        response.sendRedirect("../");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home</h1>
        <h4>Bienvenido ${user.name}</h4>
    </body>
</html>
