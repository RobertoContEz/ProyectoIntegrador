package entidades;

import entidades.Producto;
import entidades.Venta;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-14T23:56:45", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(VentaProducto.class)
public class VentaProducto_ { 

    public static volatile SingularAttribute<VentaProducto, Venta> venta;
    public static volatile SingularAttribute<VentaProducto, Float> monto;
    public static volatile SingularAttribute<VentaProducto, Long> id;
    public static volatile SingularAttribute<VentaProducto, Float> cantidad;
    public static volatile SingularAttribute<VentaProducto, Producto> producto;

}