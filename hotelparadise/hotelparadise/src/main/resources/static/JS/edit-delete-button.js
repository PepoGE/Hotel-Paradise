// Variables para almacenar la información de la fila seleccionada
let selectedRowData = null;

//Formularios de Editar y Eliminar 
const deleteFormContainer = document.querySelector(".delete-form-container");
const editForm = document.querySelector(".edit-form");
const editFormContainer = document.querySelector(".edit-form-container");

//Botones de Menu Editar
const editButton = document.getElementById("edit-button");
const cancelEditButton = document.getElementById("cancel-button-edit");
const saveButton = document.getElementById("save-button-edit");

//Botones de Menu Eliminar
const deleteButton = document.getElementById("delete-button");
const cancelDeleteButton = document.getElementById("cancel-button-delete");
const confirmButton = document.getElementById("confirm-button-delete");


// Get all the rows in the table body
const tableRows = document.querySelectorAll('#table-body tr');

// Función para actualizar la información de la fila seleccionada
function updateSelectedRowData(row) {
    selectedRowData = {
        id: row.cells[0].textContent,
        fechaEntrada: row.cells[1].textContent,
        fechaSalida: row.cells[2].textContent,
        valor: row.cells[3].querySelector('strong').textContent,
        formaDePago: row.cells[4].querySelector('.tipo').textContent.trim()
    };
}

// Función para convertir fecha de "dd-MM-yyyy" a "YYYY-MM-DD"
function convertDateFormatToInput(dateStr) {
    const parts = dateStr.split("-");
    return `${parts[2]}-${parts[1]}-${parts[0]}`;
}

// Función para calcular la diferencia en días entre dos fechas
function calcularDiferenciaEnDias(checkInDate, checkOutDate) {
    const oneDay = 24 * 60 * 60 * 1000; // Milisegundos en un día
    const differenceInDays = Math.round((checkOutDate - checkInDate) / oneDay);
    return differenceInDays;
}

// Función para actualizar el valor en base a la diferencia de días
function actualizarValor() {
    const checkInDate = new Date(document.getElementById("edit-fechaentrada").value); // Convertir cadena en objeto Date
    const checkOutDate = new Date(document.getElementById("edit-fechasalida").value); // Convertir cadena en objeto Date   
  
    // Verificamos si ambas fechas son válidas y si checkOut es posterior o igual a checkIn
    if (!isNaN(checkInDate) && !isNaN(checkOutDate) && checkOutDate >= checkInDate) {
        const differenceInDays = calcularDiferenciaEnDias(checkInDate, checkOutDate);
        const baseValuePerDay = 100; // Valor base por día
        const totalValue = baseValuePerDay * (differenceInDays + 1); // Sumamos 1 para incluir el día del check-out
        document.getElementById("edit-valor").value = totalValue;
    } else {
        document.getElementById("edit-valor").value = "";
    }
}

// Add a click event listener to each row
tableRows.forEach(row => {
    row.addEventListener('click', () => {
        // Toggle the 'selected-row' class on the clicked row
        row.classList.toggle('selected-row');

        // Update the selected row data
        updateSelectedRowData(row);

        // Deselect other rows
        tableRows.forEach(otherRow => {
            if (otherRow !== row) {
                otherRow.classList.remove('selected-row');
            }
        });
    });
});

// Add a click event listener to the 'EDITAR' button
editButton.addEventListener('click', () => {
    // Fill the edit form with selected row data
    document.getElementById("edit-id").value = selectedRowData.id;
    document.getElementById("edit-fechaentrada").value = convertDateFormatToInput(selectedRowData.fechaEntrada); // Convertir al formato YYYY-MM-DD
    document.getElementById("edit-fechasalida").value = convertDateFormatToInput(selectedRowData.fechaSalida); // Convertir al formato YYYY-MM-DD
    document.getElementById("edit-valor").value = selectedRowData.valor;
    document.getElementById("edit-tipopago").value = selectedRowData.formaDePago;

     // Update min date for check-out
     document.getElementById("edit-fechasalida").min = document.getElementById("edit-fechaentrada").value;

    // Show the edit form with opacity transition
    editFormContainer.style.display = "block";
    editForm.style.display = "flex";
    setTimeout(() => {
        editForm.style.opacity = 1;
        editFormContainer.style.opacity = 1;
    }, 0);
});

// Add input event listener to check-in date
document.getElementById("edit-fechaentrada").addEventListener('input', () => {
    // Update min date for check-out
    document.getElementById("edit-fechasalida").min = document.getElementById("edit-fechaentrada").value;

    // Calcular y actualizar el valor
    actualizarValor();
});

// Add input event listener to check-out date
document.getElementById("edit-fechasalida").addEventListener('input', () => {
    // Calcular y actualizar el valor
    actualizarValor();
});

cancelEditButton.addEventListener('click', () => {
    // Hide the edit form with opacity transition
    editFormContainer.style.opacity = 0;
    setTimeout(() => {
        editFormContainer.style.display = "none";
        editForm.style.display = "none";
    }, 300); // Adjust the transition time as needed
});

// ... (código posterior)


// Add a click event listener to the 'ELIMINAR' button
deleteButton.addEventListener('click', () => {

    const deleteIdSpan = document.getElementById("delete-id");
    deleteIdSpan.textContent = "ID: " + selectedRowData.id;
    

    // Show the delete form with opacity transition
    deleteFormContainer.style.display = "flex";
    setTimeout(() => {
        deleteFormContainer.style.opacity = 1;
    }, 0);
});

confirmButton.addEventListener('click', () => {
    const selectedId = selectedRowData.id; // Obtén el ID de la reserva seleccionada
    const URL = document.getElementById("confirm-delete");

    // Construye la URL para la eliminación utilizando el ID
    const deleteURL = '/search/deleteReservaById/' + selectedId;

    URL.href = deleteURL


});


cancelDeleteButton.addEventListener('click', () => {
    // Hide the edit form with opacity transition
    deleteFormContainer.style.opacity = 0;
    setTimeout(() => {
        deleteFormContainer.style.display = "none";
    }, 300); // Adjust the transition time as needed
});

// ... (código posterior)