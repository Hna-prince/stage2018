package com.management.loyality.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Adminst extends Users {

    public Adminst(){}
    public  Adminst(String lastname,  String firstname,  String address,  String email,  String phonenumber,  String password,  int gender,  String profil,  int status, String companyname ) throws Exception {
        super(lastname, firstname, address, email, phonenumber, password, gender, profil, status);
        this.setIdcompany(companyname);
        this.setActive(0);
    }

    public  Adminst(String lastname,  String firstname,  String address,  String email,  String phonenumber,  String password,  int gender,  String profil,  int status, String companyname, String idplace ) throws Exception {
        super(lastname, firstname, address, email, phonenumber, password, gender, profil, status);
        this.setActive(0);
        this.setIdcompany(companyname);
        this.setIdplace(idplace);
    }
        @Column
    String idcompany;

    @Column
    int active;

    @Column
    String idplace;

    public String getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(String idcompany) {
        this.idcompany = idcompany;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getIdplace() {
        return idplace;
    }

    public void setIdplace(String idplace) {
        this.idplace = idplace;
    }
}
