function confirmarCerrarSesion() {
    var confirmacion = confirm("¿Estás seguro de que quieres cerrar sesión?");
    
    if (confirmacion) {
        // Aquí puedes agregar el código para cerrar sesión
        // Por ejemplo, redireccionar a la página de cierre de sesión
        window.location.href = "/logout";
    }
}