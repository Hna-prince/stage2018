package com.management.loyality.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Loyaltytype {

    public Loyaltytype( ){}
    public Loyaltytype(String loyaltyName, String descriptions, int statusType){
        this.setLoyaltyname(loyaltyName);
        this.setDescription(descriptions);
        this. setStatustype(statusType);
    }
    @Id
    @GenericGenerator(name = "id",strategy = "com.management.loyality.domain.IdGenerator",parameters = @org.hibernate.annotations.Parameter(name = "predicat", value = "LTP"))
    @GeneratedValue(generator = "id")
    @Column
    String idloyaltytype;

    @Column
    String loyaltyname;
    @Column
    String description;
    @Column
    int statustype;

    public String getIdloyaltytype() {
        return idloyaltytype;
    }

    public void setIdloyaltytype(String idloyaltytype) {
        this.idloyaltytype = idloyaltytype;
    }


    public String getLoyaltyname() {
        return loyaltyname;
    }

    public void setLoyaltyname(String loyaltyname) {
        this.loyaltyname = loyaltyname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatustype() {
        return statustype;
    }

    public void setStatustype(int statustype) {
        this.statustype = statustype;
    }

    }
