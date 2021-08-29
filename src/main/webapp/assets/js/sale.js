document.addEventListener("DOMContentLoaded", () => {
    const formSearchClient = document.getElementById("formSearchClient");
    const formSearchProduct = document.getElementById("formSearchProduct");
    const formAddProduct = document.getElementById("formAddProduct");

    // Datos de la busqueda del cliente
    let clientDocument;
    let clientName;

    // Datos de la busqueda del producto
    let productCode;
    let productName;
    let productPrice;
    let productAmount;

    formSearchClient.addEventListener("submit", event => {
        clientDocument = document.getElementById("client_document").value;

        if (clientDocument === "" || clientDocument === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El # de documento del cliente es obligatorio',
                confirmButtonText: "Reintentar"
            });
            return false;
        }
        return true;
    });


    formSearchProduct.addEventListener("submit", event => {
        productCode = document.getElementById("product_code").value;
        if (productCode === "" || productCode === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El código del producto es obligatorio',
                confirmButtonText: "Reintentar"
            });
            return false;
        }
        return true;
    });
});


