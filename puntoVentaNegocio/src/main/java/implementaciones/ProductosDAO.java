package implementaciones;

import entidades.Producto;
import interfaces.IConexionBD;
import interfaces.IProductosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class ProductosDAO implements IProductosDAO {

    private IConexionBD conexion;

    public ProductosDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Producto producto) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException ex) {
            System.err.println("No se pudo agregar el producto");
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean editar(Producto producto) {
        EntityManager em = this.conexion.crearConexion();

        try {
            em.getTransaction().begin();

            // Busca la entidad existente en la base de datos
            Producto productoExistente = em.find(Producto.class, producto.getId());

            if (productoExistente != null) {
                productoExistente.setNombre(producto.getNombre());
                productoExistente.setPrecio(producto.getPrecio());
                productoExistente.setCodigo(producto.getCodigo());
                productoExistente.setMarca(producto.getMarca());
                productoExistente.setHabilitado(producto.getHabilitado());

                // Guarda la entidad actualizada en la base de datos
                em.merge(productoExistente);

                em.getTransaction().commit();
                return true;
            } else {
                // Manejo de error: la entidad no se encontró en la base de datos
                return false;
            }
        } catch (IllegalStateException ex) {
            System.err.println("No se pudo editar el producto");
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Producto consultarProductoPorCodigo(String codigoProducto, boolean habilitado) {
        EntityManager em =null;
        try {
            em= this.conexion.crearConexion();
            String jpqlQuery = "SELECT p FROM Producto p WHERE p.codigo LIKE :codigoProducto AND p.habilitado LIKE :habilitado";

            // OBJETO DE CONSULTA EJECUTABLE
            TypedQuery<Producto> query = em.createQuery(jpqlQuery, Producto.class);
            query.setParameter("codigoProducto",  codigoProducto );
            query.setParameter("habilitado",  habilitado );

            return query.getResultList().get(0);
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la base de datos.");
            System.err.println("No se pudo acceder a la base de datos"+ex.getMessage());
            return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar el producto introducido.");
            System.err.println("No se pudo agregar la venta"+ex.getMessage());
            return null;
        }
    }
    
    @Override
    public Producto consultarProductoPorNombre(String nombreProducto, boolean habilitado) {
        
        EntityManager em = null;
        try {
            em= this.conexion.crearConexion();
            
            String jpqlQuery = "SELECT p FROM Producto p WHERE p.nombre LIKE '%" + nombreProducto + "%' OR p.marca LIKE '%" + nombreProducto + "%' AND p.habilitado LIKE :habilitado";
            //JOptionPane.showMessageDialog(null, jpqlQuery);
            // OBJETO DE CONSULTA EJECUTABLE
            TypedQuery<Producto> query = em.createQuery(jpqlQuery, Producto.class);
            query.setParameter("habilitado",  habilitado );
            //JOptionPane.showMessageDialog(null, query.toString());
            if(query.getResultList().get(0)==null){
                
                JOptionPane.showMessageDialog(null, "El producto" + nombreProducto + " no existe.");
                return null;
            }else{
                
                return query.getResultList().get(0);
            }
            
        } catch (PersistenceException ex) {
            
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la base de datos.");
            System.err.println("No se pudo acceder a la base de datos"+ex.getMessage());
            return null;
        } catch (Exception ex) {
            
             JOptionPane.showMessageDialog(null, "El producto " + nombreProducto + " no existe.");
             System.err.println("No se pudo conectar a la base de datos  "+ex.getMessage());
              
             
            return null;
        }
    }
    
    @Override
    public List<Producto> consultarProductosPorNombre(String nombreProducto) {
        
        EntityManager em=null;
        
        try {
            em = this.conexion.crearConexion();
            String jpqlQuery = "SELECT p FROM Producto p WHERE p.nombre LIKE '%" + nombreProducto + "%' OR p.marca LIKE '%"+nombreProducto+"%'";

            // OBJETO DE CONSULTA EJECUTABLE
            TypedQuery<Producto> query = em.createQuery(jpqlQuery, Producto.class);
            
             if(query.getResultList()==null){
                
                JOptionPane.showMessageDialog(null, "No se pudo encontrar el producto introducido ");
                return null;
            }else{
            
                return query.getResultList();
            }

            
        } catch (Exception ex) {
            
             JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos ");
             System.err.println("No se pudo conectar a la base de datos  "+ex.getMessage());
              
             
            return null;
        }
    }
    
    @Override
    public List<Producto> consultarTodos() {
        try {
            EntityManager em = this.conexion.crearConexion();
            String jpqlQuery = "SELECT p FROM Producto p";

            // OBJETO DE CONSULTA EJECUTABLE
            TypedQuery<Producto> query = em.createQuery(jpqlQuery, Producto.class);

            return query.getResultList();
        } catch (IllegalStateException ex) {
            System.err.println("No se pudo encontrar el producto");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean actualizarProducto(Producto producto) {
    EntityManager em = null;

    try {
        em = this.conexion.crearConexion();
        em.getTransaction().begin();
        
        // Verificar si el producto ya está gestionado por el EntityManager
        if (!em.contains(producto)) {
            producto = em.merge(producto); // Si no, realizar merge para gestionarlo
        }
        em.getTransaction().commit();
        return true;
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "No se pudo actualizar el producto");
        System.err.println("No se pudo actualizar el producto: " + ex.getMessage());
        if (em != null && em.getTransaction().isActive()) {
            em.getTransaction().rollback(); // Deshacer la transacción en caso de error
        }
        return false;
    } finally {
        if (em != null) {
            em.close(); // Cerrar el EntityManager en cualquier caso
        }
    }
    }
    @Override
    public void actualizarStock(String codigoProducto, int cantidad) {
        
        EntityManager em = null;
        try {
            em = this.conexion.crearConexion();
            em.getTransaction().begin();

            
            Producto producto = consultarProductoPorCodigo(codigoProducto, true);
            
        

            if (producto != null) {
                float stockActual = producto.getExistencia();
                float nuevoStock = stockActual + cantidad;

                //el nuevo stock no sea negativo
                
                if (nuevoStock >= 0) {
                    producto.setExistencia(nuevoStock); // Actualiza el stock en el objeto Producto
                    em.merge(producto); // Actualiza el producto en la base de datos
                    em.getTransaction().commit();
                    System.out.println("Stock actualizado para el producto con código " + codigoProducto);
                } else {
                    throw new Exception();
                    //System.out.println("No se puede actualizar el stock a un valor negativo.");
                }
            } else {
                System.out.println("Producto con código " + codigoProducto + " no encontrado.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Error al actualizar el stock del producto con código " + codigoProducto);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    
}
