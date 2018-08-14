package com.management.loyality.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Beacon {
    public Beacon(){}



    public Beacon(java.lang.String idPlace, java.lang.String tagname, java.lang.String descripttion, int typebeacon) {
        this.setIdplace(idPlace);
        this.setTagname(tagname);
        this.setDescription(descripttion);
        this.setTypebeacon(typebeacon);

        this.setActive(0);
    }

    public Beacon(String idBeacon, String idplace, String idCampaign, String tagName, int active, String titleNotification, String description, int typeBeacon){
        this.setIdbeacon(idBeacon);
        this.setIdplace(idplace);
        this.setIdcampaigncontent(idCampaign);
        this.setTagname(tagName);
        this.setActive(active);
        this.setTitlenotification(titleNotification);
        this.setDescription(description);
        this.setTypebeacon(typeBeacon);
    }

    @Id
    @GenericGenerator(name = "id",strategy = "com.management.loyality.domain.IdGenerator",parameters = @org.hibernate.annotations.Parameter(name = "predicat", value = "BEA"))
    @GeneratedValue(generator = "id")
    @Column
    String idbeacon;
    @Column
    String idplace;
    @Column
    String idcampaigncontent;
    @Column
    String tagname;
    @Column
    int active;
    @Column
    String titlenotification;
    @Column
    String description;
    @Column
    int typebeacon;

    public String getIdbeacon() {
        return idbeacon;
    }

    public void setIdbeacon(String idbeacon) {
        this.idbeacon = idbeacon;
    }

    public String getIdplace() {
        return idplace;
    }

    public void setIdplace(String idplace) {
        this.idplace = idplace;
    }

    public String getIdcampaigncontent() {
        return idcampaigncontent;
    }

    public void setIdcampaigncontent(String idcampaigncontent) {
        this.idcampaigncontent = idcampaigncontent;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getTitlenotification() {
        return titlenotification;
    }

    public void setTitlenotification(String titlenotification) {
        this.titlenotification = titlenotification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public int getTypebeacon() {
        return typebeacon;
    }

    public void setTypebeacon(int typebeacon) {
        this.typebeacon = typebeacon;
    }
}
