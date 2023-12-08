
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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;

public class reportesControl {
    
    private IVentasDAO ventasDAO;
    private DecimalFormat formatoMonto;

    public reportesControl() {
        this.ventasDAO = DAOSFactory.creaVentasDAO();
        formatoMonto = new DecimalFormat("#.00");
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
                String reporte = "\nVenta ID: "+venta.getId()+"\n"
                        + "Fecha: "+convertirFecha(venta.getFecha())+"\n"
                        + "Vendedor: "+venta.getEmpleado().getNombre()+"\n"
                        + "Productos:\n";
                
                List<VentaProducto> ventaProductos = venta.getProductosVenta();
                for (VentaProducto ventaProducto : ventaProductos) {
                    reporte += "* "+ventaProducto.getProducto().getNombre()+"\n";
                    reporte += "    - Cantidad: "+formatearCantidad(ventaProducto.getCantidad())+"\n";
                    reporte += "    - Monto total: $"+formatearMonto(ventaProducto.getMonto())+"\n";
                }
                
                reporte += "Total: $"+formatearMonto(venta.getTotal())+"\n";
                reporte += "Pago: $"+formatearMonto(venta.getPago())+"\n";
                
                document.add(new Paragraph(reporte));
            }
            
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Venta> buscarVentasReporte(Calendar fechaInicio, Calendar fechaFin) {
        List<Venta> ventas = ventasDAO.consultarVentasPorFecha(fechaInicio, fechaFin);
        
        if(ventas == null || ventas.size()==0) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna venta en el periodo dado.\n"
                    + "Pruebe con otras fechas.");
            return null;
        }
        
        return ventas;
    }
    
    public String formatearMonto(float monto) {
        return formatoMonto.format(monto);
    }
    
    public String formatearCantidad(float cantidad) {
        String string = String.valueOf(cantidad);
        
        if(cantidad % 1 == 0) string = string.substring(0, string.length()-2);
        
        return string;
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
    
    public String convertirFecha(Date fecha) {
        int año,mes,dia;
        dia = fecha.getDate();
        mes = fecha.getMonth()+1;
        año = fecha.getYear()+1900;
        
        String d,m,a;
        d = (dia>9?"":"0")+String.valueOf(dia);
        m = (mes>9?"":"0")+String.valueOf(mes);
        a = String.valueOf(año);
        
        return d+"/"+m+"/"+a;
    }
    
    public boolean validarFecha(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); 

        try {
            Date fechaParseada = sdf.parse(fecha);

            if (!fecha.equals(sdf.format(fechaParseada))) {
                JOptionPane.showMessageDialog(null, "Fecha inválida. Por favor, ingrese las fecha con formato DD/MM/AAAA.");
                return false;
            }

        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fecha inválida. Por favor, ingrese las fecha con formato DD/MM/AAAA.");
            return false;
        }
        return true;
    }
    
    public boolean validarFechas(Calendar fechaInicio, Calendar fechaFin) {
        boolean b = fechaInicio.before(fechaFin);
        if(!b) JOptionPane.showMessageDialog(null, "Fechas inválidas.\n"
                + "Por favor, asegurese que la fecha de fin sea posterior a la fecha de inicio.");
        
        return b;
    }
}
