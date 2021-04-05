package mvc.model.server.persistence.entities.marcas;

import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.dao.Dao;

public class MarcasDao extends Dao<Marcas>
{
    public MarcasDao()
    {
        super(DataSource.getInstance());
    }

    //CONSULTAS ESPECIFICAS
}
