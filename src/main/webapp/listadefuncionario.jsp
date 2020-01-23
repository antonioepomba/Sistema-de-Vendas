<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
<script src="resources/js/datatable.js"></script>
<head>
    <title>Lista de Produtos</title>
</head>
<body>
<fieldset>
    <legend style="text-align: center;font-family: 'Times New Roman'"><strong><i class="fas fa-users"></i>Lista de Funcionario</strong></legend></legend>
    <div style="padding-right: 20px;padding-left: 20px">
        <table id="example" class="table table-striped table-bordered" align="center">
            <thead>
            <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Endereco</th>
                <th>Salario</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:forEach var="funcionario" items="${funcionarios}">
                <tr>
                    <td><c:out value="${funcionario.getNome()}" /></td>
                    <td><c:out value="${funcionario.getEmail()}" /></td>
                    <td><c:out value="${funcionario.getEndereco()}" /></td>
                    <td><c:out value="${funcionario.getSalario()}" /></td>
                    <td><a href="?action=edit&id=${funcionario.getHashId()}"><i class="fas fa-pen"></i></a>
                    <a href="?action=delete&id=${funcionario.getHashId()}"onclick="return confirm('Are you sure you want to Delete?');"><i class="fas fa-trash"></i></a>
                    </td>
                </tr>
            </c:forEach>
            <button style="background: lightgoldenrodyellow" class="btn"><i class="glyphicon glyphicon-plus"></i> <a href="Funcionario">Adicionar</a></button>
            <button style="background: lightgoldenrodyellow" class="btn"><i class="fas fa-reply"></i> <a href="Home">Voltar</a></button>
        </table>
    </div>
</fieldset>
</body>
</html>

