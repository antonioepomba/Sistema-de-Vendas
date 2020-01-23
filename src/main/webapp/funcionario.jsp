<%--
  Created by IntelliJ IDEA.
  User: delcio.lopes
  Date: 04/12/2019
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources/css/funcionario.css" rel="stylesheet">
<head>
    <title>Funcionarios</title>
</head>
<body>
<div class="form-style-8">
        <h1>Funcionarios</h1>
<form method="Post" action="Funcionario">
    <div class="col-md-6"style="width:45%"align='right'>
    <input type="text" name="nome" placeholder="Nome" required>
    </div>
    <div class="col-md-6"style="width:45%"align='right'>
    <input type="text" name="email"placeholder="Email" required />
    </div>
    <div class="col-md-6"style="width:45%"align='right'>
    <input type="password" name="senha"placeholder="senha" required />
    </div>
    <div class="col-md-6"style="width:45%"align='right'>
    <input type="text" name="endereco"placeholder="Endereco" required />
    </div>
    <div class="col-md-6"style="width:45%"align='right'>
    <input type="number" name="salario"placeholder="Salario" required />
    </div>
    <div class="col-md-6"style="width:45%"align='right'>
    <br>
    </div>
    <div class="col-md-6"style="width:45%"align='right'>
        <br>
    </div>
    <div class="col-md-6"style="width:45%"align='right'>
        <input type="submit" value="Salvar">
    <button class="btn"><a href="Home">Voltar</a></button>
</div>
</form>
    </div>
</div>
</body>
</html>
