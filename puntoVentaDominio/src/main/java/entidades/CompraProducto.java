
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="compra_producto")
public class CompraProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cantidad", nullable=false)
    private float cantidad;
    
    @Column(name="monto", nullable=false)
    private float monto;
    
    @ManyToOne
    @JoinColumn(name = "FK_Compra", nullable = false, updatable = false)
    private Compra compra;
    
    @ManyToOne
    @JoinColumn(name = "FK_Producto", nullable = false, updatable = false)
    private Producto producto;

    public CompraProducto() {
    }
    
    public CompraProducto(float cantidad, float monto, Producto producto) {
        this.cantidad = cantidad;
        this.monto = monto;
        this.producto = producto;
    }
    
    public CompraProducto(float cantidad, float monto, Compra compra, Producto producto) {
        this.cantidad = cantidad;
        this.monto = monto;
        this.compra = compra;
        this.producto = producto;
    }
    
    public CompraProducto(Long id, float cantidad, float monto, Compra compra, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.monto = monto;
        this.compra = compra;
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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
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
        if (!(object instanceof CompraProducto)) {
            return false;
        }
        CompraProducto other = (CompraProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CompraProducto{" + "id=" + id + ", cantidad=" + cantidad + ", monto=" + monto + ", compra=" + compra + ", producto=" + producto + '}';
    }

}
