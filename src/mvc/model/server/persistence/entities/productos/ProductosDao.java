package mvc.model.server.persistence.entities.productos;

import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.dao.Dao;

public class ProductosDao extends Dao<Productos>
{
    public ProductosDao()
    {
        super(DataSource.getInstance());
    }
}
