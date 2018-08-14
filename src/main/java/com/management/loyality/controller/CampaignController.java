package com.management.loyality.controller;

import com.management.loyality.service.CampaignService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class CampaignController {
    private CampaignService campaignservice;

    public CampaignController(CampaignService campaignService){
        this.campaignservice=campaignService;
    }

    @RequestMapping("/campaign/type/create")
    public String addNewCampaignContentType(@RequestParam String nameCampaignType ){
       String result="";
        try{
            result=campaignservice.insertCampaignContentType(nameCampaignType);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }


    @RequestMapping("/campaign/content/create")
    public String addNewCampaign(@RequestParam String idcampaigncontenttype, @RequestParam String idcompany, @RequestParam String title, @RequestParam String body){
        String result="";
        try{
            result=campaignservice.insertCampaignContent(idcampaigncontenttype,idcompany,title,body);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/campaign/content/change")
    public String changeCampaign(@RequestParam String idcampaign, @RequestParam String idcampaigncontenttype, @RequestParam String title, @RequestParam String bodies){
        String result="";
        try{
            result=campaignservice.updateCampaignContent(idcampaign,idcampaigncontenttype,title,bodies);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/campaign/list")
    public String campaignList(@RequestParam String idcompany){
        String result="";
        try{
            result=campaignservice.CampaignContentList(idcompany);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

}
