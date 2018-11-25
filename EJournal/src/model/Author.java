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
@PrimaryKeyJoinColumn(referencedColumnName = "personID")
@SuppressWarnings("SerializableClass")

public class Author extends Person {

    private List<Manuscript> mlist= new ArrayList<>();
}
