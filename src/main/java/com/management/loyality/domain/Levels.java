package com.management.loyality.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Levels {

    public Levels(){}
    public Levels(String description, int valuePermission, String idCompany){
        this.setDescription(description);
        this.setValuepermission(valuePermission);
        this.setIdcompany(idCompany);
    }
    @Id
    @GenericGenerator(name = "id",strategy = "com.management.loyality.domain.IdGenerator",parameters = @org.hibernate.annotations.Parameter(name = "predicat", value = "LVL"))
    @GeneratedValue(generator = "id")
    @Column
    String idlevels;
    @Column
    String description;
    @Column
    int valuepermission;
    @Column
    String idcompany;

    public String getIdlevels() {
        return idlevels;
    }

    public void setIdlevels(String idlevels) {
        this.idlevels = idlevels;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValuepermission() {
        return valuepermission;
    }

    public void setValuepermission(int valuepermission) {
        this.valuepermission = valuepermission;
    }

    public String getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(String idcompany) {
        this.idcompany = idcompany;
    }
}
