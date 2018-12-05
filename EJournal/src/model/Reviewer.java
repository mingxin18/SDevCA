/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Kevin
 */
@Entity
@DiscriminatorValue(value = "Reviewer")
@PrimaryKeyJoinColumn(referencedColumnName = "person_id")
@SuppressWarnings("SerializableClass")

public class Reviewer extends Person {

    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ManuscriptReview",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "manuscript_id"))
    private List<Manuscript> mlist= new ArrayList<>();

    public Reviewer() {
    }

    public Reviewer(String fname, String lname, String address, String email) {
        super(fname, lname, address, email);
    }

    public List<Manuscript> getMlist() {
        return mlist;
    }

    public void setMlist(List<Manuscript> mlist) {
        this.mlist = mlist;
    }
    
    @Override
    public String toString() {
        for (int i = 0; i < mlist.size(); i++) {
            System.out.println(mlist);
        }
        return "\n-----Manuscript list finished-----\n";
    }
    

}
