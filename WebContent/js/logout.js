$(document).ready(function() {

    let usuario = document.cookie;
    usuario = usuario.replace('usuario=', '');
    let display = document.getElementById("usuario");
    display.innerHTML = usuario;

    $('body').on("click mousedown mouseup focus blur keydown change dblclick mousemove mouseover mouseout mousewheel keydown keyup keypress textInput touchstart touchmove touchend touchcancel resize scroll zoom select change submit reset", function(e) {
        setCookie("usuario", usuario, 30);
    });

});

function setCookie(cname, cvalue, exmins) {
    var d = new Date();
    d.setTime(d.getTime() + (exmins * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/Trabajo_Grupal";
}