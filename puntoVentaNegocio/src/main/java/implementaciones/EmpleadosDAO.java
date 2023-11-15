/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Empleado;
import interfaces.IConexionBD;
import interfaces.IEmpleadosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Maste
 */
public class EmpleadosDAO implements IEmpleadosDAO{

    private IConexionBD conexion;
    
    public EmpleadosDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado consultarEmpleadoPorId(String id) {
        try {
            EntityManager em = this.conexion.crearConexion();
            String jpqlQuery = "SELECT e FROM Empleado e WHERE e.id LIKE :id";

            // OBJETO DE CONSULTA EJECUTABLE
            TypedQuery<Empleado> query = em.createQuery(jpqlQuery, Empleado.class);
            query.setParameter("id",  id );

            return query.getResultList().get(0);
        } catch (IllegalStateException ex) {
            System.err.println("No se pudo encontrar el empleado");
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public List<Empleado> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
