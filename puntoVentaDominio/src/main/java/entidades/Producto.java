
package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", nullable=false, length=50)
    private String nombre;
    
    @Column(name="marca", nullable=true, length=50)
    private String marca;
    
    @Column(name="precio", nullable=false)
    private float precio;
    
    @Column(name="codigo", nullable=false)
    private String codigo;
    
    @Column(name="existencia", nullable=false)
    private float existencia;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="producto")
    private List<VentaProducto> ventasProducto;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="producto")
    private List<CompraProducto> comprasProducto;

    public Producto() {
    }

    public Producto(String nombre, String marca, float precio, String codigo, float existencia) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.codigo = codigo;
        this.existencia = existencia;
    }
    
    public Producto(Long id, String nombre, String marca, float precio, String codigo, float existencia) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.codigo = codigo;
        this.existencia = existencia;
    }

    public Producto(Long id, String nombre, String marca, float precio, String codigo, float existencia, List<VentaProducto> ventasProducto, List<CompraProducto> comprasProducto) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.codigo = codigo;
        this.existencia = existencia;
        this.ventasProducto = ventasProducto;
        this.comprasProducto = comprasProducto;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getExistencia() {
        return existencia;
    }

    public void setExistencia(float existencia) {
        this.existencia = existencia;
    }

    public List<VentaProducto> getVentasProducto() {
        return ventasProducto;
    }

    public void setVentasProducto(List<VentaProducto> ventasProducto) {
        this.ventasProducto = ventasProducto;
    }

    public List<CompraProducto> getComprasProducto() {
        return comprasProducto;
    }

    public void setComprasProducto(List<CompraProducto> comprasProducto) {
        this.comprasProducto = comprasProducto;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + ", codigo=" + codigo + ", existencia=" + existencia + '}';
    }
}
