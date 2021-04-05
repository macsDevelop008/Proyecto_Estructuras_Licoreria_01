package mvc.model.server.persistence.entities.cabeceraFacturas;

import mvc.model.server.persistence.dto.Dto;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

public class CabeceraFacturas implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;

    //Mapeando
    private BigDecimal numeroFactura;
    private Date fecha;
    private String nombreCliente;

    //Constructores
    public CabeceraFacturas(BigDecimal numeroFactura, Date fecha, String nombreCliente)
    {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;                     //OJO con el formato al insertar
        this.nombreCliente = nombreCliente;
    }

    public CabeceraFacturas(BigDecimal numeroFactura)
    {
        this.numeroFactura = numeroFactura;
    }

    public CabeceraFacturas()
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
        System.out.println(sql);
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
        System.out.println(sql);
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
