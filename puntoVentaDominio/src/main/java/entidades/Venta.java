
package entidades;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="venta")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_venta", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REGIST_DATE", nullable = false)
    private Date fecha;
    
    @Column(name="total", nullable=false)
    private float total;
    
    @Column(name="pago", nullable=false)
    private float pago;
    
    @ManyToOne
    @JoinColumn(name = "FK_Empleado")
    private Empleado empleado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="venta")
    private List<VentaProducto> productosVenta;

    public Venta() {
    }
    
    public Venta(Date fecha, float total, float pago, List<VentaProducto> productosVenta) {
        this.fecha = fecha;
        this.total = total;
        this.pago = pago;
        this.productosVenta = productosVenta;
    }
    
    public Venta(Long id, Date fecha, float total, float pago, Empleado empleado) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.pago = pago;
        this.empleado = empleado;
    }

    public Venta(Date fecha, float total, float pago, Empleado empleado, List<VentaProducto> productosVenta) {
        this.fecha = fecha;
        this.total = total;
        this.pago = pago;
        this.empleado = empleado;
        this.productosVenta = productosVenta;
    }
    
    public Venta(Long id, Date fecha, float total, float pago, Empleado empleado, List<VentaProducto> productosVenta) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.pago = pago;
        this.empleado = empleado;
        this.productosVenta = productosVenta;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<VentaProducto> getProductosVenta() {
        return productosVenta;
    }

    public void setProductosVenta(List<VentaProducto> productosVenta) {
        this.productosVenta = productosVenta;
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
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fecha=" + fecha + ", total=" + total + ", pago=" + pago + ", empleado=" + empleado + ", productosVenta=" + productosVenta + '}';
    }


    
}
