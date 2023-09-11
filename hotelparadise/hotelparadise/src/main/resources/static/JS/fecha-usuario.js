
 // Obtén la fecha actual
var fechaActual = new Date();

// Formatea la fecha en dd/mm/yyyy
var dd = String(fechaActual.getDate()).padStart(2, '0');
var mm = String(fechaActual.getMonth() + 1).padStart(2, '0'); // Los meses son indexados desde 0
var yyyy = fechaActual.getFullYear();

var fechaFormateada = dd + '/' + mm + '/' + yyyy;

// Asigna la fecha formateada al elemento HTML
document.getElementById('fecha').textContent = fechaFormateada;