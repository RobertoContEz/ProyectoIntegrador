
package control;

import entidades.Venta;
import implementaciones.DAOSFactory;
import interfaces.IVentasDAO;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class reportesControl {
    
    private IVentasDAO ventasDAO;

    public reportesControl() {
        this.ventasDAO = DAOSFactory.creaVentasDAO();
    }
    
    public void imprimirReporte(String reporte) {
    }
    
    public void guardarReporte(String reporte) {
    }
    
    public List<Venta> buscarVentasReporte(Calendar fechaInicio, Calendar fechaFin) {
        return ventasDAO.consultarVentasPorFecha(fechaInicio, fechaFin);
    }
    
    public Calendar convertirFecha(String string) {
        Calendar fecha = new GregorianCalendar();
        
        String[] values = string.split("/");
        int año,mes,dia;
        dia = Integer.parseInt(values[0]);
        mes = Integer.parseInt(values[1])-1;
        año = Integer.parseInt(values[2]);
        
        fecha.set(año, mes, dia);
        
        return fecha;
    }
    
}
