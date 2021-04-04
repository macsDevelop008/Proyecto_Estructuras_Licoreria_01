package mvc.model.server.persistence.entities.productos;

import collections.ToList;
import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.dao.Dao;
import mvc.model.server.persistence.dto.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductosDao extends Dao<Productos>
{
    public ProductosDao() {
        super(DataSource.getInstance());
    }

    //Puede retornar multiples objetos
    @Override
    public ToList<Productos> read()
    {
        DataSource         dataSource = DataSource.getInstance();
        Productos             data       = new Productos();
        ResultSet resultSet  = dataSource.runQuery(data.read());

        ToList<Productos> productosList = new ToList<Productos>();
        try
        {
            while (resultSet.next())
            {
                productosList.agregarAlFinal(getData(resultSet));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return productosList;
    }

    //Retorna solo 1 objeto
    @Override
    public Productos findById(Dto data)
    {
        //Recupera un Object de la DB, crea el puente o lo obtiene
        DataSource dataSource = DataSource.getInstance();
        //Ejecuta la consulta y almacena su resultado
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        //Instancia un objeto de la entidad mapeada respectiva
        Productos     productos     = null;
        try
        {
            //Recorre la "tabla"(como la que se muestra en una consulta sql), pero en este caso solo hay 1 tupla como resultado de la consulta
            while (resultSet.next())
            {
                //Crea el objeto respectivo del Dao y lo retorna con la informacion del resulSet
                productos = getData(resultSet);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
            //Error
        }
        return productos;
    }

    //Crea y retorna objeto respectivo del Dao con la informacion del ResultSet
    private Productos getData(ResultSet resultSet) throws SQLException
    {
        return new Productos
                (
                        resultSet.getDouble("tipos_productos_codigo"),
                        resultSet.getDouble("marcas_codigo"),
                        resultSet.getDouble("codigo"),
                        resultSet.getString("nombre")
                );
    }
}
