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
@PrimaryKeyJoinColumn(referencedColumnName = "personID")
@SuppressWarnings("SerializableClass")

public class Reviewer extends Person {

    private List<Interest> ilist= new ArrayList<>();
    private List<Manuscript> mlist= new ArrayList<>();

}
