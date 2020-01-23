package com.sales.controller;

import com.sales.repositorio.RepositorioProduto;
import com.sales.model.ProdutoModel;
import com.sales.utility.NumberConverter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Produto"})
public class ProdutoController extends HttpServlet {


    private static final long serialVersionUID = 1L;
    ProdutoModel produtos = new ProdutoModel();
    RepositorioProduto repositorio_produto = new RepositorioProduto();
    NumberConverter numberConverter= new NumberConverter();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        session.setAttribute("LoginController",Boolean.TRUE);
        if (session.getAttribute("username") != null) {
        request.getRequestDispatcher("produto.jsp").forward(request, response);
    }  else {

            response.sendRedirect("Login");
    }
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<ProdutoModel> listaProdutos = repositorio_produto.getAllProdutos();
        request.setAttribute("produtos", listaProdutos);
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String preco = request.getParameter("price");
        setProduto(id,name, preco);

        if (id.isEmpty()) {
            save(produtos);


        } else {
            edit(produtos);

        }
        redireccionar(request, response, "ListaProduto");
    }

    private void save(ProdutoModel produtos) {
        repositorio_produto.save(produtos);
    }

    private void edit(ProdutoModel produtos) {
        repositorio_produto.edit(produtos);
    }

    private void redireccionar(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException,
            IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    private void setProduto(String id,String name, String price) {
        try {
            int intid = numberConverter.getInt(id);
            produtos.setId(intid);
            produtos.setName(name);
            Double preco = numberConverter.getDouble(price);
            produtos.setPreco(preco);
        } catch (Exception erro) {

        }
    }
}





