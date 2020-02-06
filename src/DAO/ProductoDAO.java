/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcos
 */
public class ProductoDAO {
    private static EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("SI_Taller_MecPU");
    
    public void crear(Producto obj){
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
    
    public boolean eliminar(Producto obj){
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
    public Producto leer(Producto par) {
        EntityManager em = emf.createEntityManager();
        Producto producto = null;       
        Query q = em.createQuery(" SELECT p FROM Producto p " + 
                " WHERE p.codigo = :codigo")        
                .setParameter("codigo", par.getCodigo());        
        try {
            producto = (Producto) q.getSingleResult();            
        }catch (NoResultException e) {
            return producto;
        }
        catch (NonUniqueResultException e) {
            producto = (Producto) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return producto;
        }                   
    }
    public Producto leer(int cod) {
        EntityManager em = emf.createEntityManager();
        Producto producto = null;       
        Query q = em.createQuery(" SELECT p FROM Producto p " + 
                " WHERE p.codigo = :codigo")        
                .setParameter("codigo", cod);        
        try {
            producto = (Producto) q.getSingleResult();            
        } catch (NoResultException e) {
            return producto;
        }
        catch (NonUniqueResultException e) {
            producto = (Producto) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return producto;
        }                   
    }
    public Producto leer(String nombreP) {
        EntityManager em = emf.createEntityManager();
        Producto producto = null;       
        Query q = em.createQuery(" SELECT p FROM Producto p " + 
                " WHERE p.nombre = :nombre")        
                .setParameter("nombre", nombreP);        
        try {
            producto = (Producto) q.getSingleResult();            
        } catch (NoResultException e) {
            return producto;
        }
        catch (NonUniqueResultException e) {
            producto = (Producto) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return producto;
        }                   
    }
    public Producto leerAct(Producto par) {
        EntityManager em = emf.createEntityManager();
        Producto producto = null;       
        Query q = em.createQuery(" SELECT p FROM Producto p " + 
                " WHERE p.codigo = :codigo" +
                " AND p.nombre = :nombre")        
                .setParameter("codigo", par.getCodigo())        
                .setParameter("nombre", par.getNombre());
        try {
            producto = (Producto) q.getSingleResult();            
        }catch (NoResultException e) {
            return producto;
        }
        catch (NonUniqueResultException e) {
            producto = (Producto) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return producto;
        }                   
    }
    public List<Producto> leer() { //guarda toda la búsqueda en una lista
        EntityManager em = emf.createEntityManager();
        List<Producto> producto =  new ArrayList<Producto>();       
        Query q = em.createQuery("SELECT p FROM Producto p");                                                 
        try {
            producto = q.getResultList();  
            System.out.println(q.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return producto;
        }
    }
    public boolean actualizar(Producto obj, Producto nuevoObj){
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            boolean ret = false;
            try{
                obj = leer(obj);
                obj.setNombre(nuevoObj.getNombre());
                obj.setCantidad(nuevoObj.getCantidad());
                obj.setCodigo(nuevoObj.getCodigo());   
                obj.setPrecioCompra(obj.getPrecioCompra());
                obj.setPrecioVenta(obj.getPrecioVenta());
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

