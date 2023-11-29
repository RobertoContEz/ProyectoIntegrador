
package control;

import entidades.Producto;
import implementaciones.DAOSFactory;
import interfaces.IProductosDAO;
import java.util.List;

public class productosControl {
    
    private IProductosDAO productosDAO;

    public productosControl() {
        this.productosDAO = DAOSFactory.creaProductosDAO();
    }
    
    public List<Producto> buscarProductos(){
        List<Producto> productos = productosDAO.consultarTodos();
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getHabilitado() == false){
                productos.remove(i);
                i--;
            }
        }
        return productos;
    }
    
    public List<Producto> buscarProductosPorNombreMarca(String nombre){
        List<Producto> productos = productosDAO.consultarProductosPorNombre(nombre);
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getHabilitado() == false){
                productos.remove(i);
                i--;
            }
        }
        return productos;
    }
    
    public boolean agregarProducto(Producto producto){
        return productosDAO.agregar(producto);
    }
    
    public boolean editarProducto(Producto producto){
        return productosDAO.editar(producto);
    }
    
}
