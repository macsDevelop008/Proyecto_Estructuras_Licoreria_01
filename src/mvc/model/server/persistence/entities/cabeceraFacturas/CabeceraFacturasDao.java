package mvc.model.server.persistence.entities.cabeceraFacturas;

import collections.ToList;
import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.dao.Dao;
import mvc.model.server.persistence.dto.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CabeceraFacturasDao extends Dao<CabeceraFacturas>
{
    public CabeceraFacturasDao() {
        super(DataSource.getInstance());
    }

    //Puede retornar multiples objetos
    @Override
    public ToList<CabeceraFacturas> read()
    {
        DataSource         dataSource = DataSource.getInstance();
        CabeceraFacturas             data       = new CabeceraFacturas();
        ResultSet resultSet  = dataSource.runQuery(data.read());

        ToList<CabeceraFacturas> cabeceraFacturasList = new ToList<CabeceraFacturas>();
        try
        {
            while (resultSet.next())
            {
                cabeceraFacturasList.agregarAlFinal(getData(resultSet));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return cabeceraFacturasList;
    }

    //Retorna solo 1 objeto
    @Override
    public CabeceraFacturas findById(Dto data)
    {
        //Recupera un Object de la DB, crea el puente o lo obtiene
        DataSource dataSource = DataSource.getInstance();
        //Ejecuta la consulta y almacena su resultado
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        //Instancia un objeto de la entidad mapeada respectiva
        CabeceraFacturas     cabeceraFactura     = null;
        try
        {
            //Recorre la "tabla"(como la que se muestra en una consulta sql), pero en este caso solo hay 1 tupla como resultado de la consulta
            while (resultSet.next())
            {
                //Crea el objeto respectivo del Dao y lo retorna con la informacion del resulSet
                cabeceraFactura = getData(resultSet);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
            //Error
        }
        return cabeceraFactura;
    }

    //Crea y retorna objeto respectivo del Dao con la informacion del ResultSet
    private CabeceraFacturas getData(ResultSet resultSet) throws SQLException
    {
        return new CabeceraFacturas
                (
                        resultSet.getDouble("numero_factura"),
                        resultSet.getDate("fecha"),
                        resultSet.getString("nombre_cliente")
                );
    }
}
