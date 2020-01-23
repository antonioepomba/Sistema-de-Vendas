package com.sales.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database
{
    String driver =("com.mysql.cj.jdbc.Driver");
    String db_username = "root";
    String db_password = "";
    String db_url = "jdbc:mysql://localhost:3306/sistema_de_vendas?serverTimezone=UTC";

    Connection connection = null;

    public Database()
    {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(db_url, db_username, db_password);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Connection conexao()
    {
        return this.connection;
    }
}
