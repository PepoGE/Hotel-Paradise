// Función para verificar si un valor es numérico
function isNumeric(value) {
    return !isNaN(parseFloat(value)) && isFinite(value);
}

// Función para verificar si un valor tiene formato de fecha "dd-mm-yyyy"
function isDate(value) {
    const regex = /^\d{2}-\d{2}-\d{4}$/;
    return regex.test(value);
}

// Función para obtener el valor de una celda, considerando su tipo
function getCellValue(cell) {
    const content = cell.textContent.trim();
    if (isNumeric(content)) {
        return parseFloat(content.replace(/[^0-9.-]+/g, '')); // Convirtiendo a número
    }
    return content.toLowerCase(); // Valor de texto en minúsculas
}

// Función para formatear fechas de 'dd-mm-yyyy' a 'yyyy-mm-dd'
function convertToSortableDate(dateString) {
    const [dd, mm, yyyy] = dateString.split('-');
    return `${yyyy}-${mm}-${dd}`;
}

function formatDate(dateString) {
    const [datePart] = dateString.split(' ');
    const [yyyy, mm, dd] = datePart.split('-');
    return `${dd}-${mm}-${yyyy}`;
}

// ... (código restante)

// ... (código anterior)

document.addEventListener('DOMContentLoaded', () => {
    const dateCells = document.querySelectorAll('.date-to-format');
    dateCells.forEach((cell) => {
        const originalDate = cell.textContent.trim();
        const sortableDate = convertToSortableDate(originalDate);
        cell.setAttribute('data-sort', sortableDate); // Almacena el valor sortable
        const formattedDate = formatDate(originalDate);
        cell.textContent = formattedDate;
    });
});

// ... (resto del código)



const search = document.querySelector('.input-group input'),
    table_rows = document.querySelectorAll('tbody tr'),
    table_headings = document.querySelectorAll('thead th');

search.addEventListener('input', searchTable);

function searchTable() {
    const search_data = normalizeText(search.value.toLowerCase());

    table_rows.forEach((row, i) => {
        const table_data = normalizeText(row.textContent.toLowerCase());
        row.classList.toggle('hide', table_data.indexOf(search_data) < 0);
        row.style.setProperty('--delay', i / 25 + 's');
    });

    document.querySelectorAll('tbody tr:not(.hide)').forEach((visible_row, i) => {
        visible_row.style.backgroundColor = (i % 2 == 0) ? 'transparent' : '#0000000b';
    });
}

table_headings.forEach((head, i) => {
    let sort_asc = true;
    head.onclick = () => {
        table_headings.forEach(head => head.classList.remove('active'));
        head.classList.add('active');

        document.querySelectorAll('td').forEach(td => td.classList.remove('active'));
        table_rows.forEach(row => {
            row.querySelectorAll('td')[i].classList.add('active');
        });

        head.classList.toggle('asc', sort_asc);
        sort_asc = head.classList.contains('asc') ? false : true;

        sortTable(i, sort_asc);
    };
});

function sortTable(column, sort_asc) {
    const rowsArray = Array.from(table_rows);

    rowsArray.sort((a, b) => {
        const first_row_cell = a.querySelectorAll('td')[column];
        const second_row_cell = b.querySelectorAll('td')[column];

        const first_row_value = getCellValue(first_row_cell);
        const second_row_value = getCellValue(second_row_cell);

        const trimmed_first = String(first_row_value).trim().toUpperCase();
        const trimmed_second = String(second_row_value).trim().toUpperCase();

        if (trimmed_first === "N/A") {
            return sort_asc ? -1 : 1;
        } else if (trimmed_second === "N/A") {
            return sort_asc ? 1 : -1;
        } else if (isNumeric(trimmed_first)) {
            return sort_asc ? (trimmed_first - trimmed_second) : (trimmed_second - trimmed_first);
        } else if (isDate(trimmed_first)) {
            const dateA = convertToSortableDate(first_row_value);
            const dateB = convertToSortableDate(second_row_value);
            return sort_asc ? (dateA.localeCompare(dateB)) : (dateB.localeCompare(dateA));
        } else {
            return sort_asc ? (trimmed_first.localeCompare(trimmed_second)) : (trimmed_second.localeCompare(trimmed_first));
        }
    });

    rowsArray.forEach(sorted_row => document.querySelector('tbody').appendChild(sorted_row));
}

// ... (resto del código)
