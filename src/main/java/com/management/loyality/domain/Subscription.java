package com.management.loyality.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Subscription {

    public Subscription(){}
    public  Subscription(String idCompany, String idCustomer){
        this.setIdcompany(idCompany);
        this.setId(idCustomer);
        this.setCurrentpointvalue(0);
        this.setStatus(0);
    }

    @Id
    @GenericGenerator(name = "id",strategy = "com.management.loyality.domain.IdGenerator",parameters = @org.hibernate.annotations.Parameter(name = "predicat", value = "SUB"))
    @GeneratedValue(generator = "id")
    @Column
    String idsubscription;
    @Column
    String idcompany;
    @Column
    String id;
    @Column
    int currentpointvalue;
    @Column
    int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIdsubscription() {
        return idsubscription;
    }

    public void setIdsubscription(String idsubscription) {
        this.idsubscription = idsubscription;
    }

    public String getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(String idcompany) {
        this.idcompany = idcompany;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrentpointvalue() {
        return currentpointvalue;
    }

    public void setCurrentpointvalue(int currentpointvalue) {
        this.currentpointvalue = currentpointvalue;
    }
}
