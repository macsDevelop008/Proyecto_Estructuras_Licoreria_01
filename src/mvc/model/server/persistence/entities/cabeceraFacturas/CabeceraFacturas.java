package mvc.model.server.persistence.entities.cabeceraFacturas;

import mvc.model.server.persistence.dto.Dto;

import java.io.Serializable;
import java.util.Date;

public class CabeceraFacturas implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;

    //Sql ingresado por el usuario.
    private String sql;

    //Mapeando
    private double numeroFactura;
    private Date fecha;
    private String nombreCliente;

    //Constructores
    public CabeceraFacturas(String sql, double numeroFactura, Date fecha, String nombreCliente)
    {
        this.sql = sql;
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
    }

    public CabeceraFacturas(double numeroFactura, Date fecha, String nombreCliente)
    {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
    }

    public CabeceraFacturas(double numeroFactura)
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
        return sql + numeroFactura +", '"
                + fecha.toString() + "','"
                + nombreCliente
                + "');";
    }

    @Override
    public String read()
    {
        return sql;
    }

    @Override
    public String update()
    {
        return sql;
    }

    @Override
    public String delete()
    {
        return sql + this.numeroFactura;
    }

    @Override
    public String findById()
    {
        return sql + this.numeroFactura;
    }

    //------------------

    public double getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(double numeroFactura) {
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
                "sql='" + sql + '\'' +
                ", numeroFactura=" + numeroFactura +
                ", fecha=" + fecha +
                ", nombreCliente='" + nombreCliente + '\'' +
                '}';
    }
}
