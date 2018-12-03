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
}
