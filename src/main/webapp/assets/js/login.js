document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("formLogin");
    form.addEventListener("submit", event => {
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;
        if (email === "" || email === undefined) {
            event.preventDefault();
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El correo electrónico es obligatorio',
                confirmButtonText: "Reintentar"
            });
            return false;
        }
        if (password === "" || password === undefined) {
            event.preventDefault();
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'La contraseña es obligatoria',
                confirmButtonText: "Reintentar"
            });
            return false;
        }
        return true;
    });
});











