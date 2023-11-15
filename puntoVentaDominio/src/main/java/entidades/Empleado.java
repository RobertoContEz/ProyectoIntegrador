
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", nullable=false, length=100)
    private String nombre;
    
    @Column(name="correo", nullable=false, length=100)
    private String correo;
    
    @Column(name="contrasena", nullable=false, length=50)
    private String contraseña;
    
    @Column(name="telefono", nullable=false, length=100)
    private String telefono;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="empleado")
    private List<Venta> ventasEmpleado;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="empleado")
    private List<Compra> comprasEmpleado;

    public Empleado() {
    }

    public Empleado(String nombre, String correo, String contraseña, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
    }
    
    public Empleado(Long id, String nombre, String correo, String contraseña, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
    }

    public Empleado(Long id, String nombre, String correo, String contraseña, String telefono, List<Venta> ventasEmpleado, List<Compra> comprasEmpleado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.ventasEmpleado = ventasEmpleado;
        this.comprasEmpleado = comprasEmpleado;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Venta> getVentasEmpleado() {
        return ventasEmpleado;
    }

    public void setVentasEmpleado(List<Venta> ventasEmpleado) {
        this.ventasEmpleado = ventasEmpleado;
    }

    public List<Compra> getComprasEmpleado() {
        return comprasEmpleado;
    }

    public void setComprasEmpleado(List<Compra> comprasEmpleado) {
        this.comprasEmpleado = comprasEmpleado;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + ", telefono=" + telefono + '}';
    }
    
}
