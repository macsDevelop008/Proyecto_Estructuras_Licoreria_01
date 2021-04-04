package mvc.model.server.persistence.entities.marcas;

import collections.ToList;
import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.dao.Dao;
import mvc.model.server.persistence.dto.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarcasDao extends Dao<Marcas>
{
    public MarcasDao() {
        super(DataSource.getInstance());
    }

    //Puede retornar multiples objetos
    @Override
    public ToList<Marcas> read()
    {
        DataSource         dataSource = DataSource.getInstance();
        Marcas             data       = new Marcas();
        ResultSet resultSet  = dataSource.runQuery(data.read());

        ToList<Marcas> marcasList = new ToList<Marcas>();
        try
        {
            while (resultSet.next())
            {
                marcasList.agregarAlFinal(getData(resultSet));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return marcasList;
    }


    //Retorna solo 1 objeto
    @Override
    public Marcas findById(Dto data)
    {
        //Recupera un Object de la DB, crea el puente o lo obtiene
        DataSource dataSource = DataSource.getInstance();
        //Ejecuta la consulta y almacena su resultado
        ResultSet  resultSet  = dataSource.runQuery(data.findById());
        //Instancia un objeto de la entidad mapeada respectiva
        Marcas     marcas     = null;
        try
        {
            //Recorre la "tabla"(como la que se muestra en una consulta sql), pero en este caso solo hay 1 tupla como resultado de la consulta
            while (resultSet.next())
            {
                //Crea el objeto respectivo del Dao y lo retorna con la informacion del resulSet
                marcas = getData(resultSet);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
            //Error
        }
        return marcas;
    }

    //Crea y retorna objeto respectivo del Dao con la informacion del ResultSet
    private Marcas getData(ResultSet resultSet) throws SQLException
    {
        return new Marcas
                (
                        resultSet.getDouble("codigo"),
                        resultSet.getString("nombre")
                );
    }
}
