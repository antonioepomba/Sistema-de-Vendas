package com.sales.controller;

import com.sales.model.ProdutoModel;
import com.sales.repositorio.RepositorioProduto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/EditarController")
public class EditarController extends HttpServlet {
    RepositorioProduto repositorioProduto = new RepositorioProduto();
    private String action;

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ProdutoModel produtos = repositorioProduto.getProdutoById(request.getParameter("id"));
        request.setAttribute("produtos", produtos);
        request.getRequestDispatcher("editarcliente.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProdutoModel produtos = repositorioProduto.getProdutoById(request.getParameter("id"));
        request.setAttribute("produtos", produtos);
        request.getRequestDispatcher("editarcliente.jsp").include(request, response);
        action = request.getParameter("action");
        if (action != null) {
            if (action.equals("edit")) {
                editar(request, response);
            }
        }
    }
}