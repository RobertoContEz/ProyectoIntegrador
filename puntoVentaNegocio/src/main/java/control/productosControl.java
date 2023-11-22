
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
        return productosDAO.consultarTodos();
    }
    
}
