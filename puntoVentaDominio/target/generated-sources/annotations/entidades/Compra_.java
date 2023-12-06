package entidades;

import entidades.CompraProducto;
import entidades.Empleado;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-06T00:33:03", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Calendar> fecha;
    public static volatile SingularAttribute<Compra, Float> total;
    public static volatile SingularAttribute<Compra, Empleado> empleado;
    public static volatile ListAttribute<Compra, CompraProducto> productosCompra;
    public static volatile SingularAttribute<Compra, Long> id;

}