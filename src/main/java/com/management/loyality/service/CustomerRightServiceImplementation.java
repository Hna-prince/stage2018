package com.management.loyality.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.loyality.domain.Criteria;
import com.management.loyality.domain.Levels;
import com.management.loyality.domain.Subscription;
import com.management.loyality.repository.CriteriaRepository;
import com.management.loyality.repository.LevelsRepository;
import com.management.loyality.repository.SubscriptionRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRightServiceImplementation implements CustomerRightService {

    LevelsRepository levelrepository;
    CriteriaRepository criterierepository;
    SubscriptionRepository subscriptionrepository;

    public  CustomerRightServiceImplementation(LevelsRepository levelRepository,CriteriaRepository criterieRepository, SubscriptionRepository subscriptionRepository){
        this.levelrepository=levelRepository;
        this.criterierepository=criterieRepository;
        this.subscriptionrepository=subscriptionRepository;

    }
    @Override
    public String levelsList(String idCompany) throws Exception {
        try {
            List<Levels> levelsList=levelrepository.findByCompany(idCompany);
            ObjectMapper mapper = new ObjectMapper();
            String result              = mapper.writeValueAsString(levelsList);
            return "{\"status\":0, \"levelslist\": "+result+" }";
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String insertLevels(String description, int valuepermission, String idCompany) throws Exception {
        try {
                Levels oneLevel= new Levels(description,valuepermission, idCompany);
                levelrepository.save(oneLevel);
            String response = "{'status':0, 'description' : ' un nouveau level a été enregistré'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String insertCriteria(String idSubscription, String idLevels) throws Exception {
        try {
            Criteria oneCriteria =new Criteria(idSubscription,idLevels);
            criterierepository.save(oneCriteria);
            int valuepermission=levelrepository.findById(idLevels).get().getValuepermission();

           subscriptionrepository.addLevelSubscription(valuepermission,idSubscription);


            return "{\"status\":0, \"description\" : \" Vous avez ajouté une critère pour le client\"}";
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String deleteCriteria(String idsubscription, String idLevels) throws Exception {
        try {

            /*Criteria onecriteria= new Criteria(idCustomer, idLevels);
            ExampleMatcher matcher = ExampleMatcher.matching()
                    .withIncludeNullValues();

            Example<Criteria> ex = Example.of(onecriteria, matcher);*/
            criterierepository.deleteByIdcustomerAndIdlevels(idsubscription,idLevels);
            int valuepermission=levelrepository.findById(idLevels).get().getValuepermission();

            subscriptionrepository.substractLevelSubscription(valuepermission,idsubscription);
            return "{\"status\":0, \"description\" : \" Vous avez supprimé une critère pour le client\"}";

        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String criteriaList(String idsubscription) throws Exception {
        try {
            List<Criteria> criteriaList= criterierepository.findBySubscriber(idsubscription);

            ObjectMapper mapper = new ObjectMapper();
            String result              = mapper.writeValueAsString(criteriaList);
            return "{\"status\":0, \"criterialist\": "+result+" }";
        }
        catch (Exception e){
            throw e;
        }
    }


}
