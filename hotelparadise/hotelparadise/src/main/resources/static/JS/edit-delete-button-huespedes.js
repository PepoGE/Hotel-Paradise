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
        nombre: row.cells[1].textContent,
        apellido: row.cells[2].textContent,
        fechaNacimiento: row.cells[3].textContent,
        paisNombre: row.cells[4].textContent,
        telefono: row.cells[5].textContent,
        reservaId: row.cells[6].textContent
    };
}

// Función para convertir fecha de "dd-MM-yyyy" a "YYYY-MM-DD"
function convertDateFormatToInput(dateStr) {
    const parts = dateStr.split("-");
    return `${parts[2]}-${parts[1]}-${parts[0]}`;
}

// Función para actualizar el valor en base a la diferencia de días
function actualizarValor() {
    const bornDate = new Date(document.getElementById("edit-fechaentrada").value); // Convertir cadena en objeto Date
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
    document.getElementById("edit-name").value =selectedRowData.nombre; 
    document.getElementById("edit-lastName").value =selectedRowData.apellido; // Convertir al formato YYYY-MM-DD
    document.getElementById("edit-bornDate").value = convertDateFormatToInput(selectedRowData.fechaNacimiento); // Convertir al formato YYYY-MM-DD

        // Find the select element for country
        var countrySelect = document.getElementById("edit-countryName");
    
        // Loop through the options and set the 'selected' property based on selectedRowData.paisNombre
        for (var i = 0; i < countrySelect.options.length; i++) {
            if (countrySelect.options[i].textContent === selectedRowData.paisNombre) {
                countrySelect.options[i].selected = true;
            } else {
                countrySelect.options[i].selected = false; // Ensure other options are not selected
            }
        }
        

    document.getElementById("edit-cellphone").value = selectedRowData.telefono;
    document.getElementById("edit-reservaId").value = selectedRowData.reservaId;


    // Show the edit form with opacity transition
    editFormContainer.style.display = "block";
    editForm.style.display = "flex";
    setTimeout(() => {
        editForm.style.opacity = 1;
        editFormContainer.style.opacity = 1;
    }, 0);
});

cancelEditButton.addEventListener('click', () => {
    // Hide the edit form with opacity transition
    editFormContainer.style.opacity = 0;
    setTimeout(() => {
        editFormContainer.style.display = "none";
        editForm.style.display = "none";
    }, 300); // Adjust the transition time as needed
});

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
    const deleteURL = '/huespedes/deleteHuespedById/' + selectedId;

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