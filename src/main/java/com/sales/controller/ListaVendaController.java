package com.sales.controller;

import com.sales.model.VendaModel;
import com.sales.repositorio.RepositorioVenda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListaVenda", urlPatterns = {"/ListaVenda"})
public class ListaVendaController extends HttpServlet {
    private String action = null;
    RepositorioVenda repositorioVenda = new RepositorioVenda();

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        VendaModel vendamodel = repositorioVenda.getVendaByHash(request.getParameter("id"));
        request.setAttribute("venda", vendamodel);
        request.getRequestDispatcher("editarvenda.jsp").include(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        VendaModel vendamodel = repositorioVenda.getVendaByHash(request.getParameter("id"));
        VendaModel del = repositorioVenda.deletevendaModel(vendamodel.getId().toString());
        request.setAttribute("venda", vendamodel);
        response.sendRedirect("ListaVenda");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<VendaModel> venda = repositorioVenda.getVendas();
        request.setAttribute("vendas", venda);
        HttpSession session = request.getSession(false);
        session.setAttribute("LoginController",Boolean.TRUE);
        action = request.getParameter("action");
        System.out.println(action instanceof String);

        if (action != null) {
            if (action.equals("edit")) {
                editar(request, response);
            } else if (action.equals("delete")) {
                delete(request, response);
            }
        } else {
        //sessao
        if (session.getAttribute("username") != null) {
            request.getRequestDispatcher("listadevenda.jsp").include(request, response);
        } else {

            response.sendRedirect("Login");
        }
    }
}
}