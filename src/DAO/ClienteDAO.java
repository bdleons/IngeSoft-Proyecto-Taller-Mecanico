package DAO;

import Entidad.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcos
 */
public class ClienteDAO {
    private static EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("SI_Taller_MecPU");
    
    public void crear(Cliente obj){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(obj);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }        
    }
    
    public boolean eliminar(Cliente obj){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            em.remove(obj);
            em.getTransaction().commit();
            ret = true;
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return ret;
        }
    }
    //Implementar para que lea en la DB
    /*public Cliente leer(Cliente par){
        EntityManager em = emf.createEntityManager();
        Cliente cliente = null;
        Query q = em.createQuery("SELECT c FROM Cliente c "+
                "WHERE c.nombres LIKE :nombres" +
                "AND c.apellidos LIKE :apellidos"+
                "AND c.cedula LIKE :cedula" +
                "AND c.telefono LIKE :telefono" +
                "AND c.direccion LIKE : direccion" +
                "AND c.num_Vehiculos LIKE :num_Vehiculos")
                .setParameter("nombres", par.getNombres())
                .setParameter("apellidos", par.getApellidos())
                .setParameter("cedula", par.getCedula())
                .setParameter("telefono", par.getTelefono())
                .setParameter("direccion", par.getDireccion())
        try{
            cliente = (Cliente) q.getSingleResult();
        }catch (NonUniqueResultException e){
            cliente = (Cliente) q.getResultList().get(0);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
            return cliente;
        }
    }
    
    public boolean actualizar(Cliente obj, Cliente nuevoObj){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            obj = leer(obj);
            obj.setNombres(nuevoObj.getNombres());
            obj.setApellidos(nuevoObj.getApellidos());
            obj.setCedula(nuevoObj.getCedula());
            obj.setTelefono(nuevoObj.getTelefono());
            obj.setDireccion(nuevoObj.getDireccion());
            obj.setNum_Vehiculos(nuevoObj.getNum_Vehiculos());
            em.merge(obj);
            em.getTransaction().commit();
            ret = true;
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return ret;
        }
    }*/
}
