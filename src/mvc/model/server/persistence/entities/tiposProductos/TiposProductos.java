package mvc.model.persistence.entities.tiposProductos;

import mvc.model.persistence.dto.Dto;

import java.io.Serializable;

public class TiposProductos implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;

    //Sql ingresado por el usuario.
    private String sql;

    //Mapeando
    private double codigo;
    private String tipo;

    //Constructores

    public TiposProductos(String sql, double codigo, String tipo) {
        this.sql = sql;
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public TiposProductos(double codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public TiposProductos(double codigo) {
        this.codigo = codigo;
    }

    public TiposProductos() {
    }
    //------------------

    @Override
    public String insert()
    {
        return sql + codigo +", '"
                + tipo
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TiposProductos{" +
                "sql='" + sql + '\'' +
                ", codigo=" + codigo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
