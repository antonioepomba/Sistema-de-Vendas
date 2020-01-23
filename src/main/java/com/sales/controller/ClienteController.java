package com.sales.controller;

import com.sales.model.ClienteModel;
import com.sales.repositorio.RepositorioCliente;
import com.sales.utility.NumberConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/Cliente"})
public class ClienteController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ClienteModel clienteModel = new ClienteModel();
    RepositorioCliente repositorioCliente = new RepositorioCliente();
    NumberConverter numberConverter = new NumberConverter();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        session.setAttribute("LoginController", Boolean.TRUE);
        if (session.getAttribute("username") != null) {
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        } else {

            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        setCliente(id, nome, endereco, telefone);

        if (id.isEmpty()) {
            save(clienteModel);
            response.sendRedirect("ListaCliente");
        } else {
            edit(clienteModel);
            response.sendRedirect("ListaCliente");
        }
    }

    private void save(ClienteModel cliente) {
        repositorioCliente.save(cliente);
    }

    private void edit(ClienteModel cliente) {
        repositorioCliente.edit(cliente);
    }

    private void setCliente(String id, String nome, String endereco, String telefone) {
        try {
            int idint = numberConverter.getInt(id);
            clienteModel.setId(idint);
            clienteModel.setName(nome);
            clienteModel.setEndereco(endereco);
            int cellphone = numberConverter.getInt(telefone);
            clienteModel.setTelefone(cellphone);
        } catch (Exception erro) {

        }
    }
}





