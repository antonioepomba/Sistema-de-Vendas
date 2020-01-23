package com.sales.controller;

import com.sales.model.FuncionarioModel;
import com.sales.repositorio.RepositorioFuncionario;
import com.sales.utility.NumberConverter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = {"/Funcionario"})
public class FuncionarioController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    FuncionarioModel funcionario = new FuncionarioModel();
    RepositorioFuncionario repositoriofuncionario = new RepositorioFuncionario();
    NumberConverter numberConverter = new NumberConverter();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
            request.getRequestDispatcher("funcionario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String endereco = request.getParameter("endereco");
        String salario = request.getParameter("salario");
        setFuncionario(id,nome, email, senha, endereco, salario);

        if(id!=null)
        {

            edit(funcionario);

            response.sendRedirect("ListaFuncionario");
        }
        else{
            System.out.println("working");
            save(funcionario);
           response.sendRedirect("ListaFuncionario");
        }
    }

    private void save(FuncionarioModel funcionarios) {
        try {
            repositoriofuncionario.save(funcionarios);
        } catch (Exception erro) {

        }


    }

    private void edit(FuncionarioModel funcionarios) {
        repositoriofuncionario.edit(funcionarios);
    }



    private void setFuncionario(String id,String nome, String email, String senha, String endereco, String salario) {
        try {
            int intid = numberConverter.getInt(id);
            funcionario.setId(intid);
            funcionario.setNome(nome);
            funcionario.setEmail(email);
            funcionario.setPassword(senha);
            funcionario.setEndereco(endereco);
           double salariofuncionario =numberConverter.getDouble(salario);
            funcionario.setSalario(salariofuncionario);
        } catch (Exception erro) {

        }
    }
}





