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
@Table(name = "Affiliate")

@SequenceGenerator(name = "afid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")
public class Affiliate {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="afid_seq")
    private int affilID;
    private String name;
    private String address;
    private String email;
    @OneToMany(mappedBy = "affil", cascade = CascadeType.ALL)
    private List<Person> plist= new ArrayList<>();
    
}
