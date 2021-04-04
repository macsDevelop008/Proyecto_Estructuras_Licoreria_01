package mvc.model.server.persistence.entities.detallesFacturas;

import collections.ToList;
import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.dao.Dao;
import mvc.model.server.persistence.dto.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DetallesFacturasDao extends Dao<DetallesFacturas>
{
    public DetallesFacturasDao() {
        super(DataSource.getInstance());
    }

    //Puede retornar multiples objetos
    @Override
    public ToList<DetallesFacturas> read()
    {
        DataSource         dataSource = DataSource.getInstance();
        DetallesFacturas             data       = new DetallesFacturas();
        ResultSet resultSet  = dataSource.runQuery(data.read());

        ToList<DetallesFacturas> detallesFacturasList = new ToList<DetallesFacturas>();
        try
        {
            while (resultSet.next())
            {
                detallesFacturasList.agregarAlFinal(getData(resultSet));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return detallesFacturasList;
    }

    //Retorna solo 1 objeto
    @Override
    public DetallesFacturas findById(Dto data)
    {
        //Recupera un Object de la DB, crea el puente o lo obtiene
        DataSource dataSource = DataSource.getInstance();
        //Ejecuta la consulta y almacena su resultado
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        //Instancia un objeto de la entidad mapeada respectiva
        DetallesFacturas     detallesFacturas     = null;
        try
        {
            //Recorre la "tabla"(como la que se muestra en una consulta sql), pero en este caso solo hay 1 tupla como resultado de la consulta
            while (resultSet.next())
            {
                //Crea el objeto respectivo del Dao y lo retorna con la informacion del resulSet
                detallesFacturas = getData(resultSet);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
            //Error
        }
        return detallesFacturas;
    }

    //Crea y retorna objeto respectivo del Dao con la informacion del ResultSet
    private DetallesFacturas getData(ResultSet resultSet) throws SQLException
    {
        return new DetallesFacturas
                (
                        resultSet.getDouble("cabecera_facturas_numero_factura"),
                        resultSet.getDouble("productos_codigo"),
                        resultSet.getInt("cantidad_producto"),
                        resultSet.getDouble("valor_unitario_producto")
                );
    }
}
