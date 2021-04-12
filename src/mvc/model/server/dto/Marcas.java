package mvc.model.server.dto;

import mvc.model.server.dto.Dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class Marcas implements Dto, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;

    //Mapeando
    private BigDecimal codigo;
    private String nombre;

    //Constructores
    public Marcas(BigDecimal codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Marcas(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public Marcas() {
    }
    //------------------

    @Override
    public String insert()
    {
        String sql = "INSERT INTO public.marcas(codigo, nombre) VALUES ("
                + codigo +", '"
                + nombre.trim()
                + "');";
        System.out.println(sql);
        return sql;
    }

    @Override
    public String read()
    {
        return "SELECT * FROM public.marcas";
    }

    @Override
    public String update()
    {
        String sql = "UPDATE public.marcas SET nombre= '"+nombre
                +"' WHERE codigo = " + codigo;
        System.out.println(sql);
        return sql;
    }

    @Override
    public String delete()
    {
        return "DELETE FROM public.marcas WHERE codigo = " + codigo;
    }

    @Override
    public String findById()
    {
        return "SELECT * FROM public.marcas WHERE codigo = " + codigo;
    }
    //------------------


    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCodigo(BigDecimal codigo) {
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
        return "mvc.view.Marcas{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
