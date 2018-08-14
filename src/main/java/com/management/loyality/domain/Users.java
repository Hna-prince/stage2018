package com.management.loyality.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@MappedSuperclass
public class Users {
    public Users(){}
    public Users (String lastname,  String firstname,  String address,  String email,  String phonenumber,  String password,  int gender,  String profil,  int status ) throws  Exception{
        //this.setId("2");
        this.setLastname(lastname);
        this.setFirstname(firstname);
        this.setAddress(address);
        this.setEmail(email);
        this.setCreationdate(LocalDate.now());
        this.setPhonenumber(phonenumber);
        this.setPassword(password);
        this.setGender(gender);
        this.setProfil(profil);
        this.setStatus(status);
    }
    @Id
   @GenericGenerator(name = "id",strategy = "com.management.loyality.domain.IdGenerator",parameters = @org.hibernate.annotations.Parameter(name = "predicat", value = "USR"))
    @GeneratedValue(generator = "id")
    @Column
    String id;

    @Column
    String lastname;
    @Column
    String Firstname;
    @Column
    String address;
    @Column
    String email;
    @Column
    String phonenumber;
    @Column
    String password;
    @Column
    LocalDate creationdate;
    @Column
    int gender;
    @Column
    String profil;
    @Column
    int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
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

    public void setEmail(String email) throws  Exception{
        String REGEX_EMAIL_VALIDATION   = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$";
        Pattern ptr                     = Pattern.compile(REGEX_EMAIL_VALIDATION);
        Matcher matcher                 = ptr.matcher(email);

        if(matcher.matches())
            this.email = email;
        else
            throw new Exception (" email not valid");


    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(LocalDate creationdate) {


        this.creationdate = creationdate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) throws Exception {
        if (gender == 0 || gender == 1)
            this.gender = gender;
        else
            throw new Exception("Sexe inconnu");
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
