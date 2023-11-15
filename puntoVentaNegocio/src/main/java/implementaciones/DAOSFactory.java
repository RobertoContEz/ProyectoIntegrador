
package implementaciones;

import interfaces.IConexionBD;
import interfaces.IEmpleadosDAO;
import interfaces.IProductosDAO;
import interfaces.IVentasDAO;

public class DAOSFactory {
    private static final IConexionBD conexion = new ConexionBD();
    
    public static IProductosDAO creaProductosDAO(){
        return new ProductosDAO(conexion);
    }
    
    public static IVentasDAO creaVentasDAO(){
        return new VentasDAO(conexion);
    }
    
    public static IEmpleadosDAO creaEmpleadosDAO(){
        return new EmpleadosDAO(conexion);
    }
}
