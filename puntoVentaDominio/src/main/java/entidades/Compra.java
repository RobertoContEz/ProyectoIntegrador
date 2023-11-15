
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="compra")
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REGIST_DATE", nullable = false)
    private Calendar fecha;
    
    @Column(name="total", nullable=false)
    private float total;
    
    @ManyToOne
    @JoinColumn(name = "FK_Empleado", nullable = false, updatable = false)
    private Empleado empleado;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="compra")
    private List<CompraProducto> productosCompra;

    public Compra() {
    }

    public Compra(Calendar fecha, float total, Empleado empleado) {
        this.fecha = fecha;
        this.total = total;
        this.empleado = empleado;
    }

    public Compra(Long id, Calendar fecha, float total, Empleado empleado) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.empleado = empleado;
    }

    public Compra(Calendar fecha, float total, List<CompraProducto> productosCompra) {
        this.fecha = fecha;
        this.total = total;
        this.productosCompra = productosCompra;
    }
    
    public Compra(Long id, Calendar fecha, float total, Empleado empleado, List<CompraProducto> productosCompra) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.empleado = empleado;
        this.productosCompra = productosCompra;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<CompraProducto> getProductosCompra() {
        return productosCompra;
    }

    public void setProductosCompra(List<CompraProducto> productosCompra) {
        this.productosCompra = productosCompra;
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
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", fecha=" + fecha + ", total=" + total + '}';
    }
    
}
