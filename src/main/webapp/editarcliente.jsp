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
    <title>Clientes</title>
</head>
<body>
<div class="form-style-8">
    <h1 style="text-align: center">Cliente</h1>
    <form   action="Cliente" method="post">
        <input type="hidden" name="id" id="id" value="${cliente.getId()}">
        <div class="col-md-6"style="width:45%"align='right'>
            <input type="text" name="nome" value="${cliente.getName()}" >
        </div>
        <div class="col-md-6"style="width:45%"align='right'>
            <input type="text" name="endereco" value="${cliente.getEndereco()}"  />
        </div>
        <div class="col-md-6"style="width:45%"align='right'>

        </div>
        <div class="col-md-6"style="width:45%"align='right'>
            <input type="number" name="telefone" value="${cliente.getTelefone()}" />
        </div>
        <div class="col-md-6"style="width:45%"align='right'>
        <br>
        </div>
        <div class="col-md-6"style="width:45%"align='right'>
            <br>
        </div>
        <div class="col-md-6"style="width:45%"align='right'>
            <input type="submit" value="Atualizar">
            <button class="btn"><i class="fas fa-reply"></i> <a href="ListaCliente">Voltar</a></button>
        </div>
    </form>
</div>
</div>
</body>
</html>


