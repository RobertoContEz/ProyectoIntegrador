
package interfaces;

import entidades.Venta;
import java.util.List;

public interface IVentasDAO {
    public boolean agregar(Venta venta);
    public Venta consultarVenta(Long idVenta);
    public List<Venta> consultarTodos();
}
