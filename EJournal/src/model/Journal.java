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
    private Calendar pub_date;
            
    
    
    
    @OneToMany(mappedBy = "journal", cascade = CascadeType.ALL)
    private List<Manuscript> mlist = new ArrayList<>();
}
