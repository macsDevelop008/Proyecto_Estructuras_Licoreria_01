package mvc.model.client.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetallesFacturasClient implements DtoClient, Serializable
{
    private static final long       serialVersionUID = 916479397570182364L;

    //Mapeo
    private BigDecimal cabeceraFacturasNumeroFactura;
    private BigDecimal productosCodigo;
    private int cantidadProducto;
    private BigDecimal valorUnitarioProducto;

    //Constructores
    public DetallesFacturasClient(BigDecimal cabeceraFacturasNumeroFactura, BigDecimal productosCodigo, int cantidadProducto, BigDecimal valorUnitarioProducto)
    {
        this.cabeceraFacturasNumeroFactura = cabeceraFacturasNumeroFactura;
        this.productosCodigo = productosCodigo;
        this.cantidadProducto = cantidadProducto;
        this.valorUnitarioProducto = valorUnitarioProducto;
    }

    public DetallesFacturasClient(BigDecimal cabeceraFacturasNumeroFactura, BigDecimal productosCodigo)
    {
        this.cabeceraFacturasNumeroFactura = cabeceraFacturasNumeroFactura;
        this.productosCodigo = productosCodigo;
    }

    public DetallesFacturasClient()
    {
    }
    //----------------------------------------

    @Override
    public String insert()
    {
        String sql = "INSERT INTO public.detalles_facturas(cabecera_facturas_numero_factura, productos_codigo," +
                " cantidad_producto, valor_unitario_producto) VALUES ("
                + cabeceraFacturasNumeroFactura +", '"
                + productosCodigo + "', '"
                + cantidadProducto + "', '"
                + valorUnitarioProducto
                + "');";
        return sql;
    }

    @Override
    public String read()
    {
        return "SELECT * FROM public.detalles_facturas";
    }

    @Override
    public String update()
    {
        String sql = "UPDATE public.detalles_facturas SET cantidad_producto= '"+cantidadProducto
                +"', valor_unitario_producto='"+valorUnitarioProducto
                +"' WHERE cabecera_facturas_numero_factura = " + cabeceraFacturasNumeroFactura +" AND productos_codigo = "+productosCodigo;
        return sql;
    }

    @Override
    public String delete()
    {
        return "DELETE FROM public.detalles_facturas WHERE cabecera_facturas_numero_factura = " + cabeceraFacturasNumeroFactura +" AND productos_codigo = "+productosCodigo;
    }

    @Override
    public String findById()
    {
        return "SELECT * FROM public.detalles_facturas WHERE cabecera_facturas_numero_factura = " + cabeceraFacturasNumeroFactura +" AND productos_codigo = "+productosCodigo;
    }


    //----------------------------------------
    public BigDecimal getCabeceraFacturasNumeroFactura() {
        return cabeceraFacturasNumeroFactura;
    }

    public void setCabeceraFacturasNumeroFactura(BigDecimal cabeceraFacturasNumeroFactura) {
        this.cabeceraFacturasNumeroFactura = cabeceraFacturasNumeroFactura;
    }
    public BigDecimal getProductosCodigo() {
        return productosCodigo;
    }

    public void setProductosCodigo(BigDecimal productosCodigo) {
        this.productosCodigo = productosCodigo;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public BigDecimal getValorUnitarioProducto() {
        return valorUnitarioProducto;
    }

    public void setValorUnitarioProducto(BigDecimal valorUnitarioProducto) {
        this.valorUnitarioProducto = valorUnitarioProducto;
    }

    @Override
    public String toString() {
        return "DetallesFacturas{" +
                "cabeceraFacturasNumeroFactura=" + cabeceraFacturasNumeroFactura +
                ", productosCodigo=" + productosCodigo +
                ", cantidadProducto=" + cantidadProducto +
                ", valorUnitarioProducto=" + valorUnitarioProducto +
                '}';
    }
}
