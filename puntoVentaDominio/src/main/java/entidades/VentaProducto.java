
package entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="venta_producto")
public class VentaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cantidad", nullable=false)
    private float cantidad;
    
    @Column(name="monto", nullable=false)
    private float monto;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_Venta", nullable = false)
    private Venta venta;
    
    @JoinColumn(name = "FK_Producto", nullable = false)
    private Producto producto;

    public VentaProducto() {
    }

    public VentaProducto(float cantidad, float monto, Producto producto) {
        this.cantidad = cantidad;
        this.monto = monto;
        this.producto = producto;
    }
    
    public VentaProducto(float cantidad, float monto, Venta venta, Producto producto) {
        this.cantidad = cantidad;
        this.monto = monto;
        this.venta = venta;
        this.producto = producto;
    }
    
    public VentaProducto(Long id, float cantidad, float monto, Venta venta, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.monto = monto;
        this.venta = venta;
        this.producto = producto;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        if (!(object instanceof VentaProducto)) {
            return false;
        }
        VentaProducto other = (VentaProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VentaProducto{" + "id=" + id + ", cantidad=" + cantidad + ", monto=" + monto + ", venta=" + venta + ", producto=" + producto + '}';
    }
    
}
