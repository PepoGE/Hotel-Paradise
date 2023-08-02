
// Obtener referencias a los inputs de fecha de check-in y check-out
const checkInInput = document.getElementById("check-in-date");
const checkOutInput = document.getElementById("check-out-date");

// Agregar un evento "change" al input de check-in
checkInInput.addEventListener("change", () => {
    // Obtener el valor seleccionado en el input de check-in
    const checkInDate = new Date(checkInInput.value);

    // Formatear la fecha de check-in para establecer el atributo "min" en el input de check-out
    const formattedCheckInDate = checkInDate.toISOString().split('T')[0];

    // Actualizar el atributo "min" del input de check-out para bloquear fechas anteriores
    checkOutInput.min = formattedCheckInDate;

    // Si el valor actual del input de check-out es anterior al check-in, actualizarlo
    if (new Date(checkOutInput.value) < checkInDate) {
        checkOutInput.value = formattedCheckInDate;
    }
});
