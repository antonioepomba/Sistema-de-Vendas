package com.sales.repositorio;
import com.sales.utility.Database;
import com.sales.model.ProdutoModel;
import com.sales.utility.Encrypt;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RepositorioProduto {


    private Database conexao;
    private ResultSet rs;
    PreparedStatement statement;

    public RepositorioProduto() {
        this.conexao = new Database();
        this.rs = null;
    }


                public List<ProdutoModel> getAllProdutos() {
                    String listQuery = ("SELECT * FROM productos");
                    ResultSet produtoset = null;
                    try {

                      statement= this.conexao.conexao().prepareStatement(listQuery);
                        produtoset = statement.executeQuery();
                        List<ProdutoModel> productList = new ArrayList<ProdutoModel>();
                        while (produtoset.next()) {
                            ProdutoModel produtos = new ProdutoModel();
                            produtos.setId(produtoset.getInt("id"));
                            produtos.setName(produtoset.getString("nome"));
                            produtos.setPreco(produtoset.getDouble("preco"));
                            Encrypt encrypt = new Encrypt();
                            produtos.setHashId(encrypt.encrypt(produtos.getId().toString()));
                            productList.add(produtos);

                        }
                        statement.close();
                        return productList;
                    } catch (SQLException | NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                public void save(ProdutoModel produtos) {

                    String sql = ("INSERT INTO productos(nome, preco)  VALUES (?, ?);");

                    try {


                        statement = this.conexao.conexao().prepareStatement(sql);
                        statement.setString(1, produtos.getName());
                        statement.setDouble(2, produtos.getPreco());
                        int count = statement.executeUpdate();
                        System.out.println(count);
                        statement.close();

                        } catch (SQLException e) {
                            e.printStackTrace();
                    }
                }

                public void edit(ProdutoModel produtos) {

                    String sql = "UPDATE productos SET nome=?, preco=?  WHERE id = " + produtos.getId() + ";";

                    try {

                        statement = this.conexao.conexao().prepareStatement(sql);
                        statement.setString(1, produtos.getName());
                        statement.setDouble(2, produtos.getPreco());
                        int count = statement.executeUpdate();
                        System.out.println(count);
                        statement.close();


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                public ProdutoModel deleteProduto(String id) {


                    String sql = "DELETE FROM productos where id = ? ";
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


                public ProdutoModel getProdutoById(String id) {
                    try {

                        String sql = ("SELECT  * FROM productos WHERE  id = " + id);
                        statement = this.conexao.conexao().prepareStatement(sql);
                        this.rs = statement.executeQuery();

                        while (rs.next()) {
                            ProdutoModel produtos = new ProdutoModel();
                            produtos.setId(rs.getInt("id"));
                            produtos.setName(rs.getString("nome"));
                            produtos.setPreco(rs.getDouble("preco"));
                            statement.close();
                            return produtos;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

    public ProdutoModel getProdutoByHash(String hash) {
        try {
            List<ProdutoModel> lista = this.getAllProdutos();
            Encrypt encrypt = new Encrypt();
            for (ProdutoModel aux : lista) {
                String _hash = encrypt.encrypt(aux.getId().toString());
                if(_hash.equals(hash)) return aux;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}










