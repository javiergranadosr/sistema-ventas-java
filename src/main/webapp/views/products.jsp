<%-- HEADER DEL SISTEMA  --%>
<jsp:include page = "../WEB-INF/template/header.jsp" />
<%-- MENU NAVEGACION DEL SISTEMA --%>
<jsp:include page = "../WEB-INF/template/navbar.jsp" />
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale  value ="es_MX" />

<%-- VERIFICAR SESSION --%>
<%
    // Si no existe una session mandamos al usuario a la pagina login
    if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
        response.sendRedirect("index.jsp");
    }
%>
<div class ="container-fluid my-3" >
    <div class="row">
        <div class="card col-12 col-md-12 col-lg-3">
            <div class="card-body">
                <h5 class="card-title"> <i class="bi bi-cart-plus"></i> Agregar nuevo producto </h5>
                <br>
                <div>
                    <form  id="formProduct" action="${pageContext.request.contextPath}/product?view=products" method="POST">
                        <div class="form-group">
                            <label for ="product_name" >Nombre del producto<span class="text-danger" >*</span></label>
                            <input type="text" class="form-control form-control-sm" name="product_name" id ="product_name" placeholder ="Nombre del producto"  value ="${product.name}" >
                        </div>
                        <div class="form-group">
                            <label for ="product_description" >Descripción del producto<span class="text-danger" >*</span></label>
                            <textarea class="form-control" id="product_description"  name="product_description" rows="3" placeholder ="Descripción del producto" >${product.description}</textarea>
                        </div>
                        <div class="form-group">
                            <label for ="product_unit" >Unidad del producto<span class="text-danger" >*</span></label>
                            <input type="text" class="form-control form-control-sm" name="product_unit" id="product_unit" placeholder ="Unidad del producto" value = "${product.unit}">
                        </div>
                        <div class="form-group">
                            <label for="product_price" >Precio del producto<span class="text-danger" >*</span></label>
                            <input type="number" class="form-control form-control-sm" name="product_price" id="product_price" placeholder="Precio del producto" value = "${product.price}">
                        </div>
                        
                 
                        <button type ="submit" name ="action" value="add"  class="btn btn-dark btn-sm" >   <i class="bi bi-plus-circle"></i> Agregar producto</button>
                        <button type ="submit" name ="action" value="update" class ="btn btn-info btn-sm" > <i class="bi bi-check2-circle"></i> Editar producto</button>

                    </form>
                </div>
            </div>
        </div>

        <div class="col-12 col-md-12 col-lg-9">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Descripción</th>
                        <th scope="col">Unidad</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%--  Iteramos cada elemento de la lista de clientes--%>
                    <c:forEach var="product"  items="${products}" >
                        <tr>
                            <td>${product.name} </td>
                            <td>${product.description}</td>
                            <td><span class ="badge badge-dark" >${product.unit}</span></td>
                            <td> <fmt:formatNumber  value ="${product.price}" type ="currency" />  </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/product?view=products&action=load&id=${product.id}"
                                   class ="btn btn-info btn-sm" ><i class="bi bi-pencil-square text-white"></i></a>
                                <a href="${pageContext.request.contextPath}/product?view=products&action=delete&id=${product.id}"
                                   class ="btn btn-danger btn-sm" ><i class="bi bi-trash text-white"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%-- FOOTER DEL SISTEMA --%>
<script src="assets/js/product.js" charset="UTF-8"></script>
<jsp:include page = "../WEB-INF/template/footer.jsp" />        
