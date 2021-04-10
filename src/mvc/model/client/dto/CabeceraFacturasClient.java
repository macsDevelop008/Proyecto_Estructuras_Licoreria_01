package mvc.model.client.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CabeceraFacturasClient implements DtoClient, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;

    //Mapeando
    private BigDecimal numeroFactura;
    private Date fecha;
    private String nombreCliente;

    //Constructores
    public CabeceraFacturasClient(BigDecimal numeroFactura, Date fecha, String nombreCliente)
    {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;                     //OJO con el formato al insertar
        this.nombreCliente = nombreCliente;
    }

    public CabeceraFacturasClient(BigDecimal numeroFactura)
    {
        this.numeroFactura = numeroFactura;
    }

    public CabeceraFacturasClient()
    {
    }
    //------------------

    @Override
    public String insert()
    {
        String sql = "INSERT INTO public.cabecera_facturas(numero_factura, fecha, nombre_cliente) VALUES ("
                + numeroFactura +", '"
                + fecha + "', '"
                + nombreCliente.trim()
                + "');";
        return sql;
    }

    @Override
    public String read()
    {
        return "SELECT * FROM public.cabecera_facturas";
    }

    @Override
    public String update()
    {
        String sql = "UPDATE public.cabecera_facturas SET fecha= '"+fecha
                +"', nombre_cliente='"+nombreCliente.trim()
                +"' WHERE numero_factura = " + numeroFactura;
        return sql;
    }

    @Override
    public String delete()
    {
        return "DELETE FROM public.cabecera_facturas WHERE numero_factura = " + numeroFactura;
    }

    @Override
    public String findById()
    {
        return "SELECT * FROM public.cabecera_facturas WHERE numero_factura = " + numeroFactura;
    }

    //------------------

    public BigDecimal getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(BigDecimal numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        return "CabeceraFacturas{" +
                "numeroFactura=" + numeroFactura +
                ", fecha=" + fecha +
                ", nombreCliente='" + nombreCliente + '\'' +
                '}';
    }
}
