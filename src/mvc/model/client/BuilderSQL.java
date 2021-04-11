package mvc.model.client;
import mvc.model.client.dao.*;
import mvc.model.client.dto.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public  class BuilderSQL
{
    public BuilderSQL()
    {
    }

    public  String builderReturn()
    {
        return builder();
    }


    String builder()
    {
        String sql = "";

        menuEntities();

        String inputMenuEntities = "";
        String inputMenuQueries = "";

        Scanner inputScanner = new Scanner (System.in);
        inputMenuEntities = inputScanner.nextLine();

        if(inputMenuEntities.equals("0"))
        {
            //Cerrar el servidor
            sql = "EXIT";
        }
        else
            {
                menuQueries();
                inputMenuQueries = inputScanner.nextLine();

                sql = findQuerie(inputMenuEntities,inputMenuQueries);
            }

        return sql;
    }

     void menuEntities()
    {
        System.out.println("Selecciona la tabla a consultar");
        System.out.println("1. Marcas");
        System.out.println("2. Tipos de Productos");
        System.out.println("3. Productos");
        System.out.println("4. Cabecera de Facturas");
        System.out.println("5. Detalles de Facturas");
        System.out.println("0. Salir");
    }

     void menuQueries()
    {
        System.out.println("Selecciona el tipo de consulta que deseas hacer");
        System.out.println("1. Insert");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Select");
        System.out.println("5. Select by Id");
    }

     String findQuerie(String entity, String typeQuerie)
    {

        String result = "";

        switch (entity)
        {
            case "1": //Marcas
                result = BuilderMarca.querieMarcas(typeQuerie);
                break;
            case "2": //Tipos de Productos
                result = BuilderTiposProductos.querieTiposProductos(typeQuerie);
                break;
            case "3": //Productos
                result = BuilderProductos.querieProductos(typeQuerie);
                break;
            case "4": //Cabecera Factura
                result = BuilderCabeceraFactura.querieCabeceraFactura(typeQuerie);
                break;
            case "5": //Detalles de Facturas
                result = BuilderDetallesFacturas.querieDetallesFacturas(typeQuerie);
                break;
        }
        return result;
    }
}


//*********************************

class  BuilderMarca
{
    public static String querieMarcas(String typeQuerie)
    {
        String sql = "";
        MarcasDao marcasDao = new MarcasDao();
        MarcasClient marcasClient;

        switch (typeQuerie)
        {
            case "1": //Insert
                marcasClient = insertObject();
                sql = marcasDao.insert(marcasClient);
                break;

            case "2": //Update
                marcasClient = updateObject();
                sql = marcasDao.update(marcasClient);
                break;
            case "3": //Delete
                marcasClient = deleteObject();
                sql = marcasDao.delete(marcasClient);
                break;

            case "4": //Select
                marcasClient = new MarcasClient();
                sql = marcasDao.read(marcasClient);
                break;

            case "5": //Select by Id
                marcasClient = findByIdObject();
                sql = marcasDao.findById(marcasClient);
                break;
        }

        return sql;
    }


    public static MarcasClient insertObject()
    {
        MarcasClient obj = null;
        Scanner inputScanner = new Scanner (System.in);
        String codigo = "";
        String nombre = "";

        System.out.println("Insertar nueva Marca");
        System.out.println("Ingrese los siguientes datos:");
        System.out.println("Codigo: ");
        codigo = inputScanner.nextLine();
        System.out.println("Nombre: ");
        nombre = inputScanner.nextLine();

        obj = new MarcasClient(new BigDecimal(codigo), nombre);

        return  obj;
    }

    public static MarcasClient updateObject()
    {
        MarcasClient obj = null;
        Scanner inputScanner = new Scanner (System.in);
        String codigo = "";
        String nombre = "";

        System.out.println("Actualizar una Marca");
        System.out.println("Ingrese los siguientes datos:");
        System.out.println("Codigo del Registro a Modificar: ");
        codigo = inputScanner.nextLine();
        System.out.println("Nombre Nuevo: ");
        nombre = inputScanner.nextLine();

        obj = new MarcasClient(new BigDecimal(codigo), nombre);

        return  obj;
    }

    public static MarcasClient deleteObject()
    {
        MarcasClient obj = null;
        Scanner inputScanner = new Scanner (System.in);
        String codigo = "";

        System.out.println("Actualizar una Marca");
        System.out.println("Ingrese los siguientes datos:");
        System.out.println("Codigo del Registro a Eliminar: ");
        codigo = inputScanner.nextLine();

        obj = new MarcasClient(new BigDecimal(codigo));

        return  obj;
    }
    public static MarcasClient findByIdObject()
    {
        MarcasClient obj = null;
        Scanner inputScanner = new Scanner (System.in);
        String codigo = "";

        System.out.println("Buscar una Marca por ID");
        System.out.println("Ingrese los siguientes datos:");
        System.out.println("Codigo del Registro a Buscar: ");
        codigo = inputScanner.nextLine();

        obj = new MarcasClient(new BigDecimal(codigo));

        return  obj;
    }
}

//*********************************

class BuilderCabeceraFactura
{
    public static String querieCabeceraFactura(String typeQuerie)
    {
        String sql = "";
        CabeceraFacturasDao cabeceraFacturasDao = new CabeceraFacturasDao();
        CabeceraFacturasClient cabeceraFacturasClient;

        switch (typeQuerie)
        {
            case "1": //Insert
                try
                {
                    cabeceraFacturasClient = insertObject();
                    sql = cabeceraFacturasDao.insert(cabeceraFacturasClient);
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
                break;

            case "2": //Update
                try {
                    cabeceraFacturasClient = updateObject();
                    sql = cabeceraFacturasDao.update(cabeceraFacturasClient);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "3": //Delete
                cabeceraFacturasClient = deleteObject();
                sql = cabeceraFacturasDao.delete(cabeceraFacturasClient);
                break;

            case "4": //Select
                cabeceraFacturasClient = new CabeceraFacturasClient();
                sql = cabeceraFacturasDao.read(cabeceraFacturasClient);
                break;

            case "5": //Select by Id
                cabeceraFacturasClient = findByIdObject();
                sql = cabeceraFacturasDao.findById(cabeceraFacturasClient);
                break;
        }

        return sql;
    }

    static CabeceraFacturasClient insertObject() throws ParseException {
        CabeceraFacturasClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String numeroFactura = "";
        String fecha = "";
        String nombreCliente = "";

        System.out.println("Insertar nueva Cabecera de Factura");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Numero de la Factura: ");
        numeroFactura = inputScanner.nextLine();
        System.out.println("Fecha: Ejemplo 2020-01-08 17:25:31");
        fecha = inputScanner.nextLine();
        System.out.println("Nombre del Cliente: ");
        nombreCliente = inputScanner.nextLine();

        SimpleDateFormat fechaFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date fechaResult = fechaFormat.parse(fecha);

        obj = new CabeceraFacturasClient(new BigDecimal(numeroFactura),
                                            fechaResult,
                                            nombreCliente);

        return  obj;
    }

    static CabeceraFacturasClient updateObject() throws ParseException
    {
        CabeceraFacturasClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String numeroFactura = "";
        String fecha = "";
        String nombreCliente = "";

        System.out.println("Actualizar Cabecera de Factura");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Numero de Factura a Modificar: ");
        numeroFactura = inputScanner.nextLine();
        System.out.println("Nueva Fecha: Ejemplo 2020-01-08 17:25:31");
        fecha = inputScanner.nextLine();
        System.out.println("Nuevo Nombre del Cliente: ");
        nombreCliente = inputScanner.nextLine();

        SimpleDateFormat fechaFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date fechaResult = fechaFormat.parse(fecha);

        obj = new CabeceraFacturasClient(new BigDecimal(numeroFactura),
                fechaResult,
                nombreCliente);

        return  obj;
    }

    static CabeceraFacturasClient deleteObject()
    {
        CabeceraFacturasClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String numeroFactura = "";

        System.out.println("Eliminar Cabecera de Factura");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo del Registro a Eliminar: ");;
        numeroFactura = inputScanner.nextLine();

        obj = new CabeceraFacturasClient(new BigDecimal(numeroFactura));

        return  obj;
    }

    public static CabeceraFacturasClient findByIdObject()
    {
        CabeceraFacturasClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String numeroFactura = "";

        System.out.println("Buscar Cabecera de Factura por Id");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo del Registro a Buscar: ");;
        numeroFactura = inputScanner.nextLine();

        obj = new CabeceraFacturasClient(new BigDecimal(numeroFactura));

        return  obj;
    }
}

//*********************************

class BuilderTiposProductos
{
    public static String querieTiposProductos(String typeQuerie)
    {
        String sql = "";
        TiposProductosDao tiposProductosDao = new TiposProductosDao();
        TiposProductosClient tiposProductosClient;

        switch (typeQuerie)
        {
            case "1": //Insert
                try
                {
                    tiposProductosClient = insertObject();
                    sql = tiposProductosDao.insert(tiposProductosClient);
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
                break;

            case "2": //Update
                try {
                    tiposProductosClient = updateObject();
                    sql = tiposProductosDao.update(tiposProductosClient);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "3": //Delete
                tiposProductosClient = deleteObject();
                sql = tiposProductosDao.delete(tiposProductosClient);
                break;

            case "4": //Select
                tiposProductosClient = new TiposProductosClient();
                sql = tiposProductosDao.read(tiposProductosClient);
                break;

            case "5": //Select by Id
                tiposProductosClient = findByIdObject();
                sql = tiposProductosDao.findById(tiposProductosClient);
                break;
        }

        return sql;
    }

    static TiposProductosClient insertObject() throws ParseException
    {
        TiposProductosClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String codigo = "";
        String tipo = "";

        System.out.println("Insertar nuevo Tipo de Producto");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo del Producto: ");
        codigo = inputScanner.nextLine();
        System.out.println("Tipo de producto");
        tipo = inputScanner.nextLine();


        obj = new TiposProductosClient(new BigDecimal(codigo),
                tipo);

        return  obj;
    }

    static TiposProductosClient updateObject() throws ParseException
    {
        TiposProductosClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String codigo = "";
        String tipo = "";

        System.out.println("Actualizar Tipo de Producto");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo del Tipo de Producto a Modificar: ");
        codigo = inputScanner.nextLine();
        System.out.println("Nuevo Tipo: ");
        tipo = inputScanner.nextLine();


        obj = new TiposProductosClient(new BigDecimal(codigo),
                tipo);

        return  obj;
    }

    static TiposProductosClient deleteObject()
    {
        TiposProductosClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String codigo = "";

        System.out.println("Eliminar Tipo de Producto");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo del Registro a Eliminar: ");;
        codigo = inputScanner.nextLine();

        obj = new TiposProductosClient(new BigDecimal(codigo));

        return  obj;
    }

    public static TiposProductosClient findByIdObject()
    {
        TiposProductosClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String codigo = "";

        System.out.println("Buscar Tipo de Producto por Id");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo del Registro a Buscar: ");;
        codigo = inputScanner.nextLine();

        obj = new TiposProductosClient(new BigDecimal(codigo));

        return  obj;
    }
}

//*********************************

class BuilderProductos
{
    public static String querieProductos(String typeQuerie)
    {
        String sql = "";
        ProductosDao productosDao = new ProductosDao();
        ProductosClient productosClient;

        switch (typeQuerie)
        {
            case "1": //Insert
                try
                {
                    productosClient = insertObject();
                    sql = productosDao.insert(productosClient);
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
                break;

            case "2": //Update
                try {
                    productosClient = updateObject();
                    sql = productosDao.update(productosClient);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "3": //Delete
                productosClient = deleteObject();
                sql = productosDao.delete(productosClient);
                break;

            case "4": //Select
                productosClient = new ProductosClient();
                sql = productosDao.read(productosClient);
                break;

            case "5": //Select by Id
                productosClient = findByIdObject();
                sql = productosDao.findById(productosClient);
                break;
        }

        return sql;
    }

    static ProductosClient insertObject() throws ParseException
    {
        ProductosClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String tiposProductosCodigo = "";
        String marcasCodigo = "";
        String codigo = "";
        String nombre = "";

        System.out.println("Insertar nuevo Producto");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo del tipo de Producto: ");
        tiposProductosCodigo = inputScanner.nextLine();
        System.out.println("Codigo de la marca del Producto");
        marcasCodigo = inputScanner.nextLine();
        System.out.println("Codigo del Producto");
        codigo = inputScanner.nextLine();
        System.out.println("Nombre del Producto");
        nombre = inputScanner.nextLine();


        obj = new ProductosClient(new BigDecimal(tiposProductosCodigo),
                                    new BigDecimal(marcasCodigo),
                                    new BigDecimal(codigo),
                                    nombre);


        return  obj;
    }

    static ProductosClient updateObject() throws ParseException
    {
        ProductosClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String tiposProductosCodigo = "";
        String marcasCodigo = "";
        String codigo = "";
        String nombre = "";

        System.out.println("Actualizar Producto");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo del Producto a Modificar: ");
        codigo = inputScanner.nextLine();
        System.out.println("Nuevo Codigo del Tipo de Producto: ");
        tiposProductosCodigo = inputScanner.nextLine();
        System.out.println("Nuevo Codigo de la Marca del Producto: ");
        marcasCodigo = inputScanner.nextLine();
        System.out.println("Nuevo Nombre del Producto: ");
        nombre = inputScanner.nextLine();


        obj = new ProductosClient(new BigDecimal(tiposProductosCodigo),
                new BigDecimal(marcasCodigo),
                new BigDecimal(codigo),
                nombre);

        return  obj;
    }

    static ProductosClient deleteObject()
    {
        ProductosClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String codigo = "";

        System.out.println("Eliminar Producto");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo del Registro a Eliminar: ");;
        codigo = inputScanner.nextLine();

        obj = new ProductosClient(new BigDecimal(codigo));

        return  obj;
    }

    public static ProductosClient findByIdObject()
    {
        ProductosClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String codigo = "";

        System.out.println("Buscar Producto por Id");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo del Registro a Buscar: ");;
        codigo = inputScanner.nextLine();

        obj = new ProductosClient(new BigDecimal(codigo));

        return  obj;
    }
}

//*********************************

class BuilderDetallesFacturas
{
    public static String querieDetallesFacturas(String typeQuerie)
    {
        String sql = "";
        DetallesFacturasDao detallesFacturasDao = new DetallesFacturasDao();
        DetallesFacturasClient detallesFacturasClient;

        switch (typeQuerie)
        {
            case "1": //Insert
                try
                {
                    detallesFacturasClient = insertObject();
                    sql = detallesFacturasDao.insert(detallesFacturasClient);
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
                break;

            case "2": //Update
                try {
                    detallesFacturasClient = updateObject();
                    sql = detallesFacturasDao.update(detallesFacturasClient);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "3": //Delete
                detallesFacturasClient = deleteObject();
                sql = detallesFacturasDao.delete(detallesFacturasClient);
                break;

            case "4": //Select
                detallesFacturasClient = new DetallesFacturasClient();
                sql = detallesFacturasDao.read(detallesFacturasClient);
                break;

            case "5": //Select by Id
                detallesFacturasClient = findByIdObject();
                sql = detallesFacturasDao.findById(detallesFacturasClient);
                break;
        }

        return sql;
    }

    static DetallesFacturasClient insertObject() throws ParseException
    {
        DetallesFacturasClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String cabeceraFacturasNumeroFactura = "";
        String productosCodigo = "";
        String cantidadProducto = "";
        String valorUnitarioProducto = "";

        System.out.println("Insertar nuevo Detalle de Factura");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo de la Cabecera de Factura: ");
        cabeceraFacturasNumeroFactura = inputScanner.nextLine();
        System.out.println("Codigo del Producto");
        productosCodigo = inputScanner.nextLine();
        System.out.println("Cantidad del Producto");
        cantidadProducto = inputScanner.nextLine();
        System.out.println("Precio(U) del Producto");
        valorUnitarioProducto = inputScanner.nextLine();


        obj = new DetallesFacturasClient(new BigDecimal(cabeceraFacturasNumeroFactura),
                new BigDecimal(productosCodigo),
                Integer.parseInt(cantidadProducto),
                new BigDecimal(valorUnitarioProducto));


        return  obj;
    }

    static DetallesFacturasClient updateObject() throws ParseException
    {
        DetallesFacturasClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String cabeceraFacturasNumeroFactura = "";
        String productosCodigo = "";
        String cantidadProducto = "";
        String valorUnitarioProducto = "";

        System.out.println("Actualizar Detalle de la Factura");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo de la Cabecera de Factura a Modificar ");
        cabeceraFacturasNumeroFactura = inputScanner.nextLine();
        System.out.println("Codigo del Producto a Modificar");
        productosCodigo = inputScanner.nextLine();
        System.out.println("Nueva Cantidad del Producto");
        cantidadProducto = inputScanner.nextLine();
        System.out.println("Nuevo Precio(U) del Producto");
        valorUnitarioProducto = inputScanner.nextLine();


        obj = new DetallesFacturasClient(new BigDecimal(cabeceraFacturasNumeroFactura),
                new BigDecimal(productosCodigo),
                Integer.parseInt(cantidadProducto),
                new BigDecimal(valorUnitarioProducto));

        return  obj;
    }

    static DetallesFacturasClient deleteObject()
    {
        DetallesFacturasClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String cabeceraFacturasNumeroFactura = "";
        String productosCodigo = "";

        System.out.println("Eliminar Detalle de Factura");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo de la Cabecera de Factura a Eliminar: ");
        cabeceraFacturasNumeroFactura = inputScanner.nextLine();
        System.out.println("Codigo del Producto a Eliminar: ");
        productosCodigo = inputScanner.nextLine();

        obj = new DetallesFacturasClient(new BigDecimal(cabeceraFacturasNumeroFactura),
                new BigDecimal(productosCodigo));

        return  obj;
    }

    public static DetallesFacturasClient findByIdObject()
    {
        DetallesFacturasClient obj = null;
        Scanner inputScanner = new Scanner (System.in);

        String cabeceraFacturasNumeroFactura = "";
        String productosCodigo = "";

        System.out.println("Buscar Producto por Id");
        System.out.println("Ingrese los siguientes datos:");

        System.out.println("Codigo de la Cabecera de Factura a Buscar: ");;
        cabeceraFacturasNumeroFactura = inputScanner.nextLine();
        System.out.println("Codigo del Producto a Buscar: ");;
        productosCodigo = inputScanner.nextLine();

        obj = new DetallesFacturasClient(new BigDecimal(cabeceraFacturasNumeroFactura),
                new BigDecimal(productosCodigo));

        return  obj;
    }
}
