package mvc.model.server.persistence.entities.detallesFacturas;

import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.dao.Dao;

public class DetallesFacturasDao extends Dao<DetallesFacturas>
{
    public DetallesFacturasDao()
    {
        super(DataSource.getInstance());
    }

    //CONSULTAS ESPECIFICAS
}
