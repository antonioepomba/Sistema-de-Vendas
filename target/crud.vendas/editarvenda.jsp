<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources/css/venda.css" rel="stylesheet">
<head>
    <title>venda</title>
</head>

<body>
<div id="funcionario-box">
    <div class="left">
        <h1>Venda</h1>
        <form action="Venda" method="post">
            <input type="hidden" name="id" id="id" value="${venda.getId()}"><br>
            <br>
            <input type="text" name="nome" value="${venda.getName()}">
            <br>
            <input type="text" name="produto" value="${venda.getProduto()}">
            <br>
            <input type="number" name="quantidade" value="${venda.getQuantity()}">
            <input type="number" name="total" value="${venda.getTotal()}">
            <br>
            <input type="submit" value="Actualizar">
            <button  style="background: lightgoldenrodyellow"  class="btn"><i class="fas fa-reply"></i> <a href="ListaVenda">Voltar</a></button>
        </form>
    </div>
</div>
</body>
</html>