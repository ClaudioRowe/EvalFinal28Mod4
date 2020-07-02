<%@ page language='java' contentType='text/html; charset=UTF-8'%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Registro: Planificador</title>
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

    <style>

    #formaReg {
      margin: auto;
      background-color: orange;
      border-radius: 5px
    }

    #titReg {
      text-align: center;
      padding-bottom: 5vh;
      padding-top: 3vh;
      background-color: orange;
      border-radius: 5px;
      margin-bottom: 13vh;
    }

    #botonForma {
      margin: auto;
    }

    </style>

</head>


  <body>

    <h1 id="titReg">Ingresa tus datos</h1>

  <div class="card justify-content-center">

    <form method="post" action="registro" class="card-body" id="formaReg" >

    <label class="col-5">Nombre</label>
    <input type="text" placeholder="Nombre" name="nombre" ><br>
    <label class="col-5">Apellido</label>
    <input type="text" placeholder="Apellido" name="apellido"><br>
    <label class="col-sm-5 col-md-5 col-5">Nombre de usuario</label>
    <input type="text" placeholder="Usuario" name="usuario"><br>
    <label class="col-5">Password</label>
    <input type="text" placeholder="Password" name="password"><br>
    <label class="col-5">E-mail</label>
    <input type="email" placeholder="E-mail" name="email"><br><br>

    <label class="col-sm-5 col-3">País</label>
    <select name="pais">
    <option value="CHL">Chile</option>
    <option value="ARG">Argentina</option>
    <option value="PER">Perú</option>
    <option value="ECU">Ecuador</option>
    <option value="VEN">Venezuela</option>
    <option value="BOL">Bolivia</option>
    <option value="COL">Colombia</option>
    <option value="URY">Uruguay</option>
    <option value="PRY">Paraguay</option>
    </select><br><br>
    <input type="submit" value="Enviar" id="botonForma">
    </form>

  </div>

  </body>

</html>



