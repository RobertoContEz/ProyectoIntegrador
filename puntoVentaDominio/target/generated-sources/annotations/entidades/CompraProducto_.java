package entidades;

import entidades.Compra;
import entidades.Producto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-14T23:56:45", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(CompraProducto.class)
public class CompraProducto_ { 

    public static volatile SingularAttribute<CompraProducto, Compra> compra;
    public static volatile SingularAttribute<CompraProducto, Float> monto;
    public static volatile SingularAttribute<CompraProducto, Long> id;
    public static volatile SingularAttribute<CompraProducto, Float> cantidad;
    public static volatile SingularAttribute<CompraProducto, Producto> producto;

}