/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import model.*;
/**
 *
 * @author Kevin
 */
public class PersistenceOperations {
    EntityManagerFactory emf;
    EntityManager em;

    public PersistenceOperations() {
        emf = Persistence.createEntityManagerFactory("EJournalPU");
        em = emf.createEntityManager();
    }
    
    public void addAffil(String name, String address, String email){
        em.getTransaction().begin();
        Affiliate a = new Affiliate(name,address,email);
        em.persist(a);
        em.getTransaction().commit();
    }
    
    public void addManuscript(String title){
        em.getTransaction().begin();
        Manuscript m = new Manuscript(title);
        em.persist(m);
        em.getTransaction().commit();
    }
    
    public void assignAuthorToManuscript(int id,int man_id){
        em.getTransaction().begin();
        Author a = (Author) findPerson(id);
        Manuscript m = findManuscript(man_id);
        m.addAuthor(a);
        em.getTransaction().commit();
    }
    
    public Person findPerson(int id){
        Person p = em.find(Person.class, id);
        if (p == null) {
            System.out.println("Author/Reviewer Not Found");
        }
        return p;
    }
    
    public Manuscript findManuscript(int id){
        Manuscript m = em.find(Manuscript.class, id);
        if (m == null) {
            System.out.println("Manuscript Not Found");
        }
        return m;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void close() {
        em.close();
        emf.close();
    }


}
