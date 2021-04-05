package mvc.model.server.persistence;

import collections.ToList;
import mvc.model.server.persistence.entities.cabeceraFacturas.CabeceraFacturas;
import mvc.model.server.persistence.entities.cabeceraFacturas.CabeceraFacturasDao;
import mvc.model.server.persistence.entities.detallesFacturas.DetallesFacturas;
import mvc.model.server.persistence.entities.detallesFacturas.DetallesFacturasDao;
import mvc.model.server.persistence.entities.marcas.Marcas;
import mvc.model.server.persistence.entities.marcas.MarcasDao;
import mvc.model.server.persistence.entities.productos.Productos;
import mvc.model.server.persistence.entities.productos.ProductosDao;
import mvc.model.server.persistence.entities.tiposProductos.TiposProductos;
import mvc.model.server.persistence.entities.tiposProductos.TiposProductosDao;

import java.math.BigDecimal;

public class TestDB
{
    public static void main(String[] args)
    {
        new TestDB();
    }

    public TestDB()
    {

        //Prueba read
        DetallesFacturasDao detallesFacturasDao = new DetallesFacturasDao();
        DetallesFacturas detallesFacturas = new DetallesFacturas();

        //Almacena la lista generada con los datos d ela DB
        ToList<DetallesFacturas> detallesFacturasToList = new ToList<DetallesFacturas>();
        detallesFacturasToList = detallesFacturasDao.read(detallesFacturas);

        //Mostrar resultados por Consola
        for (int i = 0; i < detallesFacturasToList.getTamanio(); i++)
        {
            System.out.println(detallesFacturasToList.getValor(i));
        }

        //-------------------------------------------------------------------------
/*
        //Prueba BuscarPorID
        DetallesFacturasDao detallesFacturasDao = new DetallesFacturasDao();
        DetallesFacturas detallesFacturas = new DetallesFacturas(BigDecimal.valueOf(8), BigDecimal.valueOf(20100432));

        System.out.println(detallesFacturasDao.findById(detallesFacturas));
*/
    }
}
