<%--
  Created by IntelliJ IDEA.
  User: Antonio Epomba
  Date: 19/12/2019
  Time: 07:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources/css/cliente.css" rel="stylesheet">
<head>
    <title>Clientes</title>
</head>
<body>
<div id="funcionario-box">
    <div class="left">
        <h1 style="text-align: center">Cliente</h1>
        <form action="Cliente" method="Post">
            <input type="hidden" name="id" id="id">
            <br>
            Nome:<br>
            <input type="text" name="nome">
            <br>
            Endereco: <br>
            <input type="text" name="endereco">
            <br>
            Telefone: <br>
            <input type="number" name="telefone">
            <br>
            <input type="submit" value="Salvar">
            <button  style="background: lightgoldenrodyellow"  class="btn"><a href="Home">Voltar</a></button>
        </form>
    </div>
</div>
</body>
</html>
