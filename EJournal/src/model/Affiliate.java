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
//@Table(name = "Affiliate")

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
    
    public Affiliate(){
        
    }
    
    public Affiliate(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }
    
    public int getAffId(){
        return affilID;
    }
    
    public void setAffId(int id){
        this.affilID = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void getName(String name){
        this.name = name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void getaAdress(String address){
        this.address = address;
    }
    
    public String geEmail(){
        return email;
    }
    
    public void getEmail(String email){
        this.email = email;
    }
    
    public List<Person> getPlist() {
        return plist;
    }

    public void setPlist(List<Person> plist) {
        this.plist = plist;
    }
    
    
    
    
    
}
