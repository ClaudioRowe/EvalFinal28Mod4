//Límite de password a 20 carácteres
$(document).ready(function() {
    var input = document.getElementById('password');
    input.addEventListener('onkeypress', function() {
        if (this.value.length > 20)
            this.value = this.value.slice(0, 20);
    })
});

//Funcion menu
$(document).ready(main);

var contador = 1;

function main() {
    $('.menu_bar').click(function() {
        if (contador == 1) {
            $('.nav-list').animate({
                left: '0'
            });
            contador = 0;
        } else {
            contador = 1;
            $('.nav-list').animate({
                left: '-100%'
            });
        }
    });
};


//Funcion barra slidebars
$(document).ready(function() {
    // Initialize Slidebars
    var controller = new slidebars();
    controller.init();

    // Toggle Slidebars
    $('#sld1').on('click', function(event) {
        // Stop default action and bubbling
        event.stopPropagation();
        event.preventDefault();

        // Toggle the Slidebar with id 'id-1'
        controller.toggle('id-1');
    });

    $('#sld2').on('click', function(event) {
        // Stop default action and bubbling
        event.stopPropagation();
        event.preventDefault();

        // Toggle the Slidebar with id 'id-2'
        controller.toggle('id-2');
    });

    $('#sld3').on('click', function(event) {
        // Stop default action and bubbling
        event.stopPropagation();
        event.preventDefault();

        // Toggle the Slidebar with id 'id-3'
        controller.toggle('id-3');
    });

    $('#sld4').on('click', function(event) {
        // Stop default action and bubbling
        event.stopPropagation();
        event.preventDefault();

        // Toggle the Slidebar with id 'id-4'
        controller.toggle('id-4');
    });
});