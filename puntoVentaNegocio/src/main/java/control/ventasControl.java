
package control;

import entidades.Empleado;
import implementaciones.DAOSFactory;
import interfaces.IProductosDAO;
import interfaces.IVentasDAO;
import entidades.Producto;
import entidades.Venta;
import entidades.VentaProducto;
import interfaces.IEmpleadosDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ventasControl {

    private List<VentaProducto> listaCompras = new ArrayList<>();
    
    private IProductosDAO productosDAO;
    private IVentasDAO ventasDAO;
    private IEmpleadosDAO empleadosDAO;
    private float total;
    
    public ventasControl() {
        this.productosDAO = DAOSFactory.creaProductosDAO();
        this.ventasDAO = DAOSFactory.creaVentasDAO();
        this.empleadosDAO = DAOSFactory.creaEmpleadosDAO();
    }
    
    public Empleado consultaEmpleadoId(String id){
        return empleadosDAO.consultarEmpleadoPorId(id);
    }

    public  List<VentaProducto> borrarProductoVenta(String nombreProducto){
        Producto producto = productosDAO.consultarProductoPorNombre(nombreProducto);
        for (int i = 0; i < listaCompras.size() ; i++) {
            if(listaCompras.get(i).getProducto() == producto){
                listaCompras.remove(i);
            }
        }
        return listaCompras;
    }
    
    public Producto buscarProductoPorNombre(String nombre){
        Producto producto = productosDAO.consultarProductoPorNombre(nombre);
        System.out.println("Producto : " + producto);
        return producto;
    }
    
    public Producto buscarProductoPorNumero(String codigo){
        Producto producto = productosDAO.consultarProductoPorCodigo(codigo);
        System.out.println("Producto : " + producto);
        return producto;
    }
    
    public List<VentaProducto> agregarProductoVenta(String codigoProducto, int cantidad){
        Producto producto = productosDAO.consultarProductoPorCodigo(codigoProducto);
        boolean existente = false;
        for (int i = 0; i < listaCompras.size() ; i++) {
            if(producto.equals(listaCompras.get(i).getProducto())){
                VentaProducto venta = listaCompras.get(i);
                venta.setCantidad(venta.getCantidad() + cantidad);
                venta.setMonto(venta.getProducto().getPrecio()*venta.getCantidad());
                
                listaCompras.set(i, venta);
                existente = true;
            }
        }
        if(existente == false){
            listaCompras.add(new VentaProducto(cantidad, producto.getPrecio()*cantidad, producto));
        }
        total = 0;
        for (VentaProducto ventaproducto : listaCompras) {
            total += ventaproducto.getMonto();
        }
        return listaCompras;
    }

    public float getTotal() {
        return total;
    }
    
    public List<VentaProducto> vaciarListaCompras(){
        listaCompras.clear();
        return listaCompras;
    }
    
    public void realizarVenta(float pago){
        Venta venta = new Venta(
                                new Date(), 
                                total, 
                                pago, 
                         consultaEmpleadoId("1"), 
                    listaCompras);
        for (VentaProducto listaCompra : listaCompras) {
            listaCompra.setVenta(venta);
        }
        ventasDAO.agregar(venta);
    }
}
