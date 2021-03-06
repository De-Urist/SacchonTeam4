package team4.Sacchon.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository <Obj,Id> {

    private final EntityManager em;
    public abstract Class<Obj> getEntityClass();
    public abstract String getClassName();

    public Repository(EntityManager em) {
        this.em = em;
    }

    //Create
    public Obj save (Obj obj){
        try{
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            return obj;
        } catch (Exception e){
            System.out.println("Error creating object : " + obj.getClass().getName());
            e.printStackTrace();
        }
        return null;
    }

    //Read
    public Obj read(Id id){
        return em.find(getEntityClass(), id);
    }

    public List<Obj> findAll(){
        return em.createQuery("from " + getClassName()).getResultList();
    }

    //Update
    public Obj update(Obj obj){
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Error updating object : " + obj.getClass().getName());
            e.printStackTrace();
        }
        return null;
    }

    //Delete
    public boolean delete(Id id){
        Obj obj = read(id);
        if(obj == null){
            return false;
        }
        try{
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception e){
            System.out.println("Error deleting object : " + obj.getClass().getName());
            return false;
        }
    }
}
