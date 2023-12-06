
package control;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import entidades.Venta;
import entidades.VentaProducto;
import implementaciones.DAOSFactory;
import interfaces.IVentasDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class reportesControl {
    
    private IVentasDAO ventasDAO;

    public reportesControl() {
        this.ventasDAO = DAOSFactory.creaVentasDAO();
    }
    
    public void guardarReporte(List<Venta> ventas, String nombre) {
        File folder = new File("C:/reportes/");
        folder.mkdirs();
        String filePath = "C:/reportes/"+nombre+".pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            
            for (Venta venta : ventas) {
                String reporte = "Venta ID: "+venta.getId()+"\n"
                        + "Fecha: "+venta.getFecha()+"\n"
                        + "Vendedor: "+venta.getEmpleado().getNombre()+"\n"
                        + "Productos:\n";
                
                List<VentaProducto> ventaProductos = venta.getProductosVenta();
                for (VentaProducto ventaProducto : ventaProductos) {
                    reporte += " ° "+ventaProducto.getProducto().getNombre()+"\n";
                    reporte += "    - Cantidad: "+ventaProducto.getCantidad()+"\n";
                    reporte += "    - Monto total: $"+ventaProducto.getMonto()+"\n";
                }
                
                reporte += "Total: $"+venta.getTotal()+"\n";
                reporte += "Pago: $"+venta.getPago()+"\n";
                
                document.add(new Paragraph(reporte));
            }
            
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
