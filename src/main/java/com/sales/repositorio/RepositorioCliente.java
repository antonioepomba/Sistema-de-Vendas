package com.sales.repositorio;

import com.sales.model.ClienteModel;
import com.sales.utility.Database;
import com.sales.utility.Encrypt;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RepositorioCliente {

    private Database conexao;
    private ResultSet rs;
    PreparedStatement statement;


    public RepositorioCliente() {
        this.conexao = new Database();
        this.rs = null;
    }

    public List<ClienteModel> getAllClientes() {
        String produto_query = ("SELECT * FROM clientes");
        try {

            statement = this.conexao.conexao().prepareStatement(produto_query);
            rs = statement.executeQuery();
            List<ClienteModel> clientlist = new ArrayList<ClienteModel>();
            while (rs.next()) {
                ClienteModel clienteModel = new ClienteModel();
                clienteModel.setId(rs.getInt("id"));
                clienteModel.setName(rs.getString("name"));
                clienteModel.setEndereco(rs.getString("endereco"));
                clienteModel.setTelefone(rs.getInt("telefone"));

                Encrypt encrypt = new Encrypt();
                clienteModel.setHashId(encrypt.encrypt(clienteModel.getId().toString()));

                clientlist.add(clienteModel);
            }
            statement.close();
            return clientlist;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void save(ClienteModel clienteModel) {
        String sql = ("INSERT INTO clientes(name,endereco,telefone)  VALUES (?, ?, ?);");

        try {

            // Step 2:Create a statement using connection object
            statement = this.conexao.conexao().prepareStatement(sql);
            statement.setString(1, clienteModel.getName());
            statement.setString(2, clienteModel.getEndereco());
            statement.setInt(3, clienteModel.getTelefone());
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {

            printSQLException(e);
        }
    }

    public void edit(ClienteModel clienteModel) {

        String sql = "UPDATE clientes SET name=?, endereco=?, telefone=?  WHERE id = " +clienteModel.getId()+ ";";

        try {
            statement = this.conexao.conexao().prepareStatement(sql);
            statement.setString(1, clienteModel.getName());
            statement.setString(2, clienteModel.getEndereco());
            statement.setInt(3, clienteModel.getTelefone());
            statement.executeUpdate();

            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ClienteModel getClientById(String id) {
        try {

            String sql = ("SELECT  * FROM clientes WHERE  id = " + id);
            PreparedStatement statement = this.conexao.conexao().prepareStatement(sql);
            this.rs = statement.executeQuery();

            while (rs.next()) {
                ClienteModel clienteModel = new ClienteModel();
                clienteModel.setId(rs.getInt("id"));
                clienteModel.setName(rs.getString("name"));
                clienteModel.setEndereco(rs.getString("endereco"));
                clienteModel.setTelefone(rs.getInt("telefone"));
                System.out.println("editar");
                statement.close();
                return clienteModel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ClienteModel deleteCliente(String id) {

        String sql = "DELETE FROM clientes where id = ? ";
        try {
            statement = this.conexao.conexao().prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public ClienteModel getClientByHash(String hash) {
        try {
            List<ClienteModel> lista = this.getAllClientes();
            Encrypt encrypt = new Encrypt();
            for (ClienteModel aux : lista) {
                String _hash = encrypt.encrypt(aux.getId().toString());
                if (_hash.equals(hash))
                    return aux;
            }
        } catch (NoSuchAlgorithmException e) {
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


}





