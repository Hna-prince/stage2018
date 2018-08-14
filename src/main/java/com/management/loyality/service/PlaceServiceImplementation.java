package com.management.loyality.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.loyality.domain.Place;
import com.management.loyality.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaceServiceImplementation implements PlaceService {

    PlaceRepository repository;

    @Autowired
    public PlaceServiceImplementation(PlaceRepository placerepository)throws Exception{
        this.repository=placerepository;
    }
    @Override
    public String insertPlace(String idAdmin, String address, String nameplace) {
        try{
            Place onePlace=new Place(idAdmin,address, nameplace);
            repository.save(onePlace);

            String response = "{'status':0, 'description' : ' la place a été  créé'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String getList(String idAdmin) throws Exception {
        try {
            List<Place> placeList = repository.findByAdmin(idAdmin);
            if (placeList.size() == 0) {
                return "{\"status\":1, \"placelist\": {} }";
            }
            else {

                ObjectMapper mapper = new ObjectMapper();
                String result              = mapper.writeValueAsString(placeList);
                return "{\"status\":0, \"placelist\": "+result+" }";
            }
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public String updatePlace(String idplace, String address, String nameplace) throws Exception {
        try {
            repository.setPlaceInfoById(address,nameplace, idplace);
            String response = "{'status':0, 'description' : ' la place a été  modifié avec succès'}";
            return response.replaceAll("'", "\"");

        }catch (Exception e){
            throw e;
        }
    }
}
