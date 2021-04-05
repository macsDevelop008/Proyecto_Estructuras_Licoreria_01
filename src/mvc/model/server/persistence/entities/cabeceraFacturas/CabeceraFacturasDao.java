package mvc.model.server.persistence.entities.cabeceraFacturas;

import collections.ToList;
import mvc.model.server.persistence.DataSource;
import mvc.model.server.persistence.dao.Dao;
import mvc.model.server.persistence.dto.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CabeceraFacturasDao extends Dao<CabeceraFacturas>
{
    public CabeceraFacturasDao()
    {
        super(DataSource.getInstance());
    }

    //CONSULTAS ESPECIFICAS

}
