
package interfaces;

import entidades.Producto;
import java.util.List;

public interface IProductosDAO {
    public boolean agregar(Producto producto);
    public Producto consultarProductoPorCodigo(String codigoProducto);
    public Producto consultarProductoPorNombre(String nombreProducto);
    public List<Producto> consultarProductosPorNombre(String nombreProducto);
    public List<Producto> consultarTodos();
}
