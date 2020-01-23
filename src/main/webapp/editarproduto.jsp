<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Produtos</title>
</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link href="resources/css/produto.css" rel="stylesheet">
<body>
<div id="produto-box">
    <div class="left">
        <h1>Produto</h1>
<form  action="Produto" method="post">
    Nome:<br>
    <input type="hidden" name="id" id="id" value="${produtos.getId()}"><br>
    <div class="input-container">
        <i class="fas fa-cart-arrow-down"></i>
        Nome:<br>
    <input type="text" name="name" id="nome" value="${produtos.getName()}"><br>
    </div>
        <div class="input-container">
            <i style="size: 34px;color:red;" class="fa fa-money"></i>
            Preco:<br>
    <input type="number" name="price" id="price"
     value="${produtos.getPreco()}"><br>
        </div>
    <input type="submit" value="Atualizar">
    <button class="btn"><i class="fas fa-reply"></i> <a href="ListaProduto">Voltar</a></button>
</form>
</body>
</html>

