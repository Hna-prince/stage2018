package com.management.loyality.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Campaigncontenttype {

    public Campaigncontenttype(){}
    public Campaigncontenttype(String name){
        this.setNamecontent(name);
    }
    @Id
    @GenericGenerator(name = "id",strategy = "com.management.loyality.domain.IdGenerator",parameters = @org.hibernate.annotations.Parameter(name = "predicat", value = "CCT"))
    @GeneratedValue(generator = "id")
    @Column
    String idcampaigncontenttype;
    @Column
    String namecontent;

    public String getIdcampaigncontenttype() {
        return idcampaigncontenttype;
    }

    public void setIdcampaigncontenttype(String idcampaigncontenttype) {
        this.idcampaigncontenttype = idcampaigncontenttype;
    }

    public String getNamecontent() {
        return namecontent;
    }

    public void setNamecontent(String namecontent) {
        this.namecontent = namecontent;
    }
}
