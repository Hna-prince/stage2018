package com.management.loyality.service;

public interface SubscriptionService {
    public String subscribe(String idCustomer, String idCompany)throws Exception;
    public String subscribesList(String idCompany) throws Exception;
    public String unsubscribe(String idSubscribe) throws Exception;
    public String checkSubscription(String idCustomer, String idCompany) throws Exception;
}
