package mvc.model.server.persistence.entities.marcas;

import mvc.model.server.persistence.dto.Dto;

import java.io.Serializable;

public class Marcas implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;

    //Sql ingresado por el usuario.
    private String sql;

    //Mapeando
    private double codigo;
    private String nombre;

    //Constructores

    public Marcas(String sql, double codigo, String nombre) {
        this.sql = sql;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Marcas(double codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Marcas(double codigo) {
        this.codigo = codigo;
    }

    public Marcas() {
    }
    //------------------

    @Override
    public String insert()
    {
        return sql + codigo +", '"
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
        return "Marcas{" +
                "sql='" + sql + '\'' +
                ", codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
