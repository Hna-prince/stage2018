package com.management.loyality.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Customer extends Users {

    public Customer(){}

    public Customer(String lastname,  String firstname,  String address,  String email,  String phonenumber,  String password,  int gender,  String profil,  int status, String birthdate ) throws Exception{
         super ( lastname, firstname, address, email, phonenumber, password, gender, profil, status );
         this.setBirthdateString(birthdate);
         this.setLevels(10);
    }
    @Column
    LocalDate birthdate;

    @Column
    int levels;


    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    public void setBirthdateString(String birthdate) {
        this.birthdate = LocalDate.parse(birthdate);
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

}
