$(document).ready(function() {

    // Variables para la ejecución del plugin Muuri
    var docElem = document.documentElement;
    var kanban = document.querySelector('.kanban-demo');
    var board = kanban.querySelector('.board');
    var itemContainers = Array.prototype.slice.call(kanban.querySelectorAll('.board-column-content'));
    var columnGrids = [];
    var dragCounter = 0;
    var boardGrid;

    //Inicialización del plugin Muuri en las columnas del tablero
    itemContainers.forEach(function(container) {

        var muuri = new Muuri(container, {
                items: '.board-item',
                layoutDuration: 400,
                layoutEasing: 'ease',
                dragEnabled: true,
                dragSort: function() {
                    return columnGrids;
                },
                dragSortHeuristics: {
                    sortInterval: 0,
                    minDragDistance: 0,
                    minBounceBackAngle: 0
                },
                dragContainer: document.body,
                dragReleaseDuration: 400,
                dragReleaseEasing: 'ease'
            })
            .on('dragStart', function(item) {
                ++dragCounter;
                docElem.classList.add('dragging');
                item.getElement().style.width = item.getWidth() + 'px';
                item.getElement().style.height = item.getHeight() + 'px';
            })
            .on('dragEnd', function(item) {
                if (--dragCounter < 1) {
                    docElem.classList.remove('dragging');
                }
            })
            .on('dragReleaseEnd', function(item) {
                item.getElement().style.width = '';
                item.getElement().style.height = '';
                columnGrids.forEach(function(muuri) {
                    muuri.refreshItems();
                });
            })
            .on('layoutStart', function() {
                boardGrid.refreshItems().layout();
            });

        columnGrids.push(muuri);

    });

    //Inicialización del plugin Muuri en el tablero principal
    boardGrid = new Muuri(board, {
        layoutDuration: 400,
        layoutEasing: 'ease',
        dragEnabled: false,
        dragSortHeuristics: {
            sortInterval: 0,
            minDragDistance: 0,
            minBounceBackAngle: 0
        },
        dragStartPredicate: {
            handle: '.board-column-header'
        },
        dragReleaseDuration: 400,
        dragReleaseEasing: 'ease'
    });

    // Oculta el panel para agregar nueva actividad
    $('.add-task-form').hide();

    // Oculta el panel para agregar detalles a la actividad
    $('.task-details').hide();

    // Otorga funcionalidad al botón de nueva actividad
    $('.add-task>button').click(function() {
        $('.add-task-form').slideToggle('fast');
    });

    // Otorga funcionalidad al botón de agregar
    $('.add-task-form>button').click(function() {

        let descripcion = $('#desc-add').val(),
            detalles = $('#detalles-add').val(),
            fecha = $('#fecha-add').val(),
            categoria = $('#categoria-add').val();

        if (descripcion && detalles && fecha && categoria) {

            let fechaLong = new Date(fecha);
            fechaLong = fechaLong.getTime();


            let data = {
                descripcion: descripcion,
                detalles: detalles,
                fecha: fechaLong,
                categoria: categoria
            }

            $.ajax({
                url: 'agregaractividad',
                type: 'POST',
                data: data,
                success: function(response) {

                    if (response !== 'error') {
                        let newItem = document.createElement('div');
                        let content = '<div class="board-item" data-id="' + response + '"><div class="board-item-content">' + descripcion + '<p>' + detalles + '</p></div></div>';
                        newItem.innerHTML = content;
                        newItem = newItem.firstChild;
                        columnGrids[0].add(newItem);
                        $('.board-item').click(function() {
                            let id = $(this).attr('data-id');
                            $('#id-edit').val(id);
                            $('.task-details').slideDown('fast');
                        });
                        columnGrids.forEach(function(muuri) {
                            muuri.refreshItems();
                        });
                        $('#add').val('');

                    }
                    $('.add-task-form').slideUp('fast');
                },
                dataType: 'html'
            });
        }

    });

    // Otorga funcionalidad al hacer (doble) click en las actividades del tablero
    $('.board-item').click(function() {
        $('.task-details').slideDown('fast');
    });

    // Otorga funcionalidad al botón de editar detalles de actividad
    $('#add-details').click(function() {
        let id = $('#id-edit').val(),
            descripcion = $('#desc-edit').val(),
            detalles = $('#detalles-edit').val(),
            fecha = $('#fecha-edit').val(),
            categoria = $('#categoria-edit').val();

        if (descripcion && detalles && fecha && categoria) {

            let fechaLong = new Date(fecha);
            fechaLong = fechaLong.getTime();

            let data = {
                id: id,
                descripcion: descripcion,
                detalles: detalles,
                fecha: fechaLong,
                categoria: categoria
            }

            $.ajax({
                url: 'editaractividad',
                type: 'POST',
                data: data,
                success: function(response) {

                    if (response === 'ok') {
                        $('[data-id=' + id + ']').html('<div class="board-item-content">' + descripcion + '<p>' + detalles + '</p></div>');
                    }

                    $('.task-details').slideUp('fast');

                },
                dataType: 'html'
            });
        }

    });
});