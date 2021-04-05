package mvc.model.server.persistence;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataSource
{
    //Singleton
    private static DataSource dataSource = null;
    private Connection con;

    private DataSource()
    {
        Properties conProperties = new Properties();

        try
        {
            //Puente - conexión a la DB

            conProperties.load(new FileInputStream("src/mvc/model/server/persistence/data/connection.properties"));

            String url = conProperties.getProperty("url");
            String user = conProperties.getProperty("user");
            String password = conProperties.getProperty("password");

            con = DriverManager.getConnection(url, user, password);

            //Test
            System.out.println("Conexión DB Exitosa");

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error, Conexión DB NO Exitosa");
        }
    }

    //Metodo a invocar para poder conectar con la DB
    public static DataSource getInstance()
    {
        if (dataSource == null)
        {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    //Ejecuta el executeQuery -> Select
    //@ Retorna -> resulSet que contiene la información
    public ResultSet runQuery(String sql)
    {
        ResultSet resultSet = null;
        try
        {
            //Permite la ejecucion de instrucciones sql en la DB
            Statement statement = con.createStatement();
            resultSet = statement.executeQuery(sql);

            System.out.println("Successful query: "+sql);
        }
        catch (SQLException e)
        {
            System.out.println("Query error: "+e.getMessage());
        }
        return resultSet;
    }

    //Ejecuta el executeUpdate -> Delete, update, insert
    //@ Return true o false, si lo hizo bien o no
    public boolean runExecuteUpdate(String sql)
    {
        int rows=0;
        try
        {
            //Permite la ejecucion de instrucciones sql en la DB
            Statement statement = con.createStatement();
            rows = statement.executeUpdate(sql);
            System.out.println("Successful query: "+sql);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println("Query error: "+e.getMessage());
            return false;
        }
    }
}
