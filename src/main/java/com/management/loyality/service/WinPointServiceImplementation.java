package com.management.loyality.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.loyality.domain.EarningRule;
import com.management.loyality.domain.Loyalitypoint;
import com.management.loyality.domain.Loyaltytype;
import com.management.loyality.domain.Subscription;
import com.management.loyality.repository.EarningRuleRepository;
import com.management.loyality.repository.LoyalitypointRepository;
import com.management.loyality.repository.LoyaltytypeRepository;
import com.management.loyality.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WinPointServiceImplementation implements WinPointService {

    LoyaltytypeRepository loyaltytyperepository;
    EarningRuleRepository earnrulerepository;
    SubscriptionRepository subscriptionrepository;
    LoyalitypointRepository loyalitypointrepository;

    @Autowired

    public WinPointServiceImplementation(LoyaltytypeRepository loyaltytypeRepository, EarningRuleRepository earnruleRepository, SubscriptionRepository subscriptionrRepository,  LoyalitypointRepository loyalitypointRepository){
         loyaltytyperepository          = loyaltytypeRepository;
         earnrulerepository             = earnruleRepository;
         this.subscriptionrepository    = subscriptionrRepository;
         this.loyalitypointrepository   = loyalitypointRepository;

    }

    @Override
    public String insertLoyaltyType(String loyaltyName, String descriptions, int statusType) throws Exception {
        try {
            Loyaltytype oneLoyaltyType= new Loyaltytype(loyaltyName, descriptions, statusType);
            loyaltytyperepository.save(oneLoyaltyType);
            return "{\"status\":0, \"description\": \" Un nouveau type de fidélité a été créé\" }";
        }
        catch (Exception e){
            throw  e;
        }
    }

    @Override
    public String loyaltyTypeListDefault() throws Exception {
        try {
            List<Loyaltytype> loyaltyTypeList   = loyaltytyperepository.findAll();
            ObjectMapper mapper                 = new ObjectMapper();
            String result                       = mapper.writeValueAsString(loyaltyTypeList);
            return "{\"status\":0, \"loyaltytypelist\": "+result+" }";
        }
        catch (Exception e){
            throw  e;
        }
    }

    @Override
    public String loyaltyTypeListCustomized() throws Exception {
        return null;
    }

    @Override
    public String defineEarningRule(String idCompany,String idLoyalityType,String startdate, String enddate, int earnedpoint, String targetchar) throws Exception {
        try {
            EarningRule oneEarningRule= new EarningRule(idCompany,idLoyalityType,startdate, enddate, earnedpoint,targetchar);
            earnrulerepository.save(oneEarningRule);

            return "{\"status\":0, \"description\": \" Un nouveau type de fidélité a été créé\" }";
        }
        catch (Exception e){
            throw  e;
        }
    }

    @Override
    public String changeActivityEarningRule(String idEarningRule) throws Exception {
        try {
            int activity    =0;
            String  message = " La règle a été réactivée. ";
            if( earnrulerepository.findById(idEarningRule).get().getActive() == 0) {
                activity    = 1;
                message     =" La règle vient d'être activéé. ";
            }
            earnrulerepository.setActivity(activity,idEarningRule);

            return "{\"status\":0, \"description\": \""+message+"\" }";

        }
        catch (Exception e){
            throw  e;
        }
    }

    @Override
    public String updateEarningRule(String idEarningRule, int earnedpoint, int activity, String targetchar) throws Exception {
        try {
            EarningRule oneEarningRule = new EarningRule(idEarningRule, earnedpoint,activity,targetchar);
            earnrulerepository.setEarningRule(oneEarningRule);

            return "{\"status\":0, \"description\": \" La règle vient d'être modifiée \" }";


        }
        catch (Exception e){
            throw  e;
        }
    }

    @Override
    public String currentPoint(String idsubscription) throws Exception {
        try {
           Subscription subscriber = subscriptionrepository.findById(idsubscription).get();

            return "{\"status\":0, \"currentpointvalue\": "+subscriber.getCurrentpointvalue()+" }";
        }
        catch (Exception e){
            throw  e;
        }
    }

    @Override
    public String customerEarningPointHistory(String idsubscription) throws Exception {
        try {
            List<Loyalitypoint> loyaltyPointList= loyalitypointrepository.findBySubscriber(idsubscription);
            ObjectMapper mapper                 = new ObjectMapper();
            String result                       = mapper.writeValueAsString(loyaltyPointList);
            return "{\"status\":0, \"loyalitytpointlist\": "+result+" }";
        }
        catch (Exception e){
            throw  e;
        }
    }

    @Override
    @Transactional
    public String earningPoint( String idEarningRule, String idsubscription) throws Exception {
        try {

            int earnedPoint =earnrulerepository.findById(idEarningRule).get().getEarnedpoint();
            Loyalitypoint oneLoyaltyPoint= new Loyalitypoint(idEarningRule, idsubscription, earnedPoint);
           loyalitypointrepository.saveAndFlush(oneLoyaltyPoint);
           subscriptionrepository.setCurrentPointValueSubscriber(earnedPoint,idsubscription);
            return "{\"status\":0, \"description\": \" Vous avez gagné "+earnedPoint+" points \" }";

        }
        catch (Exception e){
            throw  e;
        }
    }

    @Override
    public String earningRuleListCompany(String idCompany) throws Exception {
        try{
           List<EarningRule> earningRuleList= earnrulerepository.findByCompany(idCompany);
            ObjectMapper mapper                 = new ObjectMapper();
            String result                       = mapper.writeValueAsString(earningRuleList);
            return "{\"status\":0, \"earningrulelist\": "+result+" }";
        }
        catch (Exception e){
            throw  e;
        }

    }
}
