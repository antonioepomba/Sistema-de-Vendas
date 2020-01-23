package com.sales.model;

public class ProdutoModel {
    private Integer id;

    private String name;

    private String hashId;

    private double preco;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getHashId() {
        return this.hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }
}
