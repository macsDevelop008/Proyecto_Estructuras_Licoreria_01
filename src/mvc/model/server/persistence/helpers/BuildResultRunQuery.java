package mvc.model.server.persistence.helpers;

import collections.ToList;
import mvc.model.server.dto.*;
import mvc.model.server.persistence.DataSource;

import java.sql.ResultSet;

public  class BuildResultRunQuery
{
    public static ToList<? extends Dto> objMultipleResult(String sql, DataSource dataSource )
    {
        //runQuery

        ResultSet resultSet;

        ToList<? extends Dto> obj =  new ToList<>();

        resultSet = dataSource.runQuery(sql);

        obj = resultMultipleRaw(sql, resultSet);

        return obj;
    }

    public static Dto objSimpleResult(String sql, DataSource dataSource )
    {
        ResultSet resultSet;
        resultSet = dataSource.runQuery(sql);
        Dto obj;
        obj = resultSimpleRaw(sql, resultSet);
        return obj;
    }

    private static ToList<? extends Dto> resultMultipleRaw(String sql, ResultSet resultSet)
    {
        //SELECT * FROM public.cabecera_facturas

        if(sql.contains("public.cabecera_facturas"))
        {
            Entity<CabeceraFacturas> entity = new Entity<CabeceraFacturas>(CabeceraFacturas.class);
            return entity.getMultipleRows(resultSet);
        }else
        if(sql.contains("public.detalles_facturas"))
        {
            Entity<DetallesFacturas> entity = new Entity<DetallesFacturas>(DetallesFacturas.class);
            return entity.getMultipleRows(resultSet);
        }else
        if(sql.contains("public.marcas"))
        {
            Entity<Marcas> entity = new Entity<Marcas>(Marcas.class);
            return entity.getMultipleRows(resultSet);
        }else
        if(sql.contains("public.productos"))
        {
            Entity<Productos> entity = new Entity<Productos>(Productos.class);
            return entity.getMultipleRows(resultSet);
        }
        else //public.tipos_productos
        {
            Entity<TiposProductos> entity = new Entity<TiposProductos>(TiposProductos.class);
            return entity.getMultipleRows(resultSet);
        }
    }

    private static Dto resultSimpleRaw(String sql, ResultSet resultSet)
    {
        if(sql.contains("public.cabecera_facturas"))
        {
            Entity<CabeceraFacturas> entity = new Entity<CabeceraFacturas>(CabeceraFacturas.class);
            return entity.getSingleRow(resultSet);
        }else
        if(sql.contains("public.detalles_facturas"))
        {
            Entity<DetallesFacturas> entity = new Entity<DetallesFacturas>(DetallesFacturas.class);
            return entity.getSingleRow(resultSet);
        }else
        if(sql.contains("public.marcas"))
        {
            Entity<Marcas> entity = new Entity<Marcas>(Marcas.class);
            return entity.getSingleRow(resultSet);
        }else
        if(sql.contains("public.productos"))
        {
            Entity<Productos> entity = new Entity<Productos>(Productos.class);
            return entity.getSingleRow(resultSet);
        }
        else //public.tipos_productos
        {
            Entity<TiposProductos> entity = new Entity<TiposProductos>(TiposProductos.class);
            return entity.getSingleRow(resultSet);
        }
    }
}
