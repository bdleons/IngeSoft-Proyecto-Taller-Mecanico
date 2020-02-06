/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Factura;
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
 * @author NICOLAS
 */
public class FacturaDAO {
   private static EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("SI_Taller_MecPU");
    
    public void crear(Factura obj){
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
    
    public boolean eliminar(Factura obj){
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
    public Factura leer(Factura par) {
        EntityManager em = emf.createEntityManager();
        Factura factura = null;       
        Query q = em.createQuery(" SELECT u FROM Factura u " + 
                " WHERE u.Id = :Id")        // se cambia 'LIKE' por '=' porque el primero parece sólo funcionar con parámetros enteros.                        
                .setParameter("Id", par.getId());        
        try {
            factura = (Factura) q.getSingleResult();            
        } catch (NoResultException e) {
            return factura;
        } catch (NonUniqueResultException e) {
            factura = (Factura) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return factura;
        }
    }
    public Factura leer(Long cedula) {
        EntityManager em = emf.createEntityManager();
        Factura factura = null;       
        Query q = em.createQuery(" SELECT u FROM Factura u " + 
                " WHERE u.codigo = :codigo")        // se cambia 'LIKE' por '=' porque el primero parece sólo funcionar con parámetros enteros.                        
                .setParameter("codigo", cedula);        
        try {
            factura = (Factura) q.getSingleResult();            
        } catch (NoResultException e) {
            return factura;
        }   catch (NonUniqueResultException e) {
            factura = (Factura) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return factura;
        }
    }
    
    public List<Factura> leer() { //guarda toda la búsqueda en una lista
        EntityManager em = emf.createEntityManager();
        List<Factura> facturas = new ArrayList<Factura>();
        Query q = em.createQuery("SELECT u FROM Factura u");
        try {
            facturas = q.getResultList();
            System.out.println(q.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return facturas;
        }
    }
    
    public boolean actualizar(Factura obj, Factura nuevoObj){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            obj = leer(obj);
            obj.setCedulacliente(nuevoObj.getCedulacliente());
            obj.setIdempleado(nuevoObj.getIdempleado());
            obj.setPrecio(nuevoObj.getPrecio());            
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
