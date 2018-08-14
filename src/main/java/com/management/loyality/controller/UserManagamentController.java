package com.management.loyality.controller;

import com.management.loyality.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class UserManagamentController {

    private SubscriptionService subscriptionservice;
    @Autowired
    public UserManagamentController(SubscriptionService subService){
        this.subscriptionservice=subService;
    }

    @RequestMapping("/users/subscribe")
    public String subscribe(@RequestParam String idcustomer, @RequestParam  String idcompany){
        String result="";
        try{
           result= subscriptionservice.subscribe(idcustomer,idcompany);

        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/users/unsubscribe")
    public String unsubscribe(@RequestParam String idsubscription){
        String result="";
        try{
            result=subscriptionservice.unsubscribe(idsubscription);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/users/checkSubscription")
    public String checkSubscription(@RequestParam String idcustomer, @RequestParam  String idcompany){
        String result="";
        try{
            result=subscriptionservice.checkSubscription(idcustomer,idcompany);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/company/list/subscribers")
    public String subscribesCompany(@RequestParam String idcompany){
        String result="";
        try{
            result=subscriptionservice.subscribesList(idcompany);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }
}
