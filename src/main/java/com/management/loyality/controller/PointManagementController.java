package com.management.loyality.controller;

import com.management.loyality.service.WinPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class PointManagementController {

    private WinPointService winPointService;
    @Autowired
    public PointManagementController(WinPointService winpointService){
        this.winPointService =  winpointService;
    }
    @RequestMapping("/loyalty/type/create")
    public String createLoyaltyType(@RequestParam String loyaltyname,@RequestParam String description,@RequestParam int statustype){
        String result="";
        try{
           result =  winPointService.insertLoyaltyType( loyaltyname,  description,  statustype);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/loyalty/list/default")
    public String loyaltyTypeList(){
        String result="";
        try{
            result = winPointService.loyaltyTypeListDefault();
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/company/earningRule/create")
    public String createEarningRule(@RequestParam String idcompany,@RequestParam String idloyaltytype, @RequestParam String startdate,@RequestParam String enddate,@RequestParam int earnedpoint,@RequestParam String targetchar){
        String result="";
        try{
             result =    winPointService.defineEarningRule(idcompany,  idloyaltytype,  startdate, enddate,  earnedpoint, targetchar);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/company/earningRule/changeactivity")
    public String changeEarningRuleActivity(@RequestParam  String idearningrule) {
        String result="";
        try{
            result = winPointService.changeActivityEarningRule(idearningrule);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/company/earningRule/update")
    public String updateEarningRule(@RequestParam String idearningrule,@RequestParam int earnedpoint,@RequestParam int activity,@RequestParam String targetchar){
        String result="";
        try{
            result = winPointService.updateEarningRule(idearningrule,  earnedpoint,  activity,  targetchar);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/company/earningRule/list")
    public String earningRuleList(@RequestParam String idcompany){
        String result="";
        try{
                result = winPointService.earningRuleListCompany(idcompany);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }


    @RequestMapping("/users/earnPoint")
    public String earnPoint(@RequestParam String idearningRule,@RequestParam String idsubscription){
        String result="";
        try{
            result = winPointService.earningPoint(idearningRule,  idsubscription);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/users/currentPoint")
    public String getCurrentPoint(@RequestParam String idsubscription){
        String result="";
        try{
            result = winPointService.currentPoint(idsubscription);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    @RequestMapping("/users/point/earnHistory")
    public String earnedPointHistory(@RequestParam String idsubscription){
        String result="";
        try{
            result =  winPointService.customerEarningPointHistory(idsubscription);
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }

    /*@RequestMapping("/testCheck")
    public String earnedPointHistory(){
        String result="";
        try{
            result= ("it"+String.valueOf(winPointService.checkEarnPointOnceADay("LTP2")));
        }catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }finally {
            return result;
        }
    }*/
}
