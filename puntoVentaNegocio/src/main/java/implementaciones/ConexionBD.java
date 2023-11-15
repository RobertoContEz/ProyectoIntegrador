
package implementaciones;

import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionBD implements IConexionBD{

    @Override
    public EntityManager crearConexion() throws IllegalStateException {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("puntoVentaPU");
        return emFactory.createEntityManager();
    }

    public static void cerrarEntityManagerFactory() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("puntoVentaPU");
        if (emFactory != null && emFactory.isOpen()) {
            emFactory.close();
        }
    }
}
