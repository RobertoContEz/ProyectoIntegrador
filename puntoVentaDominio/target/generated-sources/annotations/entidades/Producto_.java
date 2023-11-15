package entidades;

import entidades.CompraProducto;
import entidades.VentaProducto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-13T21:43:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> marca;
    public static volatile SingularAttribute<Producto, Float> existencia;
    public static volatile SingularAttribute<Producto, Float> precio;
    public static volatile SingularAttribute<Producto, String> codigo;
    public static volatile ListAttribute<Producto, CompraProducto> comprasProducto;
    public static volatile SingularAttribute<Producto, Long> id;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile ListAttribute<Producto, VentaProducto> ventasProducto;

}