package mvc.model.server.dto;

import mvc.model.server.dto.Dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TiposProductos implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;

    //Mapeando
    private BigDecimal codigo;
    private String tipo;

    //Constructores

    public TiposProductos(BigDecimal codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public TiposProductos(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public TiposProductos() {
    }
    //--------------------------------

    @Override
    public String insert()
    {
        String sql = "INSERT INTO public.tipos_productos(codigo, tipo) VALUES ("
                + codigo +", '"
                + tipo.trim()
                + "');";
        System.out.println(sql);
        return sql;
    }

    @Override
    public String read()
    {
        return "SELECT * FROM public.tipos_productos";
    }

    @Override
    public String update()
    {
        String sql = "UPDATE public.tipos_productos SET tipo= '"+tipo
                +"' WHERE codigo = " + codigo;
        System.out.println(sql);
        return sql;
    }

    @Override
    public String delete()
    {
        return "DELETE FROM public.tipos_productos WHERE codigo = " + codigo;
    }

    @Override
    public String findById()
    {
        return "SELECT * FROM public.tipos_productos WHERE codigo = " + codigo;
    }

    //--------------------------------

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCodigo(BigDecimal codigo) {
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
                "codigo=" + codigo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
