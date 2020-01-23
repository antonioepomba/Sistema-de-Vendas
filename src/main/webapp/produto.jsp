<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <link href="resources/css/produto.css" rel="stylesheet">
    <head>
        <title>Produtos</title>
    </head>
    <style></style>
    <body>
    <div id="produto-box">
        <div class="left">
            <h1>Produto</h1>
            <form action="Produto" method="post">
                <input type="hidden" name="id" id="id">
                <div class="input-container">
                    <i class="fas fa-cart-arrow-down"></i>
                    Nome:<br>
                    <input type="text" name="name" id="name"><br>
                </div>
                <div class="input-container">
                    <i style="size: 34px;color:red;" class="fa fa-money"></i>
                    Preco:<br>
                    <input type="number" name="price" id="price"><br>
                </div>
                <br>
                <input type="submit" class="btn" value="Salvar">
                <button class="btn"><a href="Home">Voltar</a></button>
            </form>
    </body>
</div>
</div>
</html>

