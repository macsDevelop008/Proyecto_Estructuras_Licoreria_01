package mvc.model.server.persistence.dao;

import collections.ToList;
import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.dto.Dto;

public abstract class Dao<T extends Dto>
{
    //Objeto con el que se irá ejecutando las instrucciones sql
    private final DataSource dataSource;

    protected Dao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    //Metodo genericos, usados para cualquier tabla

    //Llega el objeto por parametro y este contiene la instruccion SQL para ejecutar el evento deseado.
    public boolean insert(Dto data)
    {
        return dataSource.runExecuteUpdate(data.insert());
    }

    public abstract ToList<T> read();


    public boolean update(Dto data)
    {
        return dataSource.runExecuteUpdate(data.update());
    }

    public boolean delete(Dto data)
    {
        return dataSource.runExecuteUpdate(data.delete());
    }

    public abstract T findById(Dto data);
}
