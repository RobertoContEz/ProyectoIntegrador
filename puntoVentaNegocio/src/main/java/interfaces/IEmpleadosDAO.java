/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Empleado;
import java.util.List;

public interface IEmpleadosDAO {
    public boolean agregar(Empleado empleado);
    public Empleado consultarEmpleadoPorId(String id);
    public List<Empleado> consultarTodos();
}
