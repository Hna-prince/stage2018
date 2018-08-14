package com.management.loyality.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.loyality.domain.Beacon;
import com.management.loyality.repository.BeaconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeaconServiceImplementation implements BeaconService {

    BeaconRepository repository;

    @Autowired
    public BeaconServiceImplementation(BeaconRepository brepository){ this.repository = brepository;}
    @Override
    public String insertBeacon(String idPlace, String tagName, String description, int typeB) throws Exception {
        try {

            Beacon oneBeacon=new Beacon(idPlace,tagName,description,typeB);
            repository.save(oneBeacon);
            String response = "{'status':0, 'description' : ' le beacon a été  enregistrée avec succès'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String beaconListByPlace(String idPlace) throws Exception {
        try {

           List<Beacon> beaconList=repository.findByPlace(idPlace);
            if (beaconList.size() == 0) {
                return "{\"status\":1, \"beaconlist\": {} }";
            }
            else {

                ObjectMapper mapper = new ObjectMapper();
                String result              = mapper.writeValueAsString(beaconList);
                return "{\"status\":0, \"beaconlist\": "+result+" }";
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String beaconListByCompany(String idAdmin) throws Exception {
        return null;
    }

    @Override
    public String updateBeaconCharacteristic(String idBeacon, String idplace, String idCampaign, String tagName, int active, String titleNotification, String description, int typeBeacon) throws Exception {
        try {
            if (idCampaign.isEmpty())
                idCampaign=null;
            Beacon oneBeacon= new Beacon( idBeacon,  idplace,  idCampaign,  tagName,  active,  titleNotification,  description,  typeBeacon);
            repository.setBeaconFeatureById(oneBeacon);
            String response = "{'status':0, 'description' : ' les caractéristiques du beacon ont été modifiés avec succès'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String updateNotification(String titleNotification, String description, String idBeacon) throws Exception {
        return null;
    }

    @Override
    public String activateBeacon(String idBeacon) throws Exception {
       try {
           Beacon oneBeacon = new Beacon();
           oneBeacon.setIdbeacon(idBeacon);
           Beacon beaconFounded=repository.findById(idBeacon).get();
           int activity=0;
           if(beaconFounded.getActive() == 0)
                activity = 1;

           oneBeacon.setActive(activity);
            repository.activateBeacon(oneBeacon);
           String response = "{'status':0, 'description' : ' le beacon a été  modifié avec succès'}";
           return response.replaceAll("'", "\"");
       }catch (Exception e){
            throw e;
       }
    }

    @Override
    public String updateCampaignBeacon(String idCampaignContent, String idBeacon) throws Exception {
        try {
            repository.assignNewCampaign(idCampaignContent,idBeacon);
            String response = "{'status':0, 'description' : ' la campagne a été attribué au beacon avec succès'}";
            return response.replaceAll("'", "\"");

        }
        catch (Exception e){
            throw e;
        }
    }

}
