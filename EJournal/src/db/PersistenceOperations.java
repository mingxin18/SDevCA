/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;
import java.util.Calendar;
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

    public void addJournalIssue(Journal j) {
        em.getTransaction().begin();
        em.persist(j);
        em.getTransaction().commit();
    }

    public void addAffil(Affiliate a) {
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    public void addAuthor(Author a) {
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    public void addReviewer(Reviewer r) {
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
    }

    public void addManuscript(Manuscript m) {
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
    }

    public void assignAuthorToManuscript(int id, int man_id) {
        em.getTransaction().begin();
        Author a = (Author) findPerson(id);
        Manuscript m = findManuscript(man_id);
        m.addAuthor(a);
        em.getTransaction().commit();
    }

    public void reviewManuscript(int id, int man_id) {
        em.getTransaction().begin();
        Reviewer r = (Reviewer) findPerson(id);
        Manuscript m = findManuscript(man_id);
        m.addReviewer(r);
        em.getTransaction().commit();
    }

    public void reviewManuscript(int man_id) {
        em.getTransaction().begin();
        Manuscript m = findManuscript(man_id);
        m.setManuscript_status("under_review");
        em.getTransaction().commit();
    }
    
    public void scheduleManuscriptToJournal(int man_id, int journal_id){
        em.getTransaction().begin();
        Manuscript m = findManuscript(man_id);
        Journal j = findJournal(journal_id);
        j.scheduleManuscript(m);
        em.getTransaction().commit();
    }

    public Person findPerson(int id) {
        Person p = em.find(Person.class, id);
        if (p == null) {
            System.out.println("Author/Reviewer Not Found");
        }
        return p;
    }

    public Manuscript findManuscript(int id) {
        Manuscript m = em.find(Manuscript.class, id);
        if (m == null) {
            System.out.println("Manuscript Not Found");
        }
        return m;
    }
    
    public Journal findJournal(int id){
        Journal j = em.find(Journal.class, id);
        if (j == null) {
            System.out.println("Journal Not Found");
        }
        return j;
    }

    public void accept(int manuID) {
        em.getTransaction().begin();
        Manuscript m = findManuscript(manuID);
        m.setManuscript_status("accepted");
        m.setAcceptance_date(Calendar.getInstance());
        em.getTransaction().commit();
    }

    public void reject(int manuID) {
        em.getTransaction().begin();
        Manuscript m = findManuscript(manuID);
        m.setManuscript_status("rejected");
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();
    }

}
