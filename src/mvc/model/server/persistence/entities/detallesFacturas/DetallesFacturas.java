package mvc.model.server.persistence.entities.detallesFacturas;

import mvc.model.server.persistence.dto.Dto;

import java.io.Serializable;

public class DetallesFacturas implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;

    //Sql ingresado por el usuario.
    private String sql1, sql2;

    //Mapeo
    private double cabeceraFacturasNumeroFactura;
    private double productosCodigo;
    private int cantidadProducto;
    private double valorUnitarioProducto;

    //Constructores

    public DetallesFacturas(String sql1, String sql2,double cabeceraFacturasNumeroFactura, double productosCodigo, int cantidadProducto, double valorUnitarioProducto) {
        this.sql1 = sql1;
        this.sql2 = sql2;
        this.cabeceraFacturasNumeroFactura = cabeceraFacturasNumeroFactura;
        this.productosCodigo = productosCodigo;
        this.cantidadProducto = cantidadProducto;
        this.valorUnitarioProducto = valorUnitarioProducto;
    }

    public DetallesFacturas(double cabeceraFacturasNumeroFactura, double productosCodigo, int cantidadProducto, double valorUnitarioProducto) {
        this.cabeceraFacturasNumeroFactura = cabeceraFacturasNumeroFactura;
        this.productosCodigo = productosCodigo;
        this.cantidadProducto = cantidadProducto;
        this.valorUnitarioProducto = valorUnitarioProducto;
    }

    public DetallesFacturas(double cabeceraFacturasNumeroFactura, double productosCodigo) {
        this.cabeceraFacturasNumeroFactura = cabeceraFacturasNumeroFactura;
        this.productosCodigo = productosCodigo;
    }

    public DetallesFacturas() {
    }
    //----------------------------------------

    @Override
    public String insert()
    {
        return sql1 + cabeceraFacturasNumeroFactura +", '"
                + productosCodigo +", '"
                + cantidadProducto + "','"
                + valorUnitarioProducto
                + "');";
    }

    @Override
    public String read()
    {
        return sql1;
    }

    @Override
    public String update()
    {
        return sql1;
    }

    @Override
    public String delete()
    {
        //llave primaria compuesta (2 atributos)      sql2 -> "AND productos_codigo ="
        return sql1 + cabeceraFacturasNumeroFactura + sql2 + productosCodigo;
    }

    @Override
    public String findById()
    {
        //llave primaria compuesta (2 atributos)      sql2 -> "AND productos_codigo ="
        return sql1 + cabeceraFacturasNumeroFactura + sql2 + productosCodigo;
    }

    //----------------------------------------

    public String getSql1() {
        return sql1;
    }

    public void setSql1(String sql1) {
        this.sql1 = sql1;
    }

    public String getSql2() {
        return sql2;
    }

    public void setSql2(String sql2) {
        this.sql2 = sql2;
    }

    public double getCabeceraFacturasNumeroFactura() {
        return cabeceraFacturasNumeroFactura;
    }

    public void setCabeceraFacturasNumeroFactura(double cabeceraFacturasNumeroFactura) {
        this.cabeceraFacturasNumeroFactura = cabeceraFacturasNumeroFactura;
    }

    public double getProductosCodigo() {
        return productosCodigo;
    }

    public void setProductosCodigo(double productosCodigo) {
        this.productosCodigo = productosCodigo;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getValorUnitarioProducto() {
        return valorUnitarioProducto;
    }

    public void setValorUnitarioProducto(double valorUnitarioProducto) {
        this.valorUnitarioProducto = valorUnitarioProducto;
    }

    @Override
    public String toString() {
        return "DetallesFacturas{" +
                "sql1='" + sql1 + '\'' +
                ", sql2='" + sql2 + '\'' +
                ", cabeceraFacturasNumeroFactura=" + cabeceraFacturasNumeroFactura +
                ", productosCodigo=" + productosCodigo +
                ", cantidadProducto=" + cantidadProducto +
                ", valorUnitarioProducto=" + valorUnitarioProducto +
                '}';
    }
}
