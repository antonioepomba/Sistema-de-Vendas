<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="src/main/webapp/resources/style.css"/>
<link href="resources/css/index.css" rel="stylesheet">
<script src="resources/js/validation.js"></script>
<head>
    <title>Login</title>
</head>

<body>
<img src="resources/pictures/ecommerce.jpg"/>
<div id="login">
    <div id="triangle"></div>
    <h2 style="text-align: center">Login</h2>
    <form action="Login" method="post">
        <div class="input-container">
            <i class="fas fa-user"></i>
            <input type="text" name="usuario" id="usuario"placeholder="Usuario"/>
        </div>
        <div class="input-container">
            <i class="fas fa-low-vision"></i>
            <input type="password" name="senha" id="senha"placeholder="Senha"/>
        </div>
        <br>
        <input type="submit" value="Login" ><br>
        <br>
        <a style="text-align: center;ont-family: 'Allan" href="Funcionario"><i style="color: #222222;font-size: 15px" class="fas fa-pen"></i>Registrar</a>
    </form>
</div>
</body>
</html>

