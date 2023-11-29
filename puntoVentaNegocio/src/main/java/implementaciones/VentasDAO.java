/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Venta;
import interfaces.IConexionBD;
import interfaces.IVentasDAO;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class VentasDAO implements IVentasDAO{

    private IConexionBD conexion;

    public VentasDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public boolean agregar(Venta venta) {
         EntityManager em =null;
        try {
            
            
                em= this.conexion.crearConexion();
                 em.getTransaction().begin();
                 em.persist(venta);
                 em.getTransaction().commit();
                 
                
                 return true;
            
            
           
        } catch (Exception ex) {
            
             JOptionPane.showMessageDialog(null, "No se pudo agregar la venta"+ex.getMessage());
             System.err.println("No se pudo agregar la venta"+ex.getMessage());
              
             
            return false;
        }
    }
    
    private boolean isDatabaseConnectionIssue(Exception ex) {
    // Implement your logic here to identify whether the exception is due to a database connectivity issue
    // You may need to check the exception type or other details
    // For simplicity, this example assumes that any exception is considered a database connectivity issue
    return true;
}
    

    @Override
    public Venta consultarVenta(Long idVenta) {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.find(Venta.class, idVenta);
        } catch (IllegalStateException ex) {
            System.err.println("No se pudo encontrar la venta");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Venta> consultarTodos() {
        try {
            EntityManager em = this.conexion.crearConexion();
            String jpqlQuery = "SELECT v FROM Venta v";

            // OBJETO DE CONSULTA EJECUTABLE
            TypedQuery<Venta> query = em.createQuery(jpqlQuery, Venta.class);

            return query.getResultList();
        } catch (IllegalStateException ex) {
            System.err.println("No se pudo encontrar la venta");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Venta> consultarVentasPorFecha(Calendar fechaInicio, Calendar fechaFin) {
        try {
            EntityManager em = this.conexion.crearConexion();
            String jpqlQuery = "SELECT v FROM Venta v WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin";

            // OBJETO DE CONSULTA EJECUTABLE
            TypedQuery<Venta> query = em.createQuery(jpqlQuery, Venta.class);
            query.setParameter("fechaInicio", fechaInicio, TemporalType.TIMESTAMP);
            query.setParameter("fechaFin", fechaFin, TemporalType.TIMESTAMP);
            
            return query.getResultList();
        } catch (IllegalStateException ex) {
            System.err.println("No se pudo encontrar la venta");
            ex.printStackTrace();
            return null;
        }
    }
    
}
