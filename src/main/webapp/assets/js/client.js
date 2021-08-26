document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("formClient");
    form.addEventListener("submit", event => {
        const clientDocument = document.getElementById("client_document").value;
        const clientName = document.getElementById("client_name").value;
        const clientSurname = document.getElementById("client_surname").value;
        const clientEmail = document.getElementById("client_email").value;
        const clientPassword = document.getElementById("client_password").value;
        const clientState = document.getElementById("client_state").value;

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

        if (clientName === "" || clientName === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El nombre del cliente es obligatorio ',
                confirmButtonText: "Reintentar"
            });
            return false;
        }

        if (clientSurname === "" || clientSurname === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Los apellidos del cliente son obligatorios',
                confirmButtonText: "Reintentar"
            });
            return false;
        }

        if (clientEmail === "" || clientEmail === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El correo electrónico del cliente es obligatorio',
                confirmButtonText: "Reintentar"
            });
            return false;
        }

        if (clientPassword === "" || clientPassword === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'La contraseña del cliente es obligatoria',
                confirmButtonText: "Reintentar"
            });
            return false;
        }
        

        if (clientState === "" || clientState === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El estatus del cliente es obligatorio',
                confirmButtonText: "Reintentar"
            });
            return false;
        }
        return true;
    });
});