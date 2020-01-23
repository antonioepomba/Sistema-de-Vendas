package com.sales.repositorio;

import com.sales.utility.Database;
import com.sales.model.FuncionarioModel;
import com.sales.utility.Encrypt;


import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RepositorioFuncionario {

    private Database conexao;
    private ResultSet rs;
  private PreparedStatement statment;
    Encrypt encrypt = new Encrypt();

    public RepositorioFuncionario() {
        this.conexao = new Database();
        this.rs = null;
    }


    public List<FuncionarioModel> getFuncionarios() {
        String produto_query = ("SELECT * FROM funcionarios");
        ResultSet funcionarioset = null;
        try {

          statment = this.conexao.conexao().prepareStatement(produto_query);
            funcionarioset = statment.executeQuery();
            List<FuncionarioModel> funcionario_List = new ArrayList<FuncionarioModel>();
            while (funcionarioset.next()) {
                FuncionarioModel funcionarios = new FuncionarioModel();
                funcionarios.setId(funcionarioset.getInt("id"));
                funcionarios.setNome(funcionarioset.getString("nome"));
                funcionarios.setEmail(funcionarioset.getString("email"));
                funcionarios.setEndereco(funcionarioset.getString("endereco"));
                funcionarios.setSalario(funcionarioset.getDouble("salario"));

                //encriptar id
                Encrypt encrypt = new Encrypt();
                funcionarios.setHashId(encrypt.encrypt(funcionarios.getId().toString()));

                funcionario_List.add(funcionarios);
            }
            statment.close();
            return funcionario_List;
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean checkUser(FuncionarioModel funcionarios)  {
        String username = null;
        String password =null;

        String produto_login = ("SELECT * FROM funcionarios WHERE nome=? And password=?");

        username = funcionarios.getNome();
        password = funcionarios.getPassword();


        try {
           statment = this.conexao.conexao().prepareStatement(produto_login);
            statment.setString(1, username);
            statment.setString(2, encrypt.encrypt(password));

            this.rs = statment.executeQuery();

            return this.rs.next();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
    public FuncionarioModel deleteFuncionario(String id) {

        String sql = "DELETE FROM funcionarios where id = ? ";
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



    public void save(FuncionarioModel funcionarios) throws NoSuchAlgorithmException {


        String sql = ("INSERT INTO funcionarios(nome, email,password,endereco,salario)  VALUES (?, ?, ?, ?, ?);");

        try {

            // Step 2:Create a statement using connection object
            statment = this.conexao.conexao().prepareStatement(sql);
            statment.setString(1, funcionarios.getNome());
            statment.setString(2, funcionarios.getEmail());
            statment.setString(3, encrypt.encrypt(funcionarios.getPassword()));
            statment.setString(4, funcionarios.getEndereco());
            statment.setDouble(5, funcionarios.getSalario());
            statment.executeUpdate();

            statment.close();

        } catch (SQLException e) {

            printSQLException(e);
        }
    }
    public void edit(FuncionarioModel funcionarios) {

        String sql = "UPDATE funcionarios SET nome=?, email=?, endereco=?, salario=?  WHERE id = "+ funcionarios.getId() + ";";

        try {

            statment = this.conexao.conexao().prepareStatement(sql);
            statment.setString(1,funcionarios.getNome());
            statment.setString(2, funcionarios.getEmail());
            statment.setString(3, funcionarios.getEndereco());
            statment.setDouble(4, funcionarios.getSalario());
            int count = statment.executeUpdate();
            System.out.println(count);
            statment.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public FuncionarioModel getFuncionarioById(String id) {
        try {

            String sql = ("SELECT  * FROM funcionarios WHERE  id = " + id);
            PreparedStatement statement = this.conexao.conexao().prepareStatement(sql);
            this.rs = statement.executeQuery();

            while (rs.next()) {
                FuncionarioModel funcionario = new FuncionarioModel();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setSalario(rs.getDouble("salario"));
                statement.close();
                return funcionario;
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
    public FuncionarioModel getFuncionarioByHash(String hash) {
        try {
            List<FuncionarioModel> lista = this.getFuncionarios();
            Encrypt encrypt = new Encrypt();
            for (FuncionarioModel aux : lista) {
                String _hash = encrypt.encrypt(aux.getId().toString());
                if(_hash.equals(hash)) return aux;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}





