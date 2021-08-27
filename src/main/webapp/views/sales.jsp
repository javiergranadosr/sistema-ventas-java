<%-- HEADER DEL SISTEMA  --%>
<jsp:include page = "../WEB-INF/template/header.jsp" />
<%-- MENU NAVEGACION DEL SISTEMA --%>
<jsp:include page = "../WEB-INF/template/navbar.jsp" />
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- VERIFICAR SESSION --%>
<%
    // Si no existe una session mandamos al usuario a la pagina login
    if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
        response.sendRedirect("index.jsp");
    }
%>
<div  class="container-fluid my-3" >
    <div class="row">
        <div class="col-md-5">
            <div class="card">
                <h5 class="card-header"><i class="bi bi-info-circle"></i> Datos del cliente</h5>
                <div class="card-body">
                    <form method="POST" action="${pageContext.request.contextPath}/sale?view=sales">
                        <div class="row">
                            <div class="col-md-4 d-flex">
                                <input type="number" name="client_document"  id="client_document" class="form-control form-control-sm" placeholder="# Documento">
                                <button type ="submit" name ="action" value="search_client"  class="btn btn-dark btn-sm"  data-toggle="tooltip" data-placement="top" title="Buscar cliente">   <i class="bi bi-search"></i></button>
                            </div>
                            <div class="col-md-8 d-flex">
                                <input type="text" name="client_name"  id="client_name" class="form-control form-control-sm" value="${client.name} ${client.surname}" placeholder="Nombre del cliente">
                            </div>
                        </div>
                        <div class="row"></div>

                    </form>
                </div>
            </div>
            <div class="card">
                <h5 class="card-header"><i class="bi bi-info-circle"></i> Datos del producto</h5>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/sale?view=sales" method="POST">
                        <div class="row">
                            <div class="col-md-4 d-flex form-group">
                                <input type="number" name="product_code"  id="product_code" class="form-control form-control-sm" placeholder="Código del producto" value="${product.id}">
                                <button type ="submit" name ="action" value="search_product"  class="btn btn-dark btn-sm"  data-toggle="tooltip" data-placement="top" title="Buscar producto">   <i class="bi bi-search"></i></button>
                            </div>
                            <div class="col-md-8 d-flex form-group">
                                <input type="text" name="product_name" id="product_name" class="form-control form-control-sm" placeholder="Nombre del producto" value="${product.name}">
                            </div>
                            <div class="col-md-4 d-flex form-group">
                                <input type="text" name="product_price"  id="product_price" class="form-control form-control-sm" placeholder="$ 0000.00" value="${product.price}">
                            </div>
                            <div class="col-md-8 d-flex form-group">
                                <input type="number" value="1" name="product_amount"  id="product_amount" class="form-control form-control-sm" placeholder=" Cantidad de productos">
                            </div>
                        </div>
                        <button type ="submit" name ="action" value="add_product"  class="btn btn-dark btn-sm btn-block" >   <i class="bi bi-plus-circle"></i> Agregar producto</button>
                        <div class="row"></div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-7">
            <div class="card">
                <div class="card-header">
                    <div class="form-group">
                        <label for="invoice_number">Numero de factura</label>
                        <input type="text" class="form-control form-control-sm" name="invoice_number" id="invoice_number" placeholder="# de factura">
                    </div>


                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead >
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Código</th>
                                <th scope="col">Producto</th>
                                <th scope="col">Precio</th>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Total</th>
                                <th scope="col" >Acciones</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                <div class="card-footer d-flex">
                    <div class="col-md-8">
                        <a class="btn btn-dark btn-sm" onclick="print()" href=""> <i class="bi bi-currency-dollar"></i> Generar venta</a>
                        <a class="btn btn-info btn-sm" href=""><i class="bi bi-cart-plus"></i> Nueva venta</a>

                    </div>
                    <div class="col-md-4">
                        <input type=text" name="total" id="total" class="form-control form-control-sm" placeholder="$ 00.000.00" disabled="disabled">
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>

<%-- FOOTER DEL SISTEMA --%>
<script src="" charset="UTF-8"></script>
<jsp:include page = "../WEB-INF/template/footer.jsp" />        
