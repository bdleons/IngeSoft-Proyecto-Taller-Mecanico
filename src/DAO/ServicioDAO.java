/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entidad.Servicio;
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
public class ServicioDAO {
        private static EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("SI_Taller_MecPU");
    
    public void crear(Servicio obj){
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
    
    public Servicio leer(Servicio par) {
        EntityManager em = emf.createEntityManager();
        Servicio servicio = null;       
        Query q = em.createQuery("SELECT s FROM Servicio s " + 
                " WHERE s.nombreservicio LIKE :nombreservicio")                           
                .setParameter("nombreservicio", par.getNombreservicio());        
        try {
            servicio = (Servicio) q.getSingleResult();            
        } catch (NoResultException e) {
            return servicio;
        } catch (NonUniqueResultException e) {
            servicio = (Servicio) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return servicio;
        }
    }
    public Servicio leer(int cod) {
        EntityManager em = emf.createEntityManager();
        Servicio servicio = null;       
        Query q = em.createQuery("SELECT s FROM Servicio s " + 
                " WHERE s.codigo LIKE :codigo")                           
                .setParameter("codigo", cod);        
        try {
            servicio = (Servicio) q.getSingleResult();            
        } catch (NoResultException e) {
            return servicio;
        } catch (NonUniqueResultException e) {
            servicio = (Servicio) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return servicio;
        }
    }
    public Servicio leer(String nombreServ) {
        EntityManager em = emf.createEntityManager();
        Servicio servicio = null;       
        Query q = em.createQuery("SELECT s FROM Servicio s " + 
                " WHERE s.nombreservicio LIKE :nombreservicio")                           
                .setParameter("nombreservicio", nombreServ);        
        try {
            servicio = (Servicio) q.getSingleResult();            
        } catch (NoResultException e) {
            return servicio;
        } catch (NonUniqueResultException e) {
            servicio = (Servicio) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return servicio;
        }
    }
    public List<Servicio> leer() { //guarda toda la búsqueda en una lista
        EntityManager em = emf.createEntityManager();
        List<Servicio> servicio =  new ArrayList<Servicio>();       
        Query q = em.createQuery("SELECT s FROM Servicio s ");                                                 
        try {
            servicio = q.getResultList();  
            System.out.println(q.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return servicio;
        }
    }
    
}
