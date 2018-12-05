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

/**
 *
 * @author Kevin
 */

@Entity
@Table(name = "Journal")

@SequenceGenerator(name = "jid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")
public class Journal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "jid_seq")
    @Column(name = "journal_id")
    private int journalID;
    private String pub_period;
    private int pub_year;
    private int pub_volume;
    private int pub_number;
    
    @Temporal(TemporalType.DATE)
    private Calendar pub_date;
    
    @OneToMany(mappedBy = "journal", cascade = CascadeType.ALL)
    private List<Manuscript> mlist = new ArrayList<>();

    public Journal() {
    }

    public Journal(String pub_period, int pub_year, int pub_volume, int pub_number) {
        this.pub_period = pub_period;
        this.pub_year = pub_year;
        this.pub_volume = pub_volume;
        this.pub_number = pub_number;
    }

    public String getPub_period() {
        return pub_period;
    }

    public void setPub_period(String pub_period) {
        this.pub_period = pub_period;
    }

    public int getPub_year() {
        return pub_year;
    }

    public void setPub_year(int pub_year) {
        this.pub_year = pub_year;
    }

    public int getPub_volume() {
        return pub_volume;
    }

    public void setPub_volume(int pub_volume) {
        this.pub_volume = pub_volume;
    }

    public int getPub_number() {
        return pub_number;
    }

    public void setPub_number(int pub_number) {
        this.pub_number = pub_number;
    }

    public Calendar getPub_date() {
        return pub_date;
    }

    public void setPub_date(Calendar pub_date) {
        this.pub_date = pub_date;
    }

    public List<Manuscript> getMlist() {
        return mlist;
    }

    public void setMlist(List<Manuscript> mlist) {
        this.mlist = mlist;
    }
    
    public void scheduleManuscript(Manuscript m){
        mlist.add(m);
        m.setManuscript_status("scheduled");
        m.setJournal(this);
    }
    
    public void publish(){
        for (int i = 0; i < mlist.size(); i++) {
            mlist.get(i).setManuscript_status("published");
        }
        this.pub_date = Calendar.getInstance();
    }
    
     public void printManuscript(){
        System.out.println("Manuscripts for Journal ID: "+journalID);
        for (int i = 0; i < mlist.size(); i++) {
            System.out.println(mlist);   
        }

    }
    
    public String toString(){
        System.out.println("Manuscript Info:");
        for (int i = 0; i < mlist.size(); i++) {
            System.out.println(mlist);
        }
        return String.format("%nJournal: %nJournal ID: %5d %nPublish Period: %15s %nPublish Year: %10d %nPublish Volume: %10d "
                + "%nPublish Number: %10d %nPublish Date: %td %tb %td%n", journalID, pub_period, pub_year, pub_volume, pub_number, pub_date);
        
    }
}
