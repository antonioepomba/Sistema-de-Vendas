package com.sales.controller;

import com.sales.model.ClienteModel;
import com.sales.repositorio.RepositorioCliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListaClienteController", urlPatterns = {"/ListaCliente"})
public class ListaClienteController extends HttpServlet {

    RepositorioCliente repositorioCliente = new RepositorioCliente();
    private String action = null;

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        ClienteModel clienteModel = repositorioCliente.getClientByHash(request.getParameter("id"));
        request.setAttribute("cliente", clienteModel);
        request.getRequestDispatcher("editarcliente.jsp").include(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        ClienteModel clienteModel = repositorioCliente.getClientByHash(request.getParameter("id"));
        ClienteModel delete = repositorioCliente.deleteCliente(clienteModel.getId().toString());
        request.setAttribute("cliente", clienteModel);
        response.sendRedirect("ListaCliente");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<ClienteModel> listcliente = repositorioCliente.getAllClientes();
        request.setAttribute("clientes", listcliente);
        HttpSession session = request.getSession(false);
        session.setAttribute("LoginController", Boolean.TRUE);
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
                request.getRequestDispatcher("listadecliente.jsp").include(request, response);
            } else {

                response.sendRedirect("Login");
            }
        }
    }
}

