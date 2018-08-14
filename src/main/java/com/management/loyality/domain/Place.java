package com.management.loyality.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Place {

    public Place(){}
    public Place(String idAdmin, String addresse, String namePlace){
        this.setIdAdmin(idAdmin);
        this.setaddress(addresse);
        this.setNameplace(namePlace);
    }

    @Id
    @GenericGenerator(name = "id",strategy = "com.management.loyality.domain.IdGenerator",parameters = @org.hibernate.annotations.Parameter(name = "predicat", value = "PLC"))
    @GeneratedValue(generator = "id")
    @Column
    String idplace;
    @Column (name="id")
    String idAdmin;
    @Column
    String address;
    @Column
    String nameplace;

    public String getIdplace() {
        return idplace;
    }

    public void setIdplace(String idplace) {
        this.idplace = idplace;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getNameplace() {
        return nameplace;
    }

    public void setNameplace(String nameplace) {
        this.nameplace = nameplace;
    }
}
