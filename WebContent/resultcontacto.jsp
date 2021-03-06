<%@ page language="java" contentType="text/html; charset=UTF-8" %> 
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fin de sesión</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- JS de Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <!-- Slidebars -->
    <link rel="stylesheet" href="js/Slidebars-2.0.2/dev/slidebars.css">
    <script src="js/Slidebars-2.0.2/dev/slidebars.js"></script>
    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css">
    <!-- JS -->
    <script src="js/main.js"></script>
    <script src="js/logout.js"></script>
</head>

<body>

    <div canvas="container">
        <div class="wrapper">

            <header>
                <div class="nav-content">
                    <div class="menu_bar">
                        <a href="#" class="bt-menu">Menú</a>
                    </div>
                    <nav>
                        <ul class="nav-list">
                            <li><a href="index.html"><span ></span>Inicio</a></li>
                            <li><a href="quienes-somos.html"><span ></span>Quiénes somos</a></li>
                            <li><a href="lista.html"><span ></span>Listas</a></li>
                            <li><a href="calendario.html"><span ></span>Calendario</a></li>
                            <li><a href="rutina.html"><span ></span>Rutinas</a></li>
                            <li><a href="contacto.html"><span ></span>Contacto</a></li>

                            <div class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span ></span>Modo de uso</a>
                                <div class="dropdown-menu">
                                    <a href="lista-uso.html" class="dropdown-item">Listas</a>
                                    <a href="calendario-uso.html" class="dropdown-item">Calendario</a>
                                </div>
                            </div>
                        </ul>

                        <ul class="login">
                            <li><a href="#" id="sld3">Logout</a></li>
                        </ul>

                    </nav>
                </div>

            </header>

            <main>
                <div class="end-session">
					<% int status = (int) request.getAttribute("status");  %>
                    <% if (status > 0) { %>

                        <h2>Envío con éxito</h2>

                        <p style="font-size:20px">Tu información se ha enviado con éxito.</p>

                        <a href="index.html" style="font-size:20px">Volver a la página de inicio</a>

                        <% } else { %>

                            <h2>Error en el envío</h2>

                            <p style="font-size:20px">No se ha concretado su petición.</p>

                            <a href="index.html" style="font-size:20px">Volver a la página de inicio</a>

                        <% } %>

                </div>
            </main>
            <footer class="container-fluid">
                <p>Desarrollado por: Claudio Torres, Pamela Machino y Jaime Reyes</p>
                <p>Junio 2020, Todos los derechos reservados.</p>
            </footer>
        </div>
    </div>

    <div off-canvas="id-3 top push" class="custom-fluid-width custom-fluid-height">
        <container class="login" id="logIndex" style="display:none;">
            <h4 id="hlogin">Login</h4>
            <form class="card box-shadow" id="formaLogin">


                <div class="row justify-content-center">
                    <div class="col-3">
                        <label for="ingreso" class="labLog" id="labIng">Usuario o e-mail
                        <input type="text" id="ingreso" name="ingreso" placeholder="Usuario o e-mail" class="inLogin"></label>
                    </div>
                    <div class="col-3">
                        <label for="password" class="labLog" id="labPas">Password
                        <input type="password" id="password" name="password" placeholder="Password" class="inLogin"></label>
                    </div>
                    <div>
                        <input type="submit" value="Ingresar" id="ingresar">
                    </div>
                    <div id="checkRec">
                        <label for="recordar" id="labRecordar">Recordar clave
                        <input type="checkbox" id="checkboxLog" name="recordar">
                        </label>
                    </div>
                </div>

            </form>
        </container>
        <div class="logout-displayer" id="logoutdisplay">
            <p>Has iniciado sesión como: <span id="usuario"></span></p>
            <a href="logout">Cerrar sesión</a>
        </div>
    </div>

</body>

</html>