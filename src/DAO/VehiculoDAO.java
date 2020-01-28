/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Vehiculo;
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
public class VehiculoDAO {
    private static EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("SI_Taller_MecPU");
    
    public void crear(Vehiculo obj){
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
    
    public boolean eliminar(Vehiculo obj){
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
    public Vehiculo leer(Vehiculo par) {
        EntityManager em = emf.createEntityManager();
        Vehiculo vehiculo = null;       
        Query q = em.createQuery(" SELECT v FROM Vehiculo v " + 
                " WHERE v.matricula LIKE :matricula")                          
                .setParameter("matricula", par.getMatricula());        
        try {
            vehiculo = (Vehiculo) q.getSingleResult();            
        } catch (NoResultException e) {
            return vehiculo;
        }catch (NonUniqueResultException e) {
            vehiculo = (Vehiculo) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return vehiculo;
        }
    }
    public List<Vehiculo> leer(long cedDueño) {
        EntityManager em = emf.createEntityManager();
        List<Vehiculo> vehiculo =  new ArrayList<Vehiculo>();       
        Query q = em.createQuery(" SELECT v FROM Vehiculo v " + 
                " WHERE v.cedDueño = :cedDueño")                          
                .setParameter("cedDueño", cedDueño);        
        try {
            vehiculo = q.getResultList();            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return vehiculo;
        }
    }
    
    public boolean actualizar(Vehiculo obj, Vehiculo nuevoObj){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            obj = leer(obj);
            obj.setModelo(nuevoObj.getModelo());
            obj.setMatricula(nuevoObj.getMatricula());
            obj.setTipo_vehiculo(nuevoObj.getTipo_vehiculo());
            obj.setObservaciones(nuevoObj.getObservaciones());
            obj.setCedDueño(nuevoObj.getCedDueño());            
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
