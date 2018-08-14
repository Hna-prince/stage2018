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
    public String subscribe(@RequestParam String idCustomer, @RequestParam  String idCompany){
        String result="";
        try{
           result= subscriptionservice.subscribe(idCustomer,idCompany);

        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/users/subscri")
    @RequestMapping("/company/subscribers")
    public String subscribesCompany(@RequestParam String idCompany){
        String result="";
        try{
            result=subscriptionservice.subscribesList(idCompany);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }
}
