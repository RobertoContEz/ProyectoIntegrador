
package interfaces;

import entidades.Producto;
import java.util.List;

public interface IProductosDAO {
    public boolean agregar(Producto producto);
    public boolean editar(Producto producto);
    public Producto consultarProductoPorCodigo(String codigoProducto, boolean habilitado);
    public Producto consultarProductoPorNombre(String nombreProducto, boolean habilitado);
    public List<Producto> consultarProductosPorNombre(String nombreProducto);
    public List<Producto> consultarTodos();
    public boolean actualizarProducto(Producto producto);
    public void actualizarStock(String codigoProducto, int cantidad);
}
