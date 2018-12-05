/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Manuscript")

@SequenceGenerator(name = "mid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")
/**
 *
 * @author Kevin
 */
public class Manuscript {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "mid_seq")
    @Column(name = "Manuscript_id")
    private int manuscriptID;
    private String manuscript_title;
    private String manuscript_status;
    @Temporal(TemporalType.DATE)
    private Calendar received_date;
    @Temporal(TemporalType.DATE)
    private Calendar acceptance_date;

    @ManyToOne()
    @JoinColumn(name = "journal_id")
    private Journal journal;

    @ManyToMany(mappedBy = "mlist", cascade = CascadeType.PERSIST)
    private List<Author> alist = new ArrayList<>();
    
    @ManyToMany(mappedBy = "mlist", cascade = CascadeType.PERSIST)
    private List<Reviewer> rlist = new ArrayList<>();

    public Manuscript() {
    }
    
    

    public Manuscript(String manuscript_title) {
        this.manuscript_title = manuscript_title;
        this.manuscript_status = "received";
        this.received_date = Calendar.getInstance();
    }
    
    public void addAuthor(Author a){
        this.alist.add(a);
        a.getMlist().add(this);
    }
    
    public void addReviewer(Reviewer r){
        this.rlist.add(r);
        r.getMlist().add(this);
    }

    public int getManuscriptID() {
        return manuscriptID;
    }

    public void setManuscriptID(int manuscriptID) {
        this.manuscriptID = manuscriptID;
    }

    public String getManuscript_title() {
        return manuscript_title;
    }

    public void setManuscript_title(String manuscript_title) {
        this.manuscript_title = manuscript_title;
    }

    public String getManuscript_status() {
        return manuscript_status;
    }

    public void setManuscript_status(String manuscript_status) {
        this.manuscript_status = manuscript_status;
    }

    public Calendar getReceived_date() {
        return received_date;
    }

    public void setReceived_date(Calendar received_date) {
        this.received_date = received_date;
    }

    public Calendar getAcceptance_date() {
        return acceptance_date;
    }

    public void setAcceptance_date(Calendar acceptance_date) {
        this.acceptance_date = acceptance_date;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public List<Author> getAlist() {
        return alist;
    }

    public void setAlist(List<Author> alist) {
        this.alist = alist;
    }

    public List<Reviewer> getRlist() {
        return rlist;
    }

    public void setRlist(List<Reviewer> rlist) {
        this.rlist = rlist;
    }
    
    public void printAuthor(){
        System.out.println("Authors for Manuscript ID: "+manuscriptID);
        for (int i = 0; i < alist.size(); i++) {
            System.out.println(alist);   
        }

    }
    
    
//    public void printReviewer(){
//        System.out.println("Reviewers for Manuscript ID: "+manuscriptID);
//        for (int i = 0; i < rlist.size(); i++) {
//            System.out.println(rlist);
//                
//        }
//    }

    public String toString(){
        return String.format("%nManuscript: %nManuscript ID: %5d %nTitle: %15s %nStatus: %15s %nReceived Date: %td %tb %td "
                + "%nAcceptance Date: %td %tb %td %nJournal ID: %5d%n", manuscriptID, manuscript_title, manuscript_status, received_date, acceptance_date, journal);
        
    }
    

    
    
}
