/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    
}
