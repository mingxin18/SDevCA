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
    private Calendar received_date;
    private Calendar acceptance_date;

    @ManyToOne()
    @JoinColumn(name = "journal_id")
    private Journal journal;

    @ManyToMany(mappedBy = "mlist", cascade = CascadeType.PERSIST)
    private List<Author> alist = new ArrayList<>();
    
    @ManyToMany(mappedBy = "mlist", cascade = CascadeType.PERSIST)
    private List<Reviewer> rlist = new ArrayList<>();

}
