package com.management.loyality.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.loyality.domain.Earningrule;
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

import java.time.LocalDate;
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
    @Transactional
    public String insertLoyaltyType(String loyaltyName, String descriptions, int statusType) throws Exception {
        try {
            Loyaltytype oneLoyaltyType= new Loyaltytype(loyaltyName, descriptions, statusType);
            loyaltytyperepository.saveAndFlush(oneLoyaltyType);
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
    @Transactional
    public String defineEarningRule(String idCompany,String idLoyalityType,String startdate, String enddate, int earnedpoint, String targetchar) throws Exception {
        try {
            Earningrule oneEarningRule= new Earningrule(idCompany,idLoyalityType,startdate, enddate, earnedpoint,targetchar);
            earnrulerepository.saveAndFlush(oneEarningRule);

            return "{\"status\":0, \"description\": \" Une nouvelle règle pour gagner des points a été établie\" }";
        }
        catch (Exception e){
            throw  e;
        }
    }

    @Override
    public String changeActivityEarningRule(String idEarningRule) throws Exception {
        try {
            int activity    =1;
            String  message = " La règle vient d'être désactivéé. ";
            Earningrule oneEarningRule =earnrulerepository.findById(idEarningRule).get();
            if( oneEarningRule.getActive() != 0) {
                activity    = 0;
                message     =" La règle a été réactivée. ";
               message=  ExistActiveCurrentEarningRule(  oneEarningRule) ;
            }

            earnrulerepository.setActivity(activity,idEarningRule);

            return "{\"status\":0, \"description\": \""+message+"\" }";

        }
        catch (Exception e){
            throw  e;
        }
    }

    @Override
    public String ExistActiveCurrentEarningRule( Earningrule newEarningRule) throws Exception {
        try {
            List<Earningrule> earninRuleList    = earnrulerepository.findActive(0,newEarningRule.getIdloyaltytype());
            int tailleEarningRule               = earninRuleList.size();

            if (tailleEarningRule  == 0)
                return " no exist";
                //return false;
            else if( earninRuleList.get(tailleEarningRule-1).getEnddate() == null ){// earningRule permanent exist
                return "earningRule permanent exist";
                //return true;
            }
            else if( newEarningRule.getEnddate() == null ){ //activate a permanent earningRule
                throw  new  Exception("Désactiver d'abord tous les autres règles de gain de points du même type avant d'activer un nouveau règle permanent.");
            }
            else{
               // Boolean exist = false;
                String result="default";
                for ( int i=0; i<earninRuleList.size(); i++ ) {
                    if( newEarningRule.getStartdate().compareTo(earninRuleList.get(i).getEnddate() ) > 0 ){
                        if ( i == tailleEarningRule-1){
                            //exist= false;
                            result = "newStart > EndDate";
                            break;
                        }
                        else {
                            if( newEarningRule.getEnddate().compareTo(earninRuleList.get(i+1).getStartdate()) < 0) {
                                //exist = false;
                                result =" EndNewDate < startDate+1";
                                break;
                            }
                            else {
                                //exist =  true;
                                result =" Nope ";
                            }
                        }
                    }
                    else {
                        if( newEarningRule.getEnddate().compareTo(earninRuleList.get(i).getEnddate()) < 0 ) {
                            //exist = false;
                            result =" EndNewDate < enDate ";
                            break;
                        }
                        else {
                            //exist =  true;
                            result =" Nope 2";
                            break;
                        }
                    }

                }
               // return  exist;
                return result;
            }
        }catch (Exception e){
            throw  e;
        }
    }

    @Override
    public String updateEarningRule(String idEarningRule, int earnedpoint, int activity, String targetchar) throws Exception {
        try {
            Earningrule oneEarningRule = new Earningrule(idEarningRule, earnedpoint,activity,targetchar);
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

            Earningrule oneEarningRule= earnrulerepository.findById(idEarningRule).get();
            int earnedPoint =oneEarningRule.getEarnedpoint();

            if(checkLoyaltyOnceADay(oneEarningRule.getIdloyaltytype()) &&  ExistEarnPointOnceADay( idEarningRule)  )
                 return "{\"status\":1, \"description\": \" Vous avez atteint la limite du jour \" }";
            else {
                Loyalitypoint oneLoyaltyPoint= new Loyalitypoint(idEarningRule, idsubscription, earnedPoint);
                loyalitypointrepository.saveAndFlush(oneLoyaltyPoint);
                subscriptionrepository.setCurrentPointValueSubscriber(earnedPoint,idsubscription);
                return "{\"status\":0, \"description\": \" Vous avez gagné "+earnedPoint+" points \" }";
            }
        }
        catch (Exception e){
            throw  e;
        }
    }

    @Override
    public String earningRuleListCompany(String idCompany) throws Exception {
        try{
           List<Earningrule> earningRuleList= earnrulerepository.findByCompany(idCompany);
            ObjectMapper mapper                 = new ObjectMapper();
            String result                       = mapper.writeValueAsString(earningRuleList);
            return "{\"status\":0, \"earningrulelist\": "+result+" }";
        }
        catch (Exception e){
            throw  e;
        }

    }

    @Override
    public Boolean ExistEarnPointOnceADay(String idEarningRule) throws Exception {
        try{
                List<Loyalitypoint> loyaltyPoint= loyalitypointrepository.findByEarningRule(idEarningRule);
                if( loyaltyPoint.size() != 0 && loyaltyPoint.get(0).getAcquisitiondate().compareTo(LocalDate.now()) == 0  )
                    return true;
                else
                    return false;

        }catch (Exception e){
            throw  e;
        }
    }

    @Override
    public Boolean checkLoyaltyOnceADay(String idLoyaltyType) throws Exception {
        try {
            if(idLoyaltyType.equals("LTP4")  || idLoyaltyType.equals("LTP2") )
                return true;
            else
                return  false;
        }catch (Exception e){
            throw  e;
        }
    }


}
