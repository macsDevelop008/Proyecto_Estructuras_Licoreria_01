package mvc.model.server.persistence;

import collections.ToList;
import mvc.model.server.persistence.entities.cabeceraFacturas.CabeceraFacturas;
import mvc.model.server.persistence.entities.cabeceraFacturas.CabeceraFacturasDao;

import java.math.BigDecimal;

public class TestDB
{
    public static void main(String[] args)
    {
        new TestDB();
    }

    public TestDB()
    {

        //Prueba Read
        //Se crea objeto del DAO de la tabla y DTO para saber el SQL
        CabeceraFacturasDao cabeceraFacturasDao = new CabeceraFacturasDao();
        CabeceraFacturas cabeceraFacturas = new CabeceraFacturas();

        //Almacena la lista generada con los datos d ela DB
        ToList<CabeceraFacturas> cabeceraFacturasToList = new ToList<CabeceraFacturas>();
        cabeceraFacturasToList = cabeceraFacturasDao.read(cabeceraFacturas);

        //Mostrar resultados por Consola
        for (int i = 0; i < cabeceraFacturasToList.getTamanio(); i++)
        {
            System.out.println(cabeceraFacturasToList.getValor(i));
        }


        //-------------------------------------------------------------------------

        /*
        //Prueba BuscarPorID
        CabeceraFacturasDao cabeceraFacturasDao = new CabeceraFacturasDao();
        CabeceraFacturas cabeceraFacturas = new CabeceraFacturas(BigDecimal.valueOf(1));

        System.out.println(cabeceraFacturasDao.findById(cabeceraFacturas));
        */
    }
}
