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
import java.util.List;

@WebServlet(name = "ListaFuncionario", urlPatterns = {"/ListaFuncionario"})
public class ListaFuncionarioController extends HttpServlet {
    RepositorioFuncionario repositoriofuncionario = new RepositorioFuncionario();
    private static final long serialVersionUID = 1L;
    private String action = null;

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        FuncionarioModel funcionario = repositoriofuncionario.getFuncionarioByHash(request.getParameter("id"));
        request.setAttribute("funcionario", funcionario);
        request.getRequestDispatcher("editarfuncionario.jsp").include(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        FuncionarioModel funcionario = repositoriofuncionario.getFuncionarioByHash(request.getParameter("id"));
        FuncionarioModel del = repositoriofuncionario.deleteFuncionario(funcionario.getId().toString());
        request.setAttribute("funcionario", funcionario);
       response.sendRedirect("ListaFuncionario");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<FuncionarioModel> listafuncionario = repositoriofuncionario.getFuncionarios();
        request.setAttribute("funcionarios", listafuncionario);
        HttpSession session = request.getSession(false);
        session.setAttribute("LoginController", Boolean.TRUE);
        action = request.getParameter("action");
        if (action != null) {
            if (action.equals("edit")) {
                editar(request, response);
            } else if (action.equals("delete")) {
                delete(request, response);
            }
        }
            //sessao
            if (session.getAttribute("username") != null) {
                request.getRequestDispatcher("listadefuncionario.jsp").include(request, response);
            } else {

                request.getRequestDispatcher("index.jsp").include(request, response);
            }
        }
    }
