/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package prueba;

import entidades.Empleado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Maste
 */
public class PuntoVentaDominio {

    public static void main(String[] args) {
        Empleado emp = new Empleado("Saul Armando Reyna Lopez", "saul@gmail.com", "saul123", "64411773");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("puntoVentaPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
