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
        let text = $('#add').val();
        if (text) {
            let newItem = document.createElement('div');
            let content = '<div class="board-item"><div class="board-item-content">' + text + '</div></div>';
            newItem.innerHTML = content;
            newItem = newItem.firstChild;
            columnGrids[0].add(newItem);
            $('.board-item').click(function() {
                $('.task-details').slideDown('fast');
            });
            columnGrids.forEach(function(muuri) {
                muuri.refreshItems();
            });
            $('#add').val('');
            $('.add-task-form').slideUp('fast');
        }
    });

    // Otorga funcionalidad al hacer (doble) click en las actividades del tablero
    $('.board-item').click(function() {
        $('.task-details').slideDown('fast');
    });

    // Otorga funcionalidad al botón de aceptar, del panel de detalles de actividad
    $('#add-details').click(function() {
        $('.task-details').slideUp('fast');
    });
});