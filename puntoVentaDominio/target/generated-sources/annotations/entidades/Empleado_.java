package entidades;

import entidades.Compra;
import entidades.Venta;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-06T00:33:03", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> correo;
    public static volatile ListAttribute<Empleado, Compra> comprasEmpleado;
    public static volatile SingularAttribute<Empleado, Long> id;
    public static volatile SingularAttribute<Empleado, String> telefono;
    public static volatile SingularAttribute<Empleado, String> nombre;
    public static volatile ListAttribute<Empleado, Venta> ventasEmpleado;
    public static volatile SingularAttribute<Empleado, String> contraseña;

}