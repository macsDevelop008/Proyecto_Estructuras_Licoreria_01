package mvc.model.server.persistence.entities.productos;

import mvc.model.server.persistence.dto.Dto;

import java.io.Serializable;

public class Productos implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;

    //Sql ingresado por el usuario.
    private String sql;

    //Mapeando
    private double tiposProductosCodigo;
    private double marcasCodigo;
    private double codigo;
    private String nombre;

    //Constructores

    public Productos(String sql, double tiposProductosCodigo, double marcasCodigo, double codigo, String nombre) {
        this.sql = sql;
        this.tiposProductosCodigo = tiposProductosCodigo;
        this.marcasCodigo = marcasCodigo;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Productos(double tiposProductosCodigo, double marcasCodigo, double codigo, String nombre) {
        this.tiposProductosCodigo = tiposProductosCodigo;
        this.marcasCodigo = marcasCodigo;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Productos(double tiposProductosCodigo) {
        this.tiposProductosCodigo = tiposProductosCodigo;
    }

    public Productos() {
    }
    //------------------

    @Override
    public String insert()
    {
        return sql + tiposProductosCodigo +", '"
                + marcasCodigo + "','"
                + codigo + "','"
                + nombre.trim()
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
        return sql + this.codigo;
    }

    @Override
    public String findById()
    {
        return sql + this.codigo;
    }
    //------------------


    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public double getTiposProductosCodigo() {
        return tiposProductosCodigo;
    }

    public void setTiposProductosCodigo(double tiposProductosCodigo) {
        this.tiposProductosCodigo = tiposProductosCodigo;
    }

    public double getMarcasCodigo() {
        return marcasCodigo;
    }

    public void setMarcasCodigo(double marcasCodigo) {
        this.marcasCodigo = marcasCodigo;
    }

    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(double codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "sql='" + sql + '\'' +
                ", tiposProductosCodigo=" + tiposProductosCodigo +
                ", marcasCodigo=" + marcasCodigo +
                ", codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
