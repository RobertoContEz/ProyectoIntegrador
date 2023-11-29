
package interfaces;

import entidades.Venta;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface IVentasDAO {
    public boolean agregar(Venta venta);
    public Venta consultarVenta(Long idVenta);
    public List<Venta> consultarVentasPorFecha(Calendar fechaInicio, Calendar fechaFin);
    public List<Venta> consultarTodos();
}
