package com.management.loyality.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Loyalitypoint {

    public Loyalitypoint(){}

    public Loyalitypoint(String idearningRule, String idSubscription, int earnedpoint){
        this.setIdearningrule(idearningRule);
        this.setIdsubscription(idSubscription);
        this.setEarnedpoint(earnedpoint);
        this.setAcquisitiondate(LocalDate.now());

    }
    @Id
    @GenericGenerator(name = "id",strategy = "com.management.loyality.domain.IdGenerator",parameters = @org.hibernate.annotations.Parameter(name = "predicat", value = "LPT"))
    @GeneratedValue(generator = "id")
    @Column
    String idloyalitypoint;
    @Column
    String idearningrule;
    @Column
    String idsubscription;
    @Column
    int earnedpoint;
    @Column
    LocalDate acquisitiondate;

    public String getIdloyalitypoint() {
        return idloyalitypoint;
    }

    public void setIdloyalitypoint(String idloyalitypoint) {
        this.idloyalitypoint = idloyalitypoint;
    }

    public String getIdearningrule() {
        return idearningrule;
    }

    public void setIdearningrule(String idearningrule) {
        this.idearningrule = idearningrule;
    }

    public String getIdsubscription() {
        return idsubscription;
    }

    public void setIdsubscription(String idsubscription) {
        this.idsubscription = idsubscription;
    }

    public int getEarnedpoint() {
        return earnedpoint;
    }

    public void setEarnedpoint(int earnedpoint) {
        this.earnedpoint = earnedpoint;
    }

    public LocalDate getAcquisitiondate() {
        return acquisitiondate;
    }

    public void setAcquisitiondate(LocalDate acquisitiondate) {
        this.acquisitiondate = acquisitiondate;
    }
}
