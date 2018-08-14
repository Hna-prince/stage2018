package com.management.loyality.service;

import org.springframework.stereotype.Service;


public interface CampaignService {
    public String insertCampaignContentType(String nameContent) throws Exception;
    public String insertCampaignContent(String idCampaignContentType, String idCompany, String title, String body) throws Exception;
    public String updateCampaignContent(String idCampaignContent, String idCampaignContentType, String title, String bodies) throws Exception;
    public String CampaignContentList(String idCompany) throws Exception;
}
