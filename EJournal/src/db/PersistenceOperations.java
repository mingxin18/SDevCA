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
    
    public void addManuscript(int authId, String title, Calender currDate){
        
    }
    
    public void reviewManuscript(int revId, int manuId, Calendar currDate){
        
    }
    
    public void addReview(int revId, int manuId, int revAppropriate, int revClarity, int revMethod, int revContribution, String revRecommendation, Calendar currDate){
        
    }
    
    public void viewReviews(int manuId){
        
    }
    
    public void accept(String x, Calender currDate){
        
    }
    
    
    
    
    
    
    
    public void close() {
        em.close();
        emf.close();
    }


}
