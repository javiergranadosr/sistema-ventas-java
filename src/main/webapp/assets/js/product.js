document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("formProduct");
    form.addEventListener("submit", event => {
        const productName = document.getElementById("product_name").value;
        const productDescription = document.getElementById("product_description").value;
        const productUnit = document.getElementById("product_unit").value;
        const productPrice = document.getElementById("product_price").value;
    

        if (productName === "" || productName === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El nombre del producto es obligatorio',
                confirmButtonText: "Reintentar"
            });
            return false;
        }

        if (productDescription === "" || productDescription === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'La descripción del producto es obligatorio ',
                confirmButtonText: "Reintentar"
            });
            return false;
        }

        if (productUnit=== "" || productUnit === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'La unidad del producto es obligatorio',
                confirmButtonText: "Reintentar"
            });
            return false;
        }

        if (productPrice === "" || productPrice === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El precio del producto es obligatorio',
                confirmButtonText: "Reintentar"
            });
            return false;
        }
        return true;
    });
});