package com.sales.model;
import java.sql.Date;
import java.time.LocalDate;

public class PessoaModel {

    private Integer id;

    private String Nome;

    private Date dataNascimento;


    private String localdeTrabalho;


    private int numerodoTelefone;


    private String Endereco;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLocaldeTrabalho() {
        return localdeTrabalho;
    }

    public void setLocaldeTrabalho(String localdeTrabalho) {
        this.localdeTrabalho = localdeTrabalho;
    }

    public int getNumerodoTelefone() {
        return numerodoTelefone;
    }

    public void setNumerodoTelefone(int numerodoTelefone) {
        this.numerodoTelefone = numerodoTelefone;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }
}
