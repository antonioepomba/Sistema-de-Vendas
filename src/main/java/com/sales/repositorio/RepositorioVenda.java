package com.sales.repositorio;

import com.sales.model.VendaModel;
import com.sales.utility.Database;
import com.sales.utility.Encrypt;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioVenda{

    private Database conexao;
    private ResultSet rs;
    PreparedStatement statment;
    public RepositorioVenda() {
        this.conexao = new Database();
        rs = null;
    }
    public List<VendaModel> getVendas(){
        String vendaquery = ("SELECT * FROM vendas");
        try {
         statment = this.conexao.conexao().prepareStatement(vendaquery);
            rs = statment.executeQuery();
            List<VendaModel> vendaList = new ArrayList<VendaModel>();
            while (rs.next()) {
                VendaModel venda = new VendaModel();
                venda.setId(rs.getInt("id"));
                venda.setName(rs.getString("name"));
                venda.setProduto(rs.getString("product"));
                venda.setQuantity(rs.getInt("quantity"));
                venda.setTotal(rs.getDouble("total"));
                vendaList.add(venda);
             // Encrypt id
                Encrypt encrypt = new Encrypt();
                venda.setHashId(encrypt.encrypt(venda.getId().toString()));
            }
            statment.close();
            return vendaList;
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(VendaModel vendaModel) {
        String sql = ("INSERT INTO vendas(name, product,quantity,total)  VALUES (?, ?, ?, ?);");

        try {

            // Step 2:Create a statement using connection object
            statment = this.conexao.conexao().prepareStatement(sql);
            statment.setString(1, vendaModel.getName());
            statment.setString(2, vendaModel.getProduto());
            statment.setInt(3, vendaModel.getQuantity());
            statment.setDouble(4, vendaModel.getTotal());
            statment.executeUpdate();
            statment.close();

        } catch (SQLException e) {

            printSQLException(e);
        }
    }

    public void edit(VendaModel vendamodel) {

        String sql = "UPDATE vendas SET name=?, product=? ,quantity=?, total=? WHERE id = " +vendamodel.getId()+ ";";

        try {

            statment = this.conexao.conexao().prepareStatement(sql);
            statment.setString(1, vendamodel.getName());
            statment.setString(2, vendamodel.getProduto());
            statment.setInt(3, vendamodel.getQuantity());
            statment.setDouble(4, vendamodel.getTotal());
            int count =  statment.executeUpdate();
            System.out.println(count);
            statment.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public VendaModel deletevendaModel(String id) {
        String sql = "DELETE FROM vendas where id = ? ";
        try {
            statment = this.conexao.conexao().prepareStatement(sql);
            statment.setString(1, id);
            statment.executeUpdate();
            statment.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public VendaModel getVendaById(String id) {
        try {

            String sql = ("SELECT  * FROM vendas WHERE  id = " + id);
            PreparedStatement statement = this.conexao.conexao().prepareStatement(sql);
            this.rs = statement.executeQuery();

            while (rs.next()) {
                VendaModel vendaModel = new VendaModel();
                vendaModel.setId(rs.getInt("id"));
                vendaModel.setName(rs.getString("name"));
                vendaModel.setProduto(rs.getString("product"));
                vendaModel.setQuantity(rs.getInt("quantity"));
                vendaModel.setTotal(rs.getDouble("total"));
                statement.close();
                return vendaModel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public VendaModel getVendaByHash(String hash) {
        try {
            List<VendaModel> lista = this.getVendas();
            Encrypt encrypt = new Encrypt();
            for (VendaModel aux : lista) {
                String _hash = encrypt.encrypt(aux.getId().toString());
                if (_hash.equals(hash)) return aux;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}





