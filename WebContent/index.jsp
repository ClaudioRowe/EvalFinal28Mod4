<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setCharacterEncoding("UTF-8"); %>
        <!DOCTYPE html>
        <html lang="es">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Login</title>
            <!-- Bootstrap -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
            <!-- jQuery -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <!-- JS de Bootstrap -->
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
            <!-- CSS -->
            <link rel="stylesheet" href="css/style.css">
            <!-- JS -->
            <!--<script src="js/main.js"></script>-->
            <style>
                .logjsp {
                    margin-top: 25vh !important;
                    display: flex;
                    max-width: 400px;
                    padding: 30px;
                    border-radius: 3px;
                }
                
                .logjsp label {
                    font-size: 0.8em;
                }
                
                .logjsp>div>div {
                    display: flex;
                    justify-content: space-between;
                }
            </style>
        </head>

        <body>
            <form class="box-shadow logjsp" id="formaLogin" action="login" method="POST">

                <div class="row justify-content-center">
                    <div class="col-12">
                        <label for="ingreso" class="labLog" id="labIng">Usuario o e-mail</label>
                        <input type="text" id="ingreso" name="ingreso" placeholder="Usuario o e-mail" class="inLogin">
                    </div>
                    <div class="col-12">
                        <label for="password" class="labLog" id="labPas">Password</label>
                        <input type="password" id="password" name="password" placeholder="Password" class="inLogin">
                    </div>
                    <div class="col-12">
                        <input type="submit" value="Ingresar" id="ingresar">
                        <div>
                            <label for="recordar" id="labRecordar">Recordar clave</label>
                            <input type="checkbox" id="checkboxLog" name="recordar">
                        </div>
                    </div>
                </div>

            </form>
        </body>

        </html>