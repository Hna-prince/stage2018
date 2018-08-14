package com.management.loyality.controller;


import com.management.loyality.service.BeaconService;
import com.management.loyality.service.CompanyService;
import com.management.loyality.service.PlaceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class ManagementController {

    private PlaceService placeservice;
    private BeaconService beaconservice;
    private CompanyService companyservice;

    public ManagementController(PlaceService placeService, BeaconService beaconService, CompanyService companyService){
        this.placeservice=placeService;
        this.beaconservice=beaconService;
        this.companyservice=companyService;
    }

    @RequestMapping("/manage/place/add")
    public String addPlace(@RequestParam String idadmin,@RequestParam String address,@RequestParam String nameplace){
        String result="";
        try {
            result=placeservice.insertPlace(idadmin,address,nameplace);
        }
        catch (Exception e) {
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }
        finally {
            return result;
        }
    }

    @RequestMapping("/manage/place/list")
    public String placelist(@RequestParam String idadmin){
        String result="";
        try{
            result=placeservice.getList(idadmin);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }
        finally{
            return result;
        }
    }

    @RequestMapping("/manage/place/update")
    public String updatePlace(@RequestParam String idplace, @RequestParam String address, @RequestParam String nameplace){
       String result="";
        try {
            result=placeservice.updatePlace(idplace,address,nameplace);
        }
        catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }
        finally{
            return  result;
        }
    }

    @RequestMapping("/manage/beacon/add")
    public String addBeacon(@RequestParam String idPlace,@RequestParam String tagName,@RequestParam String description,@RequestParam int typeB){
        String result="";
        try {
               result= beaconservice.insertBeacon(idPlace,tagName,description,typeB);
        }
        catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }
        finally {
            return result;
        }
    }

    @RequestMapping("/manage/beacon/listByPlace")
    public String beaconList (@RequestParam String idplace){
        String result="";
        try {
                result=beaconservice.beaconListByPlace(idplace);
          }
          catch (Exception e){
              result="{'status':99, 'description' : ' "+e.getMessage()+"'}";

          }finally {
                return result;
          }
    }
    public String activationBeacon(@RequestParam String idBeacon){
        return null;
    }

    @RequestMapping("/manage/beacon/feature")
    public String updateBeaconFeature(@RequestParam String idBeacon, String idplace, String idCampaign, String tagName, int active, String titleNotification, String description, int typeBeacon){
       String result ="";
        try {
           result = beaconservice.updateBeaconCharacteristic( idBeacon,  idplace,  idCampaign,  tagName,  active,  titleNotification,  description,  typeBeacon);
       }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
       }finally {
           return    result;
       }
    }

    @RequestMapping("/manage/beacon/activity")
    public String updateBeaconActivity(@RequestParam String idbeacon){
        String result="";
        try {
            result=beaconservice.activateBeacon(idbeacon);

        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/manage/beacon/assignCampaign")
    public String attributeCampaigntoBeacon(@RequestParam String idbeacon,@RequestParam String idcampaign){
        //update notif
        String result="";
        try{
            result = beaconservice.updateCampaignBeacon(idcampaign,idbeacon);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }


    @RequestMapping("/create/company")
    public String createCompany(@RequestParam String companyname,  @RequestParam String description, @RequestParam String registeredaddress){
        String result="";
        try {

           result= companyservice.insertCompany(companyname,description,registeredaddress);
        }catch (Exception e)  {
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }



}
