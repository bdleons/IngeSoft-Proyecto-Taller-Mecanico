/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Empleado;
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
public class EmpleadoDAO {
        private static EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("SI_Taller_MecPU");
    
    public void crear(Empleado obj){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            if(leer(obj)==null){
                em.persist(obj);
                em.getTransaction().commit();
            }
            else
                em.getTransaction().rollback();
            
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }        
    }
    public Empleado leer(Empleado par) {
        EntityManager em = emf.createEntityManager();
        Empleado empleado = null;       
        Query q = em.createQuery(" SELECT e FROM Empleado e " + 
                " WHERE e.empleado = :empleado" +        // se cambia 'LIKE' por '=' porque el primero parece sólo funcionar con parámetros enteros.                        
                " AND e.password = :password")
                .setParameter("empleado", par.getUser())
                .setParameter("password", par.getPassword());      
        try {
            empleado = (Empleado) q.getSingleResult();            
        } catch (NoResultException e) {
            return empleado;
        } catch (NonUniqueResultException e) {
            empleado = (Empleado) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return empleado;
        }
    }
    public Empleado leer(String par) {
        EntityManager em = emf.createEntityManager();
        Empleado empleado = null;       
        Query q;
            q = em.createQuery(" SELECT e FROM Empleado e " + 
                    " WHERE e.password = :password" )      // se cambia 'LIKE' por '=' porque el primero parece sólo funcionar con parámetros enteros.
                    .setParameter("password", par);
        try {
            empleado = (Empleado) q.getSingleResult();            
        } catch (NoResultException e) {
            return empleado;
        } catch (NonUniqueResultException e) {
            empleado = (Empleado) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            return empleado;
        }
    }
}
