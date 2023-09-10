document.addEventListener('DOMContentLoaded', function() {
    const table = $('#table-huesped').DataTable({
        dom: '',
        buttons: [
            {
                extend: 'copy',
                exportOptions: {
                    columns: ':visible'
                },
                title: 'Registros de Huesped Hotel Paradise'
            },
            {
                extend: 'excel',
                exportOptions: {
                    columns: ':visible'
                },
                title: 'Registros de Huesped Hotel Paradise'
            },
            {
                extend: 'pdf',
                exportOptions: {
                    columns: ':visible'
                },
                title: 'Registros de Huesped Hotel Paradise'
            }
        ],
        language: {
            buttons: {
                copyTitle: '', //Aqui se muestra el mensaje de sucess
                copyKeys: 'Presiona <i>ctrl</i> o <i>\u2318</i> + <i>C</i> para copiar los datos de la tabla al portapapeles. <br><br>Para cancelar, haz clic en este mensaje o presiona Esc.',
                copySuccess: {
                    _: '', //Aqui el numero de cosas copiadas
                    1: '' //En caso de ser sola una fila copiada
                }
            }
        }
    });

    $('.export-button').on('click', function() {
        // Encuentra el índice del botón clickeado
        const index = $('.export-button').index(this);

        // Triggers de los botones correspondientes
        table.button(index).trigger();
    });
});