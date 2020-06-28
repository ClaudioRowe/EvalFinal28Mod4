let logincookie = document.cookie;
if (!logincookie || logincookie.indexOf("usuario=") < 0) {
    document.location = "index.jsp";
}