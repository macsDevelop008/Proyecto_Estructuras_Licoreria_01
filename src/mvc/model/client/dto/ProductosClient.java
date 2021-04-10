package mvc.model.client.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductosClient implements DtoClient, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;

    //Mapeando
    private BigDecimal tiposProductosCodigo;
    private BigDecimal marcasCodigo;
    private BigDecimal codigo;
    private String nombre;

    //Constructores
    public ProductosClient(BigDecimal tiposProductosCodigo, BigDecimal marcasCodigo, BigDecimal codigo, String nombre) {
        this.tiposProductosCodigo = tiposProductosCodigo;
        this.marcasCodigo = marcasCodigo;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public ProductosClient(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public ProductosClient() {
    }
    //------------------

    @Override
    public String insert()
    {
        String sql = "INSERT INTO public.productos(tipos_productos_codigo, marcas_codigo, codigo, nombre) VALUES ("
                + tiposProductosCodigo +", '"
                + marcasCodigo + "', '"
                + codigo + "', '"
                + nombre.trim()
                + "');";
        return sql;
    }

    @Override
    public String read()
    {
        return "SELECT * FROM public.productos";
    }

    @Override
    public String update()
    {
        String sql = "UPDATE public.productos SET tipos_productos_codigo= '"+tiposProductosCodigo
                +"', marcas_codigo='"+marcasCodigo
                +"', nombre='"+nombre.trim()
                +"' WHERE codigo = " + codigo;
        return sql;
    }

    @Override
    public String delete()
    {
        return "DELETE FROM public.productos WHERE codigo = " + codigo;
    }

    @Override
    public String findById()
    {
        return "SELECT * FROM public.productos WHERE codigo = " + codigo;
    }
    //------------------


    public BigDecimal getTiposProductosCodigo() {
        return tiposProductosCodigo;
    }

    public void setTiposProductosCodigo(BigDecimal tiposProductosCodigo) {
        this.tiposProductosCodigo = tiposProductosCodigo;
    }

    public BigDecimal getMarcasCodigo() {
        return marcasCodigo;
    }

    public void setMarcasCodigo(BigDecimal marcasCodigo) {
        this.marcasCodigo = marcasCodigo;
    }

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
        return "Productos{" +
                "tiposProductosCodigo=" + tiposProductosCodigo +
                ", marcasCodigo=" + marcasCodigo +
                ", codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
