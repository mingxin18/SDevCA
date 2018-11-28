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
@DiscriminatorValue(value = "Author")
@PrimaryKeyJoinColumn(referencedColumnName = "person_ID")
@SuppressWarnings("SerializableClass")

public class Author extends Person {

    
    
    
    
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "manuscriptauthor",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "manuscript_id"))
    private List<Manuscript> mlist= new ArrayList<>();
}
