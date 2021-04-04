package mvc.model.server.persistence.entities.tiposProductos;

import collections.ToList;
import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.dao.Dao;
import mvc.model.server.persistence.dto.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TiposProductosDao extends Dao<TiposProductos>
{
    public TiposProductosDao() {
        super(DataSource.getInstance());
    }

    //Puede retornar multiples objetos
    @Override
    public ToList<TiposProductos> read()
    {
        DataSource         dataSource = DataSource.getInstance();
        TiposProductos             data       = new TiposProductos();
        ResultSet resultSet  = dataSource.runQuery(data.read());

        ToList<TiposProductos> tiposProductosList = new ToList<TiposProductos>();
        try
        {
            while (resultSet.next())
            {
                tiposProductosList.agregarAlFinal(getData(resultSet));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return tiposProductosList;
    }

    //Retorna solo 1 objeto
    @Override
    public TiposProductos findById(Dto data)
    {
        //Recupera un Object de la DB, crea el puente o lo obtiene
        DataSource dataSource = DataSource.getInstance();
        //Ejecuta la consulta y almacena su resultado
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        //Instancia un objeto de la entidad mapeada respectiva
        TiposProductos     tiposProductos     = null;
        try
        {
            //Recorre la "tabla"(como la que se muestra en una consulta sql), pero en este caso solo hay 1 tupla como resultado de la consulta
            while (resultSet.next())
            {
                //Crea el objeto respectivo del Dao y lo retorna con la informacion del resulSet
                tiposProductos = getData(resultSet);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
            //Error
        }
        return tiposProductos;
    }

    //Crea y retorna objeto respectivo del Dao con la informacion del ResultSet
    private TiposProductos getData(ResultSet resultSet) throws SQLException
    {
        return new TiposProductos
                (
                        resultSet.getDouble("codigo"),
                        resultSet.getString("tipo")
                );
    }
}
