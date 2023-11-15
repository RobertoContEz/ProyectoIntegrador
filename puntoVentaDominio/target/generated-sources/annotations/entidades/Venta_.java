package entidades;

import entidades.Empleado;
import entidades.VentaProducto;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-15T14:16:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, Float> total;
    public static volatile ListAttribute<Venta, VentaProducto> productosVenta;
    public static volatile SingularAttribute<Venta, Empleado> empleado;
    public static volatile SingularAttribute<Venta, Long> id;
    public static volatile SingularAttribute<Venta, Float> pago;

}