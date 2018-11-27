/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import model.Affiliate;
import model.Author;
import model.Interest;
import model.Journal;
import model.Manuscript;
import model.Person;
import model.Reviewer;
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void close() {
        em.close();
        emf.close();
    }


}
