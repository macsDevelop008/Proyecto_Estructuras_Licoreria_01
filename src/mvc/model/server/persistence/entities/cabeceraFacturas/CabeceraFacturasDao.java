package mvc.model.server.persistence.entities.cabeceraFacturas;

import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.dao.Dao;


public class CabeceraFacturasDao extends Dao<CabeceraFacturas>
{
    public CabeceraFacturasDao()
    {
        super(DataSource.getInstance());
    }

    //CONSULTAS ESPECIFICAS

}
