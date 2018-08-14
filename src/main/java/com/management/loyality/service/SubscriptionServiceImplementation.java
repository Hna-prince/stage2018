package com.management.loyality.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.loyality.domain.Subscription;
import com.management.loyality.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImplementation implements  SubscriptionService{

    SubscriptionRepository repository;

    @Autowired
    public SubscriptionServiceImplementation(SubscriptionRepository subRepository){
        this.repository= subRepository;
    }

    @Override
    public String subscribe(String idCustomer, String idCompany) throws Exception {
        try {
            String message="";
            List<Subscription> subscriber=repository.findByCustomerCompany(idCustomer,idCompany);
            if(subscriber.size() == 0){
                Subscription oneSubscription= new Subscription(idCompany,idCustomer);
                repository.save(oneSubscription);
                message="votre abonnement a été effectué";

            }
            else {
                repository.setStatusSubscription(0, subscriber.get(0).getIdsubscription());
                message=" votre réabonnement a été effectué";
            }




            String response = "{'status':0, 'description' : '"+message+"'}";
            return response.replaceAll("'", "\"");

        }
        catch (Exception e){
            throw e;
        }
    }


    @Override
    public String subscribesList(String idCompany)throws Exception{
        try {
            List<Subscription> subscribesList=repository.findByCompany(idCompany);
            ObjectMapper mapper = new ObjectMapper();
            String result              = mapper.writeValueAsString(subscribesList);
            return "{\"status\":0, \"subsribesList\": "+result+" }";

        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String unsubscribe(String idSubscription)  throws  Exception{
        try {
            Subscription oneSubscribe= repository.findById(idSubscription).get();
            int status=0;
            String message="Vous vous êtes réabonné(e)";
            if(oneSubscribe.getStatus() == 0) {
                status = 1;
                message=" Vous vous êtes désabonné(e)";
            }

            repository.setStatusSubscription(status, idSubscription);

            String response = "{'status':0, 'description' : ' "+message+"'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw  e;
        }
    }

}
