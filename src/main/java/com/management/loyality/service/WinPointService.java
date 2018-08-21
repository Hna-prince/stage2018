package com.management.loyality.service;

import com.management.loyality.domain.Earningrule;

public interface WinPointService {

    public String insertLoyaltyType(String loyaltyName, String descriptions, int statusType) throws  Exception;
    public String loyaltyTypeListDefault() throws  Exception;
    public String loyaltyTypeListCustomized() throws  Exception;
    public String defineEarningRule(String idCompany, String idLoyalityType,String startdate, String enddate, int earnedpoint, String targetchar) throws  Exception;
    public String changeActivityEarningRule(String idEarningRule) throws  Exception;
    public String updateEarningRule(String idearningRule, int earnedpoint, int activity, String targetchar) throws  Exception;

    public String currentPoint(String idsubscription) throws  Exception;
    public String customerEarningPointHistory(String idsubscription) throws  Exception;

    public String  earningPoint(String idEarningRule, String idsubscription) throws  Exception;
    public String earningRuleListCompany(String idCompany) throws  Exception;

    public Boolean ExistEarnPointOnceADay(String idLoyaltyType) throws  Exception;
    public Boolean checkLoyaltyOnceADay(String idLoyaltyType) throws Exception;

    public String ExistActiveCurrentEarningRule( Earningrule newEarningRule) throws Exception;



}
