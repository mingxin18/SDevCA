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
    @Column(name="affiliate_id")
    private int affiliate_id;
    private String affiliate_name;
    private String contact_address;
    private String contact_email;
    @OneToMany(mappedBy = "affil", cascade = CascadeType.ALL)
    private List<Person> plist= new ArrayList<>();
    
    public Affiliate(){
        
    }

    public Affiliate(String affiliate_name, String contact_address, String contact_email) {
        this.affiliate_name = affiliate_name;
        this.contact_address = contact_address;
        this.contact_email = contact_email;
    }

    public int getAffiliate_id() {
        return affiliate_id;
    }

    public void setAffiliate_id(int affiliate_id) {
        this.affiliate_id = affiliate_id;
    }

    public String getAffiliate_name() {
        return affiliate_name;
    }

    public void setAffiliate_name(String affiliate_name) {
        this.affiliate_name = affiliate_name;
    }

    public String getContact_address() {
        return contact_address;
    }

    public void setContact_address(String contact_address) {
        this.contact_address = contact_address;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public List<Person> getPlist() {
        return plist;
    }

    public void setPlist(List<Person> plist) {
        this.plist = plist;
    }
    
    public void addPerson(Person p) {
        plist.add(p);
        p.setAffil(this);
    }
    
}