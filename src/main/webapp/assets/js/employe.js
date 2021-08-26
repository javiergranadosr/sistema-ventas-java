document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("formEmploye");
    form.addEventListener("submit", event => {
        const employeDocument = document.getElementById("employe_document").value;
        const employeName = document.getElementById("employe_name").value;
        const employeSurname = document.getElementById("employe_surname").value;
        const employeEmail = document.getElementById("employe_email").value;
        const employePassword = document.getElementById("employe_password").value;
        const employeState = document.getElementById("employe_state").value;

        if (employeDocument === "" || employeDocument === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El # de documento del empleado es obligatorio',
                confirmButtonText: "Reintentar"
            });
            return false;
        }

        if (employeName === "" || employeName === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El nombre del empleado es obligatorio ',
                confirmButtonText: "Reintentar"
            });
            return false;
        }

        if (employeSurname === "" || employeSurname === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Los apellidos del empleado son obligatorios',
                confirmButtonText: "Reintentar"
            });
            return false;
        }

        if (employeEmail === "" || employeEmail === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El correo electrónico del empleado es obligatorio',
                confirmButtonText: "Reintentar"
            });
            return false;
        }

        if (employePassword === "" || employePassword === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'La contraseña del empleado es obligatoria',
                confirmButtonText: "Reintentar"
            });
            return false;
        }
        

        if (employeState === "" || employeState === undefined) {
            event.preventDefault();

            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El estatus del empleado es obligatorio',
                confirmButtonText: "Reintentar"
            });
            return false;
        }
        return true;
    });
});