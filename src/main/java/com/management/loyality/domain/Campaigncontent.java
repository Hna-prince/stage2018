package com.management.loyality.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table
public class Campaigncontent {
    public Campaigncontent(){}
    public Campaigncontent(String idCampaignContentType, String idCompany,String titles, String body){
        this.setIdcampaigncontenttype(idCampaignContentType);
        this.setIdcompany(idCompany);
        this.setTitle(titles);
        this.setBodies(body);

    }


    @Id
    @GenericGenerator(name = "id",strategy = "com.management.loyality.domain.IdGenerator",parameters = @org.hibernate.annotations.Parameter(name = "predicat", value = "CMC"))
    @GeneratedValue(generator = "id")
    @Column
    String idcampaigncontent;
    @Column
    String idcampaigncontenttype;
    @Column
    String idcompany;
    @Column
    String title;
    @Column
    String bodies;

    public String getIdcampaigncontent() {
        return idcampaigncontent;
    }

    public void setIdcampaigncontent(String idcampaigncontent) {
        this.idcampaigncontent = idcampaigncontent;
    }

    public String getIdcampaigncontenttype() {
        return idcampaigncontenttype;
    }

    public void setIdcampaigncontenttype(String idcampaigncontenttype) {
        this.idcampaigncontenttype = idcampaigncontenttype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodies() {
        return bodies;
    }

    public void setBodies(String bodies) {
        this.bodies = bodies;
    }

    public String getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(String idcompany) {
        this.idcompany = idcompany;
    }
}
