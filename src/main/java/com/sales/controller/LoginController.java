package com.sales.controller;

import com.sales.model.FuncionarioModel;
import com.sales.repositorio.RepositorioFuncionario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    FuncionarioModel funcionario_model = new FuncionarioModel();
    RepositorioFuncionario funcionario = new RepositorioFuncionario();
    protected  void  doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,
            IOException {
        request.getRequestDispatcher("index.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

        HttpSession session = request.getSession();

        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        setUsuaro(usuario, senha);

        session.setAttribute("username", usuario);

        Boolean checkUser = funcionario.checkUser(funcionario_model);
        if (checkUser) {
            response.sendRedirect("Home");
        } else
            response.sendRedirect("Login");
    }

    private void setUsuaro(String usuario, String senha) {
        try {
            funcionario_model.setNome(usuario);
            funcionario_model.setPassword(senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

