package com.sales.controller;
import  com.sales.utility.NumberConverter;
import  com.sales.model.VendaModel;
import  com .sales.repositorio.RepositorioVenda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Venda", urlPatterns = {"/Venda"})
public class VendaController extends HttpServlet
{
    VendaModel vendamodel = new VendaModel();
    RepositorioVenda repositorioVenda = new RepositorioVenda();
    NumberConverter numberConverter = new NumberConverter();

   protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession(false);
       session.setAttribute("LoginController",Boolean.TRUE);
       if (session.getAttribute("username") != null) {
           request.getRequestDispatcher("venda.jsp").include(request, response);
       } else {

          response.sendRedirect("Login");
       }
   }

   protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
       String Id = request.getParameter("id");
       String nome = request.getParameter("nome");
       String produto = request.getParameter("produto");
       String quantidade = request.getParameter("quantidade");
       String total = request.getParameter("total");
       setVenda(Id,nome,produto,quantidade,total);

       if(Id!=null){
           edit(vendamodel);
           response.sendRedirect("ListaVenda");
       }else{
           save(vendamodel);
           response.sendRedirect("ListaVenda");
       }
   }

   private void save(VendaModel venda)
   {
        repositorioVenda.save(venda);
   }
   private void edit(VendaModel venda)
   {
        repositorioVenda.edit(venda);
   }
   private void setVenda(String id,String nome,String produto,String quantidade,String total)
   {
       int Id = numberConverter.getInt(id);
       vendamodel.setId(Id);
       vendamodel.setName(nome);
       vendamodel.setProduto(produto);
       int Quantidade = numberConverter.getInt(quantidade);
       vendamodel.setQuantity(Quantidade);
       double Total = numberConverter.getDouble(total);
       vendamodel.setTotal(Total);

   }
}
