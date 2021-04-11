package mvc.model.client.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class MarcasClient implements DtoClient, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;

    //Mapeando
    private BigDecimal codigo;
    private String nombre;

    //Constructores
    public MarcasClient(BigDecimal codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public MarcasClient(BigDecimal codigo)
    {
        this.codigo = codigo;
    }

    public MarcasClient()
    {
    }
    //------------------

    @Override
    public String insert()
    {
        String sql = "INSERT INTO public.marcas(codigo, nombre) VALUES ("
                + codigo +", '"
                + nombre.trim()
                + "');";
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
        return "Marcas{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
