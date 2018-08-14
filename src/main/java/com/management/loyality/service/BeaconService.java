package com.management.loyality.service;

public interface BeaconService {
    public String insertBeacon( String idPlace, String tagName, String description, int typeB) throws  Exception;
    public String beaconListByPlace(String idPlace) throws Exception;
    public String beaconListByCompany(String idAdmin) throws Exception;
    public String updateBeaconCharacteristic(String idBeacon, String idplace, String idCampaign, String tagName, int active, String titleNotification, String description, int typeBeacon) throws Exception;
    public String updateNotification(String titleNotification, String description,String idBeacon) throws  Exception;
    public String activateBeacon( String idBeacon)throws  Exception;
    public String updateCampaignBeacon(String idCampaignContent, String idBeacon) throws Exception;
}
