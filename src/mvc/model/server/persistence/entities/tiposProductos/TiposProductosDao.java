package mvc.model.server.persistence.entities.tiposProductos;

import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.dao.Dao;

public class TiposProductosDao extends Dao<TiposProductos>
{
    public TiposProductosDao()
    {
        super(DataSource.getInstance());
    }

    //CONSULTAS ESPECIFICAS
}
