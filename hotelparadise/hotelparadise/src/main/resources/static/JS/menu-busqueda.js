// Función para formatear las fechas de 'yyyy-mm-dd 00:00:00.0' a 'dd-mm-yyyy'
// Función para formatear las fechas de 'yyyy-mm-dd HH:mm:ss.s' a 'dd-mm-yyyy'
function formatDate(dateString) {
    const [datePart] = dateString.split(' ');
    const [yyyy, mm, dd] = datePart.split('-');
    return `${dd}-${mm}-${yyyy}`;
}

document.addEventListener('DOMContentLoaded', () => {
    const dateCells = document.querySelectorAll('.date-to-format');
    dateCells.forEach((cell) => {
        const originalDate = cell.textContent.trim();
        const formattedDate = formatDate(originalDate);
        cell.textContent = formattedDate;
    });
});

const search = document.querySelector('.input-group input'),
    table_rows = document.querySelectorAll('tbody tr'),
    table_headings = document.querySelectorAll('thead th');


// 1. Searching for specific data of HTML table
search.addEventListener('input', searchTable);

function searchTable() {
    table_rows.forEach((row, i) => {
        let table_data = row.textContent.toLowerCase(),
            search_data = search.value.toLowerCase();

        row.classList.toggle('hide', table_data.indexOf(search_data) < 0);
        row.style.setProperty('--delay', i / 25 + 's');
    })

    document.querySelectorAll('tbody tr:not(.hide)').forEach((visible_row, i) => {
        visible_row.style.backgroundColor = (i % 2 == 0) ? 'transparent' : '#0000000b';
    });
    
}

// 2. Sorting | Ordering data of HTML table

table_headings.forEach((head, i) => {
    let sort_asc = true;
    head.onclick = () => {
        table_headings.forEach(head => head.classList.remove('active'));
        head.classList.add('active');

        document.querySelectorAll('td').forEach(td => td.classList.remove('active'));
        table_rows.forEach(row => {
            row.querySelectorAll('td')[i].classList.add('active');
        })

        head.classList.toggle('asc', sort_asc);
        sort_asc = head.classList.contains('asc') ? false : true;

        sortTable(i, sort_asc);
    }
})

function sortTable(column, sort_asc) {
    // Si es la columna de valor, convertimos el texto a número antes de comparar
    if (column === 0 || column === 3) {
        [...table_rows].sort((a, b) => {
            let first_row = parseFloat(a.querySelectorAll('td')[column].textContent.replace(/[^0-9.-]+/g, ''));
            let second_row = parseFloat(b.querySelectorAll('td')[column].textContent.replace(/[^0-9.-]+/g, ''));

            return sort_asc ? (first_row - second_row) : (second_row - first_row);
        })
            .map(sorted_row => document.querySelector('tbody').appendChild(sorted_row));
    } else {
        // Si no es la columna de valor, ordenamos como texto
        [...table_rows].sort((a, b) => {
            let first_row = a.querySelectorAll('td')[column].textContent.toLowerCase();
            let second_row = b.querySelectorAll('td')[column].textContent.toLowerCase();

            return sort_asc ? (first_row < second_row ? 1 : -1) : (first_row < second_row ? -1 : 1);
        })
            .map(sorted_row => document.querySelector('tbody').appendChild(sorted_row));
    }
}