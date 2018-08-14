package com.management.loyality.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Company {

    public Company(){}
    public Company(String companyname, String description, String registeredaddress) {
        this.setCompanyname(companyname);
        this.setDescription(description);
        this.setRegisteredaddress(registeredaddress);
    }

    @Id
    @GenericGenerator(name = "id",strategy = "com.management.loyality.domain.IdGenerator",parameters = @org.hibernate.annotations.Parameter(name = "predicat", value = "COM"))
    @GeneratedValue(generator = "id")
    @Column
    String idcompany;
    @Column
    String companyname;
    @Column
    String description;
    @Column
    String registeredaddress;

    public String getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(String idcompany) {
        this.idcompany = idcompany;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegisteredaddress() {
        return registeredaddress;
    }

    public void setRegisteredaddress(String registeredaddress) {
        this.registeredaddress = registeredaddress;
    }
}
