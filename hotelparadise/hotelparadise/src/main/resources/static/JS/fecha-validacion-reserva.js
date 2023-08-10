const checkInInput = document.getElementById("check-in-date");
const checkOutInput = document.getElementById("check-out-date");
const valorInput = document.getElementById("money");
const formulario = document.getElementById("formulario");


// Función para calcular la diferencia en días entre dos fechas
function calcularDiferenciaEnDias(checkInDate, checkOutDate) {
    const oneDay = 24 * 60 * 60 * 1000; // Milisegundos en un día
    const differenceInDays = Math.round((checkOutDate - checkInDate) / oneDay);
    return differenceInDays;
}

// Función para actualizar el valor en base a la diferencia de días
function actualizarValor() {
    
    	 const checkInDate = new Date(checkInInput.value); // Convertir cadena en objeto Date
        const checkOutDate = new Date(checkOutInput.value); // Convertir cadena en objeto Date   
    // Verificamos si ambas fechas son válidas
    if (!isNaN(checkInDate) && !isNaN(checkOutDate) && checkOutInput >= checkInInput) {
       
        const differenceInDays = calcularDiferenciaEnDias(checkInDate, checkOutDate);
        const baseValuePerDay = 100; // Valor base por día
        const totalValue = baseValuePerDay * (differenceInDays + 1); // Sumamos 1 para incluir el día del check-out
        valorInput.value = totalValue;
    } else {
        // Si alguna de las fechas no es válida o la fecha de check-out es anterior a la fecha de check-in, mostramos un mensaje de error o dejamos el valor en blanco
        valorInput.value = ""
    }
}

// Agregar un evento "submit" al formulario
formulario.addEventListener("submit", (event) => {
  // Verificar si los campos obligatorios están completos antes de enviar el formulario
  if (checkInInput.value === "" || checkOutInput.value === "" || valorInput.value === "") {
    event.preventDefault(); // Detener el envío del formulario
    alert("Por favor, completa todos los campos antes de enviar el formulario.");
  }
});
// Agregar eventos "change" a los inputs de fecha para actualizar el valor automáticamente
checkInInput.addEventListener("input", () => {
    const checkInDate = new Date(checkInInput.value);
    const formattedCheckInDate = checkInDate.toISOString().split('T')[0];
    checkOutInput.min = formattedCheckInDate;

    if (new Date(checkOutInput.value) < checkInDate) {
        checkOutInput.value = formattedCheckInDate;
    }

    // Calcular y actualizar el valor
    actualizarValor();
});

// Agregar un evento "change" al input de check-out
checkOutInput.addEventListener("input", () => {
    // Calcular y actualizar el valor
    actualizarValor();
});

actualizarValor();

// Agregar un evento "submit" al formulario
formulario.addEventListener("submit", (event) => {
  // Verificar si los campos obligatorios están completos antes de enviar el formulario
  if (checkInInput.value === "" || checkOutInput.value === "" || valorInput.value === "") {
    event.preventDefault(); // Detener el envío del formulario
    alert("Por favor, completa todos los campos antes de enviar el formulario.");
  }
});