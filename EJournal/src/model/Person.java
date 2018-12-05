/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

@Entity
@Table(name = "Person")

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")

@SequenceGenerator(name = "pid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")
/**
 *
 * @author Kevin
 */
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pid_seq")
    @Column(name = "person_id")
    private int personID;
    @Column(name="first_name")
    private String fname;
    @Column(name="last_name")
    private String lname;
    private String address;
    private String email;
    @ManyToOne()
    @JoinColumn(name = "affiliate_id")
    private Affiliate affil;

    public Person() {

    }

    public Person(int personID) {
        
    }

    public Person(String fname, String lname, String address, String email) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.email = email;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Affiliate getAffil() {
        return affil;
    }

    public void setAffil(Affiliate affil) {
        this.affil = affil;
    }

    @Override
    public String toString() {
        return "Person:" + String.format("\nID: %5d \nFirst Name: %10s \nLast Name: %10s \nAddress: 510s \nEmail: %10s \nAffiliate: %5d ", personID, fname, lname, address, email, affil);
    }

    
}