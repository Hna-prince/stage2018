package com.management.loyality.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.loyality.domain.Campaigncontent;
import com.management.loyality.domain.Campaigncontenttype;
import com.management.loyality.repository.CampaigncontentRepository;
import com.management.loyality.repository.CampaigncontenttypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImplement implements CampaignService {

    CampaigncontentRepository repositoryCampaign;
    CampaigncontenttypeRepository repositoryCampaignType;

    @Autowired
    public CampaignServiceImplement(CampaigncontentRepository campaigncontentRepository, CampaigncontenttypeRepository campaigncontenttypeRepository){
        this.repositoryCampaign=campaigncontentRepository;
        this.repositoryCampaignType=campaigncontenttypeRepository;
    }
    @Override
    public String insertCampaignContentType(String nameContent) throws Exception {
        try{
            Campaigncontenttype oneCampaigntype=new Campaigncontenttype(nameContent);
            repositoryCampaignType.save(oneCampaigntype);

            String response = "{'status':0, 'description' : ' un nouveau type de campagne a été crée avec succes'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw e;
        }
    }



    @Override
    public String insertCampaignContent(String idCampaignContentType, String idCompany,String title, String body) throws Exception {
        try {
            Campaigncontent oneCampaign = new Campaigncontent(idCampaignContentType,idCompany,title,body);
            repositoryCampaign.save(oneCampaign);
            String response = "{'status':0, 'description' : ' la campagne  a été crée avec succes'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw e;
        }
    }



    @Override
    public String updateCampaignContent(String idCampaignContent, String idCampaignContentType, String title, String bodies) throws Exception {
        try {
            Campaigncontent campaigncontent=new Campaigncontent();
            campaigncontent.setIdcampaigncontent(idCampaignContent);
            campaigncontent.setIdcampaigncontenttype(idCampaignContentType);
            campaigncontent.setTitle(title);
            campaigncontent.setBodies(bodies);
            repositoryCampaign.updateCampaignContent(campaigncontent);
            String response = "{'status':0, 'description' : ' la campagne  a été modifié  avec succes'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String CampaignContentList(String idCompany) throws Exception {
        try{
            List<Campaigncontent> campaignContentList=repositoryCampaign.findByCompany(idCompany);

            ObjectMapper mapper = new ObjectMapper();
            String result              = mapper.writeValueAsString(campaignContentList);
            return "{\"status\":0, \"campaignlist\": "+result+" }";

        }catch (Exception e){
            throw e;
        }
    }
}
