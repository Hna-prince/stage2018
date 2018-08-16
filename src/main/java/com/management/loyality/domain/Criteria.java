package com.management.loyality.domain;

import com.management.loyality.domain.compositeKey.CompositeKeyCriteria;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
//@Embeddable
@Entity
@Table
@IdClass(CompositeKeyCriteria.class)
public class Criteria {

    public Criteria(){}
    public Criteria(String idSubscription, String idLevels){
        this.setIdsubscription(idSubscription);
        this.setIdlevels(idLevels);
    }
   /* @Id
    @GenericGenerator(name = "id",strategy = "com.management.loyality.domain.IdGenerator",parameters = @org.hibernate.annotations.Parameter(name = "predicat", value = "CRT"))
    @GeneratedValue(generator = "id")*/
   @Id
    @Column
    String idsubscription;
    @Id
    @Column
    String idlevels;

    public String getIdsubscription() {
        return idsubscription;
    }

    public void setIdsubscription(String idsubscription) {
        this.idsubscription = idsubscription;
    }

    public String getIdlevels() {
        return idlevels;
    }

    public void setIdlevels(String idlevels) {
        this.idlevels = idlevels;
    }
}
