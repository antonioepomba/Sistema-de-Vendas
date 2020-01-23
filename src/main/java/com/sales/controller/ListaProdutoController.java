package com.sales.controller;

import com.sales.model.ProdutoModel;
import com.sales.repositorio.RepositorioProduto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ListaProduto", urlPatterns = {"/ListaProduto"})
public class ListaProdutoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    RepositorioProduto repositorio_produto = new RepositorioProduto();
    private String action = null;

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ProdutoModel produtoModel = repositorio_produto.getProdutoByHash(request.getParameter("id"));
        request.setAttribute("produto", produtoModel);
        request.getRequestDispatcher("editarproduto.jsp").include(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ProdutoModel produtoModel = repositorio_produto.getProdutoByHash(request.getParameter("id"));
        ProdutoModel del = repositorio_produto.deleteProduto(produtoModel.getId().toString());
        request.setAttribute("produto", produtoModel);
        response.sendRedirect("ListaProduto");
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<ProdutoModel> listaProdutos = repositorio_produto.getAllProdutos();
        request.setAttribute("produtos", listaProdutos);
        HttpSession session = request.getSession(false);
        session.setAttribute("LoginController",Boolean.TRUE);
        action = request.getParameter("action");
        if (action != null) {
            if (action.equals("edit")){
                editar(request, response);
            }
           if (action.equals("delete")) {
                delete(request, response);
            }
        }
        //sessao
        if (session.getAttribute("username") != null) {
            request.getRequestDispatcher("listadeproduto.jsp").include(request, response);
        } else {

            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }

}

