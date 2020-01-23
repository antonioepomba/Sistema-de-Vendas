<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link href="resources/css/dashboard.css" rel="stylesheet">
<head>
    <title>Vendas</title>
</head>

<body>

<legend style="text-align:center;width:100%;font-size: 25px"><strong><i class="fas fa-shopping-cart"></i>Sistema de
    vendas</strong></legend>
<br>
<br>
<br>
<table align="center">
    <tr>
        <th>
            <div class="card">
                <a class="active" href="ListaProduto"><i class="fas fa-cart-arrow-down"></i></a>
                <div class="container">
                    <p>Produtos</p>
                </div>
            </div>
        </th>
        <th>
            <div class="card">
                <a href="ListaCliente"><i class="fas fa-user-friends"></i></a>
                <div class="container">
                    <p>Clientes</p>
                </div>
            </div>
        </th>
        <th>
            <div class="card">
                <a href="ListaFuncionario"><i class="fas fa-users"></i></a>
                <div class="container">
                    <p>Funcionarios</p>
                </div>
            </div>
        </th>
        <th>
            <div class="card">
                <a href="ListaVenda"><i class="fas fa-credit-card"></i></a>
                <div class="container">
                    <p>vendas</p>
                </div>
            </div>
        </th>
        <th>
            <div class="card">
                <a href="Logout"><i class="fa fa-power-off"></i></a>
                <div class="container">
                    <p>log out</p>
                </div>
            </div>
        </th>
    </tr>
</table>
</body>
</html>

