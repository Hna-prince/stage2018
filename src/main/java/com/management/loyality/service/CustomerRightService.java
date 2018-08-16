package com.management.loyality.service;

public interface CustomerRightService {
    public String levelsList(String idCompany) throws Exception;
    public String insertLevels(String description, int valuepermission, String idCompany)throws Exception;
   // public String updateCustomerLevels(String idSubscription)throws Exception;
    public String insertCriteria(String idsubscription, String idLevels)throws Exception;
    public String deleteCriteria(String idsubscription, String idLevels)throws Exception;
    public String criteriaList(String idsubscription)throws Exception;

}
