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
    public Cliente leer(Cliente par) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = null;       
        Query q = em.createQuery(" SELECT u FROM Cliente u " + 
                " WHERE u.cedula = :cedula")        // se cambia 'LIKE' por '=' porque el primero parece sólo funcionar con parámetros enteros.                        
                .setParameter("cedula", par.getCedula());        
        try {
            cliente = (Cliente) q.getSingleResult();            
        } catch (NonUniqueResultException e) {
            cliente = (Cliente) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
            obj.setCedula(obj.getCedula()); //deja la misma cédula para evitar conflictos
            obj.setTelefono(nuevoObj.getTelefono());
            obj.setDireccion(nuevoObj.getDireccion());            
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
    }
    
}
